package services.impl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Course;
import entities.Student;
import entities.Teacher;
import services.interfaces.CourseServicesLocal;
import services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class UtilitiesServices
 */
@Singleton
@LocalBean
@Startup
public class UtilitiesServices {
	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private CourseServicesLocal courseServicesLocal;

	/**
	 * Default constructor.
	 */
	public UtilitiesServices() {
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student("chelli", 26);
		Student student2 = new Student("moulouk", 26);
		Student student3 = new Student("fares", 26);
		Student student4 = new Student("insaf", 26);

		Course course = new Course("javaEE");
		Course course2 = new Course("classic dance");

		Teacher teacher = new Teacher("daly", "medium");
		Teacher teacher2 = new Teacher("salim", "pro");

		userServicesLocal.addUser(student);
		userServicesLocal.addUser(student2);
		userServicesLocal.addUser(student3);
		userServicesLocal.addUser(student4);

		userServicesLocal.addUser(teacher);
		userServicesLocal.addUser(teacher2);

		courseServicesLocal.addCourse(course);
		courseServicesLocal.addCourse(course2);

	}

}
