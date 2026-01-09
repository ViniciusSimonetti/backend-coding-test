package com.farmtech.productsapi.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

//Entidade JPA para representar produtos no banco de dados
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id; //Chave primária

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
