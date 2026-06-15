package runners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import keywords.ColumnKeywordExecutor;
import utils.ExcelReader;
import utils.ExtentManager;
import utils.TestDataManager;

/**
 * TestNG runner for operation full regression flows.
 */
public class TestRunnerOperation {

	private static final String TEST_DATA_PATH = "src/test/resources/data/RunManagerOperationFullRegression.xlsx";
	private static final String KEYWORDS_PATH = "src/test/resources/data/OperationfullregressionTestflow.xlsx";
	private static final String TEST_DATA_SHEET = "SampleCases";
	private static final String KEYWORDS_SHEET = "Businessflow";

	private WebDriver driver;
	private ColumnKeywordExecutor executor;
	private Map<String, List<String>> testFlowMap;

	public void testSetup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.executor = new ColumnKeywordExecutor(driver);
	}

	@AfterMethod
	public void testTeardown() {
		if (this.driver != null) {
			this.driver.quit();
		}
	}

	@BeforeClass
	public void loadTestCases() {
		this.testFlowMap = loadKeywordsMapping();
	}

	@Test(dataProvider = "testData")
	public void executeTest(Object[] testData) {
		String testScenario = (String) testData[0];
		String testCaseId = (String) testData[1];
		String executeFlag = (String) testData[4];

		TestDataManager.setCurrentTestCase(testCaseId);

		ExtentTest test = ExtentManager.startTest(testCaseId, testScenario);

		if (!"Yes".equalsIgnoreCase(executeFlag)) {
			test.skip("Test case skipped: " + testCaseId);
			throw new SkipException("Test case skipped: " + testCaseId);
		}

		testSetup();
		List<String> keywords = testFlowMap.get(testCaseId);
		if (keywords == null || keywords.isEmpty()) {
			test.skip("No keywords found for test case: " + testCaseId);
			throw new SkipException("No keywords found for test case: " + testCaseId);
		}

		System.out.println("Executing test case: " + testCaseId);
		try {
			List<Throwable> failures = executor.executeTestFlow(testScenario, keywords);
			ITestContext context = Reporter.getCurrentTestResult().getTestContext();
			context.setAttribute("failures", failures);

			if (!failures.isEmpty()) {
				Reporter.getCurrentTestResult().setStatus(ITestResult.FAILURE);
				printTestStatus(testCaseId, "Fail");
			} else {
				test.pass("All keywords executed successfully");
				printTestStatus(testCaseId, "Pass");
			}
		} catch (Exception e) {
			test.fail("Test execution error: " + e.getMessage());
			printTestStatus(testCaseId, "Fail");
			test.fail(e);
		}
	}

	private void printTestStatus(String testCaseId, String status) {
		System.out.println("==============================================================================================");
		System.out.println("\n" + testCaseId + " - " + status);
		System.out.println("==============================================================================================");
	}

	@DataProvider(name = "testData")
	public Object[][] getTestData() {
		return ExcelReader.getTestData(TEST_DATA_PATH, TEST_DATA_SHEET);
	}

	private Map<String, List<String>> loadKeywordsMapping() {
		Map<String, List<String>> mapping = new HashMap<>();
		Object[][] keywordsData = ExcelReader.getTestData(KEYWORDS_PATH, KEYWORDS_SHEET);

		for (Object[] row : keywordsData) {
			String testCaseId = (String) row[0];
			List<String> keywords = new ArrayList<>();

			for (int i = 1; i < row.length; i++) {
				if (row[i] != null && !row[i].toString().trim().isEmpty()) {
					keywords.add(row[i].toString().trim());
				}
			}

			if (!keywords.isEmpty()) {
				mapping.put(testCaseId, keywords);
			}
		}

		return mapping;
	}

	@AfterSuite
	public void tearDownSuite() {
		ExtentManager.endTest();
	}
}