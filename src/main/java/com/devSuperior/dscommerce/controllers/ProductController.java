package com.devSuperior.dscommerce.controllers;

import com.devSuperior.dscommerce.dto.CustomError;
import com.devSuperior.dscommerce.dto.ProductDTO;
import com.devSuperior.dscommerce.entities.Product;
import com.devSuperior.dscommerce.repositories.ProductRepository;
import com.devSuperior.dscommerce.services.ProductService;
import com.devSuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value= "/products")
public class ProductController {

    @Autowired
    private ProductService service;
    @GetMapping (value= "/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable long id){
           ProductDTO dto= service.findById(id);
           return ResponseEntity.ok(dto);
       }

    @GetMapping
    public ResponseEntity <Page <ProductDTO>> findAll
            (@RequestParam(name="name", defaultValue = " ") String name, Pageable pageable){
        Page <ProductDTO> dto= service.findAll(name, pageable);
        return ResponseEntity.ok(dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity <ProductDTO> insert(@Valid @RequestBody ProductDTO dto){
    dto= service.insert(dto);
    URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
    }
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping (value= "/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable long id,@Valid @RequestBody ProductDTO dto){
       dto= service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping (value= "/{id}")
    public ResponseEntity<Void> update (@PathVariable long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
