package training.services.utilities;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import training.entities.Player;
import training.entities.Team;
import training.services.interfaces.TrainingServicesLocal;

/**
 * Session Bean implementation class Utilitiesservices
 */
@Singleton
@LocalBean
@Startup
public class Utilitiesservices {
	@EJB
	private TrainingServicesLocal trainingServicesLocal;

	/**
	 * Default constructor.
	 */
	public Utilitiesservices() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		Player player = new Player();
		player.setId(1L);
		player.setName("Messi");
		
		Player player2 = new Player();
		player2.setId(2L);
		player2.setName("Mehrez");

		Team team = new Team();
		team.setId(1L);
		team.setName("Barca");

		trainingServicesLocal.addPlayer(player);
		trainingServicesLocal.addPlayer(player2);
		trainingServicesLocal.addTeam(team);
	}
}
