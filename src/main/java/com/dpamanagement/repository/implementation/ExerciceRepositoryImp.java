package com.dpamanagement.repository.implementation;

import com.dpamanagement.dao.ExerciceDAO;
import com.dpamanagement.dao.implementation.ExerciceDAOImp;
import com.dpamanagement.entity.Exercice;
import com.dpamanagement.repository.ExerciceRipository;
import com.dpamanagement.service.ExerciceService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class ExerciceRepositoryImp implements ExerciceRipository {
    ExerciceDAO exerciceDAO = new ExerciceDAOImp ();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = emf.createEntityManager();

    @Override
    public List < Exercice > getAll ( ) {
        return exerciceDAO.getAll ();
    }

    @Override
    public int count ( ) {
        Query query = entityManager.createQuery ( "SELECT COUNT(e) FROM Exercice e" );
        int count = Integer.parseInt ( String.valueOf ( query.getSingleResult () ) );
        return count;
    }

    @Override
    public void add ( Exercice exercice ) {
        exerciceDAO.add(exercice);
    }

    @Override
    public void delete ( int id ) {
        System.out.println ("this is repository " + id );
        exerciceDAO.delete(id);
    }

    @Override
    public void update ( Exercice exercise ) {
        exerciceDAO.update(exercise);
    }
}
