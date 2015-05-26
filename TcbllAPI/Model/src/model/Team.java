package model;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

/**
 * To create ID generator table "TEAM_ID_TAB_GEN":
 * CREATE TABLE "TEAM_ID_TAB_GEN" ("PRIMARY_KEY_NAME" VARCHAR2(4000) PRIMARY KEY, "NEXT_ID_VALUE" NUMBER(38));
 *
 * To initialize this table with data for this entity's ID generator 'Team.id' (starting with value '0'):
 * INSERT INTO "TEAM_ID_TAB_GEN" VALUES ('Team.id', 0);
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Team.findAll", query = "select o from Team o") })
@TableGenerator(name = "Team_Id_Tab_Gen", table = "TEAM_ID_TAB_GEN", pkColumnName = "PRIMARY_KEY_NAME",
                pkColumnValue = "Team.id", valueColumnName = "NEXT_ID_VALUE")
public class Team implements Serializable {
    private static final long serialVersionUID = -2595848019700350209L;
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "Team_Id_Tab_Gen")
    private Integer id;
    @Column(length = 50)
    private String teamname;
    @OneToMany(mappedBy = "team", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Player> playerList;

    public Team() {
    }

    public Team(Integer id, String teamname) {
        this.id = id;
        this.teamname = teamname;
    }

    public Integer getId() {
        return id;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public Player addPlayer(Player player) {
        getPlayerList().add(player);
        player.setTeam(this);
        return player;
    }

    public Player removePlayer(Player player) {
        getPlayerList().remove(player);
        player.setTeam(null);
        return player;
    }
}
