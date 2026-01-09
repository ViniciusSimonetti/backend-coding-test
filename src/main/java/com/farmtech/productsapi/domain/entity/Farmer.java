package com.farmtech.productsapi.domain.entity;

import jakarta.persistence.*;

//Entidade JPA para representar um agricultor no banco de dados
@Entity
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id; //define um numero maior de algoritmos de geracao de ID

    @Column(nullable = false)
    public String document; //Documento obrigatorio

    @Column(nullable = false)
    public String farmName; //Nome da fazenda obrigatorio

    @Column(nullable = false)
    public String state; //Estado obrigatorio
}