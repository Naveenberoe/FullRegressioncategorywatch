package utils;

import java.util.Map;
import java.util.HashMap;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class TestDataManager {
    private static final ThreadLocal<String> currentTestCaseID = new ThreadLocal<>();
    private static final String TEST_DATA_PATH = "src/test/resources/data/RunManagerOperationFullRegression.xlsx";
    private static final String TEST_DATA_SHEET = "SampleCases";

    // The entire file is to get the current testcase Name from Run Manager, to use it in all the class files.
    
    public static void setCurrentTestCase(String testCaseID) {
        currentTestCaseID.set(testCaseID);
    }

    public static Map<String, String> getCurrentTestData() throws Exception {
        String testCaseID = currentTestCaseID.get();
        if (testCaseID == null) {
            throw new IllegalStateException("Test case ID not set");
        }

        try (FileInputStream file = new FileInputStream(TEST_DATA_PATH);
             Workbook workbook = new XSSFWorkbook(file)) {
            
            Sheet sheet = workbook.getSheet(TEST_DATA_SHEET);
            Row headerRow = sheet.getRow(0);
            
            // Build column index map
            Map<String, Integer> columns = new HashMap<>();
            for (Cell cell : headerRow) {
                columns.put(cell.getStringCellValue().trim(), cell.getColumnIndex());
            }
            
            // Find matching test case row
            for (Row row : sheet) {
                Cell idCell = row.getCell(columns.get("TestCase"));
                if (idCell != null && testCaseID.equals(idCell.getStringCellValue().trim())) {
                    Map<String, String> rowData = new HashMap<>();
                    for (Map.Entry<String, Integer> entry : columns.entrySet()) {
                        Cell dataCell = row.getCell(entry.getValue());
                        rowData.put(entry.getKey(), dataCell != null ? dataCell.toString() : "");
                    }
                    return rowData;
                }
            }
            throw new RuntimeException("Test case '" + testCaseID + "' not found in sheet");
        }
    }
}