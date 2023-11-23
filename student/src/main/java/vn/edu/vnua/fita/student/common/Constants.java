package vn.edu.vnua.fita.student.common;

public interface Constants {
    interface DateTime {
        String DATE_FORMAT = "dd/MM/yyyy";
        String MONTH_YEAR_FORMAT = "MM/yyyy";
        String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
        String TIME_ZONE = "Asia/Ho_Chi_Minh";
    }

    interface FilePath {
        String STUDENT_FILE = "upload/danh-sach-sinh-vien.xlsx";
        String ERROR_STUDENT_FILE = "upload/loi-nhap-lieu-dssv.xlsx";
        String POINT_FILE = "upload/danh-sach-diem.xlsx";
        String ERROR_POINT_FILE = "upload/loi-nhap-lieu-ds-diem.xlsx";
    }

    interface RoleIdentify{
        String STUDENT = "STUDENT";
        String MONITOR = "MONITOR";
        String SUPERADMIN = "SUPERADMIN";
        String ADMIN = "ADMIN";
        String MOD = "MOD";
    }

    interface PermissionType {
        String STUDENT_MANAGEMENT = "Nhóm quyền quản lý sinh viên";
        String POINT_MANAGEMENT = "Nhóm quyền quản lý điểm";
        String STATUS_MANAGEMENT = "Nhóm quyền quản lý trạng thái";
        String STUDENT_SERVICE = "Nhóm quyền của sinh viên";
        String OTHER = "Nhóm quyền khác";
    }

    interface SortType{
        String ASC = "ascend";
        String DESC = "descend";
    }

    interface ThreadNumber{
        int MAX_THREADS = 3;
    }

    interface UserIdentifyPattern{
        String STUDENT_ID_PATTERN = "^[0-9]+$";
        String ADMIN_ID_PATTERN = "^[a-zA-Z][a-zA-Z0-9]*$";
    }

    interface StudentManager {
        String STUDENT_NOT_FOUND = "Không tìm thấy sinh viên %s";
    }

    interface ClassManager{
        String CLASS_HAS_EXISTED = "Mã lớp đã tồn tại trong hệ thống";
        String CLASS_NOT_FOUND = "Mã lớp %s không tồn tại trong hệ thống";
        String CANNOT_DELETE = "Lớp này đang ràng buộc với bảng sinh viên, vui lòng xoá hết sinh viên thuộc lớp này trước khi tiến hành xoá lớp";
        String DUPLICATE_MONITOR = "Bị trùng ban cán sự, vui lòng chọn lại";
    }

}
