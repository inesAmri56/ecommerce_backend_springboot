package com.example.e_commerce.repositories;

import com.example.e_commerce.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDAO extends JpaRepository<Category,Long> {

}
