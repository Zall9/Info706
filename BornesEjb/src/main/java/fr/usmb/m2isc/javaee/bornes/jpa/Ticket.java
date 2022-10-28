package fr.usmb.m2isc.javaee.bornes.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ticket implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private String ticketNum;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date entryDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date exitDate;
    
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn
    private List<Paiement> payments = new ArrayList<Paiement>();
    
    
    public Ticket() {
        this.entryDate = new Date();
    }
    
    
    public Ticket(UUID randomUUID, Date date) {
        this.ticketNum = randomUUID.toString();
        this.entryDate = date;
    }


    public Date getEntryDate() {
        return entryDate;
    }


    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }


    public Date getExitDate() {
        return exitDate;
    }


    public void setExitDate(Date exitDate) {
        this.exitDate = exitDate;
    }


    public String getTicketNum() {
        return ticketNum;
    }

    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }
}