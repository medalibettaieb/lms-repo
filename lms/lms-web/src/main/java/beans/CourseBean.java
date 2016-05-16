package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import entities.Course;
import entities.Theme;
import services.interfaces.CourseServicesLocal;

@ManagedBean
@ViewScoped
public class CourseBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Course course = new Course();
	private List<Course> courses = new ArrayList<>();
	private List<Course> coursesByTeacher;
	private Course courseSelected = new Course();
	private List<Theme> themes = new ArrayList<>();
	private Theme themeSelected = new Theme();
	@EJB
	private CourseServicesLocal courseServicesLocal;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public String doAddCourse() {
		course.setTheme(themeSelected);
		courseServicesLocal.addCourse(course, userBean.getUser());
		return "/pages/courseManagement/listCoursesByTeacher?faces-redirect=true";
	}

	public String doRegisterStudentToCourse(Course course) {
		Long idCourse = course.getId();
		Long idStudent = userBean.getUser().getId();
		courseServicesLocal.registerStudentToCourse(idCourse, idStudent);
		return "/login?faces-redirect=true";
	}

	public Theme doFindThemeByName(String value) {
		return courseServicesLocal.findThemeByName(value);
	}

	@PostConstruct
	public void init() {
		themes = courseServicesLocal.findAllThemes();
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

	public Course doFindCourseByName(String value) {
		return courseServicesLocal.findCourseByName(value);
	}

	public Course getCourseSelected() {
		return courseSelected;
	}

	public void setCourseSelected(Course courseSelected) {
		this.courseSelected = courseSelected;
	}

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Theme getThemeSelected() {
		return themeSelected;
	}

	public void setThemeSelected(Theme themeSelected) {
		this.themeSelected = themeSelected;
	}

}
