package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Inscription
 *
 */
@Entity

public class Inscription implements Serializable {
	@EmbeddedId
	private InscriptionId inscriptionId;
	private Float mark;
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idUser", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;
	@ManyToOne
	@JoinColumn(name = "idCourse", referencedColumnName = "id", insertable = false, updatable = false)
	private Course course;

	public Inscription() {
		super();
	}

	public Inscription(Float mark, User user, Course course) {
		this.inscriptionId = new InscriptionId(course.getId(), user.getId());
		this.mark = mark;
		this.user = user;
		this.course = course;
	}

	public Inscription(User user, Course course) {
		this.inscriptionId = new InscriptionId(course.getId(), user.getId());
		this.mark = null;
		this.user = user;
		this.course = course;
	}

	public Float getMark() {
		return this.mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	public InscriptionId getInscriptionId() {
		return inscriptionId;
	}

	public void setInscriptionId(InscriptionId inscriptionId) {
		this.inscriptionId = inscriptionId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
