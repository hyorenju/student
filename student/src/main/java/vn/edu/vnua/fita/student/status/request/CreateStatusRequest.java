package vn.edu.vnua.fita.student.status.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateStatusRequest {
    @NotBlank(message = "Tên trạng thái không được để trống")
    private String name;
}
