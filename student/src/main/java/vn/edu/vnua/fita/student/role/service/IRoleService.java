package vn.edu.vnua.fita.student.role.service;

import vn.edu.vnua.fita.student.model.authorization.PermissionChecker;
import vn.edu.vnua.fita.student.role.entity.Role;
import vn.edu.vnua.fita.student.role.request.UpdateRoleRequest;

import java.util.List;

public interface IRoleService {
    Role updateRole(String id, UpdateRoleRequest request);
    List<PermissionChecker> checkPermissions(String id);
}
