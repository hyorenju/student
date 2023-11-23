package vn.edu.vnua.fita.student.student.repository;

import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.major.entity.Major;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.term.entity.Term;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>, JpaSpecificationExecutor<Student> {
    List<Student> findAllByAclass(AClass aclass);
    List<Student> findAllByCourse(Course course);
    List<Student> findAllByMajor(Major major);
    List<Student> findAllByTerms(Term term);
}
