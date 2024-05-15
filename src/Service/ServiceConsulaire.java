package Service;

import Component.Personne;
import Component.Visa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceConsulaire {
    private List<Visa> visas;

    public ServiceConsulaire() {
        visas = new ArrayList<>();
    }

    public void demanderVisa(Personne personne, Visa visa) {
        if (!visas.contains(visa)) {
            visas.add(visa);
            if(personne.getPassport() == null) {
                System.out.println("Aucun passeport associé à " + personne.getNom() + " " + personne.getPrenom());
                return;
            } if(visa.getDateExpiration().isAfter(personne.getPassport().getDateExpiration())){
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

    public void demanderPrologationVisa(Personne personne, Visa visa, LocalDate nouvelleDateExpiration) {
        if(visas.contains(visa)) {
            if(nouvelleDateExpiration.isAfter(visa.getDateExpiration())){
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

    public void annulerVisa(Visa visa) {
        if(visas.contains(visa)) {
            visa.setValide(false);
            System.out.println("Le visa a été annulé avec succès.");
        } else {
            System.out.println("Le visa n'a pas été délivré par ce service.");
        }
    }
}
