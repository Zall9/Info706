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

/**
 * Servlet utilisee pour mettre en place le fonctionnement de paiement.
 */
@WebServlet("/PayerServlet")
public class PayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Operations ejb;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("ticketNum");
		Ticket ticket = ejb.getTicketStr(num);

		//fonction permettant de savoir si l'utilisateur peut faire le paiement ou pas 
		// l'utilisateur ayant deja effectuer le paiement, lorsqu'il retourne sur la page de paiement il est direct rediriger vers la sortie
		if(ticket.canMakePaiement())
		{
			request.setAttribute("ticket", ticket);
			request.getRequestDispatcher("/PayerTicket.jsp").forward(request, response);	
		}else{
			request.setAttribute("ticket", ticket);
			request.getRequestDispatcher("/ExitParking.jsp").forward(request, response);	
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
