package iset.dsi32.Interface;

import iset.dsi32.domaine.Joueur;


import java.util.List;

public interface JoueurInterface {

    public List<Joueur> getALLJoueurs();

    public Joueur addJoueur(Joueur p);

    public void updateJoueur(Joueur p);

    public void deleteJoueur(int id) ;

    public Joueur findJoueurById(int id) ;
}
