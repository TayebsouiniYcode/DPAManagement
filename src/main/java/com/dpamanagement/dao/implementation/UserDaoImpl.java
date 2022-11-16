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
    public Users add( Users u) {
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.getTransaction().commit();
        return u;
    }

    @Override
    public List<Users> getAll() {
        //CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        //CriteriaQuery <Users> cq = cb.createQuery(Users.class);
        //Root <Users> rootEntry = cq.from(Users.class);
        //CriteriaQuery<Users> all = cq.select(rootEntry);
        //TypedQuery <Users> allQuery = entityManager.createQuery(all);
        //List<Users> usersList = allQuery.getResultList();
        System.out.println ("this is dao user" );
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT u FROM Users u");
        List<Users> usersList = query.getResultList();
        entityManager.getTransaction().commit();

        System.out.println(usersList.toString());
        return usersList;
    }

    @Override
    public void update(Users user) {
        Users _user = entityManager.find(Users.class, user.getId());

        entityManager.getTransaction().begin();
        _user.setFirstName(user.getFirstName());
        _user.setLastName(user.getLastName());
        _user.setEmail(user.getEmail());
        _user.setPhone(user.getPhone());
        _user.setState(user.isState());
        _user.setRole(user.getRole());
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Users user = entityManager.find(Users.class, Long.parseLong ( String.valueOf ( id)));

        entityManager.getTransaction().begin();
        entityManager.remove(user);
        entityManager.getTransaction().commit();
    }
}
