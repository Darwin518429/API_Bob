package SerieBobEsponja.BobEsponja.bds.test;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRespository extends JpaRepository<testEntity, Long> {
    //Page<testEntity> findAllByOrderByIdAsc(Pageable pageable);
}
