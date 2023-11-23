package vn.edu.vnua.fita.student.student.service;

import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.studentstatus.entity.StudentStatus;
import vn.edu.vnua.fita.student.student.model.StudentStatistic;
import vn.edu.vnua.fita.student.request.ChangePasswordRequest;
import vn.edu.vnua.fita.student.student.request.UpdateEmailRequest;
import vn.edu.vnua.fita.student.student.request.UpdateStudentProfileRequest;

import java.io.IOException;
import java.util.List;

public interface StudentService {
    Student getProfile();
    Student updateAvatar(MultipartFile file) throws IOException;
    Student updateProfile(UpdateStudentProfileRequest request);
    Student changePassword(ChangePasswordRequest request);
    StudentStatistic getStatistic();
    List<StudentStatus> getStatus();
    Student updateEmail(UpdateEmailRequest request);
}
