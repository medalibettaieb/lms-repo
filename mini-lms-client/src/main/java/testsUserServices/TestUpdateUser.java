package testsUserServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.interfaces.UserServicesRemote;

public class TestUpdateUser {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("mini-lms/UserServices!services.interfaces.UserServicesRemote");

		User userFound = userServicesRemote.findUserById(1L);

		userFound.setName("new look");

		System.out.println(userServicesRemote.updateUser(userFound));

	}

}
