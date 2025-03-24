package com.example.e_commerce.repositories;

import com.example.e_commerce.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderDAO extends JpaRepository<Provider,Long> {
}
