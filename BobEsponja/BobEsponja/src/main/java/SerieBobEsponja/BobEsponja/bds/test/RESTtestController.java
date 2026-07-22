package SerieBobEsponja.BobEsponja.bds.test;

import SerieBobEsponja.BobEsponja.config.PagConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
@RestController
public class RESTtestController {
@Autowired
testService service;


    //Obtener  los personajes
    @GetMapping("/test")
    public List<testEntity>getAll(
    ) {
        return service.getAll();

    }

}
