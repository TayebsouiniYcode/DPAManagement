package com.dpamanagement.servlet;

import com.dpamanagement.service.ActivityService;
import com.dpamanagement.service.ExerciceService;
import com.dpamanagement.service.UserService;
import com.dpamanagement.service.implementation.ActivityServiceImpl;
import com.dpamanagement.service.implementation.ExerciceServiceImp;
import com.dpamanagement.service.implementation.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns ={"/dashboard"})
public class AdminServlet extends HttpServlet {
    UserService userService = new UserServiceImpl ();
    ActivityService activityService = new ActivityServiceImpl ();
    ExerciceService exerciceService = new ExerciceServiceImp ();
    @Override
    protected void doGet ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path) {
            case "/dashboard":
                int numberOfUsers = userService.numberOfUsers ();
                int numberOfActivities = activityService.count();
                int numberOfExercice = exerciceService.count();

                request.setAttribute ( "numberOfUsers", numberOfUsers );
                request.setAttribute ( "numberOfActivities", numberOfActivities );
                request.setAttribute ( "numberOfExercices ", numberOfExercice );

                request.getRequestDispatcher("/admin/dashboard.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {

    }
}
