package SerieBobEsponja.BobEsponja.View;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    @GetMapping("/") // Ruta
    public String hola(Model modelo) { // Devolvera un txt
        /*
        * String el método devuelve un texto, que será el nombre del HTML a mostrar
Model modelo una "mochila" donde metes los datos que quieres pasar al HTML. Spring te la da automáticamente, tú solo la usas
        * */


        modelo.addAttribute("personajes", ApiRoutes.Personajes);
      //  modelo.addAttribute("personaje","s"); // añadir como etiquetas para cceder los datos en el html
        return "index"; // Nombre del archivo html sin el . html


    }
}
