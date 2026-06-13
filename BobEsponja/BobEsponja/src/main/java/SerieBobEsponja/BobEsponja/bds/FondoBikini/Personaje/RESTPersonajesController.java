package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
//Utilizemos anotaciones para poder especificarle a sprigboot u haga algo esa anoacion esta vinculado
//A un codigo que hace algo
// esta classe ya es para poder transformarlo en el json no
@RestController
public class RESTPersonajesController {
    final String  PAGINA_ACTUAL ="1";
    final int  NUM_ELEMENTOS=  5;
    @Autowired // Me crea el objeto sin tener que hace un constructor
    PersonajeService service;
@GetMapping("/")
    public String  prueba (){
        return "Hola mundo!";
    }

    //Obtener  los personajes
    @GetMapping("/personajes")
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?:
            @RequestParam(defaultValue = PAGINA_ACTUAL) int page // Valor por defecto de la pagin
            /*@RequestParam(defaultValue = NUM_ELEMENTOS) int size*/) { // Valor por defecto del tamaño
        return service.getAll(page, NUM_ELEMENTOS);

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
//Añadir
    @PostMapping("/personajes")
    public PersonajeEntity create(@RequestBody PersonajeEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

    @PutMapping("/personajes/{id}")
    public PersonajeEntity update(@PathVariable Long id, @RequestBody PersonajeEntity p) {
        return service.update(id, p);
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
