package testsUserServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.UserServicesRemote;

public class TestDeleteUserById {
	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote userServicesRemote = (UserServicesRemote) context
				.lookup("mini-lms/UserServices!services.interfaces.UserServicesRemote");

		System.out.println(userServicesRemote.deleteUserById(1L));

	}

}
