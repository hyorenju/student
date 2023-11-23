package vn.edu.vnua.fita.student.point.request;

import lombok.Data;

import java.util.List;

@Data
public class DeletePointRequest {
    private List<Long> ids;
}
