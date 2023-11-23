package vn.edu.vnua.fita.student.permission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.permission.entity.Permission;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findAllByType(String type);
}
