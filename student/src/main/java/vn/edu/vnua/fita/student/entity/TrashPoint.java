package vn.edu.vnua.fita.student.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import vn.edu.vnua.fita.student.admin.entity.Admin;
import vn.edu.vnua.fita.student.point.entity.Point;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "trash_points")
public class TrashPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "point_id")
    private Point point;

    @Column
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "deleted_by")
    private Admin deletedBy;
}
