package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Personaje.PersonajeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRespository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByNombreStartingWithOrderByIdAsc(String nombre);
    Page<ProductoEntity> findAllByOrderByIdAsc(Pageable pageable);
}
