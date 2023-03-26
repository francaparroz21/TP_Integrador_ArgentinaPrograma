import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws EquipoNoEncontrado, IOException, TeamNotFound {


        //Path de los resultados, pronosticos y sus respectivos arrays.
        String pathResultados = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\Entrega1\\archivos\\resultados.csv";
        ArrayList<String> resultados = new ArrayList<String>();
        String pathPronosticos = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\Entrega1\\archivos\\pronosticos.csv";
        ArrayList<String> pronosticos = new ArrayList<String>();

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
        partidos.add(new Partido());
        partidos.add(new Partido());

        for (int i = 0; i < Files.readAllLines(Path.of(pathResultados)).size() - 1; i++) {
            resultados.add(Files.readAllLines(Path.of(pathResultados)).get(i + 1).replaceAll(",", ""));
            for (int j = 0; j < resultados.get(i).length(); j++) {
                char c = resultados.get(i).charAt(j);
                switch (j) {
                    case 0 -> partidos.get(i).setEquipo1(findById(teams, Character.getNumericValue(c)));
                    case 1 -> partidos.get(i).setGolesEquipo1(Character.getNumericValue(c));
                    case 2 -> partidos.get(i).setGolesEquipo2(Character.getNumericValue(c));
                    case 3 -> partidos.get(i).setEquipo2(findById(teams, Character.getNumericValue(c)));
                }
            }
            System.out.println(partidos.get(i).toString());
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
