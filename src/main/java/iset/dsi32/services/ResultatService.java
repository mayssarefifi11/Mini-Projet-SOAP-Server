package iset.dsi32.services;


import iset.dsi32.domaine.Journee;
import iset.dsi32.domaine.Resultat;
import iset.dsi32.metier.ResultatMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/resultat")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class ResultatService {

    ResultatMetier resultetMetier = new ResultatMetier();

    @Path("/getAllResultat")
    @GET
    public ArrayList<Resultat> listResultats()
    {

        return (ArrayList<Resultat>) resultetMetier.getALLResultats();
    }

    @Path("/addResultat")
    @POST
    public void addJResultat(Resultat p)
    {
        resultetMetier.addResultat(p);
    }

    @PUT
    @Path("/update")
    public void modiferResultat (Resultat p)
    {
        resultetMetier.updateResultat(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteResultat (Resultat p){
        resultetMetier.deleteResultat(p.getId());
    }
}
