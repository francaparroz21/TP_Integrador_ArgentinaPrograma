public class Ronda {
    private String nro;
    private Partido[] partidos;

    public Ronda(String nro) {
        this.nro = nro;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

    public int puntos() {
        return partidos.length;
    }

    @Override
    public String toString() {
        String toString = "Ronda "+ getNro() + "- maximo de puntos: "+ puntos();
        for (int i = 0; i < getPartidos().length; i++) {
            toString += "\n" + getPartidos()[i];
        }
        return toString;
    }
}
