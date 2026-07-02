package SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import SerieBobEsponja.BobEsponja.Config.PagConfig;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RESTPedidoController {
    @Autowired
    PedidoService service;

    @GetMapping(ApiRoutes.Pedidos + "/total")
    public List<PedidoEntity> getpedidomayor(@PathVariable Float total){
        return service.getpedidosmasde(total);
    }
    @GetMapping(ApiRoutes.Pedidos)
    public Map<String, Object> getAll(
            //@RequestParam coge los parámetros que van en la URL después del ?: x?page=num
            @RequestParam(defaultValue = PagConfig.PAGINA_DEFECTO) int page // Valor por defecto de la pagina le podemos un nombre deb se rexacto al querer obtenr en el navegaodr
    ) { // Valor por defecto del tamaño
        return service.getAll(page, PagConfig.TAMANO_DEFECTO);

    }

    //Obtener por id
    @GetMapping(ApiRoutes.getPedidos) //COn @PathVariable agarramos el id del parametro para darselo a @Getmapping
    public PedidoEntity getPersonaje(@PathVariable Long id ){

        PedidoEntity p = service.getId(id);

        return p;
    }


    @DeleteMapping(ApiRoutes.getPedidos)
    public String deletePersonaje(@PathVariable Long id){
        service.deleteId(id);
        if(service.getId(id) == null) return "Elimininado correctmente";
        else return "Error algo a pasado ";
    }
    //Añadir
// @RequestBody agarra el JSON del body de la petición HTTP
// y lo convierte automáticamente a un objeto Java
    @PostMapping(ApiRoutes.Pedidos)
    public PedidoEntity create(@RequestBody PedidoEntity p) { // Con requestBody agarr el josn manddo y lo transforma en un bojeto de java
        return service.add(p);
    }

    //Actualizar
    @PutMapping( ApiRoutes.getPedidos)
    public PedidoEntity update(@PathVariable Long id, @RequestBody PedidoEntity p) {
        return service.update(id, p);
    }

}
