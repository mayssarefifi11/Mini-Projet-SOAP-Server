package iset.dsi32.services;


import iset.dsi32.domaine.Action;
import iset.dsi32.metier.ActionMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/action")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class ActionService {

    ActionMetier actionMetier = new ActionMetier();


    @Path("/getAllAction")
    @GET
    public ArrayList<Action> listActions()
    {

        return (ArrayList<Action>) actionMetier.getALLActions();
    }

    @Path("/addAction")
    @POST
    public void addAction (Action p)
    {

        actionMetier.addAction(p);
    }

    @PUT
    @Path("/update")
    public void modiferAction (Action p)
    {
        actionMetier.updateAction(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteAction (Action p){
        actionMetier.deleteAction(p.getId());
    }

}
