package vn.edu.vnua.fita.student.statistic.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.course.dto.CourseDTO;
import vn.edu.vnua.fita.student.term.dto.TermDTO;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;

import java.util.List;

@Data
public class CourseChartDTO {
    private CourseDTO course;
    private TermDTO term;
    private List<CircleChart> chart;
}
