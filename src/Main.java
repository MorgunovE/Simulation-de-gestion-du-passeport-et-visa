import Component.Passeport;
import Component.Personne;
import Component.Visa;
import Service.ServiceConsulaire;
import Service.ServicePasseport;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Création d'une personne
        Personne personne = new Personne("Max", "Power");

        // Service des passeports
        ServicePasseport servicePasseport = new ServicePasseport();
        Passeport passeport = servicePasseport.delivrerPasseport(personne.getPassport());// TODO

        // Demande de visa auprès du service consulaire
        ServiceConsulaire serviceConsulaire = new ServiceConsulaire();
        Visa visa = serviceConsulaire.delivrerVisa(personne, "Touriste"); //TODO

        // Affichage des informations de la personne, du passeport et du visa
        afficherInformations(personne);

        // Simuler une invalidité de passeport
        servicePasseport.invaliderPasseport(passeport); //TODO

        // Simuler une prolongation de visa
        LocalDate nouvelleDateExpirationVisa = visa.getDateEpiration().plusMonths(1); //TODO
        serviceConsulaire.prolongerDateExpiration(passeport, nouvelleDateExpirationPasseport); //TODO

        // Affichage des informations mises à jour
        afficherInformations(personne);
    }

    private static void afficherInformations(Personne personne) {
        System.out.println("Informations de la personne : ");
        System.out.println("Nom : " + personne.getNom()); //TODO
        System.out.println("Prenom : " + personne.getPrenom()); //TODO

        Passeport passeport = personne.getPassport();
        if(passeport != null) {
            System.out.println("Informations du passeport : ");
            System.out.println("Numero : " + passeport.getNumero()); //TODO
            System.out.println("Date de délivrance : " + passeport.getDateDelivrance()); //TODO
            System.out.println("Date d'expiration : " + passeport.getDateExpiration()); //TODO
            System.out.println("Valide : " + passeport.estValide()); //TODO

            Visa visa = passeport.getVisa(); //TODO
            if(visa != null) {
                System.out.println("Informations du visa : ");
                System.out.println("Type : " + visa.getType()); //TODO
                System.out.println("Date de délivrance : " + visa.getDateDelivrance()); //TODO
                System.out.println("Date d'expiration : " + visa.getDateExpiration()); //TODO
                System.out.println("Valide : " + visa.estValide()); //TODO
            }

        } else {
            System.out.println("Personne n'a pas de passeport.");
        }
        System.out.println("------------------------------");
    }
}