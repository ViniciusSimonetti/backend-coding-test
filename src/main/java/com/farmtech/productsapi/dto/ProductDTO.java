package com.farmtech.productsapi.dto;
import java.time.LocalDateTime;

public class ProductDTO {

    private Long id; // Chave primária

    private String name; // Nome do produto (único e obrigatório)
    private String  status; //Status do produto (enum)
    private FarmerDTO farmerDTO; //Produtor associado ao produto

    private LocalDateTime createdAt; //Data de criação
    private LocalDateTime updatedAt; //Data de atualização

}
