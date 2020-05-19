package xyz.matve.spreparer;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import xyz.matve.spreparer.models.Sale;
import xyz.matve.spreparer.repos.SaleRepo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Первоначальная загрузка данных
 */
@Component
@ConditionalOnProperty(name = "init-data", havingValue = "true")
@Slf4j
public class InitData implements ApplicationRunner {
    @Autowired
    public SaleRepo saleRepo;

    // TODO либо выпелить, либо вынести в конфигурацию Spring @Value
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



    // TODO логгировать вызовы
    public static Sale createSale(int appUserId, String product, int qty) {
        Sale sale = new Sale();
        sale.setAppUserId(appUserId);
        sale.setProduct(product);
        sale.setQty(qty);

        return sale;
    }

    public void run(ApplicationArguments args) throws Exception {
        final Configuration cfg = new Configuration();
        log.info("write fake data...");

        List<Sale> list = new ArrayList<Sale>(){{
            add(createSale(1, "prod1", 5));
            add(createSale(1, "prod2", 2));
            add(createSale(1, "prod3", 4));
            add(createSale(2, "prod4", 3));
            add(createSale(2, "prod5", 2));
            add(createSale(2, "prod6", 6));
        }};

        saleRepo.saveAll(list);
    }

}