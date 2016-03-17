package testsCourseServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CourseServicesRemote;

public class TestRegisterStudentToCourse {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseServicesRemote courseServicesRemote = (CourseServicesRemote) context
				.lookup("/mini-lms/CourseServices!services.interfaces.CourseServicesRemote");

		System.out.println(courseServicesRemote.registerStudentToCourse(1L, 1L));
		System.out.println(courseServicesRemote.registerStudentToCourse(1L, 2L));
		System.out.println(courseServicesRemote.registerStudentToCourse(2L, 3L));
		System.out.println(courseServicesRemote.registerStudentToCourse(2L, 4L));
	}

}
