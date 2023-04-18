import com.tp_integrador_argprograma.demo.Equipo;
import com.tp_integrador_argprograma.demo.Partido;
import com.tp_integrador_argprograma.demo.Ronda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RondaTest {

    @Test
    void puntos() {
        Equipo boca = new Equipo(1, "Boca", "Club");
        Equipo river = new Equipo(2, "River", "Club");
        Equipo racing = new Equipo(3, "Racing", "Club");
        Partido bocavsriver = new Partido(boca, river, 1, 0);
        Partido rivervsracing = new Partido(river, racing, 0, 0);
        Partido racingvsboca = new Partido(racing, boca, 1, 2);
        Partido[] partidos = new Partido[]{bocavsriver, rivervsracing, racingvsboca};

        Ronda ronda = new Ronda("1", partidos);


        assertEquals(3,ronda.puntos());
    }
}