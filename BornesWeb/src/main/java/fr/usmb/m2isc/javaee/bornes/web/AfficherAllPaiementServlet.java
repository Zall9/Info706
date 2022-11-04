package fr.usmb.m2isc.javaee.bornes.web;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/AfficherAllPaiementServlet")
public class AfficherAllPaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private Operations ejb;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfficherAllPaiementServlet() {
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
		//get All paiement from ticket
		List<Paiement> paiements = ticket.getPayments();
		request.setAttribute("ticket", ticket);
		request.setAttribute("allPaiements", paiements);
		request.getRequestDispatcher("/AfficherAllPaiements.jsp").forward(request, response);

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
