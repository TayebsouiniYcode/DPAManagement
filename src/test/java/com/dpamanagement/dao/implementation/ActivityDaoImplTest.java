package com.dpamanagement.dao.implementation;

import com.dpamanagement.dao.ActivityDao;
import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;
import com.dpamanagement.entity.Users;
import com.dpamanagement.repository.ActivityRepository;
import com.dpamanagement.repository.implementation.ActivityRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoImplTest {

    ActivityDao activityDao = new ActivityDaoImpl ();
    ActivityRepository activityRepository = new ActivityRepositoryImpl ();
    @Test
    void addActivity(){
        var activity = new  Activity ( null ,
                "UnitTestActivity" ,
                "Description by unit testing" ,
                LocalDate.of(2021, 9, 13) ,
                LocalDate.of(2022, 12, 13) ,
                true ,
                null ,
                null ,
                null );

        assertNotNull ( activityDao.add ( activity ));
    }

    @Test
    void deleteActivityById(){
        Long latestActivityId = activityRepository.getLatestActivityId();
        assertNotNull ( latestActivityId );

        assertTrue ( activityDao.delete ( Integer.parseInt ( String.valueOf ( latestActivityId ) ) ) );
    }


}