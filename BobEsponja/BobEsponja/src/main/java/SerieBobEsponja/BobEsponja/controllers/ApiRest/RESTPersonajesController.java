package SerieBobEsponja.BobEsponja.controllers.ApiRest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//Utilizemos anotaciones para poder especificarle a sprigboot u haga algo esa anoacion esta vinculado
//A un codigo que hace algo
// esta classe ya es para poder transformarlo en el json no
@RestController
public class RESTPersonajesController {
@GetMapping("/")
    public String  prueba (){
        return "Hola mundo!";
    }
}
