package com.dpamanagement.servlet;

import com.dpamanagement.entity.*;
import com.dpamanagement.service.ActivityService;
import com.dpamanagement.service.ExerciceService;
import com.dpamanagement.service.ParticipantService;
import com.dpamanagement.service.UserService;
import com.dpamanagement.service.implementation.ActivityServiceImpl;
import com.dpamanagement.service.implementation.ExerciceServiceImp;
import com.dpamanagement.service.implementation.ParticipantServiceImpl;
import com.dpamanagement.service.implementation.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ActivityServlet", urlPatterns ={ "/activities", "/addActivity", "/editActivity", "/deleteActivity"})
public class ActivityServlet extends HttpServlet {
    ActivityService activityService = new ActivityServiceImpl( );
    Activity activity;
    ExerciceService exerciceService = new ExerciceServiceImp ();
    ParticipantService participantService = new ParticipantServiceImpl ();
    UserService userService = new UserServiceImpl ();

    List<Activity> activityList;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/activities":
                List<Users> participantList = userService.gitAllUsersByRoleName ("participant");
                request.setAttribute ( "participantList", participantList );


                List< Users > userList = userService.getAllUsers();
                request.setAttribute ( "userList", userList );

                List<Exercice> exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );

                //List<Participant> participantList = participantService.getAll();
                //request.setAttribute ( "participantList", participantList );

                List<Activity> activityList = activityService.getAll();
                System.out.println (activityList.toString () );
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
                List<Users> _participantList = userService.gitAllUsersByRoleName ("participant");
                request.setAttribute ( "participantList", _participantList );


                List< Users > _userList = userService.getAllUsers();
                request.setAttribute ( "userList", _userList );

                List<Exercice> _exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", _exerciceList );
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
                Long idResponsable = Long.parseLong (  request.getParameter ( "responsable" ));
                String[] participantId = request.getParameterValues ( "participants" );
                List<Users> participants = new ArrayList <> (  );
                if (participants.size () > 0){
                    for ( String s : participantId ) {
                        if (s != null){
                            participants.add ( new Users ( Long.parseLong ( s ) ) );
                        }
                }



                }

                activity = new Activity (  );
                        activity.setDateDebut(dateDebut);
                        activity.setDateFin(dateFin);
                        activity.setDescription(description);
                        activity.setStatus(status);
                        activity.setTitle(title);
                        activity.setExercise(new Exercice ( idExercice));
                        activity.setResponsable ( new Users ( idResponsable) );
                        activity.setParticipantList(participants);
                activityService.add(activity);

                List<Users> participantList = userService.gitAllUsersByRoleName ("participant");
                request.setAttribute ( "participantList", participantList );


                List< Users > userList = userService.getAllUsers();
                request.setAttribute ( "userList", userList );

                List<Exercice> exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );

                List<Activity> activityList = activityService.getAll();
                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);
                break;
            case "/editActivity":
                LocalDate date_Debut = LocalDate.parse (request.getParameter ( "dateDebut" ));
                LocalDate date_Fin = LocalDate.parse ( request.getParameter ( "dateFin" ));
                String descriptions = request.getParameter ( "description" );
                Boolean _status = Boolean.parseBoolean ( request.getParameter ( "status" ));
                String titles = request.getParameter("title");
                activity = new Activity (  );
                activity.setDateDebut(date_Debut);
                activity.setDateFin(date_Fin);
                activity.setDescription(descriptions);
                activity.setStatus(_status);
                activity.setTitle(titles);
                activity.setExercise(new Exercice((long) 1));
                //  activity.setParticipantList((List<Participant>) new Participant());
                activityService.update(activity);

                List<Users> _participantList = userService.gitAllUsersByRoleName ("participant");
                request.setAttribute ( "participantList", _participantList );


                List< Users > _userList = userService.getAllUsers();
                request.setAttribute ( "userList", _userList );

                List<Exercice> _exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", _exerciceList );
                activityList = activityService.getAll();
                request.setAttribute ( "activityList", activityList );
                request.getRequestDispatcher("/activity/activities.jsp").forward(request, response);

                break;
        }
    }
}
