import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, TeamNotFound {

        ArrayList<String> resultadosPartidos = getFile("./src/archivos/resultados.csv");
        ArrayList<String> resultadosPronosticos = getFile("./src/archivos/pronosticos.csv");

        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(new Equipo(1, "Boca", "Club"));
        equipos.add(new Equipo(2, "River", "Club"));
        equipos.add(new Equipo(3, "Racing", "Club"));

        ArrayList<Partido> partidos = new ArrayList<Partido>();

        for (int i = 0; i < resultadosPartidos.size() - 1; i++) {

            for (int j = 0; j < resultadosPartidos.get(i + 1).length(); j++) {
                switch (j) {
                    case 0:
                        equipos.get(i)
                        break;
                }
            }
        }


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
    public static ArrayList<String> getFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        try {
            return (ArrayList<String>) Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException();
        }
    }

}
