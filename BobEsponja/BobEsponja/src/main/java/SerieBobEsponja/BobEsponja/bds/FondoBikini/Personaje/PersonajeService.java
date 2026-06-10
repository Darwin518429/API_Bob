package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository pr;
    public List<PersonajeEntity> getAll() {
        return pr.findAll();
    }
public PersonajeEntity getId(Long id ){

        return pr.findByid(id);
}
public void deleteId(Long id ){

        pr.deleteById(id);
}
}
