package SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido;

import SerieBobEsponja.BobEsponja.Exception.*;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PedidoService {

    @Autowired
  private   PedidoRepository dao;
    public List<PedidoEntity>getAllList(){
        return dao.findAll();
    }
    public List<PedidoEntity> getpedidosmasde(Float precio){
    if(precio < 0 ) throw  new PrecioInvalidException(ErrorMensajes.PedidoPrecio);
    return dao.getPedidomasde(precio);
    }


    public PedidoEntity getId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);

        return dao.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(ErrorMensajes.PedidoId));
    }
    public void deleteId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        dao.deleteById(id);
    }
    //Hare pequeñas comprovaciones
    public PedidoEntity add(PedidoEntity p ){
        if(p == null ) throw new AddException(ErrorMensajes.PeidoAdd);

        return dao.save(p);
    }

    public Map<String, Object> getAll(int page, int size)  {
        if(page <= 0 ) throw new GetPageException(ErrorMensajes.PedidoPage);
        if(size <= 0 ) throw  new GetSizeException(ErrorMensajes.PedidoSize);
        Pageable pageable = PageRequest.of(page - 1 , size); // Pongo -1 para que empieze en uno
        Page<PedidoEntity> resultado = dao.findAllByOrderByIdAsc(pageable);
        if (resultado.isEmpty()) throw new GetPageException(ErrorMensajes.PedidoPage);
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
        response.put("Pedidos", resultado.getContent());      // los  elementos/datos

        return response;
    }
    //SE DEBE DE REEMPLAZAR POR COMPLETO
    public PedidoEntity update(Long id, PedidoEntity p) {
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        if(dao.findById(id).isEmpty()) throw new AddException(ErrorMensajes.PedidoId);
        p.setId(id);        //  Vamos a reemplazar todos los cambios del personaje actual
        return dao.save(p); // Hara  UPDATE porque detectara el objeto que tendra una id (Si tiene id actualizara)
    }
}
