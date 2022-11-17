package com.dpamanagement.repository;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;

import java.util.List;

public interface UserRepository {

    Users add( Users user);
    Users login(Users user);
    int count();
    List<Users> getAll();
    List< Role > getAllRole();
    List<Users> getAllParticipant();
    void update(Users user);
    boolean delete (int id);


}