package vn.edu.vnua.fita.student.student.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.edu.vnua.fita.student.controller.BaseController;
import vn.edu.vnua.fita.student.student.dto.StudentDTO;
import vn.edu.vnua.fita.student.studentstatus.dto.StudentStatusDTO;
import vn.edu.vnua.fita.student.student.model.StudentStatistic;
import vn.edu.vnua.fita.student.request.ChangePasswordRequest;
import vn.edu.vnua.fita.student.student.request.UpdateEmailRequest;
import vn.edu.vnua.fita.student.student.request.UpdateStudentProfileRequest;
import vn.edu.vnua.fita.student.student.service.StudentServiceImpl;

import java.io.IOException;
import java.util.List;

@RequestMapping("student")
@RequiredArgsConstructor
@RestController
public class StudentUserController extends BaseController {
    private final StudentServiceImpl studentService;
    private final ModelMapper modelMapper;

    @PostMapping("profile")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> getMyProfile() {
        StudentDTO response = modelMapper.map(studentService.getProfile(), StudentDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("avatar")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> updateMyAvatar(@RequestBody MultipartFile file) throws IOException {
        StudentDTO response = modelMapper.map(studentService.updateAvatar(file), StudentDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("update")
    @PreAuthorize("hasAnyAuthority('UPDATE_STUDENT_PROFILE')")
    public ResponseEntity<?> updateMyProfile(@Valid @RequestBody UpdateStudentProfileRequest request) {
        StudentDTO response = modelMapper.map(studentService.updateProfile(request), StudentDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("change-password")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest request){
        StudentDTO response = modelMapper.map(studentService.changePassword(request), StudentDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("statistic")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> getStudentStatistic(){
        StudentStatistic response = studentService.getStatistic();
        return buildItemResponse(response);
    }

    @PostMapping("status")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> getStudentStatusList(){
        List<StudentStatusDTO> response = studentService.getStatus().stream().map(
                studentStatus -> modelMapper.map(studentStatus, StudentStatusDTO.class)
        ).toList();
        return buildListItemResponse(response, response.size());
    }

    @PostMapping("email")
    @PreAuthorize("hasAnyAuthority('STUDENT', 'MONITOR')")
    public ResponseEntity<?> updateEmail(@Valid @RequestBody UpdateEmailRequest request){
        StudentDTO response = modelMapper.map(studentService.updateEmail(request), StudentDTO.class);
        return buildItemResponse(response);
    }
}