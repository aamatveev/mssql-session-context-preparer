package xyz.matve.spreparer.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.matve.spreparer.models.Sale;

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
