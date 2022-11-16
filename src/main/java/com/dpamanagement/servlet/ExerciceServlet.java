package com.dpamanagement.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ExerciceServlet", urlPatterns = "/exercices")
public class ExerciceServlet extends HttpServlet {
    @Override
    protected void doGet ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path) {
            case "/exercices":
                request.getRequestDispatcher("/exercice/exercices.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost ( HttpServletRequest request , HttpServletResponse response ) throws ServletException, IOException {

    }
}
