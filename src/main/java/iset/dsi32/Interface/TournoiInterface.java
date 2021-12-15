package iset.dsi32.Interface;

import iset.dsi32.domaine.Tournoi;

import java.util.List;

public interface TournoiInterface {

    public List<Tournoi> getALLTournois();

    public Tournoi addTournoi(Tournoi p);

    public void updateTournoi(Tournoi p);

    public void deleteTournoi(int id) ;

    public List<Tournoi> findTournoisById(String id) ;
}
