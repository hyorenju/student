package vn.edu.vnua.fita.student.term.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.course.entity.Course;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.major.entity.Major;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "terms")
public class Term {
    @Id
    @Column(name = "id", length = 100)
    private String id;

    @Column(name = "name", length = 200)
    private String name;

    @ManyToMany(mappedBy = "terms")
    private Collection<Student> students;

    @ManyToMany(mappedBy = "terms")
    private Collection<AClass> classes;

    @ManyToMany(mappedBy = "terms")
    private Collection<Course> courses;

    @ManyToMany(mappedBy = "terms")
    private Collection<Major> majors;
}
