package vn.edu.vnua.fita.student.major.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vn.edu.vnua.fita.student.major.entity.Major;
import vn.edu.vnua.fita.student.major.repository.MajorRepository;
import vn.edu.vnua.fita.student.major.request.CreateMajorRequest;
import vn.edu.vnua.fita.student.major.request.GetMajorListRequest;
import vn.edu.vnua.fita.student.major.request.UpdateMajorRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MajorManager implements IMajorService {
    private final MajorRepository majorRepository;
    private final String majorHadExisted = "Mã chuyên ngành đã tồn tại trong hệ thống";
    private final String majorNotFound = "Mã chuyên ngành %s không tồn tại trong hệ thống";
    private final String cannotDelete = "Ngành này đang ràng buộc với bảng sinh viên, vui lòng xoá hết sinh viên thuộc ngành này trước khi tiến hành xoá ngành";

    @Override
    public Page<Major> getMajorList(GetMajorListRequest request) {
        return majorRepository.findAll(PageRequest.of(request.getPage() - 1, request.getSize(),
                Sort.by("id").ascending()));
    }

    @Override
    public List<Major> getAllMajor() {
        return majorRepository.findAll(Sort.by("id").ascending());
    }

    @Override
    public Major createMajor(CreateMajorRequest request) {
        if (majorRepository.existsById(request.getId())) {
            throw new RuntimeException(majorHadExisted);
        }
        Major major = Major.builder()
                .id(request.getId().toUpperCase())
                .name(request.getName())
                .totalCredits(request.getTotalCredits())
                .build();
        return majorRepository.saveAndFlush(major);
    }

    @Override
    public Major updateMajor(UpdateMajorRequest request) {
        Major major = majorRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException(String.format(majorNotFound, request.getId())));
        major.setName(request.getName());
        major.setTotalCredits(request.getTotalCredits());
        return majorRepository.saveAndFlush(major);
    }

    @Override
    public Major deleteMajor(String id) {
        try {
            Major major = majorRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format(majorNotFound, id)));
            majorRepository.deleteById(id);
            return major;
        } catch (
                DataIntegrityViolationException e) {
            throw new RuntimeException(cannotDelete);
        }
    }
}
