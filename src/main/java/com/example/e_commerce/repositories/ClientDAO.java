package com.example.e_commerce.repositories;

import com.example.e_commerce.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDAO extends JpaRepository<Client,Long> {
    List<Client> id(Long id);
}
