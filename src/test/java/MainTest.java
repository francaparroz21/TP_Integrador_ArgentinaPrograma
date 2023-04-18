import com.tp_integrador_argprograma.demo.Equipo;
import com.tp_integrador_argprograma.demo.EquipoNoEncontrado;
import com.tp_integrador_argprograma.demo.Main;
import com.tp_integrador_argprograma.demo.Ronda;
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
        ArrayList<Ronda> rondas = new ArrayList<>();
        Ronda r1 = new Ronda("1");
        Ronda r2 = new Ronda("2");
        Ronda r3 = new Ronda("3");
        Collections.addAll(rondas,r2,r3,r1);
        Main.sortRound(rondas);


    }

    @Test
    void findRound() {
        ArrayList<Ronda> rondas = new ArrayList<>();
        Ronda r1 = new Ronda("1");
        Ronda r2 = new Ronda("2");
        Ronda r3 = new Ronda("3");
        Collections.addAll(rondas,r1,r2,r3);

        assertEquals(true,Main.findRound('2',rondas));
        assertFalse(Main.findRound('5',rondas));
    }

    @Test
    void findRoundByNum() {
        ArrayList<Ronda> rondas = new ArrayList<>();
        Ronda r1 = new Ronda("1");
        Ronda r2 = new Ronda("2");
        Ronda r3 = new Ronda("3");
        Collections.addAll(rondas,r1,r2,r3);

        assertEquals(r1, Main.findRoundByNum('1',rondas));
        assert  r1 == Main.findRoundByNum('1',rondas);
        assertNull(Main.findRoundByNum('4',rondas));
        assert Main.findRoundByNum('4',rondas) == null;
    }

    @Test
    void findTeamById() throws EquipoNoEncontrado {
        ArrayList<Equipo> equipos = new ArrayList<>();
        Equipo boca = new Equipo(1, "Boca", "Club");
        Equipo river = new Equipo(2, "River", "Club");
        Equipo racing = new Equipo(3, "Racing", "Club");
        Collections.addAll(equipos,boca,racing,river);


        assertEquals(racing,Main.findTeamById(equipos,3));
        assertThrows(EquipoNoEncontrado.class,()->{
            Main.findTeamById(equipos,4);
        },"No se encontro ningun equipo en la lista.");

        assert racing == Main.findTeamById(equipos,3);
    }

    @Test
    void getFile() throws IOException {
        String pathRondas = "./src/archivos/rondas.csv";
        String pathPronosticos = "./src/archivos/pronosticos.csv";

        Path rondas = Paths.get(pathRondas);
        Path pronosticos = Paths.get(pathPronosticos);

        List<String> fileRondas = Files.readAllLines(rondas);
        List<String> filePronosticos = Files.readAllLines(pronosticos);

        assertEquals(fileRondas.subList(1,fileRondas.size()),Main.getFile(pathRondas));
        assertEquals(filePronosticos.subList(1,filePronosticos.size()), Main.getFile(pathPronosticos));
    }
}