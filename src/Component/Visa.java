package Component;

import java.time.LocalDate;

public class Visa {
    private static int compteurVisa = 0;
    private int numero;
    private String type;
    private LocalDate dateDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;

    public Visa(String type, LocalDate dateDelivrance, LocalDate dateExpiration) {
        this.numero = ++compteurVisa;
        this.type = type;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.valide = dateExpiration.isAfter(LocalDate.now());
    }

    public int getNumero() {
        return numero;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public void setDateDelivrance(LocalDate dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public boolean estValide() {
        if(dateExpiration.isAfter(LocalDate.now()) && valide){
            return true;
        } else {
            setValide(false);
            return false;
        }

    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

//    public void prolongerDateExpiration(LocalDate nouvelleDateExpiration) {
//        if (nouvelleDateExpiration.isAfter(dateExpiration)) {
//            dateExpiration = nouvelleDateExpiration;
//            System.out.println("La date d'expiration du visa a été prolongée avec succès.");
//        } else {
//            System.out.println("La nouvelle date d'expiration doit être postérieure à la date actuelle.");
//        }
//    }

//    public void afficherInformations() {
//        System.out.println("Informations du visa : ");
//        System.out.println("Numero de visa: " + numero);
//        System.out.println("Type de visa: " + type);
//        System.out.println("Date de délivrance de visa : " + dateDelivrance);
//        System.out.println("Date d'expiration de visa : " + dateExpiration);
//        System.out.println("Visa est valide : " + (estValide() ? "Oui" : "Non"));
//    }
}


