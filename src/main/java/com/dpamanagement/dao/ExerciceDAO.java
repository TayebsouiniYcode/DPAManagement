package com.dpamanagement.dao;

import com.dpamanagement.entity.Exercice;

import java.util.List;

public interface ExerciceDAO {
    List < Exercice > getAll();
    void add(Exercice exercice);
    void delete(int id);
    void update(Exercice exercise);
}
