package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import SerieBobEsponja.BobEsponja.Exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonajeService {
    @Autowired
  private   PersonajeRepository repo;
   /* public List<PersonajeEntity> getAll() {
        return repo.findAll();
    }*/
public PersonajeEntity getId(Long id ){
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);

        return repo.findById(id)
        .orElseThrow(() -> new ElementNotFoundException(ErrorMensajes.PersonajeNotFound));
}
public void deleteId(Long id ){
    if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
    repo.deleteById(id);
}
//Hare pequeñas comprovaciones
public PersonajeEntity add(PersonajeEntity p ){
    if(p.getNombre().length() < 4 || p.getEspecie().length() < 2  ) throw new AddPersonajeException(ErrorMensajes.PersonajeAddException);

return repo.save(p);
}
    public List<PersonajeEntity> getPersonajeOcupacion(String Ocupacion ){
        if(Ocupacion.isBlank()) throw new StringInvalidException(ErrorMensajes.InvalidString);
        return repo.findByOcupacionOrderByNombreAsc(Ocupacion);
    };

    public Map<String, Object> getAll(int page, int size)  {
        if(page <= 0 ) throw new GetPageException(ErrorMensajes.PersonajePage);
        if(size <= 0 ) throw  new GetSizeException(ErrorMensajes.PersonajeEleemnt);
        Pageable pageable = PageRequest.of(page - 1 , size); // Pongo -1 para que empieze en uno
        Page<PersonajeEntity> resultado = repo.findAllByOrderByIdAsc(pageable);
        if (resultado.isEmpty()) throw new GetPageException(ErrorMensajes.PersonajePage);
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
        response.put("personajes", resultado.getContent());      // los  elementos/datos

        return response;
    }
//SE DEBE DE REEMPLAZAR POR COMPLETO
    public PersonajeEntity update(Long id, PersonajeEntity p) {
        if(id <= 0 ) throw new IdInvalidException(ErrorMensajes.InvalidId);
        if(repo.findById(id).isEmpty()) throw new AddPersonajeException(ErrorMensajes.PersonajeNotFound);
        p.setId(id);        //  Vamos a reemplazar todos los cambios del personaje actual
        return repo.save(p); // Hara  UPDATE porque detectara el objeto que tendra una id (Si tiene id actualizara)
    }
}
