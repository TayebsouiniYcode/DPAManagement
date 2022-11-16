package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.ActivityDao;
import com.dpamanagement.entity.Activity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ActivityDaoImpl implements ActivityDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    @Override
    public List<Activity> getAll() {
        System.out.println ("this is place " );
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery ( "SELECT a FROM Activity a" );
        List<Activity> activityList =  query.getResultList ();
        entityManager.getTransaction().commit();
        System.out.println (activityList.toString () );
        return activityList;
    }

    @Override
    public void add(Activity activity) {
        entityManager.getTransaction().begin();
        entityManager.persist ( activity );
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete ( int id ) {
        Activity activity = entityManager.find(Activity.class, Long.parseLong ( String.valueOf ( id)));

        entityManager.getTransaction().begin();
        entityManager.remove(activity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update ( Activity activity ) {
        Activity _activity = entityManager.find(Activity.class, activity.getId ());

        entityManager.getTransaction().begin();
        _activity.setDateDebut (activity.getDateDebut ());
        _activity.setDateFin(activity.getDateFin());
        _activity.setDescription(activity.getDescription());
        _activity.setStatus(activity.getStatus());
        _activity.setTitle(activity.getTitle());

        entityManager.getTransaction().commit();
    }

}
