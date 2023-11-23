package vn.edu.vnua.fita.student.display.service;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.fita.student.display.entity.Display;
import vn.edu.vnua.fita.student.display.request.CreateDisplayRequest;
import vn.edu.vnua.fita.student.display.request.GetDisplayListRequest;
import vn.edu.vnua.fita.student.display.request.UpdateDisplayRequest;

import java.io.IOException;

public interface IDisplayService {
    Page<Display> getDisplayList(GetDisplayListRequest request);
    Display getDisplay(Long id);
    Display createDisplay(CreateDisplayRequest request);
    Display updateDisplay(Long id, UpdateDisplayRequest request);
    String uploadImg(MultipartFile file) throws IOException;
}
