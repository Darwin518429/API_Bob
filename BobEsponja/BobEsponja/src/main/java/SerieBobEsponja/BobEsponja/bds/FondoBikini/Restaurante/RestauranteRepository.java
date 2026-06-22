package SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteEntity, Long> {
    Page<RestauranteEntity> findAllByOrderByIdAsc(Pageable pageable);

    @Query("SELECT r.propietario, COUNT(r) FROM RestauranteEntity r GROUP BY r.propietario ORDER BY COUNT(r) DESC")
    List<Object[]> getPropietariosRestaurantes();


}
