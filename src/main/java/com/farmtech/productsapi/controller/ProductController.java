package com.farmtech.productsapi.controller;
import com.farmtech.productsapi.dto.ProductDTO;

import com.farmtech.productsapi.mapper.Mapper;
import com.farmtech.productsapi.model.ProductModel;
import com.farmtech.productsapi.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    private Mapper mapper = new Mapper();

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Cria um novo produto
    @PostMapping
    public ProductDTO create(@RequestBody ProductModel product) {
        //Implementando o mapper
        ProductDTO productDTO = mapper.MapperToDTO(product);
        productDTO.farmer = mapper.MapperToDTO(product.farmer);

        return productService.saveProduct(productDTO);
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
