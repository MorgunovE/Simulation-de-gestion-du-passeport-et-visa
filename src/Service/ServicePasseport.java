package Service;

import Component.Passeport;
import Component.Personne;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    public void verifierPasseports() {
        passeports.forEach(passeport -> {
            if(passeport.estValide() && passeport.getDateExpiration().isBefore(LocalDate.now())) {
                System.out.println("Le passeport de " + passeport.getNumero() + " est invalide.");
                annulerPasseport(passeport);
            } else if(!passeport.estValide()) {
                System.out.println("Le passeport de numero " + passeport.getNumero() + " est annuler.");
            } else {
                System.out.println("Le passeport de numero " + passeport.getNumero() + " est valide.");
            }
        });
    }

    public void planifierVerificationAnnuelle() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable verifierTask = () -> {
            LocalDate aujourdhui = LocalDate.now();
            if(aujourdhui.getMonthValue() == 12 && aujourdhui.getDayOfMonth() == 31) {
                verifierPasseports();
            }
        };

        long initialDelay = 0;
        long period = 1;
        TimeUnit timeUnit = TimeUnit.DAYS;
        scheduler.scheduleAtFixedRate(verifierTask, initialDelay, period, timeUnit);
        System.out.println("La processus automatique de vérification de la validité et de la date d'expiration des passeports des citoyens est active");
    }



}
