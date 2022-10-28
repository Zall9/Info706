package fr.usmb.m2isc.javaee.bornes.ejb;

import java.util.List;
import java.util.UUID;

import fr.usmb.m2isc.javaee.bornes.jpa.Ticket;

public interface Operations {
    public Ticket b1CreerTicket();

    public Ticket entrer();

    public void b2Payer(UUID ticketID, UUID paiementID);

    public boolean estSortiAvant15mins(Ticket ticket);

    public void sortir(Ticket ticket);

    public Ticket getTicket(UUID id);

    public Ticket getTicketStr(String id);


    List<Ticket> findAllTickets();
}
