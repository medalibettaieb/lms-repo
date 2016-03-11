package testsUserServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.interfaces.UserServicesRemote;

public class TestFindAllUsers {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("mini-lms/UserServices!services.interfaces.UserServicesRemote");

		List<User> users = userServicesRemote.findAllUsers();

		for (User u : users) {
			System.out.println(u.getName());
		}

	}

}
