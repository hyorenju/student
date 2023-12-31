package vn.edu.vnua.fita.student.term.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTermRequest {
    @NotBlank(message = "Mã học kỳ không được để trống")
    @Pattern(regexp = "^\\d{4}[1-2]$", message = "Mã học kỳ phải có dạng 'năm + học kỳ' Ví dụ 'Học kỳ 1 năm 2020' được viết dưới dạng: 20201")
    @Size(min = 5, max = 5, message = "Mã học kỳ không đúng định dạng")
    private String id;
}
