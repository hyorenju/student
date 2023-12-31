package vn.edu.vnua.fita.student.display.service;

import com.google.cloud.storage.Blob;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.fita.student.display.entity.Display;
import vn.edu.vnua.fita.student.display.repository.CustomDisplayRepository;
import vn.edu.vnua.fita.student.display.repository.DisplayRepository;
import vn.edu.vnua.fita.student.display.request.CreateDisplayRequest;
import vn.edu.vnua.fita.student.display.request.GetDisplayListRequest;
import vn.edu.vnua.fita.student.display.request.UpdateDisplayRequest;
import vn.edu.vnua.fita.student.service.file.FirebaseService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class DisplayManager implements IDisplayService {
    private final DisplayRepository displayRepository;
    private final FirebaseService firebaseService;

    @Value("${firebase.storage.bucket}")
    private String bucketName;

    @Override
    public Page<Display> getDisplayList(GetDisplayListRequest request) {
        Specification<Display> specification = CustomDisplayRepository.filterDisplayList(
                request.getLocation()
        );
        return displayRepository.findAll(specification, PageRequest.of(request.getPage() - 1, request.getSize()));
    }

    @Override
    public Display getDisplay(Long id) {
        return displayRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy hiển thị"));
    }

    @Override
    public Display createDisplay(CreateDisplayRequest request) {
        Display display = Display.builder()
                .img(request.getImg())
                .title(request.getTitle())
                .content(request.getContent())
                .location(request.getLocation())
                .build();

        return displayRepository.saveAndFlush(display);
    }

    @Override
    public Display updateDisplay(Long id, UpdateDisplayRequest request) {
        Display display = displayRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy dữ liệu"));

        display.setImg(request.getImg());
        display.setTitle(request.getTitle());
        display.setContent(request.getContent());

        return displayRepository.saveAndFlush(display);
    }

    @Override
    public String uploadImg(MultipartFile file) throws IOException {
        Blob blob = firebaseService.uploadImage(file, bucketName);

        return blob
                .signUrl(FirebaseExpirationTimeConstant.EXPIRATION_TIME, TimeUnit.MILLISECONDS)
                .toString();
    }
}
