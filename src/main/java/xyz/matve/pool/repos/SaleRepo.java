package xyz.matve.pool.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.matve.pool.models.Sale;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer> {

}
