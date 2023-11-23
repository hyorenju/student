package vn.edu.vnua.fita.student.major.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.major.entity.Major;

@Repository
public interface MajorRepository extends JpaRepository<Major, String> {
}
