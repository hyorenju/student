package vn.edu.vnua.fita.student.course.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.term.entity.Term;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(length = 100)
    private String id;

    @Column(length = 200)
    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Collection<Student> students;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "courses_terms",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "term_id")
    )
    private Collection<Term> terms;

}
