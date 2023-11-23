package vn.edu.vnua.fita.student.status.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.status.entity.Status;
import vn.edu.vnua.fita.student.status.request.CreateStatusRequest;
import vn.edu.vnua.fita.student.status.request.GetStatusListRequest;
import vn.edu.vnua.fita.student.status.request.UpdateStatusRequest;

import java.util.List;

public interface IStatusService {
    Page<Status> getStatusList(GetStatusListRequest request);
    List<Status> getAllStatus();
    Status createStatus(CreateStatusRequest request);
    Status updateStatus(Integer id, UpdateStatusRequest request);
    Status deleteStatus(Integer id);
}
