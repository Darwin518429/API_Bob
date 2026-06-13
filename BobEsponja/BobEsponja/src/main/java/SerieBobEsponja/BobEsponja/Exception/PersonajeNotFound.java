package SerieBobEsponja.BobEsponja.Exception;

public class PersonajeNotFound  extends RuntimeException{

    public PersonajeNotFound(Long id) {
        super("Personaje con id " + id + " no encontrado");
    }
}
