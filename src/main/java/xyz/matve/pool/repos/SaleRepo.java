package xyz.matve.pool.repos;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xyz.matve.pool.models.Sale;

import java.util.List;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer> {

//    @Transactional
    default boolean populate(List<Sale> sales) {
        for (Sale sale :
                sales) {
            save(sale);
        }
        return true;
    }

}
