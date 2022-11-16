package com.dpamanagement.repository.implementation;
import com.dpamanagement.dao.UserDao;
import com.dpamanagement.dao.implementation.UserDaoImpl;
import com.dpamanagement.entity.Users;
import com.dpamanagement.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;


public class UserRepositoryImpl implements UserRepository {
    Users user =new Users();
    UserDao userDao = new UserDaoImpl ();
    @Override
    public Users add(Users user) {
        return userDao.add(user);
    }

    @Override
    public Users login ( Users user ) {
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager entityManager = emf.createEntityManager();
            Query query = entityManager.createQuery ( "SELECT u FROM Users  u WHERE u.username= :username" );
            query.setParameter("username", user.getUsername ());
            user = (Users) query.getSingleResult ();
            return  user;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List < Users > getAll ( ) {
        return userDao.getAll();
    }

    @Override
    public void update ( Users user ) {
        userDao.update(user);
    }

    @Override
    public void delete ( int id ) {
        userDao.delete(id);
    }


}