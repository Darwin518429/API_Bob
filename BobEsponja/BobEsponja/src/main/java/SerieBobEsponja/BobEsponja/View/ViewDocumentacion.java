package SerieBobEsponja.BobEsponja.View;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewDocumentacion {
    @GetMapping(RoutesView.documentacion)
    public String doc(Model modelo ){
        modelo.addAttribute("api",ApiRoutes.Base);
        modelo.addAttribute("personajes", ApiRoutes.Personajes);
        modelo.addAttribute("ingrediente", ApiRoutes.Ingrediente);
        modelo.addAttribute("pedido", ApiRoutes.Pedidos);
        modelo.addAttribute("producto", ApiRoutes.Productos);
        modelo.addAttribute("restaurante", ApiRoutes.Restaurantes);


        return "documentacion";
    }
}
