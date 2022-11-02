package fr.usmb.m2isc.javaee.bornes.ejb;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.Remote;
import javax.ejb.Stateless;
//import javax.jws.WebMethod;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import fr.usmb.m2isc.javaee.bornes.jpa.Paiement;
import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;



@Stateless
@Remote
public class OperationsBean implements Operations {

    @PersistenceContext
    private EntityManager em;

    @Override
    // It creates a new ticket with a random UUID and the current date.
    public Ticket b1CreerTicket() {
        // instantiate the ticket with the current date
        Ticket ticket = new Ticket(java.util.UUID.randomUUID(), new Date());
        em.persist(ticket);
        return ticket;
    }

    @Override
    // It creates a new ticket with a random UUID and the current date.
    public Ticket entrer() {
        return b1CreerTicket();
    }

    public Paiement createPayment(double montant, String typePaiement) {
        //Paiement paiement = new Paiement(java.util.UUID.randomUUID().toString(), new Date(), montant, typePaiement);
        Paiement paiement = new Paiement(montant, typePaiement);
        em.persist(paiement);
        return paiement;
    }

    @Override
    public void b2Payer(UUID ticketID, UUID paiementID) {
        Ticket ticket = em.find(Ticket.class, ticketID);
        Paiement paiement = em.find(Paiement.class, paiementID);
        Date now = new Date();
        ticket.setExitDate(now);
        paiement.setDatePaiement(now);
        // I need the difference between dateEntree and dateSortie in minutes
        double difference = (ticket.getExitDate().getTime() - ticket.getEntryDate().getTime()) / 60000;
        paiement.setMontant(difference);

    }

    // @Override
    // public double estSortiAvant15mins(Ticket ticket, Date exitDatetest) {
    //     double difference = (exitDatetest.getTime() - ticket.getLastDatePaiement().getTime()) / 60000;
    //     return difference;
    //     // if (difference < 15) {
    //     //     return true;
    //     // } else {
    //     //     return false;
    //     // }


    //     //return (exitDate.getTime() - ticket.getLastDatePaiement().getTime()) < 900000;
    // }

    
    @Override
    public void updateTicket(Ticket t){
        em.merge(t);
    }

    /**
     * Get a ticket by its id.
     * 
     * @param id The id of the ticket to retrieve
     * @return A ticket object
     */
    @Override
    public Ticket getTicket(UUID id) {
        return em.find(Ticket.class, id.toString());
    }

    // getTicket with String id argument
    @Override
    public Ticket getTicketStr(String id) {
        return getTicket(UUID.fromString(id));
    }


    @Override
	public List<Ticket> findAllTickets() {
        return em.createQuery("SELECT t FROM Ticket t", Ticket.class).getResultList();
	}

    @Override
	public List<Ticket> findAllTicketsNoLeave() {
        return em.createQuery("SELECT t FROM Ticket t WHERE t.exitDate IS NULL", Ticket.class).getResultList();
	}

}