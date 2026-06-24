package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import SerieBobEsponja.BobEsponja.Exception.StringInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
@Autowired
private ProductoRespository dao;
    //Consultas predeterminadas
   public List<ProductoEntity> getNombreRestaurante(String nom){
        if(nom.isBlank()) throw new  StringInvalidException("Error");

        List<ProductoEntity> ls = dao.findByNombreStartingWithOrderByIdAsc(nom);
        if(ls.isEmpty()) throw  new  StringInvalidException("Error vacio");
        return ls;
    }
}
