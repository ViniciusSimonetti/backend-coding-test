package com.farmtech.productsapi.repository.Interfaces;

import com.farmtech.productsapi.data.Farmer;
import com.farmtech.productsapi.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//Interface para o repositório de produtos
public interface ProductRepository extends JpaRepository<Product, Long> {
}
