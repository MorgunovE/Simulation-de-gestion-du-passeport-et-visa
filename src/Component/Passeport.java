package Component;

//Chaque passeport a :
//o un numéro,
//o une date et un lieu de délivrance,
//o une date d'expiration,
//o une validité, exemple, un passeport volé ou perdu peut être invalidé.
//o un passeport peut contenir un visa.
//Programmation orientée objet

import java.time.LocalDate;

public class Passeport {
    private String numero;
    private LocalDate dateDelivrance;
    private String lieuDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;
    private Visa visa;

    /**
     * Prolonge la date d'expiration du passeport avec la nouvelle date spécifiée.
     *
     * @param nouvelleDateExpiration La nouvelle date d'expiration du passeport.
     */
    public void prolongerDateExpiration(LocalDate nouvelleDateExpiration) {
        // Implémentation de la prolongation de la date d'expiration... TODO
    }

}
