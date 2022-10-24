package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;
import java.util.UUID;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.bornes.ejb.Operations;

@WebServlet("/CreerTicket")
public class CreerTicketServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private Operations ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UUID id = UUID.fromString(request.getParameter("ticketId"));
        request.setAttribute("ticket", ejb.getTicket(id));
        request.getRequestDispatcher("/WEB-INF/creerTicket.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
