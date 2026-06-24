package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
