package beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entities.Student;
import entities.Teacher;
import services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class UserBean {
	// models
	private Student student = new Student();
	private Teacher teacher = new Teacher();

	// injection
	@EJB
	private UserServicesLocal userServicesLocal;

	// methodes
	public String doAddStudent() {
		userServicesLocal.addUser(student);
		return "";
	}

	public String doAddTeacher() {
		userServicesLocal.addUser(teacher);
		return "";
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

}
