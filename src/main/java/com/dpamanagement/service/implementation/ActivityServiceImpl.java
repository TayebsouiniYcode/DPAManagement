package com.dpamanagement.service.implementation;

import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;
import com.dpamanagement.repository.ActivityRepository;
import com.dpamanagement.repository.implementation.ActivityRepositoryImpl;
import com.dpamanagement.service.ActivityService;
import com.dpamanagement.repository.ActivityRepository;
import com.dpamanagement.repository.implementation.ActivityRepositoryImpl;

import java.util.List;

public class ActivityServiceImpl implements ActivityService {

    ActivityRepository activityRepository = new ActivityRepositoryImpl ();

    @Override
    public List<Activity> getAll() {
        return  activityRepository.getAll();
    }

    @Override
    public void add(Activity activity) {
        activityRepository.add(activity);
    }

    @Override
    public int count ( ) {
        return activityRepository.count();
    }
    public void delete ( int id ) {
        System.out.println ("this is service : " + id );
        activityRepository.delete(id);
    }

    @Override
    public void update ( Activity activity ) {
        activityRepository.update(activity);
    }
}
