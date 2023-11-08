package com.devSuperior.dscommerce.controllers;

import com.devSuperior.dscommerce.dto.OrderDTO;
import com.devSuperior.dscommerce.dto.ProductDTO;
import com.devSuperior.dscommerce.dto.ProductMinDTO;
import com.devSuperior.dscommerce.services.ProductService;
import com.devSuperior.dscommerce.services.exceptions.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value= "/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping (value= "/{id}")
    public ResponseEntity<OrderDTO> findById(@PathVariable long id){
           OrderDTO dto= service.findById(id);
           return ResponseEntity.ok(dto);
       }
}
