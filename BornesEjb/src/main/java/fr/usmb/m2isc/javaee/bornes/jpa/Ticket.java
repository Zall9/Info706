package fr.usmb.m2isc.javaee.bornes.jpa;

import java.util.Date;
import java.util.UUID;

public class Ticket {

    private UUID id;
    private Date dateEntree;
    private Date dateSortie;
    private Paiement[] paiment_list;



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

    //add new paiement in array
    public  Paiement[] addPaiement(int n, Paiement x)
   {
       int i;
   
       // create a new array of size n+1
       Paiement newarr[] = new Paiement[n + 1];
   
       // insert the elements from
       // the old array into the new array
       // insert all elements till n
       // then insert x at n+1
       for (i = 0; i < n; i++)
           newarr[i] = this.paiment_list[i];
   
       newarr[n] = x;

       return newarr;
   }

   //total of all paiement
    public double totalPaiement(){
         double total = 0;
         for (int i = 0; i < this.paiment_list.length; i++) {
              total += this.paiment_list[i].getMontant();
         }
         return total;
    }

    //remove paiement from array who is given in parameter
    public Paiement[] removePaiement(int n, Paiement x)
    {
        int i;
        int j = 0;
   
        // create a new array of size n-1
        Paiement newarr[] = new Paiement[n - 1];
   
        // insert the elements from
        // the old array into the new array
        // except the element at index x
        for (i = 0; i < n; i++) {
            if (this.paiment_list[i] != x) {
                newarr[j++] = this.paiment_list[i];
            }
        }
   
        return newarr;
    }

    //return last paiement
    public Paiement lastPaiement(){
        return this.paiment_list[this.paiment_list.length - 1];
    }

    //return paiement from array who is given in parameter
    public Paiement getPaiement(int n, Paiement x){
        for (int i = 0; i < n; i++) {
            if (this.paiment_list[i] == x) {
                return this.paiment_list[i];
            }
        }
        return null;
    }

    // une méthode toDate
    @Override
    public String toString() {
        return "Ticket [dateEntree=" + dateEntree.toString() + ", dateSortie=" + dateSortie.toString() + ", id=" + id
                + "]";
    }
}
