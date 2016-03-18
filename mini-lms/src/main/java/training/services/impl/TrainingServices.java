package training.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignPlayerToTeam(Long idPlayer, Long idTeam) {
		// TODO Auto-generated method stub
		
	}

}
