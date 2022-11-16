package com.dpamanagement.dao;

import com.dpamanagement.entity.Users;

import java.util.List;

public interface UserDao {
    Users add( Users u);
    List<Users> getAll();

    void update(Users user);
    void delete(int id);
}