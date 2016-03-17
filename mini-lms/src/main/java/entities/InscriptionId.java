package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InscriptionId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long idCourse;
	private Long idUser;

	public InscriptionId() {
	}

	public InscriptionId(Long idCourse, Long idUser) {
		super();
		this.idCourse = idCourse;
		this.idUser = idUser;
	}

	public Long getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Long idCourse) {
		this.idCourse = idCourse;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCourse == null) ? 0 : idCourse.hashCode());
		result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscriptionId other = (InscriptionId) obj;
		if (idCourse == null) {
			if (other.idCourse != null)
				return false;
		} else if (!idCourse.equals(other.idCourse))
			return false;
		if (idUser == null) {
			if (other.idUser != null)
				return false;
		} else if (!idUser.equals(other.idUser))
			return false;
		return true;
	}

}
