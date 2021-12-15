package iset.dsi32.domaine;


import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "joueur")
public class Joueur {

    private int id;

    private String nom, prenom;

    private int age, nbreCartonsJaunes, nbreCartonsRouges, nbreButs;

    private Equipe equipe;

    public Joueur() {
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.age = 0;
        this.nbreCartonsJaunes = 0;
        this.nbreCartonsRouges = 0;
        this.nbreButs = 0;
        this.equipe = null;
    }

    public Joueur(int id, String nom, String prenom, int age, int nbreCartonsJaunes, int nbreCartonsRouges, int nbreButs, Equipe equipe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nbreCartonsJaunes = nbreCartonsJaunes;
        this.nbreCartonsRouges = nbreCartonsRouges;
        this.nbreButs = nbreButs;
        this.equipe = equipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNbreCartonsJaunes() {
        return nbreCartonsJaunes;
    }

    public void setNbreCartonsJaunes(int nbreCartonsJaunes) {
        this.nbreCartonsJaunes = nbreCartonsJaunes;
    }

    public int getNbreCartonsRouges() {
        return nbreCartonsRouges;
    }

    public void setNbreCartonsRouges(int nbreCartonsRouges) {
        this.nbreCartonsRouges = nbreCartonsRouges;
    }

    public int getNbreButs() {
        return nbreButs;
    }

    public void setNbreButs(int nbreButs) {
        this.nbreButs = nbreButs;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", nbreCartonsJaunes=" + nbreCartonsJaunes +
                ", nbreCartonsRouges=" + nbreCartonsRouges +
                ", nbreButs=" + nbreButs +
                ", equipe=" + equipe.toString() +
                '}';
    }
}
