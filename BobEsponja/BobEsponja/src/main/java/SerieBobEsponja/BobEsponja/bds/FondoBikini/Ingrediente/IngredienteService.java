package SerieBobEsponja.BobEsponja.bds.FondoBikini.Ingrediente;

import SerieBobEsponja.BobEsponja.Exception.*;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido.PedidoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class IngredienteService {
    @Autowired
    IngredienteRespository dao;

    public IngredienteEntity getId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);

        return dao.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(ErrorMensajes.IngredienteId));
    }
    public void deleteId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        dao.deleteById(id);
    }
    //Hare pequeñas comprovaciones
    public IngredienteEntity add(IngredienteEntity p ){
        if(p == null ) throw new AddException(ErrorMensajes.IngredienteAdd);

        return dao.save(p);
    }

    public Map<String, Object> getAll(int page, int size)  {
        if(page <= 0 ) throw new GetPageException(ErrorMensajes.IngredientePage);
        if(size <= 0 ) throw  new GetSizeException(ErrorMensajes.IngredienteSize);
        Pageable pageable = PageRequest.of(page - 1 , size); // Pongo -1 para que empieze en uno
        Page<IngredienteEntity> resultado = dao.findAllByOrderByIdAsc(pageable);
        if (resultado.isEmpty()) throw new GetPageException(ErrorMensajes.IngredientePage);
        //Creare un objeto primero para que represente una partado en el json osea:
        /*
         * info:{
         * Numero pagina...
         * }
         * */
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("paginaActual", resultado.getNumber() + 1)  ;     // pagina actual
        info.put("totalPaginas", resultado.getTotalPages()); // total paginas
        info.put("totalElementos", resultado.getTotalElements()); // total registros

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("Info",info);
        response.put("Ingrediente", resultado.getContent());      // los  elementos/datos

        return response;
    }
    //SE DEBE DE REEMPLAZAR POR COMPLETO
    public IngredienteEntity update(Long id, IngredienteEntity p) {
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        if(dao.findById(id).isEmpty()) throw new AddException(ErrorMensajes.IngredienteId);
        p.setId(id);        //  Vamos a reemplazar todos los cambios del personaje actual
        return dao.save(p); // Hara  UPDATE porque detectara el objeto que tendra una id (Si tiene id actualizara)
    }
}
