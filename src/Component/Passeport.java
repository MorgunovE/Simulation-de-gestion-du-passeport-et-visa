package Component;

import java.time.LocalDate;

public class Passeport {
    private int numero;
    private LocalDate dateDelivrance;
    private String lieuDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;
    private Visa visa;

    public static int compteurPasseport = 0;

    public Passeport (LocalDate dateDelivrance, LocalDate dateExpiration,String lieuDelivrance ) {
        this.numero = ++compteurPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.lieuDelivrance = lieuDelivrance;
        this.valide = dateExpiration.isAfter(LocalDate.now());
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(LocalDate dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getLieuDelivrance() {
        return lieuDelivrance;
    }

    public void setLieuDelivrance(String lieuDelivrance) {
        this.lieuDelivrance = lieuDelivrance;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public boolean estValide() {
        if(dateExpiration.isAfter(LocalDate.now()) && valide){
            return true;
        } else {
            visa.setValide(false);
            setValide(false);
            return false;
        }
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

//    public void prolongerDateExpiration(LocalDate nouvelleDateExpiration) {
//        if(nouvelleDateExpiration.isAfter(dateExpiration)) {
//            dateExpiration = nouvelleDateExpiration;
//            System.out.println("La date d'expiration du passeport a été prolongée avec succès.");
//        } else  {
//            System.out.println("La nouvelle date d'expiration doit être postérieure à la date actuelle.");
//        }
//    }

//    public void afficherInformations() {
//        System.out.println("Numéro de passeport:  " + numero);
//        System.out.println("Date de délivrance de passeport : " + dateDelivrance);
//        System.out.println("Date d'expiration de passeport : " + dateExpiration);
//        System.out.println("Lieu de délivrance de passeport : " + lieuDelivrance);
//        System.out.println("Passeport est valide : " + (estValide() ? "Oui" : "Non"));
//        if (visa != null) {
//            visa.afficherInformations();
//        }
//    }

}
