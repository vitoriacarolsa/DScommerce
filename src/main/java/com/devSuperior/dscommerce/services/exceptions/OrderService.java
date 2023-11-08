package com.devSuperior.dscommerce.services.exceptions;

import com.devSuperior.dscommerce.dto.OrderDTO;
import com.devSuperior.dscommerce.dto.ProductDTO;
import com.devSuperior.dscommerce.entities.Order;
import com.devSuperior.dscommerce.entities.Product;
import com.devSuperior.dscommerce.repositories.OrderRepository;
import com.devSuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;
    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = repository.findById(id).orElseThrow
                (() -> new ResourceNotFoundException("Recurso não encontrado"));
        return new OrderDTO(order);
    }
}
