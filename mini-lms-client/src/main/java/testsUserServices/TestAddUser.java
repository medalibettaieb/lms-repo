package testsUserServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.User;
import services.interfaces.UserServicesRemote;

public class TestAddUser {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("mini-lms/UserServices!services.interfaces.UserServicesRemote");

		User user = new User();
		user.setId(1L);
		user.setName("chelli");

		System.out.println(userServicesRemote.addUser(user));

	}

}
