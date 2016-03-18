package testsCourseServices;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import services.interfaces.CourseServicesRemote;

public class TestAssignTeacherToCourseSlaveSide {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseServicesRemote courseServicesRemote = (CourseServicesRemote) context
				.lookup("/mini-lms/CourseServices!services.interfaces.CourseServicesRemote");

		System.out.println(courseServicesRemote.assignTeacherToCourseSlaveSide(1L, 5L));
	}

}
