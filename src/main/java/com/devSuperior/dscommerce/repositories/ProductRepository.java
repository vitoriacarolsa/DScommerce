package com.devSuperior.dscommerce.repositories;

import com.devSuperior.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
