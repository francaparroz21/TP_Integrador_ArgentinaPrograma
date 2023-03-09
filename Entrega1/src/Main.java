public class Main {
    public static void main(String[] args) {
        Equipo river = new Equipo("River","Asd");
        Equipo boca = new Equipo("Boca","Asd");

        Partido partido1 = new Partido(river,boca,1,2);
        System.out.println(partido1.resultadoEquipo1());
        System.out.println("=".repeat(50));
        System.out.println(partido1.resultadoEquipo2());
    }
}