package com.dpamanagement.servlet;

import com.dpamanagement.entity.Role;
import com.dpamanagement.entity.Users;
import com.dpamanagement.service.UserService;
import com.dpamanagement.service.implementation.UserServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns ={ "/utilisateurs", "/editUser", "/deleteUser"})
public class UserServlet extends HttpServlet {
    UserService userService = new UserServiceImpl ();
    List< Users> usersList;
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/utilisateurs":
                System.out.println ("servlet with path /utilisateurs" );
                usersList = userService.getAll();

                request.setAttribute ( "usersList", usersList );
                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;
            case "/deleteUser":
                int id = Integer.parseInt ( request.getParameter ( "id" ));
                userService.delete(id);
                usersList = userService.getAll();

                request.setAttribute ( "usersList", usersList );
                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path) {
            case "/editUser":
                Long id = Long.parseLong ( request.getParameter ( "id" ) );
                String firstname = request.getParameter ( "firstname" );
                String lastname = request.getParameter ( "lastname" );
                String email = request.getParameter ( "email" );
                String phone = request.getParameter ( "phone" );
                Boolean status = Boolean.parseBoolean ( request.getParameter ( "status"  ) );
                String roleName = request.getParameter ( "role" );
                Role role;
                if (roleName.equals ( "administrateur" )) {
                    role = new Role(Long.parseLong ( "2"), "administrateur");
                } else {
                    role = new Role(Long.parseLong ( "1"), "utilisateur");
                }

                Users user = new Users ( id, firstname, lastname, phone, null, email, null, status, role );

                userService.update(user);
                //System.out.println ( "id " + id + " " + firstname + " " + lastname + "" +
                //        " " + email + " " + phone + " " + status + " " + roleName );

                //System.out.println (  );
                List< Users> usersList = userService.getAll();

                request.setAttribute ( "usersList", usersList );
                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;
        }
    }
}

