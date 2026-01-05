package com.farmtech.productsapi.controller;

import com.farmtech.productsapi.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    //Cria um novo produto
    @PostMapping
    public String create(@RequestBody ProductDTO product) {
        return "OK";
    }

    //Atualiza um produto existente
    @PutMapping("/{id}")
    public String update(@PathVariable Long id, @RequestBody ProductDTO product) {
        return "OK";
    }

    //Lista os produtos
    @GetMapping
    public List<ProductDTO> list() {
        return Collections.emptyList();
    }

    //Faz a busca do produto atraves do ID
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return new ProductDTO();
    }
}
