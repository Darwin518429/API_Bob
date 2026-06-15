package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
// No deajar  hacer esto:
// http://localhost:8080/personajes?page=1&size=1
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
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PAGINA_ACTUAL) int page // Valor por defecto de la pagin
            /*@RequestParam(defaultValue = NUM_ELEMENTOS) int size*/) { // Valor por defecto del tamaño
        return service.getAll(page, NUM_ELEMENTOS);

    }
    //Obtener por id
   @GetMapping("/personajes/{id}") //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public PersonajeEntity getPersonaje(@PathVariable Long id ){

        PersonajeEntity p =service.getId(id);

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
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping("/personajes")
    public PersonajeEntity create(@RequestBody PersonajeEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

//Actualizar
    @PutMapping("/personajes/{id}")
    public PersonajeEntity update(@PathVariable Long id, @RequestBody PersonajeEntity p) {
        return service.update(id, p);
    }

}
