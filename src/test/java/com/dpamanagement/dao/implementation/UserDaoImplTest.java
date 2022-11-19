package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.UserDao;
import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;
import com.dpamanagement.repository.UserRepository;
import com.dpamanagement.repository.implementation.UserRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl ();
    UserRepository userRepository = new UserRepositoryImpl ();

    @Test
    void testingAddUserToDataBase ( ) {
        var user = new Users ( null,
                "Khalid",
                "Hagane",
                "0603948857",
                "Khalidhagane",
                "KhalidHagane@gmail.com",
                "123",
                true,
                new Role ( Long.parseLong ( String.valueOf ( 1 ) )));

        assertEquals ( user, userDao.addUser ( user ) );
        assertNotNull ( user.getId () );
    }

    @Test
    void deleteUserWithIdOnly(){
        Long id = userRepository.getLatestIdUserInDb ();
        assertTrue ( userDao.deleteUserById ( Integer.parseInt ( String.valueOf ( id ) ) ) );
    }

    @Test
    void updateUsernameForLatestUser(){
        Long latestUserId = userRepository.getLatestIdUserInDb ( );
        Users user = userDao.getUserById ( latestUserId );
        user.setUsername ("Kazoum");
        assertTrue ( userDao.updateUser ( user ) );
    }

    @Test
    void selectLatestUser(){
        Long latestUserId = userRepository.getLatestIdUserInDb ( );
        assertTrue ( userDao.deleteUserById ( Integer.parseInt ( String.valueOf ( latestUserId ) ) ) );
        assertFalse ( userDao.deleteUserById ( Integer.parseInt ( String.valueOf ( latestUserId )  ) ));
    }

    @Test
    void gettAllUsers() {
        assertNotNull ( userDao.getAllUsers () );
    }
}