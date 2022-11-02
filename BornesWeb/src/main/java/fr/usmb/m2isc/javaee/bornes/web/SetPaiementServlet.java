package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.bornes.ejb.Operations;
import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Servlet utilisee pour afficher un compte.
 */
@WebServlet("/SetPaiementServlet")
public class SetPaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operations ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetPaiementServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("ticketNum");
		Ticket ticket = ejb.getTicketStr(num);
        ticket.setaPayer();
        //create new date now
        Date n = new Date();

        long duration  = ticket.getEntryDate().getTime() - n.getTime();
        long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
        double montant = 10000;

        // ticket.setcurrentMontant(montant);

		request.setAttribute("ticket", ticket);
        request.setAttribute("montant", montant);

		request.getRequestDispatcher("/PayerTicket.jsp").forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
