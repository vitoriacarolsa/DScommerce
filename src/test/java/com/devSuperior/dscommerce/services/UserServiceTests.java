package com.devSuperior.dscommerce.services;

import com.devSuperior.dscommerce.entities.User;
import com.devSuperior.dscommerce.projections.UserDetailsProjection;
import com.devSuperior.dscommerce.repositories.UserRepository;
import com.devSuperior.dscommerce.tests.UserDetailsFactory;
import com.devSuperior.dscommerce.tests.UserFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    private String existingUserName, nonExistingUserName;
    private User user;
    private List<UserDetailsProjection> userDetails;

    @BeforeEach
    void setUp() throws Exception {
        existingUserName = "maria@gmail.com";
        nonExistingUserName = "user@gmail.com";

        user = UserFactory.createCustomClientUser(1L, existingUserName);
        userDetails = UserDetailsFactory.createCustomAdminUser(existingUserName);

        Mockito.when(repository.searchUserAndRolesByEmail(existingUserName)).thenReturn(userDetails);
        Mockito.when(repository.searchUserAndRolesByEmail(nonExistingUserName)).thenReturn(new ArrayList<>());
    }

    @Test
    public void loadUserByUsernameShouldReturnUserDetailsWhenUserExists() {

        UserDetails result = service.loadUserByUsername(existingUserName);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.getUsername(), existingUserName);
    }

    @Test
    public void loadUserByUsernameShouldThrowUserNotFoundExceptionWhenUserDoesNotExists() {

        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername(nonExistingUserName);
        });

    }
}
