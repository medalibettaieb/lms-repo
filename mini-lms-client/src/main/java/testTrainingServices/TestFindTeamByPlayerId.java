package testTrainingServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.entities.Team;
import training.services.interfaces.TrainingServicesRemote;

public class TestFindTeamByPlayerId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainingServicesRemote trainingServicesRemote = (TrainingServicesRemote) context
				.lookup("/mini-lms/TrainingServices!training.services.interfaces.TrainingServicesRemote");

		Team team = trainingServicesRemote.findTeamByPlayerId(1L);

		System.out.println(team.getName());

	}

}
