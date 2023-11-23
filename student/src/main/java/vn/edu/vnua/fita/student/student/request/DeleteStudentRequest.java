package vn.edu.vnua.fita.student.student.request;

import lombok.Data;

import java.util.List;

@Data
public class DeleteStudentRequest {
    private List<String> ids;
}
