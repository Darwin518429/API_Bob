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
//JPA  Java Persistence API
/*
* Nos sirve para especificar como se debe de comnuicar java entre las bds omo la implmentacion mysql  hecho
con JDBC pero aqui est ams automatizado
* */

//HIbernate es el que traduce las classe a codigo sql(Agarra el codigo del dao y lo transforma en sql)