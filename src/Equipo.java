public class Equipo {
    private int id;
    private String nombre;
    private String descripcion;

    public int getId() {
        return id;
    }

    public Equipo(int id, String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return  "ID: " + getId()+"\n" +
                "Nombre: " + getNombre() + "\n" +
                "Descripcion: " + getDescripcion();
    }
}
