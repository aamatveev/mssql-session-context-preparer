package xyz.matve.spreparer.controllers;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.matve.spreparer.models.Sale;
import xyz.matve.spreparer.repos.SaleRepo;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static xyz.matve.spreparer.InitData.createSale;

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
}
