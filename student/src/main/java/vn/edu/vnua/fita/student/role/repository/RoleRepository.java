package vn.edu.vnua.fita.student.role.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.role.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
