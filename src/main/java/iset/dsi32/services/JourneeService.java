package iset.dsi32.services;

import iset.dsi32.domaine.Joueur;
import iset.dsi32.domaine.Journee;
import iset.dsi32.metier.JourneeMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/journee")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class JourneeService {

    JourneeMetier journeeMetier = new JourneeMetier();


    @Path("/getAllJournee")
    @GET
    public ArrayList<Journee> listJournees()
    {

        return (ArrayList<Journee>) journeeMetier.getALLJournees();
    }

    @Path("/addJournee")
    @POST
    public void addJournee (Journee p)
    {
        journeeMetier.addJournee(p);
    }

    @PUT
    @Path("/update")
    public void modiferJournee (Journee p)
    {
        journeeMetier.updateJournee(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteJournee (Journee p){
        journeeMetier.deleteJournee(p.getId());
    }
}
