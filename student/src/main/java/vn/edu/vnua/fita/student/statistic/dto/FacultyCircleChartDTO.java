package vn.edu.vnua.fita.student.statistic.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;
import vn.edu.vnua.fita.student.term.dto.TermDTO;

import java.util.List;

@Data
public class FacultyCircleChartDTO {
    private TermDTO term;
    private List<CircleChart> chart;
}
