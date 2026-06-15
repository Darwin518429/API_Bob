package SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<PersonajeEntity, Long> {
    //NO HACE FALTA PONER LOS METODOS PREDETMINADOS D EJPA YA TIENEN POR DEFECTO
    //SOLO POMER METODOS PERSONALIZADOS
/*
PersonajeEntity findByid(Long id);
 List<PersonajeEntity> findAll();
 PersonajeEntity save(PersonajeEntity p);
 Page<PersonajeEntity> getAll(int page, int size);*/
//save nos puede serviar para añadir o modficar
    // Mira el objeto si tiene id modifia si no tiene o añade

//Consutlas personalizadas
// En el Repository
Page<PersonajeEntity> findAllByOrderByNombreDesc(Pageable pageable);
    List<PersonajeEntity> findByNombreContainingOrderByNombreAsc(String nombre); // Buscar si continene caracteres especificos
   List<PersonajeEntity> findByEspecieOrderByNombreAsc(String Especie); // Buscar  por especie


}
