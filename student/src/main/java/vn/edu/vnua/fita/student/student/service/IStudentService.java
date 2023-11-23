package vn.edu.vnua.fita.student.student.service;

import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.fita.student.entity.TrashStudent;
import vn.edu.vnua.fita.student.student.entity.Student;
import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.student.request.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IStudentService {
    Page<Student> getStudentList(GetStudentListRequest request);
    Student getStudentById(String id);
    Student createStudent(CreateStudentRequest request) throws ParseException;
    Student updateStudent(UpdateStudentRequest request) throws ParseException;
    TrashStudent deleteStudent(String id);
    List<TrashStudent> deleteManyStudent(DeleteStudentRequest request);
    TrashStudent deletePermanent(Long id);
    TrashStudent restoreStudent(Long id);
    List<TrashStudent> restoreManyStudent(RestoreStudentRequest request);
    Page<TrashStudent> getTrashStudentList(GetTrashStudentRequest request);
    void importFromExcel(MultipartFile file) throws IOException, ExecutionException, InterruptedException;
    String exportToExcel(ExportStudentListRequest request) throws IOException;
}
