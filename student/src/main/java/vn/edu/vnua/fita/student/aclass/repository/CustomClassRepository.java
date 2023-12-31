package vn.edu.vnua.fita.student.aclass.repository;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import vn.edu.vnua.fita.student.aclass.entity.AClass;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomClassRepository {
    public static Specification<AClass> filterClassList(String classId) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasText(classId)) {
                if (classId.contains("K\\d")) {
                    predicates.add(criteriaBuilder.like(root.get("id"), classId + "%"));
                } else {
                    predicates.add(criteriaBuilder.like(root.get("id"), "%" + classId + "%"));
                }
            }
            query.orderBy(criteriaBuilder.desc(root.get("id")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
