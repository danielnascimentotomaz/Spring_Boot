package com.api.product_ms.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity // Para dizer que essa classe vai ser uma entidade
@Table(name = "tb_product") // Se  não colocar  anotação @Table o nome da tabela assumira
// o nome da classe
@Data // como nois estamos usando lombok com a notação @Data ele cria pra nois os gets sets equals hashcode
public class Product {
    @Id // id da tabela
    @GeneratedValue(strategy = GenerationType.AUTO)// gera automaticamente o id
    @Column(name = "id") // nome da coluna
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private  String description;

    @Column(name = "price",nullable = false)
    private double Price;

    @Column(name = "available")
    private boolean available;

}
