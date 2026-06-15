package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

/**
 * Enhanced Excel reader supporting multiple sheets and backward compatibility
 */
public class ExcelReader {
	
	// Excel reader for reading only the RUN MANAGER - excel file
	
    private static final DataFormatter dataFormatter = new DataFormatter();

    // New: Multi-sheet data retrieval
    public static Map<String, Object[][]> getMultiSheetTestData(String filePath, List<String> sheetNames) {
        validateFile(filePath);
        Map<String, Object[][]> sheetDataMap = new LinkedHashMap<>();
        
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            for (String sheetName : sheetNames) {
                try {
                    Sheet sheet = workbook.getSheet(sheetName);
                    if (sheet != null) {
                        sheetDataMap.put(sheetName, processSheet(sheet));
                    }
                } catch (Exception e) {
                    System.err.println("Error processing sheet '" + sheetName + "': " + e.getMessage());
                }
            }
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
        
        return sheetDataMap;
    }

    // Modified existing method (unchanged signature)
    public static Object[][] getTestData(String filePath, String sheetName) {
        validateFile(filePath);
        
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            Sheet sheet = validateSheet(workbook, sheetName);
            return processSheet(sheet);
            
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
    }

    // New: Consolidated sheet processing
    private static Object[][] processSheet(Sheet sheet) {
        List<Object[]> rows = new ArrayList<>();
        Iterator<Row> rowIterator = sheet.iterator();
        
        if (!rowIterator.hasNext()) {
            return new Object[0][];
        }

        // Skip header
        Row headerRow = rowIterator.next();
        int colCount = headerRow.getLastCellNum();
        
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            rows.add(processRow(row, colCount));
        }
        
        return rows.toArray(new Object[0][]);
    }

    // Existing helper methods (unchanged)
    private static Object[] processRow(Row row, int columnCount) {
        Object[] rowData = new Object[columnCount];
        for (int i = 0; i < columnCount; i++) {
            Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            rowData[i] = dataFormatter.formatCellValue(cell).trim();
        }
        return rowData;
    }

    private static Sheet validateSheet(Workbook workbook, String sheetName) {
        Sheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new RuntimeException("Sheet not found. Available: " + getSheetNames(workbook));
        }
        return sheet;
    }

    private static void validateFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists() || !file.getName().endsWith(".xlsx") || file.length() == 0) {
            throw new RuntimeException("Invalid Excel file: " + filePath);
        }
    }

    private static String getSheetNames(Workbook workbook) {
        List<String> names = new ArrayList<>();
        workbook.forEach(sheet -> names.add(sheet.getSheetName()));
        return String.join(", ", names);
    }
}
