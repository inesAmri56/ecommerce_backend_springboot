package com.example.e_commerce.repositories;

import com.example.e_commerce.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverDAO  extends JpaRepository<Driver,Long> {
}
