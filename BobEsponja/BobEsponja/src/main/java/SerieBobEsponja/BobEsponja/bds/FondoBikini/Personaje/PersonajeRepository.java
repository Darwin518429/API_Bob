package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
public PersonajeEntity findByid(Long id);
}
