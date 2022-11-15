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


    //constructeur par défaut
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

    }

    public void setEstSorti(boolean b) {
        this.estSorti = b;
    }

    public boolean getEstSorti() {
        return estSorti;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    //variable utiliser dans les jsp et servlet permettant de mettre en place l'affichage dynamique
    public void setaPayer() {
        if(aPayer){
            aPayer = false;
        }else{
            aPayer = true;
        }
    }


    public void setaPayer(boolean b){
        this.aPayer = b;
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
    public boolean addPaiement(Paiement paiement){
        return this.payments.add(paiement);
    }

    //return datePaiement of last Paiement who is in array
    public Paiement getLastPaiement(){
        //need to works just with one paiement inside
        if(this.payments.size() == 1){
            return this.payments.get(0);
        }else if(this.payments.size() > 1 ){
            return this.payments.get(this.payments.size()-1);
        }else{
            return null;
        }
    }

    //create getter and setter for payments
    public List<Paiement> getPayments(){
        return this.payments;
    }

    public void setPayments(List<Paiement> payments){
        this.payments = payments;
    }

    //return paiment at i
    public String getPaiementAt(int i){
        return this.payments.get(i).toString();
    }


    //fontion permettant d'accepter la possibilite d'effectuer des paiements seulement si aucun paiement existe ou si le dernier depasse de plus de 15 minutes
    //can make Payement
    public boolean canMakePaiement(){
        if(this.payments.size() == 0){
            return true;
        }else{
            Date now = new Date();
            Date lastPaiement = this.getLastPaiement().getDatePaiement();

            //diff in minute

            int diffMinutes = 15;

            long diff = (now.getTime() - lastPaiement.getTime()) / 60000;
            if(diff >= diffMinutes){
                return true;
            }else{
                return false;
            }
        }
    }

}