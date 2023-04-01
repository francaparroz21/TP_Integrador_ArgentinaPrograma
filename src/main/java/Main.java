import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static char[] numbers = {'1','2','3','4','5','6','7','8','9'};
    public static void main(String[] args) throws IOException, TeamNotFound {


        List<String> resultadosPartidos = getFile("./src/archivos/resultados.csv");
        List<String> resultadosPronosticos = getFile("./src/archivos/pronosticos.csv");
        System.out.println(resultadosPartidos);

        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo(1, "Boca", "Club"));
        equipos.add(new Equipo(2, "River", "Club"));
        equipos.add(new Equipo(3, "Racing", "Club"));

        ArrayList<Partido> partidos = new ArrayList<Partido>();




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
        List<String> file = Files.readAllLines(path, StandardCharsets.UTF_8);
        file.remove(0);
        return file;
    }

}
