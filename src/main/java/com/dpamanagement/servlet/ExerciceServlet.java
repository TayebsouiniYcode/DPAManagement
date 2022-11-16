package com.dpamanagement.servlet;

import com.dpamanagement.service.ExerciceService;
import com.dpamanagement.service.implementation.ExerciceServiceImp;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.dpamanagement.entity.Exercice;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "ExerciceServlet", urlPatterns = {"/exercices", "/addExercice", "/deleteExercice", "/editExercice"})
public class ExerciceServlet extends HttpServlet {
    ExerciceService exerciceService = new ExerciceServiceImp ( );
    Exercice exercice;
    List < Exercice> exerciceList;

    @Override
    protected void doGet ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/exercices":
                exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );
                request.getRequestDispatcher("/exercice/exercices.jsp").forward(request, response);
                break;
            case  "/addExercice":
                request.getRequestDispatcher("exercice/addExercice.jsp").forward(request, response);
                break;
            case  "/deleteExercice" :
                int id = Integer.parseInt ( request.getParameter ( "id" ));
                System.out.println ("this is servlet : " + id );
                exerciceService.delete(id);
                exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );
                request.getRequestDispatcher("/exercice/exercices.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/addExercice":
                String year = request.getParameter ( "year" );
                LocalDate dateDebut = LocalDate.parse (request.getParameter ( "dateDebut" ));
                LocalDate dateFin = LocalDate.parse ( request.getParameter ( "dateFin" ));
                Boolean status = Boolean.parseBoolean ( request.getParameter ( "status" ));
                String description = request.getParameter ( "description" );

                exercice = new Exercice ( year, dateDebut, dateFin, status, description );
                exerciceService.add(exercice);

                exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );
                request.getRequestDispatcher("/exercice/exercices.jsp").forward(request, response);
                break;
            case "/editExercice":
                String _year = request.getParameter ( "year" );
                LocalDate _dateDebut = LocalDate.parse (request.getParameter ( "dateDebut" ));
                LocalDate _dateFin = LocalDate.parse ( request.getParameter ( "dateFin" ));
                Boolean _status = Boolean.parseBoolean ( request.getParameter ( "status" ));
                String _description = request.getParameter ( "description" );
                Long _id = Long.parseLong ( request.getParameter ( "id" ));

                exercice = new Exercice (_id, _year, _dateDebut, _dateFin, _status, _description);
                exerciceService.update(exercice);

                exerciceList = exerciceService.getAll();
                request.setAttribute ( "exerciceList", exerciceList );
                request.getRequestDispatcher("/exercice/exercices.jsp").forward(request, response);
                break;
        }
    }
}
