package Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Passeport représente un passeport avec ses attributs et ses opérations.
 */
public class Passeport {
    private int numero;
    private LocalDate dateDelivrance;
    private String lieuDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;
    private boolean prolongerVisaAutomatiquement;
    private List<Visa> visas;

    public static int compteurPasseport = 0;

    /**
     * Constructeur de la classe Passeport.
     *
     * @param dateDelivrance  Date de délivrance du passeport
     * @param dateExpiration  Date d'expiration du passeport
     * @param lieuDelivrance  Lieu de délivrance du passeport
     */
    public Passeport (LocalDate dateDelivrance, LocalDate dateExpiration,String lieuDelivrance ) {
        this.numero = ++compteurPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.lieuDelivrance = lieuDelivrance;
        this.valide = dateExpiration.isAfter(LocalDate.now());
        this.prolongerVisaAutomatiquement = false;
        this.visas = new ArrayList<>();
    }

    /**
     * Obtient le numéro du passeport.
     *
     * @return Le numéro du passeport
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Définit le numéro du passeport.
     *
     * @param numero Le nouveau numéro du passeport
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtient la date de délivrance du passeport.
     *
     * @return La date de délivrance du passeport
     */
    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    /**
     * Définit la date de délivrance du passeport.
     *
     * @param dateDelivrance La nouvelle date de délivrance du passeport
     */
    public void setDateDelivrance(LocalDate dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    /**
     * Obtient le lieu de délivrance du passeport.
     *
     * @return Le lieu de délivrance du passeport
     */
    public String getLieuDelivrance() {
        return lieuDelivrance;
    }

    /**
     * Définit le lieu de délivrance du passeport.
     *
     * @param lieuDelivrance Le nouveau lieu de délivrance du passeport
     */
    public void setLieuDelivrance(String lieuDelivrance) {
        this.lieuDelivrance = lieuDelivrance;
    }

    /**
     * Obtient la date d'expiration du passeport.
     *
     * @return La date d'expiration du passeport
     */
    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Définit la date d'expiration du passeport.
     *
     * @param dateExpiration La nouvelle date d'expiration du passeport
     */
    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    /**
     * Vérifie si le passeport est valide.
     *
     * @return true si le passeport est valide, false sinon
     */
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

    /**
     * Définit la validité du passeport.
     *
     * @param valide La nouvelle validité du passeport
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    /**
     * Obtient la liste des visas associés au passeport.
     *
     * @return La liste des visas
     */
    public List<Visa> getVisa() {
        return visas;
    }

    /**
     * Ajoute un visa au passeport.
     *
     * @param visa Le visa à ajouter
     */
    public void setVisa(Visa visa) {
       visas.add(visa);
    }

    /**
     * Affiche les informations du passeport et des visas associés.
     */
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

    /**
     * Vérifie si la prolongation automatique du visa est activée.
     *
     * @return true si la prolongation automatique du visa est activée, false sinon
     */
    public boolean estProlongerVisaAutomatiquement() {
        return prolongerVisaAutomatiquement;
    }

    /**
     * Active ou désactive la prolongation automatique du visa.
     *
     * @param prolongerVisaAutomatiquement Le nouveau statut de la prolongation automatique du visa
     */
    public void setProlongerVisaAutomatiquement(boolean prolongerVisaAutomatiquement) {
        this.prolongerVisaAutomatiquement = prolongerVisaAutomatiquement;
    }
}
