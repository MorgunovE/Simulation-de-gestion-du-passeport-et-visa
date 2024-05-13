package Service;

//Pour l’obtention d’un passeport, une personne s’adresse au service des passeports qui s’occupe de délivrer un passeport avec un numéro unique.

import Component.Passeport;
import Component.Visa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServicePasseport {
    private List<Passeport> passeports;

    public ServicePasseport() {
        passeports = new ArrayList<>();
    }

    public Passeport delivrerPasseport(Passeport passeport) {
        // Implémentation de la délivrance de passeport TODO
    }

    public void prolongerDateExpiration(Passeport passeport, LocalDate nouvelleDateExpiration) {
        // Implémentation de la prolongation de la date d'expiration TODO
    }

    public void demandeProlongationAvecVisa(Passeport passeport) {
        if(passeport.estProlongationAutomatique()) { //TODO
            Visa visa = passeport.getVisa(); //TODO
            if(visa != null) {
                LocalDate nouvelleDateExpirationVisa = visa.getDateExpiration().plusYears(1); //TODO
                serviceConsulaire.prolongerDateExpiration(visa, nouvelleDateExpirationVisa); //TODO

            }
        }
    }

    /**
     * Vérifie la validité et la date d'expiration des passeports des citoyens.
     * Si un passeport est sur le point d'expirer dans les 6 prochains mois, une
     * notification est envoyée ou une demande de prolongation est activée automatiquement.
     */
    public void verifierPasseports() {
        LocalDate dateAujourdhui = LocalDate.now();
        for(Passeport passeport : passeports) {
            if(passeport.getDateExpiration().minusMonths(6).isBefore(dateAujourdhui)) { //TODO
                // Envoyer une notification pour renouvellement de passeport
                // Ou activer automatiquement une demande de prolongation
                // En fonction des besoins
            }
        }
    }

}
