package com.example.e_commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table(name = "subcategory")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class SubCategory  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    @JsonIgnoreProperties("subcategories")
    private Category category ;
    @OneToMany(mappedBy = "subcategory")
    @JsonIgnoreProperties("subCategory")
    private Collection <Product>products;


}
