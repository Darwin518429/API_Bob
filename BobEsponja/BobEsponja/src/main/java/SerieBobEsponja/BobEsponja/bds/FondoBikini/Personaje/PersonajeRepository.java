package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {

public PersonajeEntity findByid(Long id);
public List<PersonajeEntity> findAll();
public PersonajeEntity save(PersonajeEntity p);

//save nos puede serviar para añadir o modficar
    /*
    * Mira el objeto si tiene id modifia si no tiene o añade
    * */
}
