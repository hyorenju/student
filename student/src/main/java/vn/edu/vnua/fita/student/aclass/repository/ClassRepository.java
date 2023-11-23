package vn.edu.vnua.fita.student.aclass.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.student.entity.Student;

@Repository
public interface ClassRepository extends JpaRepository<AClass, String>, JpaSpecificationExecutor<AClass> {
    AClass findByMonitor(Student student);
}
