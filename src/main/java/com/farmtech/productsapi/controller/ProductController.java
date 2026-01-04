package com.farmtech.productsapi.controller;

import model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @PostMapping("/Create")
    public String create(@RequestBody Product product) {
        System.out.print(product.name);
        return "OK";
    }
    @PutMapping ("/Uptade")
    public String uptade(int id, @RequestBody Product product) {
        return "OK";
    }
    @GetMapping ("/List")
    public String List(int id) {
        return "OK";
    }

}