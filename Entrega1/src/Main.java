import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, TeamNotFound {


        //Path de los resultados, pronosticos y sus respectivos arrays.
        String pathResultados = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\Entrega1\\archivos\\resultados.csv";
        ArrayList<String> resultadosPartidos = new ArrayList<String>();
        String pathPronosticos = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\Entrega1\\archivos\\pronosticos.csv";
        ArrayList<String> resultadosPronosticos = new ArrayList<String>();

        //Creamos cada equipor que van a jugar los partidos.
        Equipo boca = new Equipo(1, "BOCA", "Sport entity.");
        Equipo river = new Equipo(2, "RIVER", "Entity sport center.");
        Equipo racing = new Equipo(3, "RACING", "The academy.");

        //Creamos arraylist para cada equipo.
        ArrayList<Equipo> teams = new ArrayList<Equipo>();
        teams.add(boca);
        teams.add(river);
        teams.add(racing);

        //Creamos los partidos.
        ArrayList<Partido> partidos = new ArrayList<Partido>();

        /*  A partir de la lectura de 'resultados.csv' le añadimos la informacion a cada partido
            por eso usamos el constructor vacio, para despues, mediante la lectura usamos setters
             para los atributos de cada partido.
         */
        for (int i = 0; i < Files.readAllLines(Path.of(pathResultados)).size() - 1; i++) {
            resultadosPartidos.add(Files.readAllLines(Path.of(pathResultados)).get(i + 1).replaceAll(",", ""));
            partidos.add(new Partido());
            for (int j = 0; j < resultadosPartidos.get(i).length(); j++) {
                char c = resultadosPartidos.get(i).charAt(j);
                switch (j) {
                    case 0 -> partidos.get(i).setEquipo1(findById(teams, Character.getNumericValue(c)));
                    case 1 -> partidos.get(i).setGolesEquipo1(Character.getNumericValue(c));
                    case 2 -> partidos.get(i).setGolesEquipo2(Character.getNumericValue(c));
                    case 3 -> partidos.get(i).setEquipo2(findById(teams, Character.getNumericValue(c)));
                }
            }
        }

        //Creamos array de pronosticos.
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();

        //Leemos los pronosticos.
        for (int i = 0; i < Files.readAllLines(Path.of(pathPronosticos)).size() - 1; i++) {
            resultadosPronosticos.add(Files.readAllLines(Path.of(pathPronosticos)).get(i + 1));
            pronosticos.add(new Pronostico(partidos.get(i)));
            for (int j = 0; j < resultadosPronosticos.get(i).length(); j++) {
                char c = resultadosPronosticos.get(i).charAt(j);
                if (j == 0){
                    pronosticos.get(i).setEquipo(findById(teams,Character.getNumericValue(c)));
                }
                if (c == 'X') {
                    switch (j) {
                        case 2 -> {
                            pronosticos.get(i).setResultado(ResultadoEnum.Ganador);
                        }
                        case 3 -> {
                            pronosticos.get(i).setResultado(ResultadoEnum.Empate);
                        }
                        case 4 -> {
                            pronosticos.get(i).setResultado(ResultadoEnum.Perdedor);
                        }
                    }
                }
            }
        }


    }

    public static Equipo findById(ArrayList<Equipo> teams, int id) throws TeamNotFound {
        for (Equipo equipo : teams) {
            if (id == equipo.getId()) {
                return equipo;
            }
        }
        throw new TeamNotFound();
    }

}
