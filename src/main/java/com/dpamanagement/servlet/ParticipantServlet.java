package com.dpamanagement.servlet;

import com.dpamanagement.entity.Participant;
import com.dpamanagement.entity.Role;
import com.dpamanagement.service.ParticipantService;
import com.dpamanagement.service.implementation.ParticipantServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ParticipantServlet",  urlPatterns ={ "/participants", "/editParticipant", "/deleteParticipant"})
public class ParticipantServlet extends HttpServlet {
     ParticipantService participantService =  new ParticipantServiceImpl ();
    List< Participant > participantList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paths = request.getServletPath ();

        switch (paths){
            case "/participants":
                participantList = participantService.getAll();

                request.setAttribute ( "participantList", participantList );
                request.getRequestDispatcher ( "/participant/participants.jsp" ).forward ( request, response );
                break;
            case "/deleteParticipant":
                int id = Integer.parseInt ( request.getParameter ( "id" ));
                participantService.delete(id);
                participantList = participantService.getAll();

                request.setAttribute ( "participantList", participantList );
                request.getRequestDispatcher ( "/participant/participants.jsp" ).forward ( request, response );
                break;

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String route = request.getServletPath ();

        switch (route) {
            case "/editParticipant":
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
                String structure =request.getParameter("structure");
                Participant participant = new Participant ( id, firstname, lastname, phone, null, email, null, status, role,structure );

                participantService.update(participant);

                List<Participant> participantList = participantService.getAll();

                request.setAttribute ( "participantList", participantList );
                request.getRequestDispatcher ( "/participant/participants.jsp" ).forward ( request, response );
                break;
        }
    }
}
