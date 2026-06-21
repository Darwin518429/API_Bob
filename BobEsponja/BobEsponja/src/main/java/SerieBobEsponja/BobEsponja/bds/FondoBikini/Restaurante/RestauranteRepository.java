package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
    Page<RestauranteEntity> findAllByOrderByIdAsc(Pageable pageable);
  /*  @Query(
            SELECT r.id, COUNT(r.)
            FROM RestauranteEntity r
            GROUP BY id
            )
    Map<Long,Integer> getPropietariosRestaurantes();)
    Map<Long,Integer> getPropietariosRestaurantes(); //Hahsmpa*/
   // List<RestauranteEntity> findByNombreContainingOrderByNombreAsc(String nombre); // Buscar si continene caracteres especificos


}
