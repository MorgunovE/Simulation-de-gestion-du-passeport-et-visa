package Service;

import Component.Passeport;
import Component.Personne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicePasseport {
    private List<Passeport> passeports;

    public ServicePasseport() {
        passeports = new ArrayList<>();
    }

    public void demanderPasseport(Personne personne, Passeport passeport) {
        if (!passeports.contains(passeport)) {
            passeports.add(passeport);
            personne.setPassport(passeport);
            System.out.println("Passeport délivré avec succès à " + personne.getNom() + " " + personne.getPrenom());
        } else {
            System.out.println("Le passeport a déjà été délivré à " + personne.getNom() + " " + personne.getPrenom());
        }
    }

    public void demanderPrologationPasseport(Passeport passeport, LocalDate nouvelleDateExpiration) {
        if(passeports.contains(passeport)) {
            if(nouvelleDateExpiration.isAfter(passeport.getDateExpiration())){
                passeport.setDateExpiration(nouvelleDateExpiration);
                System.out.println("La date d'expiration du passeport a été prolongée avec succès.");
            } else {
                System.out.println("La date d'expiration doit être postérieure à la date actuelle.");
            }
        } else {
            System.out.println("Le passeport n'a pas été délivré par ce service.");
        }
    }

    public void annulerPasseport(Passeport passeport) {
        if(passeports.contains(passeport)) {
            passeport.setValide(false);
            passeport.getVisa().setValide(false);
            System.out.println("Le passeport a été annulé avec succès.");
        } else {
            System.out.println("Le passeport n'a pas été délivré par ce service.");
        }
    }

}
