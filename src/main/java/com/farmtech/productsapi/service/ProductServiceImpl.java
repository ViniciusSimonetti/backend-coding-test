package com.farmtech.productsapi.service;

import com.farmtech.productsapi.data.Farmer;
import com.farmtech.productsapi.data.Product;
import com.farmtech.productsapi.dto.ProductDTO;
import com.farmtech.productsapi.mapper.Mapper;
import com.farmtech.productsapi.repository.Interfaces.FarmerRepository;
import com.farmtech.productsapi.repository.Interfaces.ProductRepository;
import com.farmtech.productsapi.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    private Mapper mapper = new Mapper();

    //Implementação para salvar um produto no H2 database
    @Override
    public ProductDTO saveProduct(ProductDTO productDTO) {
        //Implementando o mapper
        Product product  = mapper.MapperToEntity(productDTO);
        product.farmer = mapper.MapperToEntity(productDTO.farmer);
        product.createdAt = LocalDateTime.now();
        product.updatedAt = LocalDateTime.now();

        //Salvando o farmer primeiro para garantir a integridade referencial
        Farmer farmer = farmerRepository.save(product.farmer);
        Product result  =  productRepository.save(product);
        ProductDTO dto = mapper.MapperToDTO(result);
        dto.farmer = mapper.MapperToDTO(farmer);
        return dto;
    }
}

