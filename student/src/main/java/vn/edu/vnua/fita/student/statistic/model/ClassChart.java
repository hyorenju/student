package vn.edu.vnua.fita.student.statistic.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.term.entity.Term;
import vn.edu.vnua.fita.student.model.statistic.chartform.CircleChart;

import java.util.List;

@Data
@NoArgsConstructor
public class ClassChart {
    private AClass aclass;
    private Term term;
    private List<CircleChart> chart;
}
