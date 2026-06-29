package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import SerieBobEsponja.BobEsponja.Config.PagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
// No deajar  hacer esto:
// http://localhost:8080/personajes?page=1&size=1
import java.util.*;
//Utilizemos anotaciones para poder especificarle a sprigboot u haga algo esa anoacion esta vinculado
//A un codigo que hace algo
// esta classe ya es para poder transformarlo en el json no
@RestController
public class RESTPersonajesController {
    @Autowired // Me crea el objeto sin tener que hace un constructor
    PersonajeService service;
/*@GetMapping("/")
    public String  prueba (){
        return "Hola mundo!";
    }
*/
    //Obtener  los personajes
    @GetMapping(ApiRoutes.Personajes)
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PagConfig.PAGINA_DEFECTO) int page // Valor por defecto de la pagina le podemos un nombre deb se rexacto al querer obtenr en el navegaodr
         ) { // Valor por defecto del tamaño
        return service.getAll(page, PagConfig.TAMANO_DEFECTO);

    }

    @GetMapping( ApiRoutes.Personajes +"/ocupacion/{Ocupacion}")
    public List<PersonajeEntity> getPersonaOcupacion(@PathVariable String Ocupacion ){

        return service.getPersonajeOcupacion(Ocupacion);
    };
    //Obtener por id
   @GetMapping( ApiRoutes.Personajes + "/{id}") //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public PersonajeEntity getPersonaje(@PathVariable Long id ){

        PersonajeEntity p = service.getId(id);

       return p;
    }

    @DeleteMapping(ApiRoutes.Personajes + "/{id}")
    public String deletePersonaje(@PathVariable Long id){
       service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
    }
//Añadir
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping(ApiRoutes.Personajes)
    public PersonajeEntity create(@RequestBody PersonajeEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

//Actualizar
    @PutMapping( ApiRoutes.Personajes + "/{id}")
    public PersonajeEntity update(@PathVariable Long id, @RequestBody PersonajeEntity p) {
        return service.update(id, p);
    }

}
