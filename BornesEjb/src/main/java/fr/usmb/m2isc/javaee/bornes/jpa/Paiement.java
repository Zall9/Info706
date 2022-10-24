package fr.usmb.m2isc.javaee.bornes.jpa;

import java.util.Date;
import java.util.UUID;

public class Paiement {

    /*
     * Il nous faut
     * un identifiant du paiement (numéro),
     * la date du paiement,
     * le montant payé (en euro),
     * le type de paiement utilisé (CB, espèces).
     */
    private UUID id;
    private Date datePaiement;
    private double montant;
    private String typePaiement;

    // un constructeur par défaut
    public Paiement() {
    }

    // un constructeur avec tous les paramètres

    public Paiement(UUID id, Date datePaiement, double montant, String typePaiement) {
        this.id = id;
        this.datePaiement = datePaiement;
        this.montant = montant;
        this.typePaiement = typePaiement;
    }

    // les getters et les setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
