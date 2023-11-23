package vn.edu.vnua.fita.student.point.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.student.dto.StudentDTO;
import vn.edu.vnua.fita.student.term.dto.TermDTO;

@Data
public class PointDTO {
    private Long id;
    private StudentDTO student;
    private TermDTO term;
    private Float avgPoint10;
    private Float avgPoint4;
    private Integer trainingPoint;
    private Integer creditsAcc;
    private Float pointAcc10;
    private Float pointAcc4;
    private Boolean isDeleted;
}
