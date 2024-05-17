import Component.Passeport;
import Component.Personne;
import Component.Visa;
import Service.ServiceConsulaire;
import Service.ServicePasseport;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ServicePasseport servicePasseport = new ServicePasseport();
        ServiceConsulaire serviceConsulaire = new ServiceConsulaire();

        //Test du système de gestion des passeports et des visas.
        System.out.println("------------------------------");
        System.out.println("Test du système de gestion des passeports et des visas.");
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Création d'une personne et demande de passeport et visa.");
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

        System.out.println("------------------------------");
        System.out.println("Informations de la personne : ");
        personne.afficherInformations();
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Prolongation de la date d'expiration du passeport ");
        LocalDate nouvelleDateExpiration = LocalDate.of(2030, 5, 14);
        servicePasseport.demanderPrologationPasseport(passeport, nouvelleDateExpiration);
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        System.out.println("Prolongation de la date d'expiration du visa ");
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

        System.out.println("------------------------------");
        System.out.println("La processus automatique de vérification de la validité et de la date d'expiration des passeports des citoyens");
        servicePasseport.planifierVerificationAnnuelle();
        System.out.println("------------------------------");

        //La programme simple avec Scanner pour interactions avec l'utilisateur
        System.out.println("------------------------------");
        // Demande de création de passeport
        System.out.println("Bienvenue dans le système de gestion des passeports et des visas.");
        System.out.println("Veuillez entrer votre nom : ");
        String nom = scanner.nextLine();
        System.out.println("Veuillez entrer votre prenom : ");
        String prenom = scanner.nextLine();

        // Création d'une personne
        Personne personneScanner = new Personne(nom, prenom);
        // Service des passeports
        LocalDate dateDelivrancePasseportScanner = LocalDate.now();
        LocalDate dateExpirationPasseportScanner = LocalDate.now().plusYears(5);
        System.out.print("Lieu de délivrance: ");
        String lieuDelivrancePasseportScanner = scanner.nextLine();
        Passeport passeportScanner = new Passeport(dateDelivrancePasseportScanner, dateExpirationPasseportScanner, lieuDelivrancePasseportScanner);
        servicePasseport.demanderPasseport(personneScanner, passeportScanner);

        // Demande de visa
        System.out.println("Souhaitez-vous obtenir un visa ? (y/n)");
        String choixVisaScanner = scanner.nextLine();
        if(choixVisaScanner.equalsIgnoreCase("y")){
            System.out.println("Veuillez entrer le type de visa souhaité : ");
            String typeVisaScanner = scanner.nextLine();
            LocalDate dateDelivranceVisaScanner = LocalDate.now();
            LocalDate dateExpirationVisaScanner = LocalDate.now().plusMonths(6);
            Visa visaScanner = new Visa(typeVisaScanner, dateDelivranceVisaScanner, dateExpirationVisaScanner);
            serviceConsulaire.demanderVisa(personneScanner, visaScanner);
        }

        // Affichage des informations de la personne, du passeport et du visa
        System.out.println("Informations de la personne : ");
        personneScanner.afficherInformations();
        System.out.println("Merci pour votre visite.");
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        // Simuler une invalidité de passeport suite à un vol ou une perte
        System.out.println("Avez-vous perdu ou vous vous êtes fait voler votre passeport ? (y/n)");
        String choixPerteVolScanner = scanner.nextLine();
        if(choixPerteVolScanner.equalsIgnoreCase("y")){
            servicePasseport.annulerPasseport(passeportScanner);
            System.out.println("Informations de la personne : ");
            personneScanner.afficherInformations();
            System.out.println("Merci pour votre visite.");
        }
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        // Simuler une demande de prolongation de visa
        System.out.println("Voulez-vous prolonger la date d'expiration de votre visa ? (y/n)");
        String choixProlongationVisaScanner = scanner.nextLine();
        if(choixProlongationVisaScanner.equalsIgnoreCase("y")){
            if(personneScanner.getPassport().estValide()) {
                if(!personneScanner.getPassport().getVisa().isEmpty()){
                    personneScanner.getPassport().getVisa().forEach(visaScanner -> visaScanner.setValide(true));
                    personneScanner.getPassport().getVisa().forEach(visaScanner -> serviceConsulaire.demanderPrologationVisa(personneScanner, visaScanner, LocalDate.now().plusMonths(10)));
                    System.out.println("Informations de la personne : ");
                    personneScanner.afficherInformations();
                    System.out.println("Merci pour votre visite.");
                } else {
                    System.out.println("Aucun visa associé à ce passeport.");
                }
            } else {
                System.out.println("Le passeport n'est pas valide.");
            }
        }
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        // Simuler une demande de prolongation de passeport
        System.out.println("Voulez-vous prolonger la date d'expiration de votre passeport ? (y/n)");
        String choixProlongationPasseportScanner = scanner.nextLine();
        if(choixProlongationPasseportScanner.equalsIgnoreCase("y")){
            servicePasseport.demanderPrologationPasseport(personneScanner.getPassport(), LocalDate.now().plusYears(10));
            System.out.println("Informations de la personne : ");
            personneScanner.afficherInformations();
            System.out.println("Merci pour votre visite.");
        }
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        // Simuler une nouvelle plateforme qui permet, moyennant des frais supplémentaires, l'activation automatique d'une demande de prolongation de visa sur un passeport pour lequel une demande de prolongation
        System.out.println("Voulez-vous prolonger la date d'expiration de votre visa automatique avec votre passeport ? (y/n)");
        String choixProlongationVisaAutomatiqueScanner = scanner.nextLine();
        if(choixProlongationVisaAutomatiqueScanner.equalsIgnoreCase("y")){
            personneScanner.getPassport().setProlongerVisaAutomatiquement(true);
            servicePasseport.demanderPrologationPasseport(personneScanner.getPassport(), LocalDate.now().plusYears(10));
            System.out.println("Informations de la personne : ");
            personneScanner.afficherInformations();
            System.out.println("Merci pour votre visite.");
        }
        System.out.println("------------------------------");

        System.out.println("------------------------------");
        //une structure de données qui permettrait au service des passeports de rouler un processus automatique annuel qui vérifie la validité et la date d’expiration des passeports des citoyens.
        System.out.println("Voulez-vous lancer un processus automatique de vérification de la validité et de la date d'expiration des passeports des citoyens ? (y/n)");
        String choixVerificationPasseportsAutomatiqueScanner = scanner.nextLine();
        if(choixVerificationPasseportsAutomatiqueScanner.equalsIgnoreCase("y")){
            servicePasseport.verifierPasseports();
            System.out.println("Merci pour votre visite.");
        }
        System.out.println("------------------------------");
        System.exit(0);
    }
}