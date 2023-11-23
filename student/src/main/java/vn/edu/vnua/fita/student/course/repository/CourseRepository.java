package vn.edu.vnua.fita.student.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.course.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String>, JpaSpecificationExecutor<Course> {
    Course findFirstByOrderByIdDesc();
}
