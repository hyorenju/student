package vn.edu.vnua.fita.student.statistic.controler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.edu.vnua.fita.student.statistic.dto.*;
import vn.edu.vnua.fita.student.controller.BaseController;
import vn.edu.vnua.fita.student.student.model.StudentStatistic;
import vn.edu.vnua.fita.student.statistic.request.GetStatisticRequest;
import vn.edu.vnua.fita.student.statistic.service.StatisticService;

import java.util.List;

@RestController
@RequestMapping("admin/statistic")
@RequiredArgsConstructor
public class StatisticController extends BaseController {
    private final StatisticService statisticService;
    private final ModelMapper modelMapper;

    @PostMapping("student/{id}")
    @PreAuthorize("hasAnyAuthority('GET_STUDENT_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getStudentStatistic(@PathVariable String id){
        StudentStatistic response = statisticService.getStudentStatistic(id);
        return buildItemResponse(response);
    }

    @PostMapping("class/{id}")
    @PreAuthorize("hasAnyAuthority('GET_CLASS_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getClassStatistic(@PathVariable String id, @Valid @RequestBody GetStatisticRequest request){
        List<ClassChartDTO> response = statisticService.getClassClassification(id, request).stream().map(
                classClassification -> modelMapper.map(classClassification, ClassChartDTO.class)
        ).toList();
        return buildListItemResponse(response, response.size());
    }

    @PostMapping("course/{id}")
    @PreAuthorize("hasAnyAuthority('GET_COURSE_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getCourseStatistic(@PathVariable String id, @Valid @RequestBody GetStatisticRequest request){
        List<CourseChartDTO> response = statisticService.getCourseClassification(id, request).stream().map(
                courseClassification -> modelMapper.map(courseClassification, CourseChartDTO.class)
        ).toList();
        return buildListItemResponse(response, response.size());
    }

    @PostMapping("major/{id}")
    @PreAuthorize("hasAnyAuthority('GET_MAJOR_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getMajorStatistic(@PathVariable String id, @Valid @RequestBody GetStatisticRequest request){
        List<MajorChartDTO> response = statisticService.getMajorClassification(id, request).stream().map(
                majorClassification -> modelMapper.map(majorClassification, MajorChartDTO.class)
        ).toList();
        return buildListItemResponse(response, response.size());
    }

    @PostMapping("faculty/column")
    @PreAuthorize("hasAnyAuthority('GET_FACULTY_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getFacultyColumnChart(@Valid @RequestBody GetStatisticRequest request){
        FacultyColumnChartDTO response = modelMapper.map(statisticService.getFacultyColumnChart(request), FacultyColumnChartDTO.class);
        return buildItemResponse(response);
    }

    @PostMapping("faculty/circle")
    @PreAuthorize("hasAnyAuthority('GET_FACULTY_STATISTIC', 'SUPERADMIN')")
    public ResponseEntity<?> getFacultyCircleChart(@Valid @RequestBody GetStatisticRequest request){
        List<FacultyCircleChartDTO> response = statisticService.getFacultyCircleChart(request).stream().map(
                facultyClassification -> modelMapper.map(facultyClassification, FacultyCircleChartDTO.class)
        ).toList();
        return buildListItemResponse(response, response.size());
    }

    
    
    
    
    // Dưới đây là API periodic creating, đề nghị front-end dev không sử dụng dưới mọi hình thức
    @PostMapping("class-classification")
    public ResponseEntity<?> createClassClassification(){
        statisticService.createClassClassificationPeriodic();
        return buildItemResponse("Tạo thành công");
    }
    @PostMapping("course-classification")
    public ResponseEntity<?> createCourseClassification(){
        statisticService.createCourseClassificationPeriodic();
        return buildItemResponse("Tạo thành công");
    }
    @PostMapping("major-classification")
    public ResponseEntity<?> createMajorClassification(){
        statisticService.createMajorClassificationPeriodic();
        return buildItemResponse("Tạo thành công");
    }
    @PostMapping("faculty-classification")
    public ResponseEntity<?> createFacultyClassification(){
        statisticService.createFacultyClassificationPeriodic();
        return buildItemResponse("Tạo thành công");
    }
}
