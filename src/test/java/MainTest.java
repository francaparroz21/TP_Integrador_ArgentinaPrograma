import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void leerPronosticos(){

    }

    @Test
    void buscarPartido() {
    }

    @Test
    void leerRondas() {
    }

    @Test
    void sortRound() {
    }

    @Test
    void findRound() {
    }

    @Test
    void findRoundByNum() {
    }

    @Test
    void findTeamById() throws EquipoNoEncontrado {
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo boca = new Equipo(1, "Boca", "Club");
        Equipo river = new Equipo(2, "River", "Club");
        Equipo racing = new Equipo(3, "Racing", "Club");
        Collections.addAll(equipos,boca,racing,river);

        assertEquals(Main.findTeamById(equipos,3),racing);
        assertThrows(EquipoNoEncontrado.class,()->{
            Main.findTeamById(equipos,4);
        },"No se encontro ningun equipo en la lista.");

    }

    @Test
    void getFile() throws IOException {
        String pathRondas = "./src/archivos/rondas.csv";
        String pathPronosticos = "./src/archivos/pronosticos.csv";

        Path rondas = Paths.get(pathRondas);
        Path pronosticos = Paths.get(pathPronosticos);

        List<String> fileRondas = Files.readAllLines(rondas);
        List<String> filePronosticos = Files.readAllLines(pronosticos);

        assertEquals(Main.getFile(pathRondas), fileRondas.subList(1,fileRondas.size()));
        assertEquals(Main.getFile(pathPronosticos), filePronosticos.subList(1,filePronosticos.size()));
    }
}