package com.dpamanagement.repository;

import com.dpamanagement.entity.Exercice;

import java.util.List;

public interface ExerciceRipository {

    List < Exercice > getAll();
    int count();
    void add(Exercice exercice);
    void delete(int id);
    void update(Exercice exercise);
}
