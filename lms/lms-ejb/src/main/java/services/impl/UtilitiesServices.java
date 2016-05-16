package services.impl;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.Agent;
import entities.Course;
import entities.Student;
import entities.Teacher;
import entities.Theme;
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
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UtilitiesServices() {
	}

	@PostConstruct
	public void initDb() {
		Student student = new Student("chelli", 26);
		student.setLogin("chelli");
		student.setPassword("chelli");

		Student student2 = new Student("moulouk", 26);
		student2.setLogin("moulouk");
		student2.setPassword("moulouk");

		Student student3 = new Student("fares", 26);
		student3.setLogin("fares");
		student3.setPassword("fares");

		Student student4 = new Student("insaf", 26);
		student4.setLogin("insaf");
		student4.setPassword("insaf");

		Course course = new Course("javaEE");
		Course course2 = new Course("classic dance");

		Teacher teacher = new Teacher("daly", "medium");
		teacher.setLogin("daly");
		teacher.setPassword("daly");

		Teacher teacher2 = new Teacher("salim", "pro");
		teacher2.setLogin("salim");
		teacher2.setPassword("salim");

		Agent agent = new Agent();
		agent.setName("yassine");
		agent.setLogin("yassine");
		agent.setPassword("yassine");

		Theme theme = new Theme("web development");
		Theme theme2 = new Theme("maths");

		userServicesLocal.addUser(student);
		userServicesLocal.addUser(student2);
		userServicesLocal.addUser(student3);
		userServicesLocal.addUser(student4);

		userServicesLocal.addUser(teacher);
		userServicesLocal.addUser(teacher2);

		userServicesLocal.addUser(agent);

		entityManager.persist(theme);
		entityManager.persist(theme2);
	}

}
