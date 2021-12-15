package iset.dsi32.domaine;

import iset.dsi32.domaine.enums.StatusResultat;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "resulat")
public class Resultat {

    private int id, nbreCartonsJaunes, nbreCartonsRouges ;

    private StatusResultat status;

    private Journee journee;

    private Equipe equipe;


    public Resultat() {
        this.id = 0;
        this.nbreCartonsJaunes = 0;
        this.nbreCartonsRouges = 0;
        this.status = null;
        this.journee = null;
        this.equipe = null;

    }

    public Resultat(int id, int nbreCartonsJaunes, int nbreCartonsRouges, StatusResultat status, Journee journee, Equipe equipe) {
        this.id = id;
        this.nbreCartonsJaunes = nbreCartonsJaunes;
        this.nbreCartonsRouges = nbreCartonsRouges;
        this.status = status;
        this.journee = journee;
        this.equipe = equipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbreCartonsJaunes() {
        return nbreCartonsJaunes;
    }

    public void setNbreCartonsJaunes(int nbreCartonsJaunes) {
        this.nbreCartonsJaunes = nbreCartonsJaunes;
    }

    public int getNbreCartonRouges() {
        return nbreCartonsRouges;
    }

    public void setNbreCartonRouges(int nbreCartonRouges) {
        this.nbreCartonsRouges = nbreCartonRouges;
    }

    public StatusResultat getStatus() {
        return status;
    }

    public void setStatus(StatusResultat status) {
        this.status = status;
    }

    public Journee getJournee() {
        return journee;
    }

    public void setJournee(Journee journee) {
        this.journee = journee;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return "Resultat{" +
                "id=" + id +
                ", nbreCartonsJaunes=" + nbreCartonsJaunes +
                ", nbreCartonRouges=" + nbreCartonsRouges +
                ", status='" + status.name() + '\'' +
                ", journee=" + journee.toString() +
                ", equipe=" + equipe.toString() +
                '}';
    }
}
