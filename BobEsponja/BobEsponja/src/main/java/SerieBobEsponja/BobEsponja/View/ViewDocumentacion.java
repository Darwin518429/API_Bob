package SerieBobEsponja.BobEsponja.View;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewDocumentacion {

    @Autowired
    private PersonajeService servicePersonaje;
    @GetMapping(RoutesView.documentacion)
    public String doc(Model modelo ){
        modelo.addAttribute("api",ApiRoutes.Base);
        modelo.addAttribute("pag",ApiRoutes.Base + "/entidad?page=2");

        modelo.addAttribute("personaje_entity",servicePersonaje.getAllList());

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
