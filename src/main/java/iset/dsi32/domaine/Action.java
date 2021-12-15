package iset.dsi32.domaine;

import iset.dsi32.domaine.enums.TypeAction;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "action")
public class Action {

    private int id ;

    private TypeAction typeAction;

    private Joueur joueur;

    private Resultat resultat;

    public Action() {
        this.id = 0;
        this.typeAction = null;
        this.joueur = null;
        this.resultat = null;
    }

    public Action(int id, TypeAction typeAction, Joueur joueur, Resultat resultat) {
        this.id = id;
        this.typeAction = typeAction;
        this.joueur = joueur;
        this.resultat = resultat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeAction getTypeAction() {
        return typeAction;
    }

    public void setTypeAction(TypeAction typeAction) {
        this.typeAction = typeAction;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", typeAction=" + typeAction +
                ", joueur=" + joueur.toString() +
                ", resultat=" + resultat.toString() + "}";
    }
}
