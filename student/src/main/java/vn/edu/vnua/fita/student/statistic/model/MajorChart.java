package vn.edu.vnua.fita.student.statistic.model;

import lombok.Data;
import vn.edu.vnua.fita.student.major.entity.Major;
import vn.edu.vnua.fita.student.term.entity.Term;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;

import java.util.List;

@Data
public class MajorChart {
    private Major major;
    private Term term;
    private List<CircleChart> chart;
}
