package vn.edu.vnua.fita.student.service.file.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.util.Iterator;
import java.util.concurrent.Callable;

@Data
@AllArgsConstructor
public class ReadExcelWorker implements Callable<String> {
    private Row row;

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        // Vì front end đã thông báo hình ảnh form excel request, vậy nên ở đây fix cứng số cột là 11
        for (int i = 0; i < 11; i++) {
            Cell cell = row.getCell(i);
            String data = "";
            if (cell != null) {
                cell.setCellType(CellType.STRING); // Xác định kiểu dữ liệu là STRING
                data = cell.getStringCellValue();
            }
            stringBuilder.append(data);
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
