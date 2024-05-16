package Component;

import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private Passeport passport;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Passeport getPassport() {
        return passport;
    }

    public void setPassport(Passeport passport) {
        this.passport = passport;
    }

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
