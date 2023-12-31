package vn.edu.vnua.fita.student.statistic.repository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.statistic.entity.FacultyClassification;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomFacultyClassificationRepository {
    public static Specification<FacultyClassification> filterFacultyClassificationList(String start,
                                                                                     String end) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (start != null && end != null) {
                predicates.add(criteriaBuilder.between(root.get("term").get("id"), start, end));
            }
            query.orderBy(criteriaBuilder.asc(root.get("term").get("id")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
