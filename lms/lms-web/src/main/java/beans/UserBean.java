package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Student;
import entities.Teacher;
import entities.User;
import services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class UserBean {
	// models
	private Student student = new Student();
	private Teacher teacher = new Teacher();
	private User user = new User();

	private Boolean loggedInAsTeacher = false;

	// injection
	@EJB
	private UserServicesLocal userServicesLocal;

	// methodes
	public String doAddStudent() {
		userServicesLocal.addUser(student);
		return "/greetings?faces-redirect=true";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServicesLocal.login(user.getLogin(), user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Teacher) {
				navigateTo = "/pages/teacherHome/addCourse?faces-redirect=true";
				user = userLoggedIn;
				loggedInAsTeacher = true;
			} else if (userLoggedIn instanceof Student) {
				navigateTo = "/pages/studentHome/listCourses?faces-redirect=true";
				user = userLoggedIn;
			} else {
				navigateTo = "/pages/agentHome/homeAgent?faces-redirect=true";
				user = userLoggedIn;
			}
		} else {
			navigateTo = "/login.jsf";
		}
		return navigateTo;
	}

	public String doAddTeacher() {
		userServicesLocal.addUser(teacher);
		return "/greetings?faces-redirect=true";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedInAsTeacher() {
		return loggedInAsTeacher;
	}

	public void setLoggedInAsTeacher(Boolean loggedInAsTeacher) {
		this.loggedInAsTeacher = loggedInAsTeacher;
	}

}
