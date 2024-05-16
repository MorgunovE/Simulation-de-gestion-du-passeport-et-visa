package Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Passeport {
    private int numero;
    private LocalDate dateDelivrance;
    private String lieuDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;
    private boolean prolongerVisaAutomatiquement;
    private List<Visa> visas;

    public static int compteurPasseport = 0;

    public Passeport (LocalDate dateDelivrance, LocalDate dateExpiration,String lieuDelivrance ) {
        this.numero = ++compteurPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.lieuDelivrance = lieuDelivrance;
        this.valide = dateExpiration.isAfter(LocalDate.now());
        this.prolongerVisaAutomatiquement = false;
        this.visas = new ArrayList<>();
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
            for(Visa visa : visas) {
                visa.setValide(false);
            }
            setValide(false);
            return false;
        }
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public List<Visa> getVisa() {
        return visas;
    }

    public void setVisa(Visa visa) {
       visas.add(visa);
    }

    public void afficherInformations() {
        System.out.println("Numéro de passeport:  " + numero);
        System.out.println("Date de délivrance de passeport : " + dateDelivrance);
        System.out.println("Date d'expiration de passeport : " + dateExpiration);
        System.out.println("Lieu de délivrance de passeport : " + lieuDelivrance);
        System.out.println("Passeport est valide : " + (estValide() ? "Oui" : "Non"));
        if (!visas.isEmpty()) {
            System.out.println("Informations sur les visas : ");
            visas.forEach(Visa::afficherInformations);
        }
    }

    public boolean estProlongerVisaAutomatiquement() {
        return prolongerVisaAutomatiquement;
    }

    public void setProlongerVisaAutomatiquement(boolean prolongerVisaAutomatiquement) {
        this.prolongerVisaAutomatiquement = prolongerVisaAutomatiquement;
    }
}
