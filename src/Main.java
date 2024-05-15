import Component.Passeport;
import Component.Personne;
import Component.Visa;
import Service.ServiceConsulaire;
import Service.ServicePasseport;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ServicePasseport servicePasseport = new ServicePasseport();
    private static ServiceConsulaire serviceConsulaire = new ServiceConsulaire();

    public static void main(String[] args) {
        // Demande de création de passeport
        System.out.println("Bienvenue dans le système de gestion des passeports et des visas.");
        System.out.println("Veuillez entrer votre nom : ");
        String nom = scanner.nextLine();
        System.out.println("Veuillez entrer votre prenom : ");
        String prenom = scanner.nextLine();

        // Création d'une personne
        Personne personne = new Personne(nom, prenom);
        // Service des passeports
        Passeport passeport = servicePasseport.delivrerPasseport(personne);// TODO
        personne.setPassport(passeport);

        // Demande de visa
        System.out.println("Souhaitez-vous obtenir un visa ? (oui/non)");
        String choixVisa = scanner.nextLine();
        if(choixVisa.equalsIgnoreCase("oui")){
            System.out.println("Veuillez entrer le type de visa souhaité : ");
            String typeVisa = scanner.nextLine();
            Visa visa = serviceConsulaire.delivrerVisa(personne, typeVisa); //TODO
            passeport.setVisa(visa);//TODO
        }

        // Affichage des informations de la personne, du passeport et du visa
        afficherInformations(personne);

        // Simuler une invalidité de passeport suite à un vol ou une perte
        System.out.println("Avez-vous perdu ou vous vous êtes fait voler votre passeport ? (oui/non)");
        String choixPerteVol = scanner.nextLine();
        if(choixPerteVol.equalsIgnoreCase("oui")){
            servicePasseport.annulerPasseport(passeport); //TODO
            System.out.println("Votre passeport a été invalidé.");
        }

        // Simuler une demande de prolongation de visa
        System.out.println("Voulez-vous prolonger la date d'expiration de votre visa ? (oui/non)");
        String choixProlongationVisa = scanner.nextLine();
        if(choixProlongationVisa.equalsIgnoreCase("oui")){
            LocalDate nouvelleDateExpirationVisa = visa.getDateEpiration().plusYears(1); //TODO
            serviceConsulaire.prolongerDateExpiration(passeport.getVisa(), nouvelleDateExpirationVisa); //TODO
            System.out.println("La date d'expiration de votre visa a été prolongée.");
        }

        // Simuler une demande de prolongation de passeport
        System.out.println("Voulez-vous prolonger la date d'expiration de votre passeport ? (oui/non)");
        String choixProlongationPasseport = scanner.nextLine();
        if(choixProlongationPasseport.equalsIgnoreCase("oui")){
            LocalDate nouvelleDateExpirationPasseport = passeport.getDateExpiration().plusYears(5); //TODO
            servicePasseport.prolongerDateExpiration(passeport, nouvelleDateExpirationPasseport); //TODO
            System.out.println("La date d'expiration de votre passeport a été prolongée.");
        }

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