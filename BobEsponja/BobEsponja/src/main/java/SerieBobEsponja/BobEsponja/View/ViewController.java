package SerieBobEsponja.BobEsponja.View;

import SerieBobEsponja.BobEsponja.config.ApiRoutes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/") // Ruta
    public String index(Model modelo) { // Devolvera un txt
      //File doc = new File("./BobEsponja/BobEsponja/src/main/resources/templates/documentacion");
        /*
        * String el método devuelve un texto, que será el nombre del HTML a mostrar
Model modelo una "mochila" donde metes los datos que quieres pasar al HTML. Spring te la da automáticamente, tú solo la usas
        * */

        modelo.addAttribute("personajes", ApiRoutes.Personajes);

        modelo.addAttribute("doc",RoutesView.documentacion);
      //  modelo.addAttribute("personaje","s"); // añadir como etiquetas para cceder los datos en el html
        return "index"; // Nombre del archivo html sin el . html


    }

}
