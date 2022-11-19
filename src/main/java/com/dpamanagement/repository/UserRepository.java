package com.dpamanagement.repository;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;

import java.util.List;

public interface UserRepository {

    Users addUser( Users user);
    Users login(Users user);
    int numberOfUsers();
    List<Users> getAllUsers();
    List< Role > getAllRole();
    List<Users> getAllUserByRoleName(String roleName);
    void updateUser(Users user);
    boolean deleteUserById (int id);
    Long getLatestIdUserInDb();


}