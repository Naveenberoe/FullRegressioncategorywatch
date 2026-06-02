package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

/**
 * Utility class for reading test data from Excel files (XLSX format).
 * Provides methods to read test data in various formats and supports TestNG DataProvider integration.
 */
public class DataInputProvider {

    /**
     * TestNG DataProvider that automatically provides test data from Excel based on test class name.
     * @param method The test method being executed (provided by TestNG)
     * @return Iterator of Object arrays containing test data maps
     */
    @DataProvider(name = "excelData")
    public static Iterator<Object[]> provideData(Method method) {
        // Derive sheet name from test class name (removes "Tests" suffix and adds "TestCases")
        String testClassName = method.getDeclaringClass().getSimpleName();
        String sheetName = testClassName.replace("Tests", "") + "TestCases";
        
        // Get test data from Excel file
        List<Map<String, String>> testData = getTestData(
            "src/test/resources/data/Testdata.xlsx", 
            sheetName);
            
        // Convert each test case map to Object array and return as iterator
        return testData.stream()
            .map(testCase -> new Object[]{testCase})
            .iterator();
    }
    
    /**
     * Reads test data from Excel sheet and returns as list of maps (key-value pairs).
     * Each row becomes a Map where keys are column headers and values are cell values.
     * Skips rows where "Execute" column is not "Y" or "Yes".
     * 
     * @param filePath Path to Excel file
     * @param sheetName Name of sheet to read
     * @return List of test cases with column headers as keys
     * @throws IllegalArgumentException if sheet or header row is not found
     * @throws RuntimeException if file reading fails
     */
    public static List<Map<String, String>> getTestData(String filePath, String sheetName) {
        List<Map<String, String>> testData = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            // Get specified sheet or throw exception if not found
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in Excel file");
            }
            
