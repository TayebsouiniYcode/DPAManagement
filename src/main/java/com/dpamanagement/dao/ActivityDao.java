package com.dpamanagement.dao;

import com.dpamanagement.entity.Activity;


import java.util.List;

public interface ActivityDao {
    List< Activity > getAll();
    Activity add(Activity activity);

    boolean delete( int id);
    void update(Activity activity);
}
