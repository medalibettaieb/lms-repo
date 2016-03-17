package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Course;
import entities.User;

@Local
public interface CourseServicesLocal {
	Boolean addCourse(Course course);

	Boolean deleteCourseById(Long id);

	Boolean updateCourse(Course course);

	Course findCourseById(Long id);

	List<Course> findAllCourses();
}