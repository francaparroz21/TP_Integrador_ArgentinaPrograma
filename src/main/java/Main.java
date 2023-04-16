import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException, EquipoNoEncontrado {

        List<String> resultadoRondas = getFile("./src/archivos/rondas.csv");
        List<String> resultadosPronosticos = getFile("./src/archivos/pronosticos.csv");


        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo(1, "Boca", "Club"));
        equipos.add(new Equipo(2, "River", "Club"));
        equipos.add(new Equipo(3, "Racing", "Club"));


        List<Ronda> rondas = leerRondas(resultadoRondas, equipos);
        HashMap<String, ArrayList<Pronostico>> pronosticos = leerPronosticos(resultadosPronosticos, equipos, rondas);

        System.out.println(getPuntos(pronosticos));


    }

    private static HashMap<String, Integer> getPuntos(Map<String, ArrayList<Pronostico>> pronosticos) {
        HashMap<String, Integer> puntajes = new HashMap<>();
        pronosticos.forEach((nom, pronosticosArray) -> {
            int puntos = 0;
            for (Pronostico p : pronosticosArray) {
                try {
                    puntos += p.puntos();
                } catch (EquipoNoEncontrado e) {
                    throw new RuntimeException(e);
                }
            }
            puntajes.put(nom, puntos);
        });
        return puntajes;
    }

    public static HashMap<String, ArrayList<Pronostico>> leerPronosticos(List<String> resultadosPronosticos, ArrayList<Equipo> equipos, List<Ronda> rondas) {
        HashMap<String, ArrayList<Pronostico>> pronosticos = new HashMap<>();
        try {
            for (String line : resultadosPronosticos) {
                String nombre = line.split(",")[0];
                Pronostico pronostico = new Pronostico();
                for (int i = 0; i < line.length() - nombre.length() - 1; i++) {
                    char c = line.charAt(i + nombre.length() + 1);
                    switch (i) {
                        case 0 -> pronostico.setNroRonda(String.valueOf(c));
                        case 2 -> pronostico.setEquipo(findTeamById(equipos, Character.getNumericValue(c)));
                        case 4 -> {
                            if (c == 'X') pronostico.setResultado(ResultadoEnum.Ganador);
                        }
                        case 5 -> {
                            if (c == 'X') pronostico.setResultado(ResultadoEnum.Empate);
                        }
                        case 6 -> {
                            if (c == 'X') pronostico.setResultado(ResultadoEnum.Perdedor);
                        }
                        case 8 -> pronostico.setPartido(buscarPartido(rondas,line.split(",")[1], line.split(",")[6]));
                    }
                }
                ArrayList<Pronostico> pronosticoArray;
                if (!pronosticos.containsKey(nombre)) {
                    pronosticoArray = new ArrayList<>();
                } else {
                    pronosticoArray = pronosticos.get(nombre);
                }
                pronosticoArray.add(pronostico);
                pronosticos.put(nombre, pronosticoArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pronosticos;
    }

    public static Partido buscarPartido(List<Ronda> rondas, String nroRonda, String ids) throws PartidoNoEncontrado {
        char id1 = ids.charAt(0);
        char id2 = ids.charAt(2);
        for (Ronda ronda : rondas) {
            if (ronda.getNro().equals(nroRonda)) {
                for (Partido partido : ronda.getPartidos()) {
                    if (partido.getEquipo1().getId() == Character.getNumericValue(id1) && partido.getEquipo2().getId() == Character.getNumericValue(id2)) {
                        return partido;
                    }
                }
            }
        }
        throw new PartidoNoEncontrado();
    }

    public static ArrayList<Ronda> leerRondas(List<String> resultadoRondas, ArrayList<Equipo> equipos) {
        ArrayList<Ronda> rondas = new ArrayList<>();
        try {
            for (String resultadoRonda : resultadoRondas) {
                if (!findRound(resultadoRonda.charAt(0), rondas)) {
                    rondas.add(new Ronda(String.valueOf(resultadoRonda.charAt(0))));
                }
                Partido p = new Partido();
                for (int j = 0; j < resultadoRonda.length(); j++) {
                    char c = resultadoRonda.charAt(j);
                    switch (j) {
                        case 2 -> p.setEquipo1(findTeamById(equipos, Character.getNumericValue(c)));
                        case 4 -> p.setGolesEquipo1(Character.getNumericValue(c));
                        case 6 -> p.setGolesEquipo2(Character.getNumericValue(c));
                        case 8 -> p.setEquipo2(findTeamById(equipos, Character.getNumericValue(c)));
                    }
                }
                char numRound = resultadoRonda.charAt(0);
                if (Objects.requireNonNull(findRoundByNum(numRound, rondas)).getPartidos() == null) {
                    rondas.get(rondas.indexOf(findRoundByNum(numRound, rondas))).setPartidos(new Partido[]{p});
                } else {
                    ArrayList<Partido> partidos = new ArrayList<>();
                    Collections.addAll(partidos, Objects.requireNonNull(findRoundByNum(numRound, rondas)).getPartidos());
                    partidos.add(p);
                    rondas.get(rondas.indexOf(findRoundByNum(numRound, rondas))).setPartidos(partidos.toArray(new Partido[0]));
                }
            }
            sortRound(rondas);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rondas;
    }
    public static ArrayList<Ronda> sortRound(ArrayList<Ronda> rounds) {
        Collections.sort(rounds, new Comparator<Ronda>() {
            public int compare(Ronda r1, Ronda r2) {
                return r1.getNro().compareTo(r2.getNro());
            }
        });
        return rounds;
    }
    public static boolean findRound(char c, ArrayList<Ronda> rounds) {
        for (Ronda r : rounds) if (r.getNro().equals(String.valueOf(c))) return true;
        return false;
    }
    public static Ronda findRoundByNum(char num, ArrayList<Ronda> rounds) {
        for (Ronda r : rounds) {
            if (r.getNro().equals(String.valueOf(num))) return r;
        }
        return null;
    }
    public static Equipo findTeamById(ArrayList<Equipo> teams, int id) throws EquipoNoEncontrado {
        for (Equipo equipo : teams) if (id == equipo.getId()) return equipo;
        throw new EquipoNoEncontrado();
    }
    public static List<String> getFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> file = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
        file.remove(0);
        return file;
    }

}
