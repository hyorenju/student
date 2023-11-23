package vn.edu.vnua.fita.student.aclass.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.aclass.request.CreateClassRequest;
import vn.edu.vnua.fita.student.aclass.request.GetClassListRequest;
import vn.edu.vnua.fita.student.aclass.request.UpdateClassRequest;

import java.util.List;

public interface IClassService {
    Page<AClass> getClassList(GetClassListRequest request);
    List<AClass> getAllClass();
    AClass createClass(CreateClassRequest request);
    AClass updateClass(UpdateClassRequest request);
    AClass deleteClass(String id);
}
