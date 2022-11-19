package com.dpamanagement.service;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    Users addUser( Users u);
    Users login(Users user);
    List<Users> getAllUsers();
    List< Role > getAllRole();
    List<Users> gitAllUsersByRoleName(String roleName);
    int numberOfUsers();
    void updateUser(Users user);
    boolean deleteUserById(int id);

}