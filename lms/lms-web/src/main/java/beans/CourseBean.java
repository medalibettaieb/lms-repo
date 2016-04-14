package beans;

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

	@EJB
	private CourseServicesLocal courseServicesLocal;
	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public String doAddCourse() {
		courseServicesLocal.addCourse(course, userBean.getUser());
		return "";
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

}
