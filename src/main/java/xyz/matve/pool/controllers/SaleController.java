package xyz.matve.pool.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.matve.pool.models.Sale;
import xyz.matve.pool.repos.SaleRepo;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleRepo saleRepo;

    @GetMapping(value = "")
    public List<Sale> fetchAll(){
        return saleRepo.findAll();
    }
}
