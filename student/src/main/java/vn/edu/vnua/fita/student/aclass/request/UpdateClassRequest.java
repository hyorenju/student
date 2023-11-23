package vn.edu.vnua.fita.student.aclass.request;

import lombok.Data;
import jakarta.validation.constraints.*;


@Data
public class UpdateClassRequest {
    private String id;

    @NotBlank(message = "Tên lớp không được để trống")
    private String name;

    private String monitorId;

    private String viceMonitorId;

    private String secretaryId;

    private String deputySecretaryId;

//    @Data
//    public class MonitorRequest{
//        private String id;
//    }
}
