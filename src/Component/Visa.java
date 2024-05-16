package Component;

import java.time.LocalDate;

/**
 * La classe Visa représente un visa avec ses attributs et ses opérations.
 */
public class Visa {
    private static int compteurVisa = 0;
    private int numero;
    private String type;
    private LocalDate dateDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;

    /**
     * Constructeur de la classe Visa.
     *
     * @param type            Type de visa (ex : étudiant, touriste, etc.)
     * @param dateDelivrance  Date de délivrance du visa
     * @param dateExpiration  Date d'expiration du visa
     */
    public Visa(String type, LocalDate dateDelivrance, LocalDate dateExpiration) {
        this.numero = ++compteurVisa;
        this.type = type;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.valide = dateExpiration.isAfter(LocalDate.now());
    }

    /**
     * Obtient le numéro du visa.
     *
     * @return Le numéro du visa
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Obtient le type du visa.
     *
     * @return Le type du visa
     */
    public String getType() {
        return type;
    }

    /**
     * Obtient la date de délivrance du visa.
     *
     * @return La date de délivrance du visa
     */
    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    /**
     * Définit la date d'expiration du visa.
     *
     * @param dateExpiration La nouvelle date d'expiration du visa
     */
    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    /**
     * Définit la date de délivrance du visa.
     *
     * @param dateDelivrance La nouvelle date de délivrance du visa
     */
    public void setDateDelivrance(LocalDate dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    /**
     * Définit le type du visa.
     *
     * @param type Le nouveau type du visa
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Obtient la date d'expiration du visa.
     *
     * @return La date d'expiration du visa
     */
    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    /**
     * Vérifie si le visa est valide.
     *
     * @return true si le visa est valide, false sinon
     */
    public boolean estValide() {
        if(dateExpiration.isAfter(LocalDate.now()) && valide){
            return true;
        } else {
            setValide(false);
            return false;
        }

    }

    /**
     * Définit la validité du visa.
     *
     * @param valide La nouvelle validité du visa
     */
    public void setValide(boolean valide) {
        this.valide = valide;
    }

    /**
     * Affiche les informations du visa.
     */
    public void afficherInformations() {
        System.out.println("Numero de visa: " + numero);
        System.out.println("Type de visa: " + type);
        System.out.println("Date de délivrance de visa : " + dateDelivrance);
        System.out.println("Date d'expiration de visa : " + dateExpiration);
        System.out.println("Visa est valide : " + (estValide() ? "Oui" : "Non"));
    }
}


