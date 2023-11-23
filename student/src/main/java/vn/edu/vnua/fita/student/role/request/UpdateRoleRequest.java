package vn.edu.vnua.fita.student.role.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateRoleRequest {
    private List<String> permissionIds;
}