package vn.edu.vnua.fita.student.term.request;

import lombok.Data;
import vn.edu.vnua.fita.student.request.GetPageBaseRequest;

@Data
public class GetTermListRequest extends GetPageBaseRequest {
    private String id;
}
