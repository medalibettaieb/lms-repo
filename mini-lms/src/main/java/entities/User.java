package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User implements Serializable {

	@Id
	private Long id;
	private String name;
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "teacher")
	private List<Course> courses;
	@ManyToMany
	@Column(name = "course_fk")
	private List<Course> takenCourses;

	public User() {
		super();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public List<Course> getTakenCourses() {
		return takenCourses;
	}

	public void setTakenCourses(List<Course> takenCourses) {
		this.takenCourses = takenCourses;
	}

}
