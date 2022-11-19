package com.dpamanagement.dao;

import com.dpamanagement.entity.Users;

import java.util.List;

public interface UserDao {
    Users addUser( Users u);
    List<Users> getAllUsers();
    boolean updateUser(Users user);
    boolean deleteUserById(int id);
    Users getUserById(Long id);
}