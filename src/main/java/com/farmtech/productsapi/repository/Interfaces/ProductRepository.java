package com.farmtech.productsapi.repository.Interfaces;

import com.farmtech.productsapi.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//Interface para o repositório de produtos
public interface ProductRepository extends JpaRepository<Product, Long> {
}
