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


        //Leemos cada linea del archivo de resultados, luego adentro de cada linea la recorremos con un for.
        String pathResultados = "C:\\Users\\franc\\OneDrive\\Escritorio\\TP_Integrador_ArgentinaPrograma\\Entrega1\\archivos\\resultados.csv";

        Equipo boca = new Equipo(1, "BOCA", "Sport entity.");
        Equipo river = new Equipo(2, "RIVER", "Entity sport center.");
        Equipo racing = new Equipo(3, "RACING", "The academy.");

        ArrayList<Equipo> teams = new ArrayList<Equipo>();
        teams.add(boca);
        teams.add(river);
        teams.add(racing);

        Partido partido1 = new Partido();
        ArrayList<String> resultados = new ArrayList<String>();

        for (int i = 1; i<Files.readAllLines(Path.of(pathResultados)).size(); i++){
            resultados.add(Files.readAllLines(Path.of(pathResultados)).get(i));
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
