package com.devSuperior.dscommerce.services;

import com.devSuperior.dscommerce.dto.CategoryDTO;
import com.devSuperior.dscommerce.dto.ProductDTO;
import com.devSuperior.dscommerce.dto.ProductMinDTO;
import com.devSuperior.dscommerce.entities.Category;
import com.devSuperior.dscommerce.entities.Product;
import com.devSuperior.dscommerce.repositories.CategoryRepository;
import com.devSuperior.dscommerce.repositories.ProductRepository;
import com.devSuperior.dscommerce.services.exceptions.DatabaseException;
import com.devSuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Transactional (readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = repository.findAll();
        return result.stream().map(x->new CategoryDTO(x)).toList();
    }


    }


