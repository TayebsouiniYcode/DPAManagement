package com.dpamanagement.repository.implementation;
import com.dpamanagement.dao.UserDao;
import com.dpamanagement.dao.implementation.UserDaoImpl;
import com.dpamanagement.entity.Role;
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

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    @Override
    public Users add(Users user) {
        return userDao.add(user);
    }

    @Override
    public Users login ( Users user ) {
        try {
            Query query = entityManager.createQuery ( "SELECT u FROM Users  u WHERE u.username= :username" );
            query.setParameter("username", user.getUsername ());
            user = (Users) query.getSingleResult ();
            return  user;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public int count ( ) {
        Query query = entityManager.createQuery ( "SELECT COUNT(u) FROM Users  u" );
        int count = Integer.parseInt ( String.valueOf ( query.getSingleResult () ) );
        return count;
    }

    @Override
    public List < Users > getAll ( ) {
        return userDao.getAll();
    }

    @Override
    public List < Role > getAllRole ( ) {
        Query query = entityManager.createQuery ( "SELECT r FROM Role r" );
        List<Role> roleList =  query.getResultList ();
        return roleList;
    }

    @Override
    public List < Users > getAllParticipant ( ) {
        Query query = entityManager.createQuery ( "SELECT u FROM Users u WHERE u.role.name=:role" );
        query.setParameter ( "role", "participant" );
        List<Users> userList =  query.getResultList ();
        return userList;
    }


    @Override
    public void update ( Users user ) {
        userDao.update(user);
    }

    @Override
    public boolean delete ( int id ) {
        return userDao.delete(id);
    }


}