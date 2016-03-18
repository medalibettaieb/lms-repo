package testTrainingServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import training.services.interfaces.TrainingServicesRemote;

public class TestAssignPlayerTeam {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		TrainingServicesRemote trainingServicesRemote = (TrainingServicesRemote) context
				.lookup("/mini-lms/TrainingServices!training.services.interfaces.TrainingServicesRemote");
		
		trainingServicesRemote.assignPlayerToTeam(1L, 1L);
		trainingServicesRemote.assignPlayerToTeam(2L, 1L);
		
	}

}
