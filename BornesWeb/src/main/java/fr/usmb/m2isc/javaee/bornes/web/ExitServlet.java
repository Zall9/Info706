package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;
import java.util.Date;

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
 * Servlet utilisee pour afficher un compte.
 */
@WebServlet("/ExitServlet")
public class ExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Operations ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ExitServlet() {
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
		Ticket ticket = ejb.getTicketStr(num);

		Date now = new Date();

		// Date tomorrow = new Date();
		// tomorrow.setTime(now.getTime() + 24 * 60 * 60 * 1000);
		
		//getLastPaiement
		Paiement lastPaiement =  ticket.getLastPaiement();
		Date lastDatePaiement = lastPaiement.getDatePaiement();

		// difference in minute between lastPaiement and tomoroww
		long diff = (now.getTime() - lastDatePaiement.getTime()) / (60 * 1000);

		int diffMinutes = 2;

		//check 15 minutes
		if (diff < diffMinutes) {
			// il peut sortir
			// envoyer avec un message de vous etes bien sorti

			ticket.setEstSorti(true);
			ticket.setExitDate(now);

			ejb.updateTicket(ticket);

			request.setAttribute("messageInfo", " Vous etes sortie");
			request.setAttribute("ticket", ticket);
			request.getRequestDispatcher("/index.html").forward(request, response);

		} else {
			//il doit payer
			//envoyer avec un message il faut payer a nouveaux
			request.setAttribute("messageInfo", "Vous avez depasser les 15 minutes merci de re payer");
			request.setAttribute("ticket", ticket);
			request.setAttribute("montant", lastPaiement.getMontant());
			request.getRequestDispatcher("/PayerTicket.jsp").forward(request, response);
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
