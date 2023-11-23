package vn.edu.vnua.fita.student.role.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import vn.edu.vnua.fita.student.admin.entity.Admin;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.permission.entity.Permission;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @Column(length = 100)
    private String id;

    @Column(length = 200)
    private String name;

    @OneToMany(mappedBy = "role")
    private Collection<Student> students;

    @OneToMany(mappedBy = "role")
    private Collection<Admin> admins;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "roles_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    private Collection<Permission> permissions;

}
