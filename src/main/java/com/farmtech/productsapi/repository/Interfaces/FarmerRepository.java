package com.farmtech.productsapi.repository.Interfaces;

import com.farmtech.productsapi.data.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

}
