package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.*;

/**
 * Utility class for reading test case data from Excel files in a column-keyword format.
 * Each row represents a test case with columns as key-value pairs.
 */
public class ColumnKeywordReader {
    
    /**
     * Reads test cases from an Excel file where the first row contains headers/column names
     * and subsequent rows contain test case data.
     * 
     * @param filePath Path to the Excel file containing test cases
     * @return List of test cases where each test case is represented as a Map of column names to values
     * @throws RuntimeException if there's an error reading the file
     */
    public static List<Map<String, String>> readTestCases(String filePath) {
        // Initialize list to store test cases
        List<Map<String, String>> testCases = new ArrayList<>();
        
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            // Get the first sheet from the workbook
            Sheet sheet = workbook.getSheetAt(0);
            // Create iterator to go through all rows
            Iterator<Row> rowIterator = sheet.rowIterator();
            
            // Return empty list if sheet has no rows
            if (!rowIterator.hasNext()) return testCases;
            
            // Read header row (first row) to get column names
            Row headerRow = rowIterator.next();
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                // Add each header cell value to the headers list
                headers.add(cell.getStringCellValue());
            }
            
            // Process data rows (remaining rows after header)
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // Use LinkedHashMap to maintain column order
                Map<String, String> testCase = new LinkedHashMap<>();
                
                // Process each cell in the row
                for (int i = 0; i < headers.size(); i++) {
                    // Get cell or create as blank if missing (to avoid NPE)
                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    // Map column header to cell value (trimmed)
                    testCase.put(headers.get(i), cell.getStringCellValue().trim());
                }
                
                
                testCases.add(testCase);	// Add completed test case to the list
            }
        } catch (Exception e) {
            // Wrap any exceptions in a runtime exception with descriptive message
            throw new RuntimeException("Error reading test cases from file: " + filePath, e);
        }
        return testCases;
    }
}