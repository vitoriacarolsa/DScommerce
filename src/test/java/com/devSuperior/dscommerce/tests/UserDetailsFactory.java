package com.devSuperior.dscommerce.tests;

import com.devSuperior.dscommerce.projections.UserDetailsProjection;

import java.util.ArrayList;
import java.util.List;

public class UserDetailsFactory {

    public static List<UserDetailsProjection> createCustomClientUser(String username) {
        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetaisImpl(username, "123", 1L, "ROLE_CLIENT"));

        return list;
    }


    public static List<UserDetailsProjection> createCustomAdminUser(String username) {
        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetaisImpl(username, "123", 2L, "ROLE_ADMIN"));

        return list;
    }


    public static List<UserDetailsProjection> createCustomAdminClientUser(String username) {
        List<UserDetailsProjection> list = new ArrayList<>();
        list.add(new UserDetaisImpl(username, "123", 1L, "ROLE_ADMIN"));
        list.add(new UserDetaisImpl(username, "123", 2L, "ROLE_CLIENT"));
        return list;
    }
}

class UserDetaisImpl implements UserDetailsProjection {
    private String username;
    private String password;
    private Long roleId;
    private String authorities;

    public UserDetaisImpl(){
    }

    public UserDetaisImpl(String username, String password, Long roleId, String authorities) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Long getRoleId() {
        return roleId;
    }

    @Override
    public String getAuthority() {
        return authorities;
    }
}