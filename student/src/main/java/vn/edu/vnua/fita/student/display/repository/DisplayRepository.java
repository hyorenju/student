package vn.edu.vnua.fita.student.display.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.display.entity.Display;

@Repository
public interface DisplayRepository extends JpaRepository<Display, Long>, JpaSpecificationExecutor<Display> {
}
