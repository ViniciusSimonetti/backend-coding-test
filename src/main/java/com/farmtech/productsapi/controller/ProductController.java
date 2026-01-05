package com.farmtech.productsapi.controller;

import com.farmtech.productsapi.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String create(@RequestBody Product product) {
        return "OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody Product product) {
        return "OK";
    }

    @GetMapping
    public List<Product> list() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return new Product();
    }
}
