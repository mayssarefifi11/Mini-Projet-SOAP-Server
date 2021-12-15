package iset.dsi32.domaine;

import iset.dsi32.domaine.Journee;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "tournoi")
public class Tournoi {

    private int id ;

    private String titre;

    private Date dateDebut, dateFin;

    private List<Journee> journees;

    public Tournoi() {
        this.id = 0;
        this.titre = "";
        this.dateDebut = new Date();
        this.dateFin = new Date();
        this.journees = new ArrayList<Journee>();
    }

    public Tournoi(int id, String titre, Date dateDebut, Date dateFin, List<Journee> journees) {
        this.id = id;
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.journees = journees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public List<Journee> getJournees() {
        return journees;
    }

    public void setJournees(List<Journee> journees) {
        this.journees = journees;
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", journees=" + journees.size() +
                '}';
    }
}
