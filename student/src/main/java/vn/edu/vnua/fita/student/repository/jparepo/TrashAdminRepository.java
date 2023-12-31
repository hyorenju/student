package vn.edu.vnua.fita.student.repository.jparepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.vnua.fita.student.admin.entity.Admin;

@Repository
public interface TrashAdminRepository extends JpaRepository<TrashAdmin, Long> {
    TrashAdmin findByAdmin(Admin admin);
}
