package Component;

import java.time.LocalDate;
import java.time.Period;

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

    public void demanderPassport(LocalDate dateDelivrance, LocalDate dateExpiration, String lieuDelivrance) {
        if (passport != null) {
            Passeport nouveauPassport = new Passeport(dateDelivrance, dateExpiration, lieuDelivrance); //TODO
            setPassport(nouveauPassport);
            System.out.println("Passeport délivré avec succès.");
        } else {
            System.out.println("La personne possède déjà un passeport.");
        }
    }

    public void demanderProlongationPasseport(LocalDate nouvelleDateExpiration) {
        if (passport != null) {
            passport.prolongerDateExpiration(nouvelleDateExpiration);
            System.out.println("La date d'expiration du passeport a été prolongée avec succès.");
        } else {
            System.out.println("La personne n'a pas de passeport.");
        }
    }

    public void demanderVisa(String type, LocalDate dateDelivrance, LocalDate dateExpiration) {
        if (passport != null) {
            Visa nouveauVisa = new Visa(type, dateDelivrance, dateExpiration); //TODO
            passport.setVisa(nouveauVisa); //TODO
            System.out.println("Visa délivré avec succès.");
        } else {
            System.out.println("La personne doit d'abord obtenir un passeport.");
        }
    }

    public void demanderProlongationVisa(LocalDate nouvelleDateExpiration) {
        if (passport != null && passport.getVisa() != null) { //TODO
            passport.getVisa().prolongerDateExpiration(nouvelleDateExpiration); //TODO
            System.out.println("La date d'expiration du visa a été prolongée avec succès.");
        } else {
            System.out.println("La personne n'a pas de passeport ou de visa associé.");
        }
    }

    public void annulerPasseport() {
        if (passport != null) {
            passport.setValide(false); //TODO
            passport.setVisa(null); //TODO
            System.out.println("Le passeport a été annulé avec succès.");
        } else {
            System.out.println("La personne n'a pas de passeport.");
        }
    }

    public boolean possedeVisaValide() {
        if (passport != null && passport.getVisa() != null) { //TODO
            return passport.getVisa().estValide(); //TODO
        }
        return false;
    }

    public LocalDate getDateExpirationPasseport() {
        if (passport != null) {
            return passport.getDateExpiration(); //TODO
        }
        return null;
    }

    public String getInfoVisa() {
        if(passport != null && passport.getVisa() != null) { //TODO
            Visa visa = passport.getVisa();
            return "Type de visa: " + visa.getType() + "\n" +
                    "Date de délivrance: " + visa.getDateDelivrance() + "\n" +
                    "Date d'expiration: " + visa.getDateExpiration();
        }
        return "Aucun visa associé.";
    }
}
