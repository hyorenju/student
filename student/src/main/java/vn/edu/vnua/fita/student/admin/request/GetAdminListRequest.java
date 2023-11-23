package vn.edu.vnua.fita.student.admin.request;

import lombok.Data;
import vn.edu.vnua.fita.student.request.GetPageBaseRequest;


@Data
public class GetAdminListRequest extends GetPageBaseRequest {
    private String id;
}
