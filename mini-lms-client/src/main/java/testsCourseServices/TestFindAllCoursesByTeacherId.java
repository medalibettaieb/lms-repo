package testsCourseServices;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import entities.Course;
import services.interfaces.CourseServicesRemote;

public class TestFindAllCoursesByTeacherId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CourseServicesRemote courseServicesRemote = (CourseServicesRemote) context
				.lookup("/mini-lms/CourseServices!services.interfaces.CourseServicesRemote");

		List<Course> courses = courseServicesRemote.findAllCoursesByTeacherId(5L);
		for (Course c : courses) {
			System.out.println(c.getName());
		}

	}

}
