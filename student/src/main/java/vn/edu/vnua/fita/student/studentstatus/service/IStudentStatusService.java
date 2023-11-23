package vn.edu.vnua.fita.student.studentstatus.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.studentstatus.entity.StudentStatus;
import vn.edu.vnua.fita.student.studentstatus.request.CreateStudentStatusRequest;
import vn.edu.vnua.fita.student.studentstatus.request.GetStudentStatusListRequest;
import vn.edu.vnua.fita.student.studentstatus.request.UpdateStudentStatusRequest;

import java.text.ParseException;

public interface IStudentStatusService {
    Page<StudentStatus> getStudentStatusList(GetStudentStatusListRequest request);
    StudentStatus createStudentStatus(CreateStudentStatusRequest request) throws ParseException;
    StudentStatus updateStudentStatus(UpdateStudentStatusRequest request, Long id) throws ParseException;
    StudentStatus deleteStudentStatus(Long id);
}
