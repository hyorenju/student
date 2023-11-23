package vn.edu.vnua.fita.student.statistic.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.major.dto.MajorDTO;
import vn.edu.vnua.fita.student.term.dto.TermDTO;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;

import java.util.List;

@Data
public class MajorChartDTO {
    private MajorDTO major;
    private TermDTO term;
    private List<CircleChart> chart;
}
