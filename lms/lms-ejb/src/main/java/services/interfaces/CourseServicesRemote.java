package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.Course;

@Remote
public interface CourseServicesRemote {
	Boolean addCourse(Course course);

	Boolean deleteCourseById(Long id);

	Boolean updateCourse(Course course);

	Course findCourseById(Long id);

	List<Course> findAllCourses();

	Boolean registerStudentToCourse(Long idCourse, Long idStudent);

	Boolean assignTeacherToCourseMasterSide(Long idCourse, Long idTeacher);

	Boolean assignTeacherToCourseSlaveSide(Long idCourse, Long idTeacher);

	List<Course> findAllCoursesByTeacherId(long idTeacher);
}
