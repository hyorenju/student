package vn.edu.vnua.fita.student.statistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.statistic.entity.CourseClassification;

@Repository
public interface CourseClassificationRepository extends JpaRepository<CourseClassification, Long>, JpaSpecificationExecutor<CourseClassification> {
    CourseClassification findByTermId(String termId);
}
