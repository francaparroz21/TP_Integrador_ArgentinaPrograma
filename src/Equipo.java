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

    public Equipo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    @Override
    public String toString() {
        return  "ID: " + getId()+"\n" +
                "Nombre: " + getNombre() + "\n" +
                "Descripcion: " + getDescripcion();
    }
}
