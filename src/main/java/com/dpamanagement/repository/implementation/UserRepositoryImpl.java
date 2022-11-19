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
    public List < Users > getAllUsers ( ) {return userDao.getAllUsers();}

    @Override
    public Users addUser(Users user) {
        return userDao.addUser(user);
    }

    @Override
    public void updateUser ( Users user ) {
        userDao.updateUser(user);
    }

    @Override
    public boolean deleteUserById ( int id ) {
        return userDao.deleteUserById (id);
    }

    @Override
    public int numberOfUsers ( ) {
        Query query = entityManager.createQuery ( "SELECT COUNT(u) FROM Users  u" );
        int count = Integer.parseInt ( String.valueOf ( query.getSingleResult () ) );
        return count;
    }

    @Override
    public List < Role > getAllRole ( ) {
        Query query = entityManager.createQuery ( "SELECT r FROM Role r" );
        List<Role> roleList =  query.getResultList ();
        return roleList;
    }

    @Override
    public List < Users > getAllUserByRoleName ( String roleName) {
        Query query = entityManager.createQuery ( "SELECT u FROM Users u WHERE u.role.name=:role" );
        query.setParameter ( "role", roleName );
        List<Users> userList =  query.getResultList ();
        return userList;
    }

    @Override
    public Long getLatestIdUserInDb ( ) {
        entityManager.getTransaction ().begin ();
        Query query = entityManager.createQuery ( "Select MAX(u.id) FROM Users u ");
        Long id = (Long) query.getSingleResult ();
        return id;
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
}