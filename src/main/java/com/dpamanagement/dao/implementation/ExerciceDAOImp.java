package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.ExerciceDAO;
import com.dpamanagement.entity.Exercice;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ExerciceDAOImp implements ExerciceDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();
    @Override
    public List < Exercice > getAll ( ) {

        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery ( "SELECT e FROM Exercice e" );
        List<Exercice> exerciseList =  query.getResultList ();
        entityManager.getTransaction().commit();
        return exerciseList;
    }
    @Override
    public void add ( Exercice exercice ) {
        entityManager.getTransaction().begin();
        entityManager.persist ( exercice );
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete ( int id ) {
        Exercice exercice = entityManager.find(Exercice.class, id);

        entityManager.getTransaction().begin();
        entityManager.remove(exercice);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update ( Exercice exercise ) {
        Exercice _exercise = entityManager.find(Exercice.class, exercise.getId ());

        entityManager.getTransaction().begin();
        _exercise.setYear (exercise.getYear ());
        _exercise.setDateStart ( exercise.getDateStart () );
        _exercise.setEndDate ( exercise.getEndDate () );
        _exercise.setState ( exercise.isState () );
        _exercise.setDescription ( exercise.getDescription () );
        entityManager.getTransaction().commit();
    }
}
