package fr.usmb.m2isc.javaee.bornes.ejb;

import java.util.Date;
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
        Paiement paiement = new Paiement(java.util.UUID.randomUUID(), new Date(), montant, typePaiement);
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

    @Override
    public boolean estSortiAvant15mins(Ticket ticket) {
        // return true if the attribute dateSortie from ticket is less than 15 minutes

        return (ticket.getExitDate().getTime() - ticket.getEntryDate().getTime()) < 900000;

    }

    @Override
    public void sortir(Ticket ticket) {
        if (!estSortiAvant15mins(ticket)) {
            // create a paiement
            System.out.println("Paiement en cours");
        }
    }

    /**
     * Get a ticket by its id.
     * 
     * @param id The id of the ticket to retrieve
     * @return A ticket object
     */
    @Override
    public Ticket getTicket(UUID id) {
        em.find(Ticket.class, id);
        return null;
    }

    // getTicket with String id argument
    @Override
    public Ticket getTicket(String id) {
        return getTicket(UUID.fromString(id));
    }

}