package services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Course;
import entities.Inscription;
import entities.Student;
import entities.Teacher;
import entities.User;
import services.interfaces.CourseServicesLocal;
import services.interfaces.CourseServicesRemote;
import services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class CourseServices
 */
@Stateless
public class CourseServices implements CourseServicesRemote, CourseServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;
	@EJB
	private UserServicesLocal userServicesLocal;

	/**
	 * Default constructor.
	 */
	public CourseServices() {
	}

	@Override
	public Boolean addCourse(Course course, User user) {
		Boolean b = false;
		try {
			course.setTeacher(user);
			entityManager.persist(course);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean deleteCourseById(Long id) {
		Boolean b = false;
		try {
			entityManager.remove(findCourseById(id));
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean updateCourse(Course course) {
		Boolean b = false;
		try {
			entityManager.merge(course);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Course findCourseById(Long id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	public List<Course> findAllCourses() {
		String jpql = "select c from Course  c";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	@Override
	public Boolean registerStudentToCourse(Long idCourse, Long idStudent) {
		Boolean b = false;
		try {
			Course courseFound = findCourseById(idCourse);
			Student studentFound = (Student) userServicesLocal.findUserById(idStudent);

			Inscription inscription = new Inscription(studentFound, courseFound);
			entityManager.persist(inscription);

			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean assignTeacherToCourseMasterSide(Long idCourse, Long idTeacher) {
		Boolean b = false;
		try {
			Course courseFound = findCourseById(idCourse);
			Teacher teacherFound = (Teacher) userServicesLocal.findUserById(idTeacher);

			courseFound.setTeacher(teacherFound);

			updateCourse(courseFound);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean assignTeacherToCourseSlaveSide(Long idCourse, Long idTeacher) {
		Boolean b = false;
		try {
			Course courseFound = findCourseById(idCourse);
			Teacher teacherFound = (Teacher) userServicesLocal.findUserById(idTeacher);

			List<Course> oldTeachersCourses = teacherFound.getCourses();
			oldTeachersCourses.add(courseFound);
			// use of the spesific methode
			teacherFound.linkCoursesToThisTeacher(oldTeachersCourses);
			userServicesLocal.updateUser(teacherFound);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public List<Course> findAllCoursesByTeacherId(long idTeacher) {
		String jpql = "select c from Course c where c.teacher.id= :param";
		Query query = entityManager.createQuery(jpql, Course.class);
		query.setParameter("param", idTeacher);
		return query.getResultList();
	}

	@Override
	public List<Student> findStudentsByCourseId(Long courseId) {
		List<Student> students = new ArrayList<>();
		Course courseFound = findCourseById(courseId);
		List<Inscription> inscriptions = courseFound.getInscriptions();
		for (Inscription i : inscriptions) {
			students.add((Student) i.getUser());
		}
		return students;
	}

}
