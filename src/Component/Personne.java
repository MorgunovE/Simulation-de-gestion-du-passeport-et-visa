package Component;
//Chaque personne a :
//o un nom,
//o un prénom et,
//o un passeport.
public class Personne {
    private String nom;
    private String prenom;
    private Passeport passport;

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Passeport getPassport() {
        return passport;
    }

    public void setPassport(Passeport passport) {
        this.passport = passport;
    }
}
