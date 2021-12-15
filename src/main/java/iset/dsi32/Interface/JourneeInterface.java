package iset.dsi32.Interface;

import iset.dsi32.domaine.Journee;

import java.util.List;

public interface JourneeInterface {

    public List<Journee> getALLJournees();

    public Journee addJournee(Journee p);

    public void updateJournee(Journee p);

    public void deleteJournee(int id) ;

}
