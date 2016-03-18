package training.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import training.entities.Player;
import training.entities.Team;
import training.services.interfaces.TrainingServicesLocal;
import training.services.interfaces.TrainingServicesRemote;

/**
 * Session Bean implementation class TrainingServices
 */
@Stateless
public class TrainingServices implements TrainingServicesRemote, TrainingServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public TrainingServices() {
	}

	@Override
	public void addTeam(Team team) {
		entityManager.persist(team);
	}

	@Override
	public void addPlayer(Player player) {
		entityManager.persist(player);
	}

	@Override
	public Team findTeamByPlayerId(Long idPlayer) {
		String jpql = "select t from Team t where :param member of t.players";
		Query query = entityManager.createQuery(jpql, Team.class);
		Player playerFound = entityManager.find(Player.class, idPlayer);
		query.setParameter("param", playerFound);
		return (Team) query.getSingleResult();
	}

	@Override
	public void assignPlayerToTeam(Long idPlayer, Long idTeam) {
		Team teamFound = entityManager.find(Team.class, idTeam);
		Player playerFound = entityManager.find(Player.class, idPlayer);

		List<Player> oldPlayers = teamFound.getPlayers();
		oldPlayers.add(playerFound);
		teamFound.setPlayers(oldPlayers);

		entityManager.merge(teamFound);

	}

}
