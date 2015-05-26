package rservice.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Player;

@XmlRootElement
public class PlayerList {
    
    List<Player> playerList = new ArrayList<Player>();
    
    @XmlElement(name="allplayers")
    public List<Player> getPlayerList() {
        return playerList;
    }
    
    public void setPlayerList(List<Player> playerList){
        this.playerList = playerList;    
    }
}
