package com.farmtech.productsapi.service.interfaces;

import com.farmtech.productsapi.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

//Interface para o serviço de produtos
public interface ProductService {
   //metodo para salvar um produto
   Object saveProduct(ProductDTO productDTO);

   //metodo para atualizar um produto
   ProductDTO updateProduct(Long id, ProductDTO productDTO);

   //Lista todos os produtos
   List<ProductDTO> listProducts();

   //metodo para buscar um produto pelo id
   ProductDTO getById(Long id);

}
