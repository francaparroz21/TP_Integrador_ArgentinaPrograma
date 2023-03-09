public class EquipoNoEncontrado extends Exception{

    @Override
    public String getMessage() {
        return "No se encontro ningun equipo en el partido. ";
    }
}
