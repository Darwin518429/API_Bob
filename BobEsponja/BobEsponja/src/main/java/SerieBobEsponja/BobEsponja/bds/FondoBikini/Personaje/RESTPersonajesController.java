package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//Utilizemos anotaciones para poder especificarle a sprigboot u haga algo esa anoacion esta vinculado
//A un codigo que hace algo
// esta classe ya es para poder transformarlo en el json no
@RestController
public class RESTPersonajesController {
    @Autowired
    PersonajeService service;
@GetMapping("/")
    public String  prueba (){
        return "Hola mundo!";
    }
    //Obtene todos los personajes
    @GetMapping("/personajes")
    public List<PersonajeEntity> getAllpersonajes(){
        return service.getAll();
    }
    //Obtener por id
   @GetMapping("/personajes/{id}")
    public PersonajeEntity getPersonaje(@PathVariable Long id ){

        PersonajeEntity p =service.getId(id) /* getPersonajeList(id)*/;
       if (p == null) {
       throw new PersonajeNotFoundException(id);
       }

       return p;
    }
    private PersonajeEntity getPersonajeList(Long id ){
        return service.getId(id);
    }

    @DeleteMapping("/personajes/{id}")
    public String deletePersonaje(@PathVariable Long id){
       service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
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
