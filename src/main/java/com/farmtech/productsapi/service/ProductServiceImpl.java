package com.farmtech.productsapi.service;

import com.farmtech.productsapi.data.Farmer;
import com.farmtech.productsapi.data.Product;
import com.farmtech.productsapi.dto.FarmerDTO;
import com.farmtech.productsapi.dto.ProductDTO;
import com.farmtech.productsapi.mapper.Mapper;
import com.farmtech.productsapi.repository.Interfaces.FarmerRepository;
import com.farmtech.productsapi.repository.Interfaces.ProductRepository;
import com.farmtech.productsapi.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    //Repositorio para acessar os dados dos produtos
    @Autowired
    private ProductRepository productRepository;

    //Repositorio para acessar os dados dos farmers
    @Autowired
    private FarmerRepository farmerRepository;
    //Classe responsavel por converter entre DTOs e entidades
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

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        // Busca o produto pelo id
        // Se não existir, lança erro
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Atualiza os campos básicos
        product.name = productDTO.name;
        product.status = productDTO.status;

        // Atualiza a data de modificação
        product.updatedAt = LocalDateTime.now();

        // Atualiza o farmer associado, se fornecido
        if(productDTO.farmer != null) {
            // Busca o farmer pelo documento
            Farmer farmer = farmerRepository.findByDocument(productDTO.farmer.document);
            if (farmer != null) {
                // Atualiza os campos do farmer
                farmer.farmName = productDTO.farmer.farmName;
                farmer.document = productDTO.farmer.document;
                farmer.state = productDTO.farmer.state;
                // Salva o farmer atualizado
                farmerRepository.save(farmer);
                product.farmer = farmer;
            }
        }
        productRepository.save(product);
        // Salva o produto atualizado
        ProductDTO resultDTO = mapper.MapperToDTO(product);
        resultDTO.farmer = mapper.MapperToDTO(product.farmer);

        return resultDTO;
    }


    //Implementação para atualizar um produto no H2 database
    @Override
    public List<ProductDTO> listProducts() {
        return productRepository.findAll()
                .stream()
                .map(p -> {
                    ProductDTO dto = mapper.MapperToDTO(p);
                    if (p.farmer != null) dto.farmer = mapper.MapperToDTO(p.farmer);
                    return dto;
                })
                .toList();
    }

    @Override
    public ProductDTO getById(Long id) {
        return null;
    }


}

