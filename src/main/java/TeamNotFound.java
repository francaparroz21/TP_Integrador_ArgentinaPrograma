public class TeamNotFound extends Exception{
    @Override
    public String getMessage() {
        return "No se encontro ningun equipo en la lista. ";
    }
}
