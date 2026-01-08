package com.farmtech.productsapi.mapper;

import com.farmtech.productsapi.dto.FarmerDTO;
import com.farmtech.productsapi.data.Farmer;
import com.farmtech.productsapi.data.Product;
import com.farmtech.productsapi.dto.ProductDTO;
import com.farmtech.productsapi.model.FarmerModel;
import com.farmtech.productsapi.model.ProductModel;

public class Mapper {
    //Mapear ProductDTO para Product entity
    public Product MapperToEntity(ProductDTO productDTO) {

        Product product = new Product();
        product.name = productDTO.name;
        product.status = productDTO.status;

        return product;
    }

    //Mapear Product entity para ProductDTO
    public ProductDTO MapperToDTO(Product product) {

        ProductDTO productDTO = new ProductDTO();
        productDTO.id = product.id;
        productDTO.name = product.name;
        productDTO.status = product.status;
        productDTO.createdAt = product.createdAt;
        productDTO.updatedAt = product.updatedAt;

        return productDTO;
    }

    //Mapear ProductModel para ProductDTO
    public ProductDTO MapperToDTO (ProductModel product){

        ProductDTO productDTO = new ProductDTO();
        productDTO.name = product.name;
        productDTO.status = product.status;

        return productDTO;
    }

    //--------------------------------------------------------

    //Mapear FarmerDTO para Farmer entity
    public Farmer MapperToEntity(FarmerDTO farmerDTO) {

        Farmer farmer = new Farmer();
        farmer.document = farmerDTO.document;
        farmer.farmName = farmerDTO.farmName;
        farmer.state = farmerDTO.state;

        return farmer;
    }

    //Mapear Farmer entity(Data) para FarmerDTO
    public FarmerDTO MapperToDTO(Farmer farmer) {

        FarmerDTO farmerDTO = new FarmerDTO();
        farmerDTO.document = farmer.document;
        farmerDTO.farmName = farmer.farmName;
        farmerDTO.state = farmer.state;

        return farmerDTO;
    }

    //Mapear FarmerModel para FarmerDTO
     public FarmerDTO MapperToDTO(FarmerModel farmer) {

         FarmerDTO farmerDTO = new FarmerDTO();
         farmerDTO.document = farmer.document;
         farmerDTO.farmName = farmer.farmName;
         farmerDTO.state = farmer.state;

         return farmerDTO;

     }
}
