package iset.dsi32.domaine;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;


@XmlRootElement(name = "equipe")
public class Equipe {

    private int id, classement;

    private String nom;

    private List<Resultat> resultats;

    public Equipe() {
        this.id = 0;
        this.classement = 0;
        this.nom = "";
        this.resultats = new ArrayList<Resultat>();
    }

    public Equipe(int id, int classement, String nom, List<Resultat> resultats) {
        this.id = id;
        this.classement = classement;
        this.nom = nom;
        this.resultats = resultats;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Resultat> getResultats() {
        return resultats;
    }

    public void setResultats(List<Resultat> resultats) {
        this.resultats = resultats;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", classement=" + classement +
                ", nom='" + nom + '\'' +
                '}';
    }
}
