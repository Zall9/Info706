package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.usmb.m2isc.javaee.bornes.ejb.Operations;
import fr.usmb.m2isc.javaee.bornes.jpa.Paiement;
import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;

/**
 * Servlet utilisee pour effectuer le paiement
 */
@WebServlet("/PaiementServlet")
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Operations ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaiementServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String num = request.getParameter("ticketNum");
		String typePaiement = request.getParameter("PaiementType");
		Ticket ticket = ejb.getTicketStr(num);
			
		String montant = "";

		//if montant parameter empty send to error page
		if (request.getParameter("montant") == null) {
			Date n = new Date();
			long duration  = ticket.getEntryDate().getTime() - n.getTime();
			long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);

			//2 centimes la minute
			double coefficientMontant = 0.02;

			double m = Math.abs(diffInMinutes * coefficientMontant) ;
			//convert double to string
			montant = Double.toString(m);
		}{
			montant = request.getParameter("montant");
		}
		// create new Paiement variable
		Paiement paiement = ejb.createPayment(Double.parseDouble(montant), typePaiement);
		// ajout du paiement dans le tableau de ticket

		if (ticket.addPaiement(paiement)) {
			ticket.setaPayer();
			ejb.updateTicket(ticket);

			request.setAttribute("datePaiement", paiement.getDatePaiement());
			request.setAttribute("ticket", ticket);
			request.setAttribute("taille", ticket.getPayments().size());
			request.getRequestDispatcher("/ExitParking.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
