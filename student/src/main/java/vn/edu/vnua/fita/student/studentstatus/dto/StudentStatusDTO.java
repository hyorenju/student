package vn.edu.vnua.fita.student.studentstatus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.edu.vnua.fita.student.student.dto.StudentDTO;
import vn.edu.vnua.fita.student.status.dto.StatusDTO;

import java.sql.Timestamp;

@Data
public class StudentStatusDTO {
    private Long id;

    private StudentDTO student;

    private StatusDTO status;

    @JsonFormat(pattern = DateTimeConstant.DATE_FORMAT, timezone = DateTimeConstant.TIME_ZONE)
    private Timestamp time;

    private String termId;

    private String note;
}
