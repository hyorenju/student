package vn.edu.vnua.fita.student.display.request;

import lombok.Data;
import vn.edu.vnua.fita.student.request.GetPageBaseRequest;


@Data
public class GetDisplayListRequest extends GetPageBaseRequest {
    private String location;
}
