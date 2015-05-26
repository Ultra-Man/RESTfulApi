package model.restejb;

import java.util.List;

import javax.ejb.Local;

import model.Player;
import model.Team;

@Local
public interface SessionBeanLocal {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    <T> T persistEntity(T entity);

    <T> T mergeEntity(T entity);

    Team persistTeam(Team team);

    Team mergeTeam(Team team);

    void removeTeam(Team team);

    List<Team> getTeamFindAll();

    Player persistPlayer(Player player);

    Player mergePlayer(Player player);

    void removePlayer(Player player);

    List<Player> getPlayerFindAll();
}
