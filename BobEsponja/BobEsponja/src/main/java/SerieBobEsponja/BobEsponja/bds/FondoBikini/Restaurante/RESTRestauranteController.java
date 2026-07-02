package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import SerieBobEsponja.BobEsponja.Config.PagConfig;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RESTRestauranteController {
@Autowired
RestauranteService service;
    @GetMapping(ApiRoutes.Restaurantes + "/propietarios")
    public List<Map<String,Object>> getPropietarios(){

        return service.getPropietarios();
    };

    @GetMapping(ApiRoutes.Restaurantes)
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PagConfig.PAGINA_DEFECTO) int page // Valor por defecto de la pagina le podemos un nombre deb se rexacto al querer obtenr en el navegaodr
    ) { // Valor por defecto del tamaño
        return service.getAll(page, PagConfig.TAMANO_DEFECTO);

    }

    //Obtener por id
    @GetMapping(ApiRoutes.getRestaurantes) //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public RestauranteEntity getRestaurante(@PathVariable Long id ){

        RestauranteEntity p = service.getId(id);

        return p;
    }

    @DeleteMapping(ApiRoutes.getRestaurantes)
    public String deleteRestaurante(@PathVariable Long id){
        service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
    }
    //Añadir
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping(ApiRoutes.Restaurantes)
    public RestauranteEntity create(@RequestBody RestauranteEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

    //Actualizar
    @PutMapping( ApiRoutes.getRestaurantes)
    public RestauranteEntity update(@PathVariable Long id, @RequestBody RestauranteEntity p) {
        return service.update(id,p);
    }
}
