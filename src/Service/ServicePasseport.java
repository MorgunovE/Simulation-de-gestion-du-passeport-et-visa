package Service;

//Pour l’obtention d’un passeport, une personne s’adresse au service des passeports qui s’occupe de délivrer un passeport avec un numéro unique.

import Component.Passeport;

import java.time.LocalDate;

public class ServicePasseport {
    private List<Passeport> passeports;

    public Passeport delivrerPasseport(Passeport passeport) {
        // Implémentation de la délivrance de passeport
    }

    public void prolongerDateExpiration(Passeport passeport, LocalDate nouvelleDateExpiration) {
        // Implémentation de la prolongation de la date d'expiration
    }
}
