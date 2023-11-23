package vn.edu.vnua.fita.student.aclass.service;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.edu.vnua.fita.student.aclass.entity.AClass;
import vn.edu.vnua.fita.student.common.Constants;
import vn.edu.vnua.fita.student.role.entity.Role;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.aclass.repository.CustomClassRepository;
import vn.edu.vnua.fita.student.aclass.repository.ClassRepository;
import vn.edu.vnua.fita.student.student.repository.StudentRepository;
import vn.edu.vnua.fita.student.aclass.request.CreateClassRequest;
import vn.edu.vnua.fita.student.aclass.request.GetClassListRequest;
import vn.edu.vnua.fita.student.aclass.request.UpdateClassRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassManager implements IClassService {
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;

    @Override
    public Page<AClass> getClassList(GetClassListRequest request) {
        Specification<AClass> specification = CustomClassRepository.filterClassList(
                request.getId()
        );
        return classRepository.findAll(specification, PageRequest.of(request.getPage() - 1, request.getSize()));
    }

    @Override
    public List<AClass> getAllClass() {
        return classRepository.findAll(Sort.by("id").descending());
    }

    @Override
    public AClass createClass(CreateClassRequest request) {
        try {
            if (classRepository.existsById(request.getId())) {
                throw new RuntimeException(Constants.ClassManager.CLASS_HAS_EXISTED);
            }
            Student monitor = null;
            Student viceMonitor = null;
            Student secretary = null;
            Student deputySecretary = null;

            String monitorId = request.getMonitorId();
            String viceMonitorId = request.getViceMonitorId();
            String secretaryId = request.getSecretaryId();
            String deputySecretaryId = request.getDeputySecretaryId();

            if(monitorId!=null) {
                monitor = studentRepository.findById(monitorId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, monitorId)));
                monitor.setRole(Role.builder().id(Constants.RoleIdentify.MONITOR).build());
            }
            if (viceMonitorId!=null){
                viceMonitor = studentRepository.findById(viceMonitorId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, viceMonitorId)));
            }
            if (secretaryId!=null){
                secretary = studentRepository.findById(secretaryId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, secretaryId)));
            }
            if (deputySecretaryId!=null){
                deputySecretary = studentRepository.findById(deputySecretaryId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, deputySecretaryId)));
            }

            AClass aClass = AClass.builder()
                    .id(request.getId().toUpperCase())
                    .name(request.getName())
                    .monitor(monitor)
                    .viceMonitor(viceMonitor)
                    .secretary(secretary)
                    .deputySecretary(deputySecretary)
                    .build();

            return classRepository.saveAndFlush(aClass);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(Constants.ClassManager.DUPLICATE_MONITOR);
        }
    }

    @Override
    public AClass updateClass(UpdateClassRequest request) {
        try {
            AClass aClass = classRepository.findById(request.getId()).orElseThrow(() -> new RuntimeException(String.format(Constants.ClassManager.CLASS_NOT_FOUND, request.getId())));

            Student newMonitor = null;
            Student newViceMonitor = null;
            Student newSecretary = null;
            Student newDeputySecretary = null;

            String monitorId = request.getMonitorId();
            String viceMonitorId = request.getViceMonitorId();
            String secretaryId = request.getSecretaryId();
            String deputySecretaryId = request.getDeputySecretaryId();

            if(monitorId!=null) {
                newMonitor = studentRepository.findById(monitorId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, monitorId)));
                newMonitor.setRole(Role.builder().id(Constants.RoleIdentify.MONITOR).build());

                Student oldMonitor = aClass.getMonitor();
                if(oldMonitor != null) {
                    oldMonitor.setRole(Role.builder().id(Constants.RoleIdentify.STUDENT).build());
                }
            } else {
                Student oldMonitor = aClass.getMonitor();
                if (oldMonitor != null) {
                    oldMonitor.setRole(Role.builder().id(Constants.RoleIdentify.STUDENT).build());
                }
            }
            if (viceMonitorId!=null){
                newViceMonitor = studentRepository.findById(viceMonitorId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, viceMonitorId)));
            }
            if (secretaryId!=null){
                newSecretary = studentRepository.findById(secretaryId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, secretaryId)));
            }
            if (deputySecretaryId!=null){
                newDeputySecretary = studentRepository.findById(deputySecretaryId).orElseThrow(() -> new RuntimeException(String.format(Constants.StudentManager.STUDENT_NOT_FOUND, deputySecretaryId)));
            }

            aClass.setName(request.getName());
            aClass.setMonitor(newMonitor);
            aClass.setViceMonitor(newViceMonitor);
            aClass.setSecretary(newSecretary);
            aClass.setDeputySecretary(newDeputySecretary);
            return classRepository.saveAndFlush(aClass);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(Constants.ClassManager.DUPLICATE_MONITOR);
        }
    }

    @Override
    public AClass deleteClass(String id) {
        try {
            AClass aClass = classRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format(classNotFound, id)));
            classRepository.delete(aClass);
            return aClass;
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException(Constants.ClassManager.CANNOT_DELETE);
        }
    }
}
