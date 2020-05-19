package xyz.matve.pool.controllers;

import com.zaxxer.hikari.pool.HikariPool;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.matve.pool.models.Sale;
import xyz.matve.pool.repos.SaleRepo;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static xyz.matve.pool.InitData.createSale;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SaleRepo saleRepo;

    @Autowired(required = false)
    private SessionFactory sessionFactory;

    @GetMapping(value = "")
    public List<Sale> fetchAll(){
        return saleRepo.findAll();
    }

    @GetMapping(value = "/populate")
    public String populate(){
        try{
            List<Sale> list = new ArrayList<Sale>(){{
                add(createSale(1, "prod7", 5));
                add(createSale(1, "prod8", 2));
                add(createSale(1, "prod9", 4));
                add(createSale(2, "prod10", 3));
                add(createSale(2, "prod11", 2));
                add(createSale(2, "prod12", 6));
            }};

            saleRepo.populate(list);

            return "success";
        }catch (Throwable error) {
            return "failed:" + error.getMessage();
        }

    }
}
