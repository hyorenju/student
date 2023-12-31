package vn.edu.vnua.fita.student.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import vn.edu.vnua.fita.student.admin.dto.AdminDTO;
import vn.edu.vnua.fita.student.point.dto.PointDTO;

import java.sql.Timestamp;

@Data
public class TrashPointDTO {
    private String id;

    private PointDTO point;

    @JsonFormat(pattern = DateTimeConstant.DATE_TIME_FORMAT, timezone = DateTimeConstant.TIME_ZONE)
    private Timestamp time;

    private AdminDTO deletedBy;
}
