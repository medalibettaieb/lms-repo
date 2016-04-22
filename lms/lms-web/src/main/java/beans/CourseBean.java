package beans;

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
	private List<Course> courses;
	private List<Course> coursesByTeacher;
	@EJB
	private CourseServicesLocal courseServicesLocal;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public String doAddCourse() {
		courseServicesLocal.addCourse(course, userBean.getUser());
		return "/pages/courseManagement/listCoursesByTeacher?faces-redirect=true";
	}

	public String doRegisterStudentToCourse(Course course) {
		Long idCourse = course.getId();
		Long idStudent = userBean.getUser().getId();
		courseServicesLocal.registerStudentToCourse(idCourse, idStudent);
		return "/login?faces-redirect=true";
	}

	@PostConstruct
	public void init() {
		courses = courseServicesLocal.findAllCourses();
		long idTeacher = userBean.getUser().getId();
		coursesByTeacher = courseServicesLocal.findAllCoursesByTeacherId(idTeacher);
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

	public List<Course> getCoursesByTeacher() {
		return coursesByTeacher;
	}

	public void setCoursesByTeacher(List<Course> coursesByTeacher) {
		this.coursesByTeacher = coursesByTeacher;
	}

}
