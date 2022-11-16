package com.dpamanagement.service;

import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;


import java.util.List;

public interface ActivityService {
    List<Activity> getAll();
    void add(Activity activity);
    int count();
    void delete(int id);
    void update(Activity activity);
}
