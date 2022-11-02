package fr.usmb.m2isc.javaee.bornes.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Paiement implements Serializable{

    /*
     * Il nous faut
     * un identifiant du paiement (numéro),
     * la date du paiement,
     * le montant payé (en euro),
     * le type de paiement utilisé (CB, espèces).
     */
    @Id
    private String id;
    private Date datePaiement;
    private double montant;
    private String typePaiement;

    // un constructeur par défaut
    public Paiement() {
    }

    public Paiement(double montant, String typePaiement) {
        this.id = UUID.randomUUID().toString();
        this.datePaiement = new Date();
        this.montant = montant;
        this.typePaiement = typePaiement;
    }

    // un constructeur avec tous les paramètres

    public Paiement(String id, Date datePaiement, double montant, String typePaiement) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.typePaiement = typePaiement;
    }

    // les getters et les setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(Date datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }

    // une méthode toString
    @Override
    public String toString() {
        return "Paiement [datePaiement=" + datePaiement.toString() + ", id=" + id + ", montant=" + montant
                + ", typePaiement=" + typePaiement + "]";

    }

}
