package page_object_model.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {
    public static Object[][] getTestData(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist in " + filePath);
        }

        List<Object[]> data = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();

        rows.next();
        while (rows.hasNext()) {
            Row row = rows.next();
            String searchItem = row.getCell(0).getStringCellValue();
            data.add(new Object[]{searchItem});
        }
        workbook.close();
        return data.toArray(new Object[0][0]);
    }
    public static Object[][] getOrderReference(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            workbook.close();
            throw new IllegalArgumentException("Sheet \"" + sheetName + "\" does not exist in " + filePath);
        }

        List<Object[]> data = new ArrayList<>();
        Iterator<Row> rows = sheet.iterator();

        // Skip header row if necessary
        rows.next(); // Assuming the first row is a header

        while (rows.hasNext()) {
            Row row = rows.next();
            Cell cell = row.getCell(0); // Get the first cell

            // Initialize searchItem variable
            String searchItem = null;

            // Check the cell type and read accordingly
            if (cell != null) {
                switch (cell.getCellType()) {
                    case STRING:
                        searchItem = cell.getStringCellValue();
                        break;
                    case NUMERIC:
                        // If the cell is numeric, convert it to a string
                        searchItem = String.valueOf(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        searchItem = String.valueOf(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        searchItem = cell.getCellFormula(); // Handle formula if necessary
                        break;
                    default:
                        searchItem = ""; // Handle empty or other types
                        break;
                }
            }

            // Add the search item to data if it's not null
            if (searchItem != null) {
                data.add(new Object[]{searchItem});
            }
        }

        workbook.close();
        return data.toArray(new Object[0][0]);
    }

}
