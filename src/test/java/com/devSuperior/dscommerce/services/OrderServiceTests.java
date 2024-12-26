package com.devSuperior.dscommerce.services;

import com.devSuperior.dscommerce.dto.OrderDTO;
import com.devSuperior.dscommerce.entities.Order;
import com.devSuperior.dscommerce.entities.User;
import com.devSuperior.dscommerce.repositories.OrderRepository;
import com.devSuperior.dscommerce.services.exceptions.ForbiddenException;
import com.devSuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import com.devSuperior.dscommerce.tests.OrderFactory;
import com.devSuperior.dscommerce.tests.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
public class OrderServiceTests {

    @InjectMocks
    private OrderService service;

    @Mock
    private OrderRepository repository;

    @Mock
    private AuthService authService;

    private Long existingOrderId, nonExistingOrderId;
    private Order order;
    private OrderDTO orderDTO;
    private User admin, client;

    @BeforeEach
    void setUp() throws Exception{
        existingOrderId = 1L;
        nonExistingOrderId = 2L;

        admin = UserFactory.createCustomAdminUser(1L, "Jef");
        client = UserFactory.createCustomClientUser(2L, "Bob");

        order = OrderFactory.createOrder(client);

        orderDTO = new OrderDTO(order);

        Mockito.when(repository.findById(existingOrderId)).thenReturn(Optional.of(order));
        Mockito.when(repository.findById(nonExistingOrderId)).thenReturn(Optional.empty());
    }

    @Test
    public void findByIdShouldReturnOrderDTOWhenIdExistsAndAdminLogged() {
        Mockito.doNothing().when(authService).validateSelfOrAdmin(any());

        OrderDTO result = service.findById(existingOrderId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingOrderId);

    }


    @Test
    public void findByIdShouldReturnOrderDTOWhenIdExistsAndSelfClientLogged() {
        Mockito.doNothing().when(authService).validateSelfOrAdmin(any());

        OrderDTO result = service.findById(existingOrderId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getId(), existingOrderId);

    }

    @Test
    public void findByIdThrowsForbiddenExceptionWhenIdExistsAndOtherClientLogged() {
        Mockito.doThrow(ForbiddenException.class).when(authService).validateSelfOrAdmin(any());

        Assertions.assertThrows(ForbiddenException.class, () ->{
            OrderDTO result = service.findById(existingOrderId);
        });
    }

    @Test
    public void findByIdThrowsResourceNotFoundExceptionWhenIdDoesNotExist() {
        Mockito.doNothing().when(authService).validateSelfOrAdmin(any());

        Assertions.assertThrows(ResourceNotFoundException.class, () ->{
            OrderDTO result = service.findById(nonExistingOrderId);
        });
    }

}
