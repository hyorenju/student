package vn.edu.vnua.fita.student.student.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateStudentProfileRequest {
    @Size(max = 200,message = "Nơi ở hiện tại không được quá dài")
    private String residence;

    @Size(max = 200,message = "Tên bố không được quá dài")
    private String fatherName;

    private String fatherPhoneNumber;

    @Size(max = 200, message = "Tên mẹ không được quá dài")
    private String motherName;

    private String motherPhoneNumber;
}
