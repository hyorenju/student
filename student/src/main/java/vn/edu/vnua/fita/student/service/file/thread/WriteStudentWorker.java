package vn.edu.vnua.fita.student.service.file.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Row;
import vn.edu.vnua.fita.student.student.entity.Student;
import vn.edu.vnua.fita.student.util.MyUtils;

import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
public class WriteStudentWorker implements Callable<Void> {
    private Row row;
    private Student student;

    @Override
    public Void call() throws Exception {
        row.createCell(0).setCellValue(student.getId());
        row.createCell(1).setCellValue(student.getSurname());
        row.createCell(2).setCellValue(student.getLastName());
        row.createCell(3).setCellValue(student.getCourse().getId());
        row.createCell(4).setCellValue(student.getMajor().getId());
        row.createCell(5).setCellValue(student.getAclass().getId());
        row.createCell(6).setCellValue(MyUtils.convertTimestampToString(student.getDob()));
        row.createCell(7).setCellValue(student.getGender());
        row.createCell(8).setCellValue(student.getPhoneNumber());
        row.createCell(9).setCellValue(student.getEmail());
        row.createCell(10).setCellValue(student.getFamilySituation());
        row.createCell(11).setCellValue(student.getHomeTown());
        row.createCell(12).setCellValue(student.getResidence());
        row.createCell(13).setCellValue(student.getFatherName());
        row.createCell(14).setCellValue(student.getFatherPhoneNumber());
        row.createCell(15).setCellValue(student.getMotherName());
        row.createCell(16).setCellValue(student.getMotherPhoneNumber());
        return null;
    }

//    @Override
//    public void run() {
//        row.createCell(0).setCellValue(student.getId());
//        row.createCell(1).setCellValue(student.getSurname());
//        row.createCell(2).setCellValue(student.getLastName());
//        row.createCell(3).setCellValue(student.getCourse().getId());
//        row.createCell(4).setCellValue(student.getMajor().getId());
//        row.createCell(5).setCellValue(student.getAclass().getId());
//        row.createCell(6).setCellValue(MyUtils.convertTimestampToString(student.getDob()));
//        row.createCell(7).setCellValue(student.getGender());
//        row.createCell(8).setCellValue(student.getPhoneNumber());
//        row.createCell(9).setCellValue(student.getEmail());
//        row.createCell(10).setCellValue(student.getHomeTown());
//        row.createCell(11).setCellValue(student.getResidence());
//        row.createCell(12).setCellValue(student.getFatherName());
//        row.createCell(13).setCellValue(student.getFatherPhoneNumber());
//        row.createCell(14).setCellValue(student.getMotherName());
//        row.createCell(15).setCellValue(student.getMotherPhoneNumber());
//    }
}
