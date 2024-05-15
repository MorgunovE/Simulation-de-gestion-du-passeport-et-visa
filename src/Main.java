import Component.Passeport;
import Component.Personne;
import Component.Visa;
import Service.ServiceConsulaire;
import Service.ServicePasseport;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {


//    private static Scanner scanner = new Scanner(System.in);
//    private static ServicePasseport servicePasseport = new ServicePasseport();
//    private static ServiceConsulaire serviceConsulaire = new ServiceConsulaire();

    public static void main(String[] args) {
        ServicePasseport servicePasseport = new ServicePasseport();
        ServiceConsulaire serviceConsulaire = new ServiceConsulaire();

        System.out.println("------------------------------");
        Personne personne = new Personne("Premier", "Max");

        LocalDate dateDelivrancePasseport = LocalDate.of(2024, 5, 14);
        LocalDate dateExpirationPasseport = LocalDate.of(2029, 5, 14);
        String lieuDelivrancePasseport = "Montreal";
        Passeport passeport = new Passeport(dateDelivrancePasseport, dateExpirationPasseport, lieuDelivrancePasseport);
        servicePasseport.demanderPasseport(personne, passeport);

        LocalDate dateDelivranceVisa = LocalDate.of(2024, 5, 15);
        LocalDate dateExpirationVisa = LocalDate.of(2024, 11, 15);
        String typeVisa = "Touriste";
        Visa visa = new Visa(typeVisa, dateDelivranceVisa, dateExpirationVisa);
        serviceConsulaire.demanderVisa(personne, visa);

        System.out.println("------------------------------");
        System.out.println("Informations de la personne : ");
        personne.afficherInformations();
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        LocalDate nouvelleDateExpiration = LocalDate.of(2030, 5, 14);
        servicePasseport.demanderPrologationPasseport(passeport, nouvelleDateExpiration);
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        LocalDate nouvelleDateExpirationVisa = LocalDate.of(2025, 11, 15);
        serviceConsulaire.demanderPrologationVisa(personne, visa, nouvelleDateExpirationVisa);
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Informations de la personne avec nouvelle date expiration passeport et visa: ");
        personne.afficherInformations();
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Informations de la personne avec nouvelle visa et la date expiration est déterminée de la durée de validité du passeport. : ");
        LocalDate dateDelivranceVisa2 = LocalDate.of(2024, 5, 15);
        LocalDate dateExpirationVisa2 = LocalDate.of(2035, 1, 1);
        String typeVisa2 = "Etudiant";
        Visa visa2 = new Visa(typeVisa2, dateDelivranceVisa2, dateExpirationVisa2);
        serviceConsulaire.demanderVisa(personne, visa2);
        System.out.println("Informations de la personne : ");
        personne.afficherInformations();
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Annulation du visa : ");
        serviceConsulaire.annulerVisa(visa2);
        System.out.println("Informations de la personne : ");
        personne.afficherInformations();
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Annulation du passeport et automatiquement des visas qui lui sont associés: ");
        servicePasseport.annulerPasseport(passeport);
        System.out.println("Informations de la personne : ");
        personne.afficherInformations();
        System.out.println("------------------------------");


        // Demande de création de passeport
//        System.out.println("Bienvenue dans le système de gestion des passeports et des visas.");
//        System.out.println("Veuillez entrer votre nom : ");
//        String nom = scanner.nextLine();
//        System.out.println("Veuillez entrer votre prenom : ");
//        String prenom = scanner.nextLine();

        // Création d'une personne
//        Personne personne = new Personne(nom, prenom);
        // Service des passeports
//        Passeport passeport = servicePasseport.delivrerPasseport(personne);// TODO
//        personne.setPassport(passeport);

        // Demande de visa
//        System.out.println("Souhaitez-vous obtenir un visa ? (oui/non)");
//        String choixVisa = scanner.nextLine();
//        if(choixVisa.equalsIgnoreCase("oui")){
//            System.out.println("Veuillez entrer le type de visa souhaité : ");
//            String typeVisa = scanner.nextLine();
//            Visa visa = serviceConsulaire.delivrerVisa(personne, typeVisa); //TODO
//            passeport.setVisa(visa);//TODO
//        }

        // Affichage des informations de la personne, du passeport et du visa
//        afficherInformations(personne);

        // Simuler une invalidité de passeport suite à un vol ou une perte
//        System.out.println("Avez-vous perdu ou vous vous êtes fait voler votre passeport ? (oui/non)");
//        String choixPerteVol = scanner.nextLine();
//        if(choixPerteVol.equalsIgnoreCase("oui")){
//            servicePasseport.annulerPasseport(passeport); //TODO
//            System.out.println("Votre passeport a été invalidé.");
//        }

        // Simuler une demande de prolongation de visa
//        System.out.println("Voulez-vous prolonger la date d'expiration de votre visa ? (oui/non)");
//        String choixProlongationVisa = scanner.nextLine();
//        if(choixProlongationVisa.equalsIgnoreCase("oui")){
//            LocalDate nouvelleDateExpirationVisa = visa.getDateEpiration().plusYears(1); //TODO
//            serviceConsulaire.prolongerDateExpiration(passeport.getVisa(), nouvelleDateExpirationVisa); //TODO
//            System.out.println("La date d'expiration de votre visa a été prolongée.");
//        }

        // Simuler une demande de prolongation de passeport
//        System.out.println("Voulez-vous prolonger la date d'expiration de votre passeport ? (oui/non)");
//        String choixProlongationPasseport = scanner.nextLine();
//        if(choixProlongationPasseport.equalsIgnoreCase("oui")){
//            LocalDate nouvelleDateExpirationPasseport = passeport.getDateExpiration().plusYears(5); //TODO
//            servicePasseport.prolongerDateExpiration(passeport, nouvelleDateExpirationPasseport); //TODO
//            System.out.println("La date d'expiration de votre passeport a été prolongée.");
//        }

        // Affichage des informations mises à jour
//        afficherInformations(personne);
//    }

//    private static void afficherInformations(Personne personne) {
//        System.out.println("Informations de la personne : ");
//        System.out.println("Nom : " + personne.getNom()); //TODO
//        System.out.println("Prenom : " + personne.getPrenom()); //TODO
//
//        Passeport passeport = personne.getPassport();
//        if(passeport != null) {
//            System.out.println("Informations du passeport : ");
//            System.out.println("Numero : " + passeport.getNumero()); //TODO
//            System.out.println("Date de délivrance : " + passeport.getDateDelivrance()); //TODO
//            System.out.println("Date d'expiration : " + passeport.getDateExpiration()); //TODO
//            System.out.println("Valide : " + passeport.estValide()); //TODO
//
//            Visa visa = passeport.getVisa(); //TODO
//            if(visa != null) {
//                System.out.println("Informations du visa : ");
//                System.out.println("Type : " + visa.getType()); //TODO
//                System.out.println("Date de délivrance : " + visa.getDateDelivrance()); //TODO
//                System.out.println("Date d'expiration : " + visa.getDateExpiration()); //TODO
//                System.out.println("Valide : " + visa.estValide()); //TODO
//            }
//
//        } else {
//            System.out.println("Personne n'a pas de passeport.");
//        }
//        System.out.println("------------------------------");
    }
}