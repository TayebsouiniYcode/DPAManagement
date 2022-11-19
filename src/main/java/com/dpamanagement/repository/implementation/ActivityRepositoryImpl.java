package com.dpamanagement.repository.implementation;

import com.dpamanagement.dao.ActivityDao;
import com.dpamanagement.dao.implementation.ActivityDaoImpl;
import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;
import com.dpamanagement.repository.ActivityRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ActivityRepositoryImpl implements ActivityRepository {
    ActivityDao activityDAO = new ActivityDaoImpl();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public List<Activity> getAll ( ) {
        return activityDAO.getAll ();
    }

    @Override
    public void add ( Activity activity ) {
        activityDAO.add(activity);
    }

    @Override
    public int count ( ) {
        Query query = entityManager.createQuery ( "SELECT COUNT(a) FROM Activity  a" );
        int count = Integer.parseInt ( String.valueOf ( query.getSingleResult ( ) ) );
        return count;
    }

    @Override
    public boolean delete ( int id ) {
        try {
            activityDAO.delete(id);
            return true;
        } catch (Exception e) {
            System.out.println (e.toString () );
            return false;
        }
    }

    @Override
    public void update ( Activity activity ) {
        activityDAO.update(activity);
    }

    @Override
    public Long getLatestActivityId() {
        try {
            entityManager.getTransaction ().begin();
            Query query = entityManager.createQuery ( "Select MAX(a.id) FROM Activity a" );
            Long latestActivityId = (Long) query.getSingleResult ();
            entityManager.getTransaction ().commit ();
            return latestActivityId;
        } catch (Exception e) {
            entityManager.getTransaction ().rollback ();
            System.out.println (e.toString () );
            return null;
        }
    }
}
