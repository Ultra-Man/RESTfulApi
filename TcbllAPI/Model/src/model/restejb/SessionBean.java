package model.restejb;

import java.util.List;

import javax.annotation.Resource;

import javax.ejb.SessionContext;
import javax.ejb.Stateless;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Player;
import model.Team;

@Stateless(mappedName = "TcbllAPI-Model-SessionBean")
public class SessionBean implements SessionBeanLocal {
    @Resource
    SessionContext sessionContext;
    @PersistenceContext(unitName = "Model")
    private EntityManager em;

    public SessionBean() {
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        return em.merge(entity);
    }

    public Team persistTeam(Team team) {
        em.persist(team);
        return team;
    }

    public Team mergeTeam(Team team) {
        return em.merge(team);
    }

    public void removeTeam(Team team) {
        team = em.find(Team.class, team.getId());
        em.remove(team);
    }

    /** <code>select o from Team o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Team> getTeamFindAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }

    public Player persistPlayer(Player player) {
        em.persist(player);
        return player;
    }

    public Player mergePlayer(Player player) {
        return em.merge(player);
    }

    public void removePlayer(Player player) {
        player = em.find(Player.class, player.getId());
        em.remove(player);
    }

    /** <code>select o from Player o</code> */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<Player> getPlayerFindAll() {
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }
}