            // Get header row (first row) or throw exception if missing
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("No header row found in sheet");
            }
            
            // Read all column headers from first row
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(getCellValueAsString(cell));
            }
            
            // Process each data row (starting from row 1)
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row dataRow = sheet.getRow(i);
                if (dataRow == null) continue; // Skip empty rows
                
                Map<String, String> rowData = new HashMap<>();
                boolean shouldExecute = true; // Default to true if no Execute column
                
                // Process each cell in the row
                for (int j = 0; j < headers.size(); j++) {
                    String header = headers.get(j);
                    // Get cell value (create blank cell if missing)
                    String value = getCellValueAsString(
                        dataRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK));
                    
                    // Special handling for Execute column
                    if ("Execute".equalsIgnoreCase(header)) {
                        shouldExecute = "Y".equalsIgnoreCase(value) || "Yes".equalsIgnoreCase(value);
                    }
                    
                    rowData.put(header, value);
                }
                
                // Only add test case if marked for execution
                if (shouldExecute) {
                    testData.add(rowData);
                }
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
        
        return testData;
    }
    
    /**
     * Gets test data grouped by TestCaseID column.
     * @param filePath Path to Excel file
     * @param sheetName Name of sheet to read
     * @return Map of test cases with TestCaseID as key, or empty map if no valid TestCaseIDs found
     */
    public static Map<String, Map<String, String>> getTestDataByTestCaseID(String filePath, String sheetName) {
        List<Map<String, String>> testData = getTestData(filePath, sheetName);
        Map<String, Map<String, String>> result = new HashMap<>();
        
        // Group test cases by their TestCaseID
        for (Map<String, String> testCase : testData) {
            String testCaseID = testCase.get("TestCaseID");
            if (testCaseID != null && !testCaseID.isEmpty()) {
                result.put(testCaseID, testCase);
            }
        }
        
        return result;
    }
    
    
    /**
     * Gets the names of all sheets in the Excel workbook.
     * @param filePath Path to Excel file
     * @return List of sheet names in order they appear in workbook
     * @throws RuntimeException if file reading fails
     */
    public static List<String> getSheetNames(String filePath) {
        List<String> sheetNames = new ArrayList<>();
        
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {
            
            // Get all sheet names
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                sheetNames.add(workbook.getSheetName(i));
            }
            
        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file: " + filePath, e);
        }
        
        return sheetNames;
    }
    
    /**
     * Converts Excel cell value to String representation.
     * Handles all cell types (string, numeric, boolean, formula, blank) and date formatting.
     * @param cell The cell to convert
     * @return String representation of cell value
     */
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        
        // Handle formula cells by getting cached result type
        CellType cellType = cell.getCellType();
        if (cellType == CellType.FORMULA) {
            cellType = cell.getCachedFormulaResultType();
        }

        // Convert based on cell type
        switch (cellType) {
            case STRING:
                return cell.getStringCellValue().trim();
                
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    // Format date values as string
                    return cell.getLocalDateTimeCellValue().toString();
                } else {
                    // Handle numeric values (check for integer vs decimal)
                    double numValue = cell.getNumericCellValue();
                    if (numValue == (long) numValue) {
                        return String.valueOf((long) numValue);
                    }
                    return String.valueOf(numValue);
                }
                
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
                
            case BLANK:
                return "";
                
            default:
                return cell.toString();
        }
    }
    
    
    public static String getColumnValuesAsString(
            String fileName,
            String sheetName,
            String targetColumn
        ) {
            // 1. Add .xlsx extension if missing
            String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
            
            // 2. Resolve full path (assuming files are in src/test/resources/data)
            String filePath = Paths.get("src/test/resources/data", processedFileName).toString();
            
            // 3. Fetch and process data
            List<Map<String, String>> testData = getTestData(filePath, sheetName);
            StringBuilder resultBuilder = new StringBuilder();
            
            for (Map<String, String> row : testData) {
                String targetValue = row.get(targetColumn);
                
                if (targetValue != null && !targetValue.isEmpty()) {
                    resultBuilder.append("").append(targetValue).append("");
                }
            }
            
            // Remove trailing comma and space if present
            if (resultBuilder.length() > 1 && resultBuilder.charAt(resultBuilder.length() - 2) == ',') {
                resultBuilder.setLength(resultBuilder.length() - 2);
            }
            
            return resultBuilder.toString();
        }
    
    public static List<String> getColumnValues(
            String fileName,
            String sheetName,
            String targetColumn
        ) {
            // 1. Add .xlsx extension if missing
            String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
            
            // 2. Resolve full path
            String filePath = Paths.get("src/test/resources/data", processedFileName).toString();
            
            // 3. Fetch and process data
            List<Map<String, String>> testData = getTestData(filePath, sheetName);
            List<String> result = new ArrayList<>();
            
            for (Map<String, String> row : testData) {
                String targetValue = row.get(targetColumn);
                if (targetValue != null && !targetValue.isEmpty()) {
                    result.add(targetValue);
                }
            }
            
            return result;
        }

//    public static Map<String, Map<String, String>> getTestDataByColumn(
//        String fileName,    // "TestData" or "TestData.xlsx" both work
//        String sheetName,
//        String keyColumn
//    ) {
//        // 1. Add .xlsx extension if missing
//        String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
//        
//        // 2. Resolve full path (assuming files are in src/test/resources/data)
//        String filePath = Paths.get("src/test/resources/data", processedFileName).toString();
//        
//        // 3. Fetch and process data
//        List<Map<String, String>> testData = getTestData(filePath, sheetName);
//        Map<String, Map<String, String>> result = new HashMap<>();
//        
//        for (Map<String, String> row : testData) {
//            String keyValue = row.get(keyColumn);
//            if (keyValue != null && !keyValue.isEmpty()) {
//                result.put(keyValue, row);
//            }
//        }
        
