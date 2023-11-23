package vn.edu.vnua.fita.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.vnua.fita.student.display.entity.Display;
import vn.edu.vnua.fita.student.display.repository.DisplayRepository;
import vn.edu.vnua.fita.student.service.iservice.DisplayService;

@Service
@RequiredArgsConstructor
public class DisplayServiceImpl implements DisplayService {
    private final DisplayRepository displayRepository;
    private final String displayNotFound = "Không tìm thấy hiển thị này";

    @Override
    public Display getDisplayById(Long id) {
        return displayRepository.findById(id).orElseThrow(() -> new RuntimeException(displayNotFound));
    }
}
