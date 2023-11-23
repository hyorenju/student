package vn.edu.vnua.fita.student.status.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.status.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
