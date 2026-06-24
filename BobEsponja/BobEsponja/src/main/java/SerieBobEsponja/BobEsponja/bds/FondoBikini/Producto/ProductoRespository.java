package SerieBobEsponja.BobEsponja.bds.FondoBikini.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductoRespository extends JpaRepository<ProductoEntity, Long> {
    List<ProductoEntity> findByNombreStartingWithOrderByIdAsc(String nombre);

}
