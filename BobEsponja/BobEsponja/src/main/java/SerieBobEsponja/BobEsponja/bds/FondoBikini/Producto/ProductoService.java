package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import SerieBobEsponja.BobEsponja.Exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Object> getAll(int page, int size)  {
        if(page <= 0 ) throw new GetPageException(ErrorMensajes.ProductoPage);
        if(size <= 0 ) throw  new GetSizeException(ErrorMensajes.ProductoSize);
        Pageable pageable = PageRequest.of(page - 1 , size); // Pongo -1 poruqe le indicaremos que sea la pag 0  para que empieze en uno
        Page<ProductoEntity> resultado = dao.findAllByOrderByIdAsc(pageable);
        if (resultado.isEmpty()) throw new GetPageException(ErrorMensajes.ProductoPage);
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("paginaActual", resultado.getNumber() + 1)  ;     // pagina actual
        info.put("totalPaginas", resultado.getTotalPages()); // total paginas
        info.put("totalElementos", resultado.getTotalElements()); // total registros

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("Info",info);
        response.put("restaurantes", resultado.getContent());      // los  elementos/datos

        return response;
    }


    public ProductoEntity getId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);

        return dao.findById(id)
                .orElseThrow(() -> new ElementNotFoundException(ErrorMensajes.ProductoId));
    }
    public void deleteId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.ProductoId);
        dao.deleteById(id);
    }
    //Hare pequeñas comprovaciones
    public ProductoEntity add(ProductoEntity p ){
        if(p.getNombre().length() < 4 ) throw new AddException(ErrorMensajes.RestauranteAdd);

        return dao.save(p);
    }

    public ProductoEntity update(Long id, ProductoEntity p) {
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        if(dao.findById(id).isEmpty()) throw new AddException(ErrorMensajes.RestauranteId);
        p.setId(id);        //  Vamos a reemplazar todos los cambios del personaje actual
        return dao.save(p); // Hara  UPDATE porque detectara el objeto que tendra una id (Si tiene id actualizara)
    }


}
