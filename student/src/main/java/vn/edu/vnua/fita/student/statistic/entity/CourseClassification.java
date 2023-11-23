package vn.edu.vnua.fita.student.statistic.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.edu.vnua.fita.student.course.entity.Course;
import vn.edu.vnua.fita.student.term.entity.Term;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses_terms")
public class CourseClassification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "term_id")
    private Term term;

    @Column(name = "excellent")
    private Integer excellent;

    @Column(name = "good")
    private Integer good;

    @Column(name = "fair")
    private Integer fair;

    @Column(name = "medium")
    private Integer medium;

    @Column(name = "weak")
    private Integer weak;

    @Column(name = "worst")
    private Integer worst;

    @Column(name = "xuatsac")
    private Integer xuatsac;

    @Column(name = "gioi")
    private Integer gioi;

    @Column(name = "kha")
    private Integer kha;

    @Column(name = "trungbinh")
    private Integer trungbinh;

    @Column(name = "yeu")
    private Integer yeu;

    @Column(name = "kem")
    private Integer kem;
}
