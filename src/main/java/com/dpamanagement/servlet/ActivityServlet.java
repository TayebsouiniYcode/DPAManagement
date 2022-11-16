package com.dpamanagement.servlet;

import com.dpamanagement.entity.Activity;
import com.dpamanagement.entity.Exercice;
import com.dpamanagement.entity.Participant;
import com.dpamanagement.service.ActivityService;
import com.dpamanagement.service.ExerciceService;
import com.dpamanagement.service.ParticipantService;
import com.dpamanagement.service.implementation.ActivityServiceImpl;
import com.dpamanagement.service.implementation.ExerciceServiceImp;
import com.dpamanagement.service.implementation.ParticipantServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ActivityServlet", urlPatterns ={ "/activities", "/addActivity"})
public class ActivityServlet extends HttpServlet {
    ActivityService activityService = new ActivityServiceImpl( );
    Activity activity;
    ExerciceService exerciceService = new ExerciceServiceImp ();
    ParticipantService participantService = new ParticipantServiceImpl ();

    List<Activity> activityList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/activities":
                List<Activity> activityList = activityService.getAll();

                List<Exercice> exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );

                List<Participant> participantList = participantService.getAll();
                request.setAttribute ( "participantList", participantList );


                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);
                break;
            case  "/addActivity":
                request.getRequestDispatcher("/activity/addActivity.jsp").forward(request, response);
                break;
            case  "/deleteActivity" :
                int id = Integer.parseInt ( request.getParameter ( "id" ));
                System.out.println ("this is servlet : " + id );
                activityService.delete(id);
                activityList = activityService.getAll();
                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String route = request.getServletPath ();
        switch (route){
            case "/addActivity":
                LocalDate dateDebut = LocalDate.parse (request.getParameter ( "dateDebut" ));
                LocalDate dateFin = LocalDate.parse ( request.getParameter ( "dateFin" ));
                String description = request.getParameter ( "description" );
                Boolean status = Boolean.parseBoolean ( request.getParameter ( "status" ));
                String title = request.getParameter("title");
                Long idExercice = Long.parseLong (  request.getParameter ( "exercice" ));

                activity = new Activity (  );
                        activity.setDateDebut(dateDebut);
                        activity.setDateFin(dateFin);
                        activity.setDescription(description);
                        activity.setStatus(status);
                        activity.setTitle(title);
                        activity.setExercise(new Exercice ( idExercice));
                      //  activity.setParticipantList((List<Participant>) new Participant());
                activityService.add(activity);

                List<Activity> activityList = activityService.getAll();
                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);
                break;
            case "/editActivity":
                LocalDate date_Debut = LocalDate.parse (request.getParameter ( "dateDebut" ));
                LocalDate date_Fin = LocalDate.parse ( request.getParameter ( "dateFin" ));
                String descriptions = request.getParameter ( "description" );
                Boolean statu = Boolean.parseBoolean ( request.getParameter ( "status" ));
                String titles = request.getParameter("title");
                activity = new Activity (  );
                activity.setDateDebut(date_Debut);
                activity.setDateFin(date_Fin);
                activity.setDescription(descriptions);
                activity.setStatus(statu);
                activity.setTitle(titles);
                activity.setExercise(new Exercice((long) 1));
                //  activity.setParticipantList((List<Participant>) new Participant());
                //activityService.update(activity);


                activityList = activityService.getAll();
                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);

                break;
        }
    }
}
