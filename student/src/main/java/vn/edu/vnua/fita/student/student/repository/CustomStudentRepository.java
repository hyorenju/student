package vn.edu.vnua.fita.student.student.repository;

import vn.edu.vnua.fita.student.student.entity.Student;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomStudentRepository {
    public static Specification<Student> filterStudentList(String courseId,
                                                           String majorId,
                                                           String classId,
                                                           String studentId,
                                                           String familySituation) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(courseId)) {
                predicates.add(criteriaBuilder.like(root.get("course").get("id"), courseId));
            }
            if (StringUtils.hasText(majorId)) {
                predicates.add(criteriaBuilder.like(root.get("major").get("id"), majorId));
            }
            if (StringUtils.hasText(classId)) {
                predicates.add(criteriaBuilder.like(root.get("aclass").get("id"), classId));
            }
            if (StringUtils.hasText(studentId)) {
                predicates.add(criteriaBuilder.like(root.get("id"), studentId + "%"));
            }
            if (StringUtils.hasText(familySituation)) {
                predicates.add(criteriaBuilder.like(root.get("familySituation"), familySituation));
            }
            query.orderBy(
                    criteriaBuilder.asc(root.get("course").get("id")),
                    criteriaBuilder.asc(root.get("major").get("id")),
                    criteriaBuilder.asc(root.get("aclass").get("id")),
                    criteriaBuilder.asc(root.get("lastName")),
                    criteriaBuilder.asc(root.get("surname"))
            );
            predicates.add(criteriaBuilder.isFalse(root.get("isDeleted")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
