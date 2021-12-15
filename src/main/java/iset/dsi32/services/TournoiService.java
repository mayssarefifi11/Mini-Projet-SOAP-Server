package iset.dsi32.services;


import iset.dsi32.domaine.Action;
import iset.dsi32.domaine.Resultat;
import iset.dsi32.domaine.Tournoi;
import iset.dsi32.metier.TournoiMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/tournoi")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class TournoiService {

    TournoiMetier tournoiMetier = new TournoiMetier();

    @Path("/getAllTournoi")
    @GET
    public ArrayList<Tournoi> listTournois()
    {
        return (ArrayList<Tournoi>) tournoiMetier.getALLTournois();
    }

    @Path("/addTournoi")
    @POST
    public void addTournoi (Tournoi p)
    {

        tournoiMetier.addTournoi(p);
    }

    @PUT
    @Path("/update")
    public void modiferTournoi (Tournoi p)
    {
        tournoiMetier.updateTournoi(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteTournoi (Tournoi p){
        tournoiMetier.deleteTournoi(p.getId());
    }
}
