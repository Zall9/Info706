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
    
    //add image name variable string
    
    private String imagePath;

    private ArrayList<String> imageList = new ArrayList<String>();
    
    private boolean estSorti;

    private boolean aPayer;

    private Double currentMontant;


    public Ticket() {
        imageList.add("./assets/cars/bugatti.png");
        imageList.add("./assets/cars/Renault-Eleve.png");
        imageList.add("./assets/cars/twingo.png");
        this.ticketNum = UUID.randomUUID().toString();
        this.entryDate = new Date();
        //random number between 0 and imageList size
        int randomNum = (int)(Math.random() * imageList.size());
        // setTicketImage(imageList.get(randomNum));
        this.imagePath = imageList.get(randomNum);
        this.estSorti = false;
        this.aPayer = false;
        this.currentMontant = 0.0;
    }
    
    public Ticket(UUID randomUUID, Date date) {
        imageList.add("./assets/cars/bugatti.png");
        imageList.add("./assets/cars/Renault-Eleve.png");
        imageList.add("./assets/cars/twingo.png");
        this.ticketNum = randomUUID.toString();
        this.entryDate = date;
        //random number between 0 and imageList size
        int randomNum = (int)(Math.random() * imageList.size());
        // setTicketImage(imageList.get(randomNum));
        this.imagePath = imageList.get(randomNum);
        this.estSorti = false;
        this.aPayer = false;
        this.currentMontant = 0.0;

    }

    public void setEstSorti() {
        if(estSorti){
            estSorti = false;
        }else{
            estSorti = true;
        }
    }

    public boolean getEstSorti() {
        return estSorti;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setaPayer() {
        if(aPayer){
            aPayer = false;
        }else{
            aPayer = true;
        }
    }

    public boolean getaPayer() {
        return aPayer;
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
    public String getImagePath() {
        return this.imagePath;
    }

    //set imagePath
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    //add function who paiement to list
    public void addPaiement(Paiement paiement){
        this.payments.add(paiement);
    }


    //create getter and setter for currentMontant
    public void setcurrentMontant(Double montant){
        this.currentMontant = montant;
    }

    public Double getcurrentMontant(){
        return this.currentMontant;
    }

}