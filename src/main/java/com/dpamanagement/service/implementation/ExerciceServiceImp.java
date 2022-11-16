package com.dpamanagement.service.implementation;

import com.dpamanagement.entity.Exercice;
import com.dpamanagement.repository.implementation.ExerciceRepositoryImp;
import com.dpamanagement.service.ExerciceService;
import com.dpamanagement.repository.ExerciceRipository;


import java.util.List;

public class ExerciceServiceImp implements ExerciceService {
    ExerciceRipository exerciceRepository = new ExerciceRepositoryImp ();

    @Override
    public List < Exercice > getAll ( ) {
        return exerciceRepository.getAll();
    }

    @Override
    public void add ( Exercice exercice ) {
        exerciceRepository.add(exercice);
    }

    @Override
    public void delete ( int id ) {
        System.out.println ("this is service : " + id );
        exerciceRepository.delete(id);
    }

    @Override
    public int count ( ) {
        return exerciceRepository.count();
    }

    @Override
    public void update ( Exercice exercise ) {
        exerciceRepository.update(exercise);
    }
}
