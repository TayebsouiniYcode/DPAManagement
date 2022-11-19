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
    List<Role> roleList;
    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path){
            case "/utilisateurs":
                usersList = userService.getAllUsers ();
                roleList = userService.getAllRole();
                request.setAttribute ( "roleList", roleList );
                request.setAttribute ( "usersList", usersList );

                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;
            case "/deleteUser":
                int id = Integer.parseInt ( request.getParameter ( "id" ));
                if (userService.deleteUserById (id)){
                    request.setAttribute ( "deleteMessage", "true" );
                } else {
                    request.setAttribute ( "deleteMessage", "false" );
                }

                usersList = userService.getAllUsers();
                request.setAttribute ( "usersList", usersList );
                roleList = userService.getAllRole();
                request.setAttribute ( "roleList", roleList );
                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath ();

        switch (path) {
            case "/editUser":
                System.out.println ("43");
                Long id = Long.parseLong ( request.getParameter ( "id" ) );
                String firstname = request.getParameter ( "firstname" );
                String lastname = request.getParameter ( "lastname" );
                String email = request.getParameter ( "email" );
                String phone = request.getParameter ( "phone" );
                Boolean status = Boolean.parseBoolean ( request.getParameter ( "status"  ) );
                String roleName = request.getParameter ( "role" );
                System.out.println ("this is note error here" );
                Role role = null;
                System.out.println ("this is note error here 2" );
                // to refactoring
                if (roleName.equals ( "administrateur" )) {
                    role = new Role ( Long.parseLong ( "2" ) , "administrateur" );
                }
                else if (roleName.equals ( "utilisateur" )) {
                    role = new Role(Long.parseLong ( "1"), "utilisateur");
                }
                else if (roleName.equals ( "formateur" )) {
                    role = new Role(Long.parseLong ( "3"), "formateur");
                }
                else if (roleName.equals ( "intervenant" )) {
                    role = new Role(Long.parseLong ( "4"), "intervenant");
                }
                else if (roleName.equals ( "participant" )) {
                    role = new Role(Long.parseLong ( "5"), "participant");
                }

                Users user = new Users ( id, firstname, lastname, phone, null, email, null, status, role );
                userService.updateUser(user);
                usersList = userService.getAllUsers();
                roleList = userService.getAllRole();
                request.setAttribute ( "roleList", roleList );
                request.setAttribute ( "usersList", usersList );

                request.getRequestDispatcher ( "/admin/utilisateurs.jsp" ).forward ( request, response );
                break;
        }
    }
}

