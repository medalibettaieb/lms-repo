package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Course;
import services.interfaces.CourseServicesLocal;

@ManagedBean
@ViewScoped
public class CourseBean {
	private Course course = new Course();
	private List<Course> courses = new ArrayList<Course>();
	@EJB
	private CourseServicesLocal courseServicesLocal;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public String doAddCourse() {
		courseServicesLocal.addCourse(course, userBean.getUser());
		return "";
	}
	public String doRegisterStudentToCourse(Course course) {
		Long idCourse=course.getId();
		Long idStudent=userBean.getUser().getId();
		courseServicesLocal.registerStudentToCourse(idCourse, idStudent);
		return "";
	}

	@PostConstruct
	public void loadAllCourses() {
		courses = courseServicesLocal.findAllCourses();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
