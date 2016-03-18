package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Teacher
 *
 */
@Entity

public class Teacher extends User implements Serializable {

	private String level;
	private static final long serialVersionUID = 1L;

	public Teacher() {
		super();
	}

	public Teacher(String name, String level) {
		setName(name);
		setLevel(level);
	}

	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public void linkCoursesToThisTeacher(List<Course> courses) {
		this.setCourses(courses);
		for (Course c : courses) {
			c.setTeacher(this);
		}
	}
}
