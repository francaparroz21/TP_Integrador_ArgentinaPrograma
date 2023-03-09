import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws EquipoNoEncontrado {
        Equipo boca = new Equipo("boca","description");
        Equipo river = new Equipo("river","description");
        Partido partido1 = new Partido(boca,river,2,2);

        Equipo boca1 = new Equipo("boca","description");

        System.out.println(partido1.resultado(boca1));


        System.out.println();
    }
}