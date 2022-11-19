package com.dpamanagement.service.implementation;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;
import com.dpamanagement.repository.UserRepository;
import com.dpamanagement.repository.implementation.UserRepositoryImpl;
import com.dpamanagement.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepo = new UserRepositoryImpl () ;
    @Override
    public Users addUser(Users user) {
        return userRepo.addUser(user);
    }

    @Override
    public Users login ( Users user ) {
        return userRepo.login(user);
    }

    @Override
    public List < Users > getAllUsers ( ) {return userRepo.getAllUsers ();}

    @Override
    public List < Role > getAllRole ( ) {return userRepo.getAllRole();}

    @Override
    public List < Users > gitAllUsersByRoleName (String roleName ) {return userRepo.getAllUserByRoleName (roleName);}

    @Override
    public int numberOfUsers ( ) {
        return userRepo.numberOfUsers();
    }

    @Override
    public void updateUser ( Users user ) {userRepo.updateUser(user);}

    @Override
    public boolean deleteUserById ( int id ) {
        return userRepo.deleteUserById(id);
    }
}