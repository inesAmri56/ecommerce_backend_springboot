package com.example.e_commerce.repositories;

import com.example.e_commerce.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order,Long> {
}
