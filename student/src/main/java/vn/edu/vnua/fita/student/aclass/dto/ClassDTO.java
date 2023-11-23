package vn.edu.vnua.fita.student.aclass.dto;

import lombok.Data;
import vn.edu.vnua.fita.student.student.dto.MonitorDTO;

@Data
public class ClassDTO {
    private String id;
    private String name;
    private MonitorDTO monitor;
    private MonitorDTO viceMonitor;
    private MonitorDTO secretary;
    private MonitorDTO deputySecretary;
}
