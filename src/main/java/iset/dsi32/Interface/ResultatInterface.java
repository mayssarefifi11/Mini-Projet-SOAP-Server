package iset.dsi32.Interface;

import iset.dsi32.domaine.Joueur;
import iset.dsi32.domaine.Resultat;

import java.util.List;

public interface ResultatInterface {

    public List<Resultat> getALLResultats();

    public Resultat addResultat(Resultat p);

    public void updateResultat(Resultat p);

    public void deleteResultat(int id) ;

    public List<Resultat> findResultatsById(int id) ;
}
