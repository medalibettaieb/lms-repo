package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.Course;
import entities.Student;
import entities.Theme;
import entities.User;

@Local
public interface CourseServicesLocal {
	Boolean addCourse(Course course, User user);

	Boolean deleteCourseById(Long id);

	Boolean updateCourse(Course course);

	Course findCourseById(Long id);

	List<Course> findAllCourses();

	Boolean registerStudentToCourse(Long idCourse, Long idStudent);

	Boolean assignTeacherToCourseMasterSide(Long idCourse, Long idTeacher);

	Boolean assignTeacherToCourseSlaveSide(Long idCourse, Long idTeacher);

	List<Course> findAllCoursesByTeacherId(long idTeacher);

	List<Student> findStudentsByCourseId(Long courseId);

	Course findCourseByName(String value);

	Theme findThemeByName(String name);

	List<Theme> findAllThemes();
}
