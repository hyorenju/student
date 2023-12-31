package vn.edu.vnua.fita.student.course.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.fita.student.controller.BaseController;
import vn.edu.vnua.fita.student.course.dto.CourseDTO;
import vn.edu.vnua.fita.student.course.entity.Course;
import vn.edu.vnua.fita.student.course.request.CreateCourseRequest;
import vn.edu.vnua.fita.student.course.request.GetCourseListRequest;
import vn.edu.vnua.fita.student.course.service.CourseManager;

import java.util.List;

@RestController
@RequestMapping("admin/course")
@RequiredArgsConstructor
public class CourseController extends BaseController {
    private final CourseManager courseManager;
    private final ModelMapper modelMapper;

    @PostMapping("list")
    @PreAuthorize("hasAnyAuthority('SUPERADMIN')")
    public ResponseEntity<?> getCourseList(@Valid @RequestBody GetCourseListRequest request){
        Page<Course> page = courseManager.getCourseList(request);
        List<CourseDTO> response = page.getContent().stream().map(
                course -> modelMapper.map(course, CourseDTO.class)
        ).toList();
        return buildPageItemResponse(request.getPage(), response.size(), page.getTotalElements(), response);
    }

    @PostMapping("create")
    @PreAuthorize("hasAnyAuthority('SUPERADMIN')")
    public ResponseEntity<?> createCourse(@Valid @RequestBody CreateCourseRequest request){
        CourseDTO response = modelMapper.map(courseManager.createCourse(request), CourseDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("delete/{id}")
    @PreAuthorize("hasAnyAuthority('SUPERADMIN')")
    public ResponseEntity<?> deleteCourse(@PathVariable String id){
        CourseDTO response = modelMapper.map(courseManager.deleteCourse(id), CourseDTO.class);
        return buildItemResponse(response);
    }
}
