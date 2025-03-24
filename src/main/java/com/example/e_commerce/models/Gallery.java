package com.example.e_commerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.aot.generate.GeneratedTypeReference;

@Entity
@Table(name ="gallery")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Gallery {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private  Long id;
    String url_photo;
    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("gallery")
    private Product product;
}
