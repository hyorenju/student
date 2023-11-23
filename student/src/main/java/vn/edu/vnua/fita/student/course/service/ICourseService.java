package vn.edu.vnua.fita.student.course.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.course.entity.Course;
import vn.edu.vnua.fita.student.course.request.CreateCourseRequest;
import vn.edu.vnua.fita.student.course.request.GetCourseListRequest;

public interface ICourseService {
    Page<Course> getCourseList(GetCourseListRequest request);
    Course createCourse(CreateCourseRequest request);
    Course deleteCourse(String id);
    void createCoursePeriodic();
}
