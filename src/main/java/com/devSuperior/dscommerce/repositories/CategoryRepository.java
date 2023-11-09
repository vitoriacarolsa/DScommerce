package com.devSuperior.dscommerce.repositories;

import com.devSuperior.dscommerce.entities.Category;
import com.devSuperior.dscommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
