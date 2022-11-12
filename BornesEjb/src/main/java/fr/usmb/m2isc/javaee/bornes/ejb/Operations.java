package fr.usmb.m2isc.javaee.bornes.ejb;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import fr.usmb.m2isc.javaee.bornes.jpa.Paiement;
import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;

public interface Operations {


    public Ticket b1CreerTicket();

    public Ticket entrer();

    public void b2Payer(UUID ticketID, UUID paiementID);

    public void updateTicket(Ticket t);

    //return ticket
    public Ticket getTicket(UUID id);

    //return ticket (take id of ticket type string in argument)
    public Ticket getTicketStr(String id);

    public Paiement createPayment(double montant, String typePaiement);

    //retour all tickets
    List<Ticket> findAllTickets();

    //retour all tickets which cars doesn't leave parking
    List<Ticket> findAllTicketsNoLeave();

}
