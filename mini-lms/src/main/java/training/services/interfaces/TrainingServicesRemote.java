package training.services.interfaces;

import javax.ejb.Remote;

import training.entities.Player;
import training.entities.Team;

@Remote
public interface TrainingServicesRemote {
	void addTeam(Team team);

	void addPlayer(Player player);

	void assignPlayerToTeam(Long idPlayer, Long idTeam);

	Team findTeamByPlayerId(Long idPlayer);
}
