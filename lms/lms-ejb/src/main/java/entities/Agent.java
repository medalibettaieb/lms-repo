package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Agent
 *
 */
@Entity

public class Agent extends User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Agent() {
		super();
	}
   
}
