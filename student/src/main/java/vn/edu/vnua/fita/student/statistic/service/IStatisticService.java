package vn.edu.vnua.fita.student.statistic.service;

import vn.edu.vnua.fita.student.statistic.model.CourseChart;
import vn.edu.vnua.fita.student.statistic.model.MajorChart;
import vn.edu.vnua.fita.student.model.statistic.*;
import vn.edu.vnua.fita.student.statistic.model.ClassChart;
import vn.edu.vnua.fita.student.statistic.request.GetStatisticRequest;
import vn.edu.vnua.fita.student.student.model.StudentStatistic;

import java.util.List;

public interface IStatisticService {
    void createClassClassificationPeriodic();
    void createCourseClassificationPeriodic();
    void createMajorClassificationPeriodic();
    void createFacultyClassificationPeriodic();
    StudentStatistic getStudentStatistic(String id);
    List<ClassChart> getClassClassification(String classId, GetStatisticRequest request);
    List<CourseChart> getCourseClassification(String courseId, GetStatisticRequest request);
    List<MajorChart> getMajorClassification(String majorId, GetStatisticRequest request);
    FacultyColumnChart getFacultyColumnChart(GetStatisticRequest request);
    List<FacultyCircleChart> getFacultyCircleChart(GetStatisticRequest request);
}
