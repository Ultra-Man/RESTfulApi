package rservice;

import javax.ejb.EJB;

import javax.inject.Singleton;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import model.restejb.SessionBeanLocal;

import rservice.model.PlayerList;


@Path("rservice")
@Consumes("application/json")
@Produces("application/json")
public class PlayerService {
    
    @EJB
    SessionBeanLocal SeesionBean;
    
    public PlayerService() {
        super();
    }

    @GET
    public PlayerList getAll() {
        PlayerList listOfPlayers = new PlayerList();
        listOfPlayers.setPlayerList(SeesionBean.getPlayerFindAll());
        return listOfPlayers;
    }
}
