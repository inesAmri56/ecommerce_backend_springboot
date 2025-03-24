package com.example.e_commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "product")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    double price;
    String ref;
    String description;
    int qte;
    @ManyToOne
    @JoinColumn(name = "subcategory_id",nullable = false)
    @JsonIgnoreProperties("product")
    private SubCategory subcategory;
    @ManyToOne
    @JoinColumn(name = "provider_id",nullable = false)
    @JsonIgnoreProperties("product")
    private Provider provider;
    @OneToMany(mappedBy = "product")
    @JsonIgnoreProperties("product")
    private Collection <Gallery> galleries;
    @ManyToMany(mappedBy = "products",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("product")
    private Collection<Order> orders;

}
