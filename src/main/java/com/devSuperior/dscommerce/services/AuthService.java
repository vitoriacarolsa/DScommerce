package com.devSuperior.dscommerce.services;

import com.devSuperior.dscommerce.entities.User;
import com.devSuperior.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(Long userId){
        User me = userService.authenticated();
       if (me.hasRole("ROLE_ADMIN")){
           return;
       }
       if (!me.getId().equals(userId)){
           throw new ForbiddenException("Acess denied. Should be self or admin");
       }
    }
}
