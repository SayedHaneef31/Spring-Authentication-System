package com.Project._5.SpringSecurityLearning.Entity;


import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Product")
public class Product
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;



    public Product(String name, Double price) {

        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
