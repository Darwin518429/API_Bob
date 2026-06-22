package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import SerieBobEsponja.BobEsponja.Exception.*;
import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class RestauranteService {
    @Autowired
    RestauranteRepository RestauranteDao;

    public List<Map<String, Object>> getPropietarios() {
        List<Object[]> resultado = RestauranteDao.getPropietariosRestaurantes();
        List<Map<String, Object>> lista = new ArrayList<>();

        for (Object[] fila : resultado) {
            Map<String, Object> item = new LinkedHashMap<>();
            item.put("propietario", fila[0]);
            item.put("total", fila[1]);
            lista.add(item);
        }
        return lista;

    }


    public Map<String, Object> getAll(int page, int size)  {
        if(page <= 0 ) throw new GetPagePersonajeException(ErrorMensajes.RestaurentePage);
        if(size <= 0 ) throw  new GetSizePersonajeException(ErrorMensajes.RestaurentePage);
        Pageable pageable = PageRequest.of(page - 1 , size); // Pongo -1 para que empieze en uno
        Page<RestauranteEntity> resultado = RestauranteDao.findAllByOrderByIdAsc(pageable);

        Map<String, Object> info = new LinkedHashMap<>();
        info.put("paginaActual", resultado.getNumber() + 1)  ;     // pagina actual
        info.put("totalPaginas", resultado.getTotalPages()); // total paginas
        info.put("totalElementos", resultado.getTotalElements()); // total registros

        Map<String, Object> response = new LinkedHashMap<>();

        response.put("Info",info);
        response.put("restaurantes", resultado.getContent());      // los  elementos/datos

        return response;
    }


    public RestauranteEntity getId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);

        return RestauranteDao.findById(id)
                .orElseThrow(() -> new PersonajeNotFoundException(ErrorMensajes.RestauranteId));
    }
    public void deleteId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        RestauranteDao.deleteById(id);
    }
    //Hare pequeñas comprovaciones
    public RestauranteEntity add(RestauranteEntity p ){
        if(p.getNombre().length() < 4 ) throw new AddPersonajeException(ErrorMensajes.RestauranteAdd);

        return RestauranteDao.save(p);
    }

    public RestauranteEntity update(Long id, RestauranteEntity p) {
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        if(RestauranteDao.findById(id).isEmpty()) throw new AddPersonajeException(ErrorMensajes.RestauranteId);
        p.setId(id);        //  Vamos a reemplazar todos los cambios del personaje actual
        return RestauranteDao.save(p); // Hara  UPDATE porque detectara el objeto que tendra una id (Si tiene id actualizara)
    }
}
