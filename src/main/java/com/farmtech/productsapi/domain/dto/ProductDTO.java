package com.farmtech.productsapi.domain.dto;

import java.time.LocalDateTime;

//DTO para representar dados de produtos
public class ProductDTO {

    public Long id; //Identificador único do produto
    public String name; // Nome do produto (único e obrigatório)
    public String  status; //Status do produto (enum)

    public FarmerDTO farmer; //Produtor associado ao produto

    public LocalDateTime createdAt; //Data de criação
    public LocalDateTime updatedAt; //Data de atualização

}
