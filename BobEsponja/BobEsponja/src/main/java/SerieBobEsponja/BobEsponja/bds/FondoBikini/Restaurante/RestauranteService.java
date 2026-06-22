package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class RestauranteService {
    @Autowired
    RestauranteRepository RestauranteDao;

    public List<Object> getPropietario(){
        return RestauranteDao.getPropietariosRestaurantes();
    }
}
