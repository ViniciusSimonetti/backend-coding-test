package com.farmtech.productsapi.model;

//Modelo para representar dados de produtos
public class ProductModel {
    public String name; // Nome do produto (único e obrigatório)
    public String  status; //Status do produto (enum)

    public FarmerModel farmer; //Produtor associado ao produto

}
