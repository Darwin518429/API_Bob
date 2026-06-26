package SerieBobEsponja.BobEsponja.bds.FondoBikini.Pedido;

import SerieBobEsponja.BobEsponja.bds.FondoBikini.Restaurante.RestauranteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository  extends JpaRepository<PedidoEntity, Long> {
    Page<PedidoEntity> findAllByOrderByIdAsc(Pageable pageable);

    @Query("SELECT p  FROM PedidoEntity p WHERE p.total >= ?1 ")
    List<PedidoEntity> getPedidomasde(Float precio);
}