//        return result;
//    }
    
	    public static String getColumnDataAsString(
	    	    String fileName,    // "TestData" or "TestData.xlsx"
	    	    String sheetName,
	    	    String columnName,
	    	    String currentTestCaseID// Column to extract (e.g., "Email", "ProductID")
	    	) {
	    	
	    	String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
	    	String filePath = Paths.get("src/test/resources/data", processedFileName).toString();

	    	// 1. Get all rows from Excel
	    	List<Map<String, String>> allData = getTestData(filePath, sheetName);
	    	
//	    	 System.out.println("Available TestCaseIDs in Excel:");
//	    	 allData.forEach(row -> System.out.println("- " + row.get("TestCase")));

	    	// 2. Find the row matching the current test case (e.g., by "TestCaseID" or another key)
	    	Map<String, String> currentTestCaseData = allData.stream()
	    	    .filter(row -> row.get("TestCase").equals(currentTestCaseID)) // Adjust key as needed
	    	    .findFirst()
	    	    .orElseThrow(() -> new RuntimeException("Test case not found in Excel!"));

	    	// 3. Get the value for the specified column
	    	return currentTestCaseData.get(columnName);
//	    	    // 1. Process filename and resolve path
//	    	    String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
//	    	    String filePath = Paths.get("src/test/resources/data", processedFileName).toString();
//	
//	    	    // 2. Get all rows from Excel
//	    	    List<Map<String, String>> allData = getTestData(filePath, sheetName);
//	
//	    	    // 3. Extract the specified column and join into a String
//	    	    return allData.stream()
//	    	        .map(row -> row.get(columnName))  // Get value from column
//	    	        .filter(Objects::nonNull)         // Ignore null values
//	    	        .collect(Collectors.joining(", ")); // Join with commas
	    	}
	    
	    public static Map<String, Map<String, String>> getTestcaseData(
	            String fileName,
	            String sheetName,
	            String testcaseName
	    ) throws IOException {
	    	// 1. Read Excel data (unchanged)
	    	String filePath = Paths.get("src/test/resources/data", 
	    	        fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx").toString();
	    	List<Map<String, String>> allData = getTestData(filePath, sheetName);

	    	// 2. Extract and sort column headers (unchanged)
	    	List<String> orderedColumns = new ArrayList<>();
	    	if (!allData.isEmpty()) {
	    	    orderedColumns = allData.get(0).keySet().stream()
	    	            .filter(k -> !k.equals("TestCase")) // Only exclude "Testcase"
	    	            .sorted((s1, s2) -> {
	    	                // Sort months chronologically
	    	                if (s1.equals("Time")) return -1; // "Time" comes first
	    	                if (s2.equals("Time")) return 1;
	    	                
	    	                try {
	    	                    Date d1 = new SimpleDateFormat("MMM yyyy").parse(s1);
	    	                    Date d2 = new SimpleDateFormat("MMM yyyy").parse(s2);
	    	                    return d1.compareTo(d2);
	    	                } catch (ParseException e) {
	    	                    return s1.compareTo(s2); // Fallback: Alphabetical sort
	    	                }
	    	            })
	    	            .collect(Collectors.toList());
	    	}

	    	// 3. Process rows (MODIFIED to maintain column order)
	    	Map<String, Map<String, String>> testcaseData = new LinkedHashMap<>();
	    	String currentTestcase = null;

	    	for (Map<String, String> row : allData) {
	    	    String rowTestcase = row.get("TestCase");
	    	    String timeValue = row.get("Time");

	    	    // Update currentTestcase if new non-empty "Testcase" is found
	    	    if (rowTestcase != null && !rowTestcase.isEmpty()) {
	    	        currentTestcase = rowTestcase;
	    	    }

	    	    // Skip rows not belonging to target test case
	    	    if (!testcaseName.equals(currentTestcase)) continue;

	    	    // Skip rows without "Time"
	    	    if (timeValue == null || timeValue.isEmpty()) continue;

	    	    // Build row data USING THE SORTED COLUMN ORDER
	    	    Map<String, String> rowData = new LinkedHashMap<>();
	    	    for (String column : orderedColumns) {
	    	        rowData.put(column, row.get(column));
	    	    }
	    	    
	    	    testcaseData.put(timeValue, rowData);
	    	}

	    	if (testcaseData.isEmpty()) {
	    	    throw new RuntimeException("No data found for test case: " + testcaseName);
	    	}

	    	return testcaseData;
	    }
	    
	    
	    public void validateAllRows(
			    WebDriver driver, 
			    String fileName, 
			    String sheetName, 
			    String testcaseName
			) throws IOException {
			    // 1. Get all Excel data for the test case
			    Map<String, Map<String, String>> excelData = getExcelDataForTestcase(fileName, sheetName, testcaseName);
			    
			    // 2. Get all UI data
			    Map<String, Map<String, String>> uiData = getUIData(driver);
			    
			    // 3. Compare each row
			    for (Map.Entry<String, Map<String, String>> excelEntry : excelData.entrySet()) {
			        String rowName = excelEntry.getKey(); // e.g., "Total Price Inflation"
			        Map<String, String> excelRow = excelEntry.getValue();
			        Map<String, String> uiRow = uiData.get(rowName);
			        
			        if (uiRow == null) {
			            Assert.fail("Row '" + rowName + "' not found in UI!");
			        }
			        
			        // Compare each month's value
			        for (Map.Entry<String, String> monthEntry : excelRow.entrySet()) {
			            String month = monthEntry.getKey();
			            String excelValue = monthEntry.getValue();
			            String uiValue = uiRow.get(month);
			            
			            Assert.assertEquals(
			                uiValue, 
			                excelValue, 
			                "Mismatch in row '" + rowName + "' for " + month + 
			                ": UI=" + uiValue + ", Excel=" + excelValue
			            );
			        }
			    }
			}
	    
	    
	    public Map<String, Map<String, String>> getUIData(WebDriver driver) {
	    	
	    	String currentTestcase = "";
		    Map<String, Map<String, String>> uiData = new LinkedHashMap<>();
		    
		    // 1. Dynamically get UI headers (skip non-date columns)
		    List<WebElement> headerElements = driver.findElements(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/thead/tr/th[position()>1]"));
		    List<String> headers = headerElements.stream()
		        .map(WebElement::getText)
		        .collect(Collectors.toList());

		    System.out.println("Number of headers: " + headers.size());
		    
		    // 2. Get all data rows
		    List<WebElement> rows = driver.findElements(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/tbody/tr"));
		    System.out.println("Number of rows: " + rows.size());
		 
		    for (WebElement row : rows) {
		    			    	
		    	// Get Testcase if present (first column)
		    	WebElement testcaseCell = row.findElement(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/tbody/tr/td[1]"));
		        String testcaseValue = testcaseCell.getText().trim();
		    	
		     // Update current testcase if not empty
		        if (!testcaseValue.isEmpty()) {
		        	currentTestcase = testcaseValue;
		            System.out.println("New testcase: " + currentTestcase);
		        }
		        
		        // Skip if no active testcase
		        if (currentTestcase == null) {
		            continue;
		        }
		        
		        String rowName = row.findElement(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/tbody/tr/td[2]")).getText().trim(); // "Month" column
		        Map<String, String> rowData = new LinkedHashMap<>();
		        
		        // Get all data cells for THIS ROW ONLY (skip first column)
		        
//		        for(int count = 1;count< rows.size();count++)
//		        {
//		        	List<WebElement> cells = row.findElements(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/tbody/tr[" + count + "]/td[position()>1]"));
		        
		        List<WebElement> cells = row.findElements(By.xpath("(//table[@class='min-w-full border-separate border-spacing-0 w-full bg-white text-sm'])[1]/tbody/tr/td[position()>1]"));
		        System.out.println("Processing: " + currentTestcase + " - " + rowName + " | Cells: " + cells.size());
		        System.out.println("Cells in row '" + rowName + "': " + cells.size());
		        
		        // Verify counts match
//		        if (cells.size() != headers.size()) {
//		            throw new RuntimeException(
////		                "Header/cell count mismatch for row '" + rowName + "': " +
////		                headers.size() + " headers vs " + cells.size() + " cells"
//
//                "Mismatch in " + currentTestcase + " > " + rowName + ": " +
//                "Expected " + headers.size() + " cells, found " + cells.size()
//		            );
//		        }
		        
//		        for (int i = 0; i <= cells.size(); i++) {
////		            rowData.put(headers.get(i), cells.get(i).getText());
//		        	rowData.put(headers.get(i), cells.get(i).getText().trim());
//		        }
		        
		        for (int i = 0; i < headers.size(); i++) {
		            // Get the column header (e.g., "AUG 2018")
		            String header = headers.get(i); 
		            
		            // Get the cell value (e.g., "822.78") and trim whitespace
		            String cellValue = cells.get(i).getText().trim(); 
		            
		            // Map header to value
		            rowData.put(header, cellValue); 
		        }
		        
		        uiData.put(currentTestcase + "|" + rowName, rowData);
		    }
		    
//	    }
		    
		    return uiData;
		}
	    
	    public Map<String, Map<String, String>> getExcelDataForTestcase(
	    	    String fileName, 
	    	    String sheetName, 
	    	    String testcaseName
	    	) throws IOException {
	    	    // Reuse the corrected version that:
	    	    // 1. Handles empty "Testcase" cells
	    	    // 2. Sorts columns chronologically
	    	    // 3. Captures all rows under the test case
	    	    return getTestcaseData(fileName, sheetName, testcaseName);
	    	}

    /**
     * Reads multiple sheets from a file and returns combined data
     * @param filePath Path to Excel file
     * @param sheetNames List of sheets to read
     * @return Map where key=sheetName, value=rows from that sheet
     */
    public Map<String, List<Map<String, String>>> getTestDataFromSheets(
        String filePath, 
        List<String> sheetNames
    ) {
        Map<String, List<Map<String, String>>> result = new LinkedHashMap<>();
        
        for (String sheetName : sheetNames) {
            try {
                List<Map<String, String>> sheetData = getTestData(filePath, sheetName);
                result.put(sheetName, sheetData);
            } catch (Exception e) {
                System.err.println("Error reading sheet '" + sheetName + "': " + e.getMessage());
            }
        }
        
        return result;
    }
    
    public List<Map<String, String>> getTestDataRows(String filePath, String sheetName, String testCaseID) {
        List<Map<String, String>> allRows = new ArrayList<>();
        
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in file: " + filePath);
            }
            
            Row headerRow = sheet.getRow(0);
            if (headerRow == null) {
                throw new IllegalArgumentException("Header row (row 0) is empty in sheet: " + sheetName);
            }
            
            // Find the column index for TestCaseID dynamically
            int testCaseIDColumn = -1;
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                String columnName = getCellValue(headerRow.getCell(i));
                if ("TestCaseID".equalsIgnoreCase(columnName)) {
                    testCaseIDColumn = i;
                    break;
                }
            }
            
            if (testCaseIDColumn == -1) {
                throw new IllegalArgumentException("TestCaseID column not found in sheet: " + sheetName);
            }
            
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue; // skip empty rows
                
                String currentTestCaseID = getCellValue(row.getCell(testCaseIDColumn));
                if (testCaseID.equals(currentTestCaseID)) {
                    Map<String, String> rowData = new LinkedHashMap<>(); // Using LinkedHashMap to maintain column order
                    for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                        String columnName = getCellValue(headerRow.getCell(j));
                        String cellValue = getCellValue(row.getCell(j));
                        rowData.put(columnName, cellValue != null ? cellValue : "");
                    }
                    allRows.add(rowData);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Excel data from " + filePath + ", sheet: " + sheetName + 
                                     ", TestCaseID: " + testCaseID + ". Error: " + e.getMessage(), e);
        }
        
        if (allRows.isEmpty()) {
            System.out.println("Warning: No test data found for TestCaseID: " + testCaseID);
        }
        
        return allRows;
    }
    
    public static List<Map<String, String>> getRowData(String fileName,  String sheetName) 
    {
            // 1. Process filename and resolve path
            String processedFileName = fileName.endsWith(".xlsx") ? fileName : fileName + ".xlsx";
            String filePath = Paths.get("src/test/resources/data", processedFileName).toString();

            // 2. Read and return all row data
            return readExcelRows(filePath, sheetName);
        }
    
    // Helper: Read all rows from Excel
    private static List<Map<String, String>> readExcelRows(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found.");
            }

            // Read headers (first row)
            Row headerRow = sheet.getRow(0);
            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue().trim());
            }

            // Read data rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowData = new LinkedHashMap<>();

                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    rowData.put(headers.get(j), getCellValueAsString(cell));
                }
                data.add(rowData);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
        return data;
    }
    
    /**
     * Reads inflation data for multiple test cases
     * @param filePath Path to Excel file
     * @param sheetName Sheet containing the data
     * @return Map of TestCaseID → (Metric → (Month → Value))
     */
    public static Map<String, Map<String, Map<String, Double>>> readMultiTestInflationData(
            String filePath, 
            String sheetName) throws IOException {
        
        Map<String, Map<String, Map<String, Double>>> testCaseData = new LinkedHashMap<>();
        
        try (Workbook workbook = WorkbookFactory.create(new File(filePath))) {
            Sheet sheet = workbook.getSheet(sheetName);
            
            // Find column indexes
            Row headerRow = sheet.getRow(0);
            int testCaseCol = -1;
            int metricCol = -1;
            List<Integer> monthCols = new ArrayList<>();
            
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell == null) continue;
                
                String header = cell.getStringCellValue().trim();
                if ("TestCaseID".equalsIgnoreCase(header)) {
                    testCaseCol = i;
                } else if ("Metric".equalsIgnoreCase(header)) {
                    metricCol = i;
                } else if (header.matches("[A-Z]{3}\\s20\\d{2}")) {
                    monthCols.add(i);
                }
            }
            
            // Validate columns
            if (testCaseCol == -1 || metricCol == -1 || monthCols.isEmpty()) {
                throw new IllegalArgumentException("Required columns not found");
            }
            
            // Get month names
            List<String> months = monthCols.stream()
                .map(col -> headerRow.getCell(col).getStringCellValue())
                .collect(Collectors.toList());
            
            // Process all data rows
            for (int rowIdx = 1; rowIdx <= sheet.getLastRowNum(); rowIdx++) {
                Row row = sheet.getRow(rowIdx);
                if (row == null) continue;
                
                String testCaseID = row.getCell(testCaseCol).getStringCellValue().trim();
                String metric = row.getCell(metricCol).getStringCellValue().trim();
                
                // Initialize data structure if new test case
                testCaseData.putIfAbsent(testCaseID, new LinkedHashMap<>());
                
                // Read month values
                Map<String, Double> monthlyValues = new LinkedHashMap<>();
                for (int i = 0; i < monthCols.size(); i++) {
                    Cell valueCell = row.getCell(monthCols.get(i));
                    double value = valueCell != null ? valueCell.getNumericCellValue() : 0.0;
                    monthlyValues.put(months.get(i), value);
                }
                
                testCaseData.get(testCaseID).put(metric, monthlyValues);
            }
        }
        
        return testCaseData;
    }

    
    
    public static List<Map<String, String>> getRowDatausingPath(String filePath, String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new RuntimeException("Sheet '" + sheetName + "' not found.");
            }

            // Get header row (assumes first row is headers)
            Row headerRow = sheet.getRow(0);
            List<String> columnNames = new ArrayList<>();
            for (Cell cell : headerRow) {
                columnNames.add(cell.getStringCellValue());
            }

            // Process data rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Map<String, String> rowData = new LinkedHashMap<>();

                for (int j = 0; j < columnNames.size(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String value = "";
                    switch (cell.getCellType()) {
                        case STRING:
                            value = cell.getStringCellValue();
                            break;
                        case NUMERIC:
                            value = String.valueOf(cell.getNumericCellValue());
                            break;
                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;
                        default:
                            value = "";
                    }
                    rowData.put(columnNames.get(j), value.trim());
                }
                data.add(rowData);
            }

        } catch (Exception e) {
            throw new RuntimeException("Error reading Excel file: " + e.getMessage(), e);
        }
        return data;
    }
    
    public Map<String, String> getSingleTestDataRow(String filePath, String sheetName, String testCaseID) {
        List<Map<String, String>> allRows = getTestDataRows(filePath, sheetName, testCaseID);
        
        if (allRows.isEmpty()) {
            throw new RuntimeException("No test data found for TestCaseID: " + testCaseID);
        }
        
        if (allRows.size() > 1) {
            System.out.println("Warning: Multiple rows found for TestCaseID: " + testCaseID + 
                             ". Returning first matching row.");
        }
        
        return allRows.get(0);
    }

    private String getCellValue(Cell cell) {
        if (cell == null) {
            return null;
        }
        
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getLocalDateTimeCellValue().toString();
                }
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
            	switch (cell.getCachedFormulaResultType()) {
                case STRING:
                    return cell.getStringCellValue().trim();
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getLocalDateTimeCellValue().toString();
                    }
                    return String.valueOf(cell.getNumericCellValue());
                case BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                default:
                    return "";
            }

            case BLANK:
                return "";
            default:
                return "";
        }
    }
    
}