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
    public Users add(Users user) {
        return userRepo.add(user);
    }

    @Override
    public Users login ( Users user ) {
        return userRepo.login(user);
    }

    @Override
    public List < Users > getAll ( ) {
        System.out.println ("this is service" );
        return userRepo.getAll();
    }

    @Override
    public List < Role > getAllRole ( ) {
        return userRepo.getAllRole();
    }

    @Override
    public List < Users > getAllParticipant ( ) {
        return userRepo.getAllParticipant ();
    }

    @Override
    public int count ( ) {
        return userRepo.count();
    }

    @Override
    public void update ( Users user ) {
        userRepo.update(user);
    }

    @Override
    public boolean delete ( int id ) {
        return userRepo.delete(id);
    }
}



