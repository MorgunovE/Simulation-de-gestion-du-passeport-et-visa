package Component;

//Chaque visa a :
//o un type, exemple : étudiant, touriste, etc
//o une date de délivrance,
//o une date d’expiration,
//o une validité.
//

import java.time.LocalDate;

public class Visa {
    private String type;
    private LocalDate dateDelivrance;
    private LocalDate dateExpiration;
    private boolean valide;

}
