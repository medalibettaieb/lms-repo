package training.services.interfaces;

import javax.ejb.Local;

import training.entities.Player;
import training.entities.Team;

@Local
public interface TrainingServicesLocal {
	void addTeam(Team team);

	void addPlayer(Player player);

	void assignPlayerToTeam(Long idPlayer, Long idTeam);

	Team findTeamByPlayerId(Long idPlayer);
}
