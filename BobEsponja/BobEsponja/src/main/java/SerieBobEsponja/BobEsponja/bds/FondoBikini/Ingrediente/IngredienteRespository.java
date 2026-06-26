package SerieBobEsponja.BobEsponja.bds.FondoBikini.Ingrediente;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido.PedidoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRespository extends JpaRepository<IngredienteEntity, Long> {
    Page<IngredienteEntity> findAllByOrderByIdAsc(Pageable pageable);
}
