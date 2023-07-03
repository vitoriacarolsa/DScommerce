package com.devSuperior.dscommerce.controllers;

import com.devSuperior.dscommerce.dto.ProductDTO;
import com.devSuperior.dscommerce.entities.Product;
import com.devSuperior.dscommerce.repositories.ProductRepository;
import com.devSuperior.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity <Page <ProductDTO>> findAll(Pageable pageable){
        Page <ProductDTO> dto= service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity <ProductDTO> insert(@RequestBody ProductDTO dto){
    dto= service.insert(dto);
    URI uri= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
            .buildAndExpand(dto.getId()).toUri();
    return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping (value= "/{id}")
    public ResponseEntity<ProductDTO> update (@PathVariable long id, @RequestBody ProductDTO dto){
       dto= service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

}
