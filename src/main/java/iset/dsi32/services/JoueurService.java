package iset.dsi32.services;


import iset.dsi32.domaine.Equipe;
import iset.dsi32.domaine.Joueur;
import iset.dsi32.metier.JoueurMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/joueur")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class JoueurService {

    JoueurMetier joueurMetier =  new JoueurMetier();

    @Path("/getAllJoueur")
    @GET
    public ArrayList<Joueur> listJoueurs()
    {

        return (ArrayList<Joueur>) joueurMetier.getALLJoueurs();
    }

    @Path("/addJoueur")
    @POST
    public void addJoueur (Joueur p)
    {

        joueurMetier.addJoueur(p);
    }
    @PUT
    @Path("/update")
    public void modiferJoueur (Joueur p)
    {
        joueurMetier.updateJoueur(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteJoueur (Joueur p){
        joueurMetier.deleteJoueur(p.getId());
    }

}
