package vn.edu.vnua.fita.student.major.service;

import org.springframework.data.domain.Page;
import vn.edu.vnua.fita.student.major.entity.Major;
import vn.edu.vnua.fita.student.major.request.CreateMajorRequest;
import vn.edu.vnua.fita.student.major.request.GetMajorListRequest;
import vn.edu.vnua.fita.student.major.request.UpdateMajorRequest;

import java.util.List;

public interface IMajorService {
    Page<Major> getMajorList(GetMajorListRequest request);

    List<Major> getAllMajor();

    Major createMajor(CreateMajorRequest request);

    Major updateMajor(UpdateMajorRequest request);

    Major deleteMajor(String id);
}
