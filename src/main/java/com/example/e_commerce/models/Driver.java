package com.example.e_commerce.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;

@Entity
@Table (name = "driver")
@Getter @Setter @NoArgsConstructor
@AllArgsConstructor
public class Driver extends User {

String adress;

    public Driver(Long id, String firstName, String lastName, String Email, String phoneNumber,
                  String password, String username, String adress) {
        super(id, firstName, lastName, Email, phoneNumber, password, username);
        this.adress = adress;
    }
    @OneToMany(mappedBy = "driver")
    @JsonIgnoreProperties("driver")
    private Collection <Order> orders ;
}
