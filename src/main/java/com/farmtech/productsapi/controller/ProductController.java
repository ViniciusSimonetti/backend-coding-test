package com.farmtech.productsapi.controller;
import com.farmtech.productsapi.dto.ProductDTO;

import com.farmtech.productsapi.mapper.Mapper;
import com.farmtech.productsapi.model.ProductModel;
import com.farmtech.productsapi.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

//Controlador REST para gerenciar produtos
@RestController
@RequestMapping("/products")

public class ProductController {
    //Injetando o serviço de produtos
    private final ProductService productService;
    //Instanciando o mapper
    private Mapper mapper = new Mapper();

    //Construtor para injeção de dependência
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //Cria um novo produto
    @PostMapping("Create")
    public ProductDTO create(@RequestBody ProductModel product) {
        //Implementando o mapper
        ProductDTO productDTO = mapper.MapperToDTO(product);
        productDTO.farmer = mapper.MapperToDTO(product.farmer);

        return productService.saveProduct(productDTO);
    }

    //Atualiza um produto existente
    @PutMapping("Update/{id}")
    public ProductDTO update(@PathVariable Long id, @RequestBody ProductModel  product) {
        ProductDTO productDTO = mapper.MapperToDTO(product);
        productDTO.farmer = mapper.MapperToDTO(product.farmer);
        return productService.updateProduct(id, productDTO);
    }

    //Lista os produtos
    @GetMapping("List")
    public List<ProductDTO> list() {
        return Collections.emptyList();
    }

    //Faz a busca do produto atraves do ID
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return new ProductDTO();
    }
}
