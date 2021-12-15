package iset.dsi32.services;

import iset.dsi32.domaine.Action;
import iset.dsi32.domaine.Equipe;
import iset.dsi32.metier.EquipeMetier;

import java.util.ArrayList;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/equipe")
@Produces( {MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class EquipeService {

    EquipeMetier equipeMetier = new EquipeMetier();


    @Path("/getAll")
    @GET
    public ArrayList<Equipe> listEquipes()
    {

        return (ArrayList<Equipe>) equipeMetier.getALLEquipes();
    }

    @Path("/add")
    @POST
    public void addPersonne (Equipe p)
    {

        equipeMetier.addEquipe(p);
    }

    @PUT
    @Path("/update")
    public void modiferEquipe (Equipe p)
    {
        equipeMetier.updateEquipe(p);
    }

    @DELETE
    @Path("/{id}/delete")
    public void deleteEquipe (Equipe p){
        equipeMetier.deleteEquipe(p.getId());
    }







}
