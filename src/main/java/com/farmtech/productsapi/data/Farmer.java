package com.farmtech.productsapi.data;

import jakarta.persistence.*;

@Entity
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id; //define um numero maior de algoritmos de geracao de ID

    @Column(nullable = false, unique = true)
    public String document; //CPF unico e obrigatorio

    @Column(nullable = false)
    public String farmName; //Nome da fazenda obrigatorio

    @Column(nullable = false)
    public String state; //Estado obrigatorio
}