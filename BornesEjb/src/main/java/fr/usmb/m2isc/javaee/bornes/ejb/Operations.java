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

    // public double estSortiAvant15mins(Ticket ticket,Date exitDate);

    public void updateTicket(Ticket t);

    public Ticket getTicket(UUID id);

    public Ticket getTicketStr(String id);

    public Paiement createPayment(double montant, String typePaiement);

    List<Ticket> findAllTickets();
    List<Ticket> findAllTicketsNoLeave();

}
