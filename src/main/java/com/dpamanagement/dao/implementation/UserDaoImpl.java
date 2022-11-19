package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.UserDao;
import com.dpamanagement.entity.Users;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserDaoImpl implements UserDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public Users addUser( Users u) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(u);
            entityManager.getTransaction().commit();
            return u;
        }catch ( Exception e){
            return null;
        }

    }

    @Override
    public List<Users> getAllUsers() {
        //CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //CriteriaQuery <Users> cq = cb.createQuery(Users.class);
        //Root <Users> rootEntry = cq.from(Users.class);
        //CriteriaQuery<Users> all = cq.select(rootEntry);
        //TypedQuery <Users> allQuery = entityManager.createQuery(all);
        //List<Users> usersList = allQuery.getResultList();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("SELECT u FROM Users u");
            List<Users> usersList = query.getResultList();
            entityManager.getTransaction().commit();
            return usersList;
        } catch (Exception e) {
            System.out.println ("error : " + e.toString () );
            entityManager.getTransaction ().rollback ();
            return null;
        }
    }

    @Override
    public Users getUserById ( Long id ) {
        Users user = entityManager.find ( Users.class, id );
        return user;
    }

    @Override
    public boolean updateUser(Users user) {
        Users _user = entityManager.find(Users.class, user.getId());

        try{
            entityManager.getTransaction().begin();
            _user.setFirstName(user.getFirstName());
            _user.setLastName(user.getLastName());
            _user.setEmail(user.getEmail());
            _user.setPhone(user.getPhone());
            _user.setState(user.isState());
            _user.setRole(user.getRole());
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(int id) {
        Users user = entityManager.find(Users.class, Long.parseLong ( String.valueOf ( id)));
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(user);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e){
            entityManager.getTransaction ().rollback ();
            return false;
        }
    }


}
