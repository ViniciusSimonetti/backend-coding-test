package com.farmtech.productsapi.repository.Interfaces;

import com.farmtech.productsapi.data.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
//Interface para o repositório de agricultores
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    //Método para encontrar um agricultor pelo documento
    Farmer findByDocument(String document);
}
