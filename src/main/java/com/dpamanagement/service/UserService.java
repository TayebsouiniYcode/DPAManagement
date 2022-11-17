package com.dpamanagement.service;

import com.dpamanagement.entity.Users;

import java.util.ArrayList;
import java.util.List;

public interface UserService {

    Users add( Users u);
    Users login(Users user);
    List<Users> getAll();
    int count();
    void update(Users user);
    boolean delete(int id);

}