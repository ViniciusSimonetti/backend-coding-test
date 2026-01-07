package com.farmtech.productsapi.service.interfaces;

import com.farmtech.productsapi.dto.ProductDTO;
import org.springframework.stereotype.Service;


public interface ProductService {
   ProductDTO saveProduct(ProductDTO productDTO);

}
