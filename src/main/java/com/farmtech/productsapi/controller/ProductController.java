package com.farmtech.productsapi.controller;
import com.farmtech.productsapi.domain.dto.ProductDTO;

import com.farmtech.productsapi.domain.mapper.Mapper;
import com.farmtech.productsapi.domain.model.ProductModel;
import com.farmtech.productsapi.service.interfaces.ProductService;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    //ResponseEntity para tratamento de erros de validacao
    public ResponseEntity <Object> create(@RequestBody ProductModel product) {
        //Implementando o mapper
        ProductDTO productDTO = mapper.MapperToDTO(product);
        productDTO.farmer = mapper.MapperToDTO(product.farmer);

        //Condicao para retornar status HTPP de acordo com os erros de validacao
        Object result = productService.saveProduct(productDTO);
        if(result instanceof String)
            return new ResponseEntity<>(result, HttpStatusCode.valueOf(500));
        else
            return new ResponseEntity<>(result, HttpStatusCode.valueOf(200));
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
        return productService.listProducts();
    }
    //Faz a busca do produto atraves do ID
    @GetMapping("/{id}")
    public ProductDTO getById(@PathVariable Long id) {
        return productService.getById(id);
    }
}
