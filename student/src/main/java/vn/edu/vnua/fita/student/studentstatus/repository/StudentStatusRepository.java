package vn.edu.vnua.fita.student.studentstatus.repository;

import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.studentstatus.entity.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentStatusRepository extends JpaRepository<StudentStatus, Long>, JpaSpecificationExecutor<StudentStatus> {
    boolean existsByStudentIdAndStatusId(String studentId, Integer statusId);
    List<StudentStatus> findAllByTermIdAndStatusId(String termId, Integer statusId);
    List<StudentStatus> findAllByStudent(Student student);
    void deleteAllByStudent(Student student);
}
