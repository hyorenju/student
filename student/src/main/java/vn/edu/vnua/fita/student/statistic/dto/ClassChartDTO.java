package vn.edu.vnua.fita.student.statistic.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.aclass.dto.ClassDTO;
import vn.edu.vnua.fita.student.term.dto.TermDTO;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;

import java.util.List;

@Data
public class ClassChartDTO {
    private ClassDTO aclass;
    private TermDTO term;
    private List<CircleChart> chart;
}
