package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository repo;
    public List<PersonajeEntity> getAll() {
        return repo.findAll();
    }
public PersonajeEntity getId(Long id ){
    return repo.findById(id).orElse(null);  // si no existe devuelve null
       // return repo.findById(id);
}
public void deleteId(Long id ){
        repo.deleteById(id);
}

public PersonajeEntity add(PersonajeEntity p ){
return repo.save(p);
}
    public Map<String, Object> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonajeEntity> resultado = repo.findAll(pageable);
        //Creare un objeto primero para que represente una partado en el json osea:
        /*
        * info:{
        * Numero pagina...
        * }
        * */
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("paginaActual", resultado.getNumber());     // página actual
        info.put("totalPaginas", resultado.getTotalPages()); // total paginas
        info.put("totalElementos", resultado.getTotalElements()); // total registros

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Info", new ArrayList<Object>());
        response.put("personajes", resultado.getContent());      // los  elementos/datos

        return response;
    }

    public PersonajeEntity update(Long id, PersonajeEntity p) {
        p.setId(id);        //  Poner id que se quiere modificar
        return repo.save(p); //  UPDATE porque tiene id
    }
}
