package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import SerieBobEsponja.BobEsponja.Config.ApiRoutes;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RESTRestauranteController {
@Autowired
RestauranteService service;
    @GetMapping("/restaurantes" /*ApiRoutes.Restaurantes*/)
    public List<Object> getPersonaOcupacion(){

        return service.getPropietario();
    };
}
