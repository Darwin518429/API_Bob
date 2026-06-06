package SerieBobEsponja.BobEsponja.Personaje;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//Utilizemos anotaciones para poder especificarle a sprigboot u haga algo esa anoacion esta vinculado
//A un codigo que hace algo
// esta classe ya es para poder transformarlo en el json no
@RestController
public class RESTPersonajesController {
   static  List<Personaje>  llista = new ArrayList<>();
    static{
        //Es para conversar a Long
        llista.add(new Personaje(1L,"PepeElmago","Hey","Pez","Villano",1));
        llista.add(new Personaje(2L,"Pepezao","ey","ez","Random",2));

    }
@GetMapping("/")
    public String  prueba (){
        return "Hola mundo!";
    }
    //Obtene todos los personajes
    @GetMapping("/personajes")
    public List<Personaje> getAllpersonajes(){
        return llista;
    }
    //Obtener por id
   @GetMapping("/personajes/{id}")
    public Personaje getPersonaje(@PathVariable Long id ){

        Personaje p = getPersonajeList(id);
       if (p == null) {
           // Esto corta la ejecución y devuelve un error 404 al navegador
           //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Personaje no encontrado con ID: " + id);
          // throw new ResponseStatusException(HttpStatus.NOT_FOUND, "MENSAJE_DE_PRUEBA_123");
       throw new PersonajeNotFoundException(id);
       }

       return p;
    }
    private Personaje getPersonajeList(Long id ){
        return llista.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private  class PersonajeNotFoundException extends RuntimeException {
        public PersonajeNotFoundException(Long id) {
            super("No se encontró ningún personaje con la ID: " + id);
        }
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {

        @ExceptionHandler(PersonajeNotFoundException.class)
        public ResponseEntity<String> handlePersonajeNotFound(PersonajeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
