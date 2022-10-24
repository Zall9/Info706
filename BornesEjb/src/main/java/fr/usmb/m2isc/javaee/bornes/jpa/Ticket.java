package

import java.util.Date;
import java.util.UUID;

public class Ticket {

    private UUID id;
    private Date dateEntree;
    private Date dateSortie;

    // un constructeur par défaut
    public Ticket() {
    }

    // un constructeur avec tous les paramètres
    public Ticket(UUID id, Date dateEntree) {
        this.id = id;
        this.dateEntree = dateEntree;
    }

    // les getters et les setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    // une méthode toDate
    @Override
    public String toString() {
        return "Ticket [dateEntree=" + dateEntree.toString() + ", dateSortie=" + dateSortie.toString() + ", id=" + id
                + "]";
    }
}
