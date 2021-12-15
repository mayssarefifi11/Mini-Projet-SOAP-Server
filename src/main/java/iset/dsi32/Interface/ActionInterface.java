package iset.dsi32.Interface;

import iset.dsi32.domaine.Action;
import iset.dsi32.domaine.Equipe;

import java.util.List;

public interface ActionInterface {

    public List<Action> getALLActions();

    public Action addAction(Action p);

    public void updateAction(Action p);

    public void deleteAction(int id) ;





}
