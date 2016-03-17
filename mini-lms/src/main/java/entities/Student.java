package entities;

import entities.User;
import java.io.Serializable;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity

public class Student extends User implements Serializable {

	
	private Integer age;
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}   
	
	public Student(String name,Integer age) {
		setName(name);
		this.age = age;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
   
}
