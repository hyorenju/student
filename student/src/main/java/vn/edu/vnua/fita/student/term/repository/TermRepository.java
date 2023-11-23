package vn.edu.vnua.fita.student.term.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.term.entity.Term;

@Repository
public interface TermRepository extends JpaRepository<Term, String>, JpaSpecificationExecutor<Term> {
    Term findFirstByOrderByIdDesc();
}
