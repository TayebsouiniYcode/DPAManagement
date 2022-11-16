package com.dpamanagement.dao;

import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;


import java.util.List;

public interface ActivityDao {
    List< Activity > getAll();
    void add(Activity activity);

    void delete(int id);
    void update(Activity activity);
}
