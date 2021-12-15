package iset.dsi32.Interface;

import iset.dsi32.domaine.Equipe;

import java.util.List;

public interface EquipeInterface {

    public List<Equipe> getALLEquipes();

    public Equipe addEquipe(Equipe p);

    public void updateEquipe(Equipe p);

    public void deleteEquipe(int id) ;

    public Equipe findEquipeById(int id) ;

}
