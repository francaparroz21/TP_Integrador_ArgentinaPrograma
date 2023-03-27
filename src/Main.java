import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, TeamNotFound {

        //Path de los resultados, pronosticos y sus respectivos arrays.
        String pathResultados = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\archivos\\resultados.csv";
        ArrayList<String> resultadosPartidos = new ArrayList<String>();
        String pathPronosticos = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\archivos\\pronosticos.csv";
        ArrayList<String> resultadosPronosticos = new ArrayList<String>();

        //Creamos arraylist para cada equipo y en su metodo add le pasamos cada instancia.
        ArrayList<Equipo> equipos = new ArrayList<Equipo>();
        equipos.add(new Equipo(1, "BOCA", "Sport entity."));
        equipos.add(new Equipo(2, "RIVER", "Entity sport center."));
        equipos.add(new Equipo(3, "RACING", "The academy."));

        //Creamos los partidos.
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        //Creamos ronda 1.
        Ronda ronda1 = new Ronda("Uno");

        /*  A partir de la lectura de 'resultados.csv' le añadimos la informacion a cada partido
            por eso usamos el constructor vacio, para despues, mediante la lectura usando los setters
             cambiar los atributos de cada partido.*/

        for (int i = 0; i < Files.readAllLines(Path.of(pathResultados)).size() - 1; i++) {
            resultadosPartidos.add(Files.readAllLines(Path.of(pathResultados)).get(i + 1).replaceAll(",", ""));
            partidos.add(new Partido());
            for (int j = 0; j < resultadosPartidos.get(i).length(); j++) {
                char c = resultadosPartidos.get(i).charAt(j);
                switch (j) {
                    case 0 -> partidos.get(i).setEquipo1(findById(equipos, Character.getNumericValue(c)));
                    case 1 -> partidos.get(i).setGolesEquipo1(Character.getNumericValue(c));
                    case 2 -> partidos.get(i).setGolesEquipo2(Character.getNumericValue(c));
                    case 3 -> partidos.get(i).setEquipo2(findById(equipos, Character.getNumericValue(c)));
                }
            }
        }

        //Creamos array de pronosticos.
        ArrayList<Pronostico> pronosticos = new ArrayList<Pronostico>();
        int countPoints = 0;

        //Seteamos la primer ronda, con sus repectivos partidos y lo printeamos.
        ronda1.setPartidos(partidos.toArray(new Partido[0]));
        System.out.println(ronda1.toString() + "\n " + "=".repeat(50));

        //Leemos los pronosticos.
        for (int i = 0; i < Files.readAllLines(Path.of(pathPronosticos)).size() - 1; i++) {
            resultadosPronosticos.add(Files.readAllLines(Path.of(pathPronosticos)).get(i + 1));
            pronosticos.add(new Pronostico(partidos.get(i)));
            for (int j = 0; j < resultadosPronosticos.get(i).length(); j++) {
                char c = resultadosPronosticos.get(i).charAt(j);
                if (j == 0) pronosticos.get(i).setEquipo(findById(equipos, Character.getNumericValue(c)));
                if (c == 'X') {
                    switch (j) {
                        case 2 -> pronosticos.get(i).setResultado(ResultadoEnum.Ganador);
                        case 3 -> pronosticos.get(i).setResultado(ResultadoEnum.Empate);
                        case 4 -> pronosticos.get(i).setResultado(ResultadoEnum.Perdedor);
                    }
                }
            }
            //Printeamos cada pronostico dentro del primer for.
            System.out.println(pronosticos.get(i).toString());
            //Sumamos punto, ya sea 0 o 1.
            countPoints += pronosticos.get(i).puntos();
        }

        //Printeamos final de ronda con sus respectivos puntos.
        System.out.println("*".repeat(50) + "\n" +
                "El jugador obtuvo: (" + countPoints + ") / " + ronda1.puntos() + " puntos.\n" +
                "*".repeat(50));
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

}
