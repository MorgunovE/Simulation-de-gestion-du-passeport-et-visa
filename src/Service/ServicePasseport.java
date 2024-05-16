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
                passeport.setValide(true);
                passeport.setDateExpiration(nouvelleDateExpiration);
                System.out.println("La date d'expiration du passeport a été prolongée avec succès.");
                if(passeport.estProlongerVisaAutomatiquement()) {
                    if(!passeport.getVisa().isEmpty()){
                        passeport.getVisa().forEach(visa -> {
                                visa.setValide(true);
                                visa.setDateExpiration(LocalDate.now().plusMonths(9));});
                        System.out.println("La date d'expiration du visa a été prolongée automatique avec succès.");
                    } else {
                        System.out.println("Le visa n'a pas été délivré par ce service.");
                    }
                }
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
            if(!passeport.getVisa().isEmpty()){
                passeport.getVisa().forEach(visa -> visa.setValide(false));
            }
            System.out.println("Le passeport et le visa correspondant ont été annulés avec succès.");
        } else {
            System.out.println("Le passeport n'a pas été délivré par ce service.");
        }
    }



}
