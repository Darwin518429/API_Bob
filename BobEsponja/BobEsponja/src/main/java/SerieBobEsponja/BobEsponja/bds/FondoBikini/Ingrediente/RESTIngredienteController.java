package SerieBobEsponja.BobEsponja.bds.FondoBikini.Ingrediente;

import SerieBobEsponja.BobEsponja.config.ApiRoutes;
import SerieBobEsponja.BobEsponja.config.PagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
public class RESTIngredienteController {
@Autowired
IngredienteService service;


    //Obtener  los personajes
    @GetMapping(ApiRoutes.Ingrediente)
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PagConfig.PAGINA_DEFECTO) int page // Valor por defecto de la pagina le podemos un nombre deb se rexacto al querer obtenr en el navegaodr
    ) { // Valor por defecto del tamaño
        return service.getAll(page, PagConfig.TAMANO_DEFECTO);

    }

    //Obtener por id
    @GetMapping( ApiRoutes.getIngrediente) //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public IngredienteEntity getPersonaje(@PathVariable Long id ){

        IngredienteEntity p = service.getId(id);

        return p;
    }

    @DeleteMapping(ApiRoutes.getIngrediente)
    public String deletePersonaje(@PathVariable Long id){
        service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
    }
    //Añadir
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping(ApiRoutes.Ingrediente)
    public IngredienteEntity create(@RequestBody IngredienteEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

    //Actualizar
    @PutMapping( ApiRoutes.getIngrediente)
    public IngredienteEntity update(@PathVariable Long id, @RequestBody IngredienteEntity p) {
        return service.update(id, p);
    }

}
