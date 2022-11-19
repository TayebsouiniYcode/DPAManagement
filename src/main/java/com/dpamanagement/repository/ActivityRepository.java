package com.dpamanagement.repository;

import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;

import java.util.List;

public interface ActivityRepository {

    List<Activity> getAll();
    void add(Activity activity);
    int count();
    boolean delete(int id);
    void update(Activity activity);
    Long getLatestActivityId();
}
