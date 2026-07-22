package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import SerieBobEsponja.BobEsponja.config.ApiRoutes;
import SerieBobEsponja.BobEsponja.config.PagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RESTProductoController {
    @Autowired
    ProductoService service;
    // Pesonalizao
    @GetMapping(ApiRoutes.Productos + "/buscar/{nom}")
    public List<ProductoEntity> getProductoEntityNombre(@PathVariable String nom ){
        return service.getNombreRestaurante(nom);
    }


    //CRUD
    @GetMapping(ApiRoutes.Productos)
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PagConfig.PAGINA_DEFECTO) int page // Valor por defecto de la pagina le podemos un nombre deb se rexacto al querer obtenr en el navegaodr
    ) { // Valor por defecto del tamaño
        return service.getAll(page, PagConfig.TAMANO_DEFECTO);

    }

    @GetMapping(ApiRoutes.getProductos) //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public ProductoEntity getProductod(@PathVariable Long id ){

        ProductoEntity p = service.getId(id);

        return p;
    }

    @DeleteMapping(ApiRoutes.getProductos)
    public String deleteProductos(@PathVariable Long id){
        service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
    }
    //Añadir
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping(ApiRoutes.Productos)
    public ProductoEntity create(@RequestBody ProductoEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

    //Actualizar
    @PutMapping(ApiRoutes.getProductos)
    public ProductoEntity update(@PathVariable Long id, @RequestBody ProductoEntity p) {
        return service.update(id, p);
    }
}
