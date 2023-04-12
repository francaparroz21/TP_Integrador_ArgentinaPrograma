import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//comentario por si las dudas

public class Main {
    public static char[] numbers = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main(String[] args) throws IOException, TeamNotFound {

        List<String> resultadoRondas = getFile("./src/archivos/resultados.csv");
        List<String> resultadosPronosticos = getFile("./src/archivos/pronosticos.csv");


        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo(1, "Boca", "Club"));
        equipos.add(new Equipo(2, "River", "Club"));
        equipos.add(new Equipo(3, "Racing", "Club"));

        ArrayList<Ronda> rondas = new ArrayList<>();

        for (int i = 0; i < resultadoRondas.size(); i++) {
            if (!findRound(resultadoRondas.get(i).charAt(0), rondas)) {
                rondas.add(new Ronda(String.valueOf(resultadoRondas.get(i).charAt(0))));
            }
            Partido p = new Partido();
            for (int j = 0; j < resultadoRondas.get(i).length(); j++) {
                char c = resultadoRondas.get(i).charAt(j);
                switch (j) {
                    case 2 -> p.setEquipo1(findById(equipos, Character.getNumericValue(c)));
                    case 4 -> p.setGolesEquipo1(Character.getNumericValue(c));
                    case 6 -> p.setGolesEquipo2(Character.getNumericValue(c));
                    case 8 -> p.setEquipo2(findById(equipos, Character.getNumericValue(c)));
                }
            }
            if (rondas.get(Character.getNumericValue(resultadoRondas.get(i).charAt(0)) - 1).getPartidos() == null)
                rondas.get(Character.getNumericValue(resultadoRondas.get(i).charAt(0)) - 1).setPartidos(new Partido[]{p});
            else {
                ArrayList<Partido> partidos = new ArrayList<Partido>(Arrays.asList(rondas.get(Character.getNumericValue(resultadoRondas.get(i).charAt(0)) - 1).getPartidos()));
                partidos.add(p);
                rondas.get(Character.getNumericValue(resultadoRondas.get(i).charAt(0)) - 1).setPartidos(partidos.toArray(new Partido[0]));
            }
        }

        rondas.forEach(System.out::println);
    }

    public static boolean findRound(char c, ArrayList<Ronda> rounds) {
        for (Ronda r : rounds) if (r.getNro().equals(String.valueOf(c))) return true;
        return false;
    }


    /*
    FindById: toma como argumento un arraylist y un id como entero, si encuentra el equipo con su id
    lo devuelve en forma de Objeto(Equipo).
    Sino, arroja una exception, que no se encontro ningun equipo en el arraylist.
     */
    public static Equipo findById(ArrayList<Equipo> teams, int id) throws TeamNotFound {
        for (Equipo equipo : teams) if (id == equipo.getId()) return equipo;
        throw new TeamNotFound();
    }

    /*Metodo para obtener el archivo y devolverlo en un arraylist.
        Si no lo encuentra arroja una exception.
     */
    public static List<String> getFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> file = (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
        file.remove(0);
        return file;
    }

}
