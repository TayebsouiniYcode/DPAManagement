package com.dpamanagement.repository.implementation;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;
import com.dpamanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryImplTest {
    UserRepository userRepository = new UserRepositoryImpl ();

    @Test
    void getAllUsers ( ) {
        assertNotNull ( userRepository.getAllUsers () );
    }

    @Test
    void addUser ( ) {
        boolean status = true;
        var user = new Users (  null,
                "Aymane",
                "Darji",
                "0605223652",
                "aymaneDarji",
                "aymane@gmail.com",
                "123",
                status,
                new Role ( Long.parseLong ( String.valueOf ( 1 ) ) ) );

        Users _user = userRepository.addUser ( user );
        assertNotNull ( _user.getId () );
        assertTrue ( userRepository.deleteUserById ( Integer.parseInt ( String.valueOf ( _user.getId () )) ));
        assertNotNull ( _user );
        assertEquals ( status, _user.isState () );
    }
}