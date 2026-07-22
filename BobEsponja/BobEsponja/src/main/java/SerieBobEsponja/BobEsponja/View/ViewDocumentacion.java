package SerieBobEsponja.BobEsponja.View;

import SerieBobEsponja.BobEsponja.config.ApiRoutes;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Ingrediente.IngredienteService;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido.PedidoService;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeService;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto.ProductoService;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewDocumentacion {

    @Autowired
    private PersonajeService servicePersonaje;

    @Autowired
   private  ProductoService serviceProducto;

    @Autowired
    private IngredienteService serviceIngrediente;

    @Autowired
    private PedidoService servicePedido;

    @Autowired
    private RestauranteService serviceRestaurante;

    @GetMapping(RoutesView.documentacion)
    public String doc(Model modelo ){
        modelo.addAttribute("api",ApiRoutes.Base);
        modelo.addAttribute("pag",ApiRoutes.Base + "/entidad?page=2");

//Añadir  elementos
        modelo.addAttribute("personaje_entity",servicePersonaje.getAllList());
        modelo.addAttribute("producto_entity",serviceProducto.getAllList());
        modelo.addAttribute("ingrediente_entity",serviceIngrediente.getAllList());
        modelo.addAttribute("pedido_entity",servicePedido.getAllList());
        modelo.addAttribute("rest_entity",serviceRestaurante.getAllList());
        //BASE
        modelo.addAttribute("personajes", ApiRoutes.Personajes);
        modelo.addAttribute("ingrediente", ApiRoutes.Ingrediente);
        modelo.addAttribute("pedido", ApiRoutes.Pedidos);
        modelo.addAttribute("producto", ApiRoutes.Productos);
        modelo.addAttribute("restaurante", ApiRoutes.Restaurantes);

        //ID
        modelo.addAttribute("personaje_id",ApiRoutes.getPersonaje);
        modelo.addAttribute("ingrediente_id", ApiRoutes.getIngrediente);
        modelo.addAttribute("pedido_id", ApiRoutes.getPedidos);
        modelo.addAttribute("producto_id", ApiRoutes.getProductos);
        modelo.addAttribute("restaurante_id", ApiRoutes.getRestaurantes);

        return "documentacion";
    }
}
