package page_object_model.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        return readSheetData(filePath, sheetName, 1);
    }

    public static Object[][] getOrderReference(String filePath, String sheetName) throws IOException {
        return readSheetData(filePath, sheetName, 1);
    }

    private static Object[][] readSheetData(String filePath, String sheetName, int numCols) throws IOException {
        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist in " + filePath);
            }

            List<Object[]> data = new ArrayList<>();
            Iterator<Row> rows = sheet.iterator();

            if (rows.hasNext()) {
                rows.next();
            }

            while (rows.hasNext()) {
                Row row = rows.next();
                Object[] rowData = new Object[numCols];

                for (int col = 0; col < numCols; col++) {
                    Cell cell = row.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData[col] = getCellValue(cell);
                }
                data.add(rowData);
            }
            return data.toArray(new Object[0][0]);
        } catch (IOException e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            throw e;
        }
    }

    private static Object getCellValue(Cell cell) {
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case BOOLEAN:
                return cell.getBooleanCellValue();
            default:
                return "Unsupported cell type";
        }
    }
}
