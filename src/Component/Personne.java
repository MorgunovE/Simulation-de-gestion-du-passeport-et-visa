package Component;

/**
 * La classe Personne représente une personne avec un nom, un prénom et un passeport.
 */
public class Personne {
    private String nom;
    private String prenom;
    private Passeport passport;

    /**
     * Constructeur de la classe Personne.
     *
     * @param nom    Le nom de la personne
     * @param prenom Le prénom de la personne
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    /**
     * Obtient le nom de la personne.
     *
     * @return Le nom de la personne
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom de la personne.
     *
     * @param nom Le nouveau nom de la personne
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtient le prénom de la personne.
     *
     * @return Le prénom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définit le prénom de la personne.
     *
     * @param prenom Le nouveau prénom de la personne
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtient le passeport de la personne.
     *
     * @return Le passeport de la personne
     */
    public Passeport getPassport() {
        return passport;
    }

    /**
     * Définit le passeport de la personne.
     *
     * @param passport Le nouveau passeport de la personne
     */
    public void setPassport(Passeport passport) {
        this.passport = passport;
    }

    /**
     * Affiche les informations de la personne, incluant les détails de son passeport si disponible.
     */
    public void afficherInformations() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        if (passport != null) {
            System.out.println("Informations du passeport : ");
            passport.afficherInformations();
        } else {
            System.out.println("Aucun passeport associé.");
        }
    }
}
