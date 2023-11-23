package vn.edu.vnua.fita.student.admin.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.role.dto.RoleDTO;

@Data
public class AdminDTO {
    private String id;
    private String name;
    private String email;
    private RoleDTO role;
    private String avatar;
    private Boolean isDeleted;
}
