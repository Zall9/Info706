package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import fr.usmb.m2isc.javaee.bornes.ejb.Operations;
import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;

@WebServlet("/CreerTicketServlet")
public class CreerTicketServlet extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    @EJB
    private Operations ejb;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerTicketServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Ticket tck = ejb.b1CreerTicket();
        request.setAttribute("ticket", tck);
        request.getRequestDispatcher("/AfficherTicket.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
