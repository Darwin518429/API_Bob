package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository repo;
    public List<PersonajeEntity> getAll() {
        return repo.findAll();
    }
public PersonajeEntity getId(Long id ){

        return repo.findByid(id);
}
public void deleteId(Long id ){
        repo.deleteById(id);
}

public PersonajeEntity add(PersonajeEntity p ){
return repo.save(p);
}

    public PersonajeEntity update(Long id, PersonajeEntity p) {
        p.setId(id);        // ← Poner id que se quiere modificar
        return repo.save(p); // ← UPDATE porque tiene id
    }
}
