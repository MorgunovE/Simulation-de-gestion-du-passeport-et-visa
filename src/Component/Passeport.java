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
        this.valide = true;
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
        return valide;
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

    /**
     * Prolonge la date d'expiration du passeport avec la nouvelle date spécifiée.
     *
     * @param nouvelleDateExpiration La nouvelle date d'expiration du passeport.
     */
    public void prolongerDateExpiration(LocalDate nouvelleDateExpiration) {
        if(nouvelleDateExpiration.isAfter(dateExpiration)) {
            dateExpiration = nouvelleDateExpiration;
            System.out.println("La date d'expiration du passeport a été prolongée avec succès.");
        } else  {
            System.out.println("La nouvelle date d'expiration doit être postérieure à la date actuelle.");
        }
    }

    public void afficherInformations() {
        System.out.println("Numéro de passeport:  " + numero);
        System.out.println("Date de délivrance : " + dateDelivrance);
        System.out.println("Date d'expiration : " + dateExpiration);
        System.out.println("Lieu de délivrance : " + lieuDelivrance);
        System.out.println("Valide : " + (valide ? "Oui" : "Non"));
        if (visa != null) {
            System.out.println("Information du visa ; ");
            visa.afficherInformations(); //TODO
        }
    }

}
