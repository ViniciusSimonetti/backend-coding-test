package com.farmtech.productsapi.data;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; // Chave primária

    @Column(nullable = false, unique = true)//Nao vai permitir duplicidade de nome
    public String name; // Nome do produto (único e obrigatório)

    @Column(nullable = false)
    public String  status; //Status do produto (enum)

    @ManyToOne
    public Farmer farmer; //Produtor associado ao produto

    @Column
    public LocalDateTime createdAt; //Data de criação
    @Column
    public LocalDateTime updatedAt; //Data de atualização

}
