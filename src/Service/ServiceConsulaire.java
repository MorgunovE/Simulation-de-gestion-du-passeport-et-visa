package Service;

import Component.Personne;
import Component.Visa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe ServiceConsulaire gère les opérations liées aux visas,
 * y compris l'émission, la prolongation et l'annulation.
 */
public class ServiceConsulaire {
    private List<Visa> visas;

    /**
     * Constructeur par défaut initialisant la liste des visas.
     */
    public ServiceConsulaire() {
        visas = new ArrayList<>();
    }

    /**
     * Méthode pour demander un visa pour une personne.
     *
     * @param personne La personne demandant le visa
     * @param visa Le visa à délivrer
     */
    public void demanderVisa(Personne personne, Visa visa) {
        if (!visas.contains(visa)) {
            visas.add(visa);
            if(personne.getPassport() == null) {
                System.out.println("Aucun passeport associé à " + personne.getNom() + " " + personne.getPrenom());
                return;
            }
            if(visa.getDateExpiration().isAfter(personne.getPassport().getDateExpiration())){
                visa.setDateExpiration(personne.getPassport().getDateExpiration());
                personne.getPassport().setVisa(visa);
                System.out.println("Visa délivré avec succès à " + personne.getNom() + " " + personne.getPrenom());
                System.out.println("La date d'expiration du visa est déterminée de la durée de validité du passeport.");
            } else {
                personne.getPassport().setVisa(visa);
                System.out.println("Visa délivré avec succès à " + personne.getNom() + " " + personne.getPrenom());
            }
        } else {
            System.out.println("Le visa a déjà été délivré à " + personne.getNom() + " " + personne.getPrenom());
        }
    }

    /**
     * Méthode pour demander la prolongation de la date d'expiration d'un visa.
     *
     * @param personne La personne demandant la prolongation
     * @param visa Le visa à prolonger
     * @param nouvelleDateExpiration La nouvelle date d'expiration
     */
    public void demanderPrologationVisa(Personne personne, Visa visa, LocalDate nouvelleDateExpiration) {
        if(visas.contains(visa)) {
            if(nouvelleDateExpiration.isAfter(visa.getDateExpiration())){
                visa.setValide(true);
                if(nouvelleDateExpiration.isAfter(personne.getPassport().getDateExpiration())) {
                    visa.setDateExpiration(personne.getPassport().getDateExpiration());
                    System.out.println("La date d'expiration du visa est déterminée de la durée de validité du passeport.");
                } else {
                    visa.setDateExpiration(nouvelleDateExpiration);
                    System.out.println("La date d'expiration du visa a été prolongée avec succès.");
                }
            }
        } else {
            System.out.println("Le visa n'a pas été délivré par ce service.");
        }
    }

    /**
     * Méthode pour annuler un visa.
     *
     * @param visa Le visa à annuler
     */
    public void annulerVisa(Visa visa) {
        if(visas.contains(visa)) {
            visa.setValide(false);
            System.out.println("Le visa a été annulé avec succès.");
        } else {
            System.out.println("Le visa n'a pas été délivré par ce service.");
        }
    }
}
