package vn.edu.vnua.fita.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.edu.vnua.fita.student.admin.dto.AdminDTO;

import java.sql.Timestamp;

@Data
public class TrashAdminDTO {
    private String id;

    private AdminDTO admin;

    @JsonFormat(pattern = DateTimeConstant.DATE_TIME_FORMAT, timezone = DateTimeConstant.TIME_ZONE)
    private Timestamp time;

    private AdminDTO deletedBy;
}
