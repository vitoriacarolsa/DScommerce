package com.devSuperior.dscommerce.tests;

import com.devSuperior.dscommerce.entities.Role;
import com.devSuperior.dscommerce.entities.User;

import java.time.LocalDate;

public class UserFactory {

    public static User createClienteUser() {
        User user = new User(1L, "Maria", "maria@gmail.com", "988118822", LocalDate.parse("2001-07-25"), "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }

    public static User createAdminUser() {
        User user = new User(2L, "Alex", "alex@gmail.com", "988118822", LocalDate.parse("2001-07-25"), "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        user.addRole(new Role(2L, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomAdminUser(Long id, String username){
        User user = new User(id, "Alex", username, "988282818", LocalDate.parse("1987-11-11"), "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        user.addRole(new Role(id, "ROLE_ADMIN"));
        return user;
    }

    public static User createCustomClientUser(Long id, String username){
        User user = new User(id, "Maria", username, "988118822", LocalDate.parse("2001-07-25"), "$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG");
        user.addRole(new Role(1L, "ROLE_CLIENT"));
        return user;
    }
}
