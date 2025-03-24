package com.example.e_commerce.repositories;

import com.example.e_commerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Long> {
}
