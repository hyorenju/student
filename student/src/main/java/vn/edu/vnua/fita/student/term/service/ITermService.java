package vn.edu.vnua.fita.student.term.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.term.entity.Term;
import vn.edu.vnua.fita.student.term.request.CreateTermRequest;
import vn.edu.vnua.fita.student.term.request.GetTermListRequest;

import java.util.List;

public interface ITermService {
    Page<Term> getTermList(GetTermListRequest request);
    List<Term> getAllTerm();
    Term createTerm(CreateTermRequest request);
    Term deleteTerm(String id);
    void createTermPeriodic();
}
