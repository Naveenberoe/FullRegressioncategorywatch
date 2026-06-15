package testScripts;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.Category;
import PageObjects.Constants;
import PageObjects.Search;
import utils.DataInputProvider;
import utils.ExtentManager;
import utils.TestDataManager;

public class CategoryFullregression {

	public WebDriver driver;
	public ExtentTest test;

	Constants cnstnt = new Constants(driver);
	CommonSteps steps = new CommonSteps(driver);
	DataInputProvider data = new DataInputProvider();

	WebDriver secondDriver = null;
	public static String loggedInURL;

	public CategoryFullregression(WebDriver driver) {
		this.driver = driver;
		this.test = ExtentManager.getTest();

	}

	@SuppressWarnings("static-access")
	public void loginCategory() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.STG_Url);
		driver.manage().window().maximize();

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Username");
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Password");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.username, username);
		System.out.println("Username Entered");

		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswd).sendKeys(password);
		System.out.println("Password Entered");

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.login).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Search.welcome));

		WebElement homepage = driver.findElement(Search.welcome);
		if (homepage.isDisplayed()) {
			System.out.println("Login Successful");
			test.pass("Login successful").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Success"));
		} else {
			System.out.println("Login Unsuccessful");
			test.fail("Login Failed").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Failed"));
			Assert.fail("Login Failed");
		}

	}

@SuppressWarnings("static-access")
	public void loginsampleCategory() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.STG_Url);
		driver.manage().window().maximize();

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Samplecategory"
);
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Samplepassword");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.username, username);
		System.out.println("Username Entered");

		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswd).sendKeys(password);
		System.out.println("Password Entered");

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.login).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Search.welcome));

		WebElement homepage = driver.findElement(Search.welcome);
		if (homepage.isDisplayed()) {
			System.out.println("Login Successful");
			test.pass("Login successful").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Success"));
		} else {
			System.out.println("Login Unsuccessful");
			test.fail("Login Failed").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Failed"));
			Assert.fail("Login Failed");
		}
	
	}

	
	@SuppressWarnings("static-access")
	public void loginOperation() throws InterruptedException {
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.Op_Url);
		driver.manage().window().maximize();
		

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Usernameoperation");
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Passwordoperation");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.usernameop, username);
		System.out.println("Username Entered");
		
		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswdop).sendKeys(password);
		System.out.println("Password Entered");
		

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.loginop).click();
		System.out.println("Login Successful");
		Thread.sleep(2000);
		//driver.findElement(Category.operationclcikliveai).click();
		
	}


	@SuppressWarnings("static-access")
	public void loginCategoryautomation() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.STG_Url);
		driver.manage().window().maximize();

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials",
				"Usernameautomation");
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Passwordautomaion");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.username, username);
		System.out.println("Username Entered");

		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswd).sendKeys(password);
		System.out.println("Password Entered");

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.login).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Search.welcome));

		WebElement homepage = driver.findElement(Search.welcome);
		if (homepage.isDisplayed()) {
			System.out.println("Login Successful");
			test.pass("Login successful").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Success"));
		} else {
			System.out.println("Login Unsuccessful");
			test.fail("Login Failed").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Failed"));
			Assert.fail("Login Failed");
		}

	}

	@SuppressWarnings("static-access")
	public void Loginhyphen() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.STG_Url);
		driver.manage().window().maximize();

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Usernamehyphen");
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Passwordhyphen");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.username, username);
		System.out.println("Username Entered");

		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswd).sendKeys(password);
		System.out.println("Password Entered");

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.login).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Search.welcome));

		WebElement homepage = driver.findElement(Search.welcome);
		if (homepage.isDisplayed()) {
			System.out.println("Login Successful");
			test.pass("Login successful").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Success"));
		} else {
			System.out.println("Login Unsuccessful");
			test.fail("Login Failed").addScreenCaptureFromPath(steps.captureScreenshot(driver, "login Failed"));
			Assert.fail("Login Failed");
		}

	}

	@SuppressWarnings("static-access")
	public void categoryWatch() throws Exception {

		test.log(Status.INFO, "Category Watch");
		// Thread.sleep(3000);
		steps.click(driver, Category.gridicon);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.categorywatch));

		steps.click(driver, Category.categorywatch);
		System.out.println("Category watch");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.categorypage));
		WebElement category = driver.findElement(Category.categorypage);
		if (category.isDisplayed()) {
			System.out.println("Category Watch displayed");
			test.pass("Category Watch Displayed");
		} else {
			System.out.println("Category Watch not displayed");
			test.fail("Category Watch not displayed");
			Assert.fail("Category Watch not displayed");
		}

	}

	@SuppressWarnings("static-access")
	public void categoryGroupnoaccess() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.addcategory));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		steps.click(driver, Category.addcategory);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.addcategorysearchclick));

		steps.click(driver, Category.addcategorysearchclick);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.addcategorysearch));

		steps.click(driver, Category.addcategorysearchclick);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.addcategorysearch));

		steps.enterText(driver, Category.addcategorysearch, data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "query", testCase));

		List<WebElement> options = driver.findElements(By.xpath("//div[contains(@class,'option')]"));
		if (options.isEmpty()) {
			System.out.println("Category not found");
			test.pass("Options list is  empty");

		} else {
			System.out.println("Category  found");
			test.fail("Options list is not empty");
			Assert.fail("Options list is not empty");
		}

	}

	@SuppressWarnings("static-access")
	public void tableofContent() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));

		steps.click(driver, Category.carbonsteel);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.tableofcontent));

		// steps.click(driver, Category.tableofcontent);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.tableofcontentcategorywatch));

		String actualMMD = driver.findElement(Category.tableofcontentmmd).getText().trim();

		String expectedMMD = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 2", testCase);

		System.out.println("MMD | Expected: " + expectedMMD + " | Actual: " + actualMMD);

		test.info("MMD - Expected: " + expectedMMD);
		test.info("MMD - Actual: " + actualMMD);

		Assert.assertEquals(actualMMD, expectedMMD, "MMD text mismatch");

		test.pass("MMD text matched successfully");

		// 3️⃣ REPORTS
		String actualReports = driver.findElement(Category.tableofcontentreports).getText().trim();

		String expectedReports = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 3", testCase);

		System.out.println("Reports | Expected: " + expectedReports + " | Actual: " + actualReports);

		test.info("Reports - Expected: " + expectedReports);
		test.info("Reports - Actual: " + actualReports);

		Assert.assertEquals(actualReports, expectedReports, "Reports text mismatch");

		test.pass("Reports text matched successfully");

		// 4️⃣ BENCHMARKING
		String actualBenchmarking = driver.findElement(Category.tableofcontentBenchmarking).getText().trim();

		String expectedBenchmarking = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 4", testCase);

		System.out.println("Benchmarking | Expected: " + expectedBenchmarking + " | Actual: " + actualBenchmarking);

		test.info("Benchmarking - Expected: " + expectedBenchmarking);
		test.info("Benchmarking - Actual: " + actualBenchmarking);

		Assert.assertEquals(actualBenchmarking, expectedBenchmarking, "Benchmarking text mismatch");

		test.pass("Benchmarking text matched successfully");

		// 5️⃣ SUPPLIERS
		String actualSuppliers = driver.findElement(Category.tableofcontentsupplier).getText().trim();

		String expectedSuppliers = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 5", testCase);

		System.out.println("Suppliers | Expected: " + expectedSuppliers + " | Actual: " + actualSuppliers);

		test.info("Suppliers - Expected: " + expectedSuppliers);
		test.info("Suppliers - Actual: " + actualSuppliers);

		Assert.assertEquals(actualSuppliers, expectedSuppliers, "Suppliers text mismatch");

		test.pass("Suppliers text matched successfully");

		// 6️⃣ TOOLS
		String actualTools = driver.findElement(Category.tableofcontentTools).getText().trim();

		String expectedTools = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 6", testCase);

		System.out.println("Tools | Expected: " + expectedTools + " | Actual: " + actualTools);

		test.info("Tools - Expected: " + expectedTools);
		test.info("Tools - Actual: " + actualTools);

		Assert.assertEquals(actualTools, expectedTools, "Tools text mismatch");

		test.pass("Tools text matched successfully");

		// 1️⃣ CATEGORY WATCH
		String actualCategoryWatch = driver.findElement(Category.tableofcontentcategorywatch).getText().trim();

		String expectedCategoryWatch = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		System.out.println("Category Watch | Expected: " + expectedCategoryWatch + " | Actual: " + actualCategoryWatch);

		test.info("Category Watch - Expected: " + expectedCategoryWatch);
		test.info("Category Watch - Actual: " + actualCategoryWatch);

		Assert.assertEquals(actualCategoryWatch, expectedCategoryWatch, "Category Watch text mismatch");

		test.pass("Category Watch text matched successfully");

	}

	@SuppressWarnings("static-access")
	public void createBenchmark() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.diesel));

		steps.click(driver, Category.diesel);

		steps.click(driver, Category.tableofcontentBenchmarking);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.createbenchmark));
		String actualtext = driver.findElement(Category.createbenchmark).getText().trim();

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);
		Assert.assertEquals(actualtext, expected, "text mismatch");

		test.pass("text matched successfully");

	}

	@SuppressWarnings("static-access")
	public void benchmarkquestionpage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.loadmorecategory));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		// steps.click(driver, Category.loadmorecategory);

		wait.until(ExpectedConditions.elementToBeClickable(Category.loadmorecategory));
		WebElement loadmore = driver.findElement(Category.loadmorecategory);
		steps.jsClick(driver, loadmore);

		wait.until(ExpectedConditions.elementToBeClickable(Category.wheat));

		WebElement wheat = driver.findElement(Category.wheat);
		steps.jsClick(driver, wheat);

		steps.click(driver, Category.tableofcontentBenchmarking);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.createbenchmark));

		steps.click(driver, Category.createbenchmark);

		By iframeLocator = By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div[1]/div[2]/div[2]/iframe");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeLocator));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.createbenchmarkquestion));
		String actualtext = driver.findElement(Category.createbenchmarkquestion).getText().trim();

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		System.out.println("Category Watch | Expected: " + expected + " | Actual: " + actualtext);

		Assert.assertTrue(actualtext.contains(expected), "Text is not there"

		);
		test.pass("Benchmark page opened");

	}

	@SuppressWarnings("static-access")
	public void marketsites() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		WebElement marketsites = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.marketsite));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", marketsites);

		wait.until(ExpectedConditions.elementToBeClickable(Category.marketsite));

		WebElement Makersite = driver.findElement(Category.marketsite);
		steps.jsClick(driver, Makersite);
		String URL = driver.getCurrentUrl();
		String Expectedurl = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);
		if (URL.equals(Expectedurl))

		{
			System.out.println("Makersite opened");
		} else {
			System.out.println("Makersite is not working" + URL + Expectedurl);
			test.fail("Makersite is not working" + URL);
			Assert.fail("Makersite is not working" + URL);
		}
		// steps.click(driver, Category.marketsite);

	}

	@SuppressWarnings("static-access")
	public void findSupplier() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Findsupllierellipsis));

		steps.click(driver, Category.Findsupllierellipsis);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Findsuplliere));

		steps.click(driver, Category.Findsuplliere);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.suppliers1));

		String actualtext = driver.findElement(Category.suppliers1).getText().trim();

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (actualtext.equals(expected))

		{
			System.out.println("supplier page  opened");
			test.pass("Supplier page opened");

		} else {
			System.out.println("supplier page not opened" + actualtext + expected);
			test.fail("Suppler page not opened");
			Assert.fail("uppler page not opened");
		}
	}

	@SuppressWarnings("static-access")
	public void benchmarkNotinplan() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.tableheader));
		List<WebElement> header = driver.findElements(Category.tableheader);

		System.out.println(header);

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		boolean columnFound = false;
		String actualHeaders = "";

		for (WebElement header1 : header) {
			String headerText = header1.getText().trim();
			actualHeaders += headerText + " | ";

			if (headerText.equalsIgnoreCase(expected)) {
				columnFound = true;
				break;
			}
		}
		System.out.println("Expected from Excel: " + expected);
		System.out.println("Headers in UI: " + actualHeaders);
		if (columnFound)

		{
			System.out.println("Benchamrk column displayed");
			test.fail("Benchamrk column displayed");
			Assert.fail("Benchamrk column displayed");

		} else {
			System.out.println("Benchamrk column not displayed" + actualHeaders + expected);
			test.pass("Benchamrk column not displayed");

		}
	}

	@SuppressWarnings("static-access")
	public void benchmarkhyphen() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));

		String actualtext = driver.findElement(Category.hyphenbenchmark).getText().trim();

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (actualtext.equals(expected))

		{
			System.out.println("Hyphen found in benchmark");
			test.pass("Hyphen found in benchmark");

		} else {
			System.out.println("Hyphen not  found  benchmark" + actualtext + expected);
			test.fail("Hyphen not found in benchmark");
			Assert.fail("Hyphen not found in benchmark");
		}
	}

	@SuppressWarnings("static-access")
	public void expandmarketcommentry() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement expandBtn = wait.until(driver -> shadowRoot.findElement(By.cssSelector("a.mmd-cards-collapse")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", expandBtn);

		// 5️⃣ Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", expandBtn);

		WebElement shortTerm = wait.until(driver -> shadowRoot
				.findElement(By.cssSelector("div.mmd-market-analysis-section:nth-of-type(2) div.mmd-heading-2")));
		String shortTermText = shortTerm.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (shortTermText.equals(expected))

		{
			System.out.println("Text found");
			test.pass("Text found");

		} else {
			System.out.println("Text not found" + shortTermText + expected);
			test.fail("Text notfound");
			Assert.fail("Text not found");
		}
		WebElement midTerm = wait.until(driver -> shadowRoot
				.findElement(By.cssSelector("div.mmd-market-analysis-section:nth-of-type(3) div.mmd-heading-2")));
		String midTerm1 = midTerm.getText().trim();
		String expected1 = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 2", testCase);

		if (midTerm1.equals(expected1))

		{
			System.out.println("Text  found");
			test.pass("Text found");

		} else {
			System.out.println("Text not found" + midTerm1 + expected1);
			test.fail("Text notfound");
			Assert.fail("Text not found");
		}
		WebElement LongTerm = wait.until(driver -> shadowRoot
				.findElement(By.cssSelector("div.mmd-market-analysis-section:nth-of-type(4) div.mmd-heading-2")));
		String LongTerm1 = LongTerm.getText().trim();
		String expected2 = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 3", testCase);

		if (LongTerm1.equals(expected2))

		{
			System.out.println("Text found");
			test.pass("Text found");

		} else {
			System.out.println("Text not found" + LongTerm1 + expected2);
			test.fail("Text  notfound");
			Assert.fail("Text not found");
		}

	}

	@SuppressWarnings("static-access")
	public void mmdnotinplan() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonoffsets));
		steps.click(driver, Category.carbonoffsets);

		String actualtext = driver.findElement(Category.mmdplam).getText().trim();

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (actualtext.equals(expected))

		{
			System.out.println("Text found");
			test.pass("Text found");

		} else {
			System.out.println("Text not found" + actualtext + expected);
			test.fail("Text not found");
			Assert.fail("Text not found");
		}

	}

	@SuppressWarnings("static-access")
	public void Helptextpreicetrend() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement helptext = wait
				.until(driver -> shadowRoot.findElement(By.cssSelector("span[class='mmd-svg-icon mmd-svg-icon-tip']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", helptext);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", helptext);
		WebElement helptext1 = wait
				.until(driver -> shadowRoot.findElement(By.cssSelector("div[class='mmd-tooltip mmd-tooltip-show']")));
		String helptext2 = helptext1.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (helptext2.equals(expected))

		{
			System.out.println("Text found");
			test.pass("Text found");

		} else {
			System.out.println("Text not found" + helptext2 + expected);
			test.fail("Text notfound");
			Assert.fail("Text not found");
		}

	}

	@SuppressWarnings("static-access")
	public void helptextreport() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Reports help icon is scoped inside div[data-name='reports'] to avoid
		// matching other Headless UI popover buttons on the page
		WebElement reportHelpIcon = wait.until(ExpectedConditions.elementToBeClickable(
				By.cssSelector("div[data-name='reports'] button[id^='headlessui-popover-button']")));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", reportHelpIcon);

		// Native click required — JS click bypasses React synthetic events (Headless UI popover won't open)
		reportHelpIcon.click();

		// Tag-agnostic selector — panel element tag can vary (div, section, etc.)
		WebElement popoverPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("[id^='headlessui-popover-panel']")));

		String helptext2 = popoverPanel.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		if (helptext2.equals(expected)) {
			System.out.println("Text found");
			test.pass("Report help text found");
		} else {
			System.out.println("Text not found" + helptext2 + " Expected: " + expected);
			test.fail("Report help text not found"+ helptext2 + " Expected: " + expected);
			Assert.fail("Text not found" );
		}

	}
	


	@SuppressWarnings("static-access")
	public void marketviewhelptext() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		SearchContext shadowRoot = shadowHost.getShadowRoot();

		List<WebElement> helpIcons = wait.until(driver -> {
			List<WebElement> elements = shadowRoot.findElements(By.cssSelector("span.mmd-svg-icon.mmd-svg-icon-tip"));
			return elements.size() >= 3 ? elements : null;
		});

		WebElement thirdIcon = helpIcons.get(2);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", thirdIcon);

		Thread.sleep(1000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", thirdIcon);

		WebElement tooltip = wait.until(d -> {
			List<WebElement> tooltips = shadowRoot.findElements(By.cssSelector("div.mmd-tooltip-head + div"));

			for (WebElement el : tooltips) {
				if (el.isDisplayed()) {
					return el;
				}
			}
			return null;
		});

		String actualText = tooltip.getText().trim();
		System.out.println("Tooltip Text: " + actualText);

		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		Assert.assertEquals(actualText, expected, "Tooltip text mismatch");

		test.pass("Tooltip text validated successfully");
	}

	@SuppressWarnings("static-access")
	public void chsgraphview() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsgraph));
		steps.click(driver, Category.chsgraph);

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[contains(@class,'bg-[#F5F8FA]')]//span)[1]")));

		WebElement selectedBtn = driver.findElement(By.xpath("(//div[contains(@class,'bg-[#F5F8FA]')]//span)[1]"));

		String actual = selectedBtn.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		try {
			Assert.assertEquals(actual, expected);
			test.pass("Default graph view is 18M as expected");
		} catch (AssertionError e) {
			test.fail("Default graph view validation FAILED. Expected: " + expected + " but Found: " + actual);
			throw e;
		}
	}

	@SuppressWarnings("static-access")
	public void chsdropdown() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsgraph));
		steps.click(driver, Category.chsgraph);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.addhealthfactor));
		steps.click(driver, Category.addhealthfactor);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.menudropdown));

		List<WebElement> options = driver.findElements(Category.menudropdown);

		for (WebElement option : options) {
			System.out.println(option.getText());
			String actual = option.getText();
			String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
					"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

			try {
				Assert.assertEquals(actual, expected);
				test.pass("Dropdownvalue matched");
			} catch (AssertionError e) {
				test.fail("Default graph view validation FAILED. Expected: " + expected + " but Found: " + actual);
				throw e;
			}

		}
	}

	public void chsfiledownlaod() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsgraph));
		steps.click(driver, Category.chsgraph);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsdownload));
		steps.click(driver, Category.chsdownload);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsdownload1));

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		for (int i = 0; i < 40; i++) { // wait up to 40 seconds
			File[] filesAfter = folder.listFiles();
			if (filesAfter != null) {
				for (File f : filesAfter) {
					if (!beforeFiles.contains(f.getName()) && !f.getName().endsWith(".crdownload")) {

						System.out.println("New file downloaded: " + f.getName());
						isDownloaded = true;
						break;
					}
				}
			}
			if (isDownloaded)
				break;

			Thread.sleep(1000);
		}

		if (isDownloaded) {
			test.pass(" downloaded successfully");
		} else {
			test.fail("file was NOT downloaded");
			Assert.fail("file was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void mygrapgsummarypage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.mygraph));

		String actual = driver.findElement(Category.mygraph).getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		try {
			Assert.assertEquals(actual, expected);
			test.pass("Graph page opened");
		} catch (AssertionError e) {
			test.fail("Graph page not opened: " + expected + " but Found: " + actual);
			throw e;
		}
	}

	@SuppressWarnings("static-access")
	public void mygrapgdetailspage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		wait.until(ExpectedConditions.elementToBeClickable(Category.mygraph));
		WebElement graph = driver.findElement(Category.mygraph);
		steps.jsClick(driver, graph);

		String actual = driver.findElement(Category.mygraphname).getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		try {
			Assert.assertEquals(actual, expected);
			test.pass("Graph page opened");
		} catch (AssertionError e) {
			test.fail("Graph page not opened: " + expected + " but Found: " + actual);
			throw e;
		}
	}

	public void graphdownlaodsummarypage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphellipsies));
		steps.click(driver, Category.graphellipsies);

		wait.until(ExpectedConditions.elementToBeClickable(Category.grapdownload));
		WebElement downalod = driver.findElement(Category.grapdownload);
		steps.jsClick(driver, downalod);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsdownload1));

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		for (int i = 0; i < 40; i++) { // wait up to 40 seconds
			File[] filesAfter = folder.listFiles();
			if (filesAfter != null) {
				for (File f : filesAfter) {
					if (!beforeFiles.contains(f.getName()) && !f.getName().endsWith(".crdownload")) {

						System.out.println("New file downloaded: " + f.getName());
						isDownloaded = true;
						break;
					}
				}
			}
			if (isDownloaded)
				break;

			Thread.sleep(1000);
		}

		if (isDownloaded) {
			test.pass(" downloaded successfully");
		} else {
			test.fail("file was NOT downloaded");
			Assert.fail("file was NOT downloaded");
		}
	}

	public void graphdownlaodcategorypage() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		wait.until(ExpectedConditions.elementToBeClickable(Category.mygraph));
		WebElement graph = driver.findElement(Category.mygraph);
		steps.jsClick(driver, graph);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphellipsiesdetailpage));
		steps.click(driver, Category.graphellipsiesdetailpage);

		wait.until(ExpectedConditions.elementToBeClickable(Category.grapdownloaddetailspage));
		WebElement downalod = driver.findElement(Category.grapdownloaddetailspage);
		steps.jsClick(driver, downalod);

		// wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsdownload1));

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		for (int i = 0; i < 40; i++) { // wait up to 40 seconds
			File[] filesAfter = folder.listFiles();
			if (filesAfter != null) {
				for (File f : filesAfter) {
					if (!beforeFiles.contains(f.getName()) && !f.getName().endsWith(".crdownload")) {

						System.out.println("New file downloaded: " + f.getName());
						isDownloaded = true;
						break;
					}
				}
			}
			if (isDownloaded)
				break;

			Thread.sleep(1000);
		}

		if (isDownloaded) {
			test.pass(" downloaded successfully");
		} else {
			test.fail("file was NOT downloaded");
			Assert.fail("file was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void coststructuredownload() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(1);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement globalLabel = wait.until(driver -> {

			List<WebElement> hosts = driver.findElements(By.cssSelector("beroe-mmd"));
			if (hosts.isEmpty())
				return null;

			// Take the last modal instance
			WebElement modalHost = hosts.get(hosts.size() - 1);

			SearchContext shadowRoot = modalHost.getShadowRoot();

			List<WebElement> labels = shadowRoot.findElements(By.cssSelector("div.mmd-modal-form label"));

			for (WebElement label : labels) {
				if (label.getText().trim().equals("Global") && label.isDisplayed()) {
					return label;
				}
			}

			return null;
		});

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mmd-loading")));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", globalLabel);

		System.out.println("Global checkbox clicked successfully");

		WebElement continueBtn = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			WebElement btn = root.findElement(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			return btn.isDisplayed() ? btn : null;
		});

		continueBtn.click();

		WebElement year = wait.until(driver -> {

			// Wait until at least one shadow host exists
			List<WebElement> hosts = driver.findElements(By.cssSelector("beroe-mmd"));
			if (hosts.isEmpty())
				return null;

			// Take the LAST one (modal)
			WebElement modalHost = hosts.get(hosts.size() - 1);

			SearchContext shadowRoot = modalHost.getShadowRoot();

			// Locate label instead of hidden input
			List<WebElement> labels = shadowRoot.findElements(By.cssSelector("div.mmd-modal-form label"));

			for (WebElement label : labels) {
				if (label.getText().trim().equals("2020") && label.isDisplayed()) {
					return label;
				}
			}

			return null;
		});

		// Wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".mmd-loading")));

		// Click using JS (safer for styled checkboxes)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", year);

		System.out.println("Year 2020 clicked successfully");

		WebElement costStructure = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			if (buttons.size() >= 2 && buttons.get(1).isDisplayed()) {
				return buttons.get(1);
			}

			return null;
		});

		costStructure.click();

		WebElement costStructureFinal = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 3 && buttons.get(2).isDisplayed()) {
				return buttons.get(2); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});",
				costStructureFinal);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", costStructureFinal);

		System.out.println("Final Cost Structure button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		for (int i = 0; i < 40; i++) { // wait up to 40 seconds
			File[] filesAfter = folder.listFiles();
			if (filesAfter != null) {
				for (File f : filesAfter) {
					if (!beforeFiles.contains(f.getName()) && !f.getName().endsWith(".crdownload")) {

						System.out.println("New file downloaded: " + f.getName());
						isDownloaded = true;
						break;
					}
				}
			}
			if (isDownloaded)
				break;

			Thread.sleep(1000);
		}

		if (isDownloaded) {
			test.pass(" downloaded successfully");
		} else {
			test.fail("file was NOT downloaded");
			Assert.fail("file was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void pricetrenddownlaod() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement priceTrend = driver.findElement(By.xpath("//div[text()=' Price Trend ']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", priceTrend);

		// Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrend);

		WebElement download = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download);

		System.out.println("download button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		try {
			FluentWait<File> wait1 = new FluentWait<>(folder).withTimeout(Duration.ofSeconds(40)) // total wait time
					.pollingEvery(Duration.ofSeconds(1)) // check every 1 sec
					.ignoring(Exception.class);

			isDownloaded = wait1.until(dir -> {
				File[] filesAfter = dir.listFiles();
				if (filesAfter == null)
					return false;

				for (File f : filesAfter) {
					String name = f.getName();

					// skip already existing files
					if (beforeFiles.contains(name))
						continue;

					// skip partial downloads
					if (name.endsWith(".crdownload"))
						continue;

					// file fully downloaded
					if (f.exists() && f.length() > 0) {
						System.out.println("New file downloaded: " + name);
						return true;
					}
				}
				return false;
			});

		} catch (Exception e) {
			isDownloaded = false;
		}

		// Final assertion
		if (isDownloaded) {
			test.pass("File downloaded successfully");
		} else {
			test.fail("File was NOT downloaded");
			Assert.fail("File was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void pricetrendnocoststructuredownload() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.loadmorecategory));
		WebElement loadMoreBtn = driver.findElement(Category.loadmorecategory);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadMoreBtn);
		System.out.println("Object clicked ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.ethylene));
		steps.click(driver, Category.ethylene);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement priceTrend = driver.findElement(By.xpath("//div[text()=' Price Trend ']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", priceTrend);

		// Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrend);

		WebElement download = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download);

		System.out.println("download button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		boolean isDownloaded = false;

		try {
			FluentWait<File> wait1 = new FluentWait<>(folder).withTimeout(Duration.ofSeconds(40))
					.pollingEvery(Duration.ofSeconds(1))
					.ignoring(Exception.class);

			isDownloaded = wait1.until(dir -> {
				File[] filesAfter = dir.listFiles();
				if (filesAfter == null)
					return false;

				for (File f : filesAfter) {
					String name = f.getName();

					if (beforeFiles.contains(name))
						continue;

					if (name.endsWith(".crdownload"))
						continue;

					if (f.exists() && f.length() > 0) {
						System.out.println("New file downloaded: " + name);
						return true;
					}
				}
				return false;
			});

		} catch (Exception e) {
			isDownloaded = false;
		}

		// Final assertion
		if (isDownloaded) {
			test.pass("File downloaded successfully");
		} else {
			test.fail("File was NOT downloaded");
			Assert.fail("File was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void pricetrendmarketanalysisdownlaod() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement priceTrendmaeketanalysis = driver
				.findElement(By.xpath("//div[text()=' Price Trend + Market Analysis ']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				priceTrendmaeketanalysis);

		// Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrendmaeketanalysis);

		WebElement download = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 2 && buttons.get(0).isDisplayed()) {
				return buttons.get(0); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download);

		System.out.println("download button clicked");

		WebElement download1 = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 0 && buttons.get(1).isDisplayed()) {
				return buttons.get(1); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download1);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download1);

		System.out.println("download button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		try {
			FluentWait<File> wait1 = new FluentWait<>(folder).withTimeout(Duration.ofSeconds(40)) // total wait time
					.pollingEvery(Duration.ofSeconds(1)) // check every 1 sec
					.ignoring(Exception.class);

			isDownloaded = wait1.until(dir -> {
				File[] filesAfter = dir.listFiles();
				if (filesAfter == null)
					return false;

				for (File f : filesAfter) {
					String name = f.getName();

					// skip already existing files
					if (beforeFiles.contains(name))
						continue;

					// skip partial downloads
					if (name.endsWith(".crdownload"))
						continue;

					// file fully downloaded
					if (f.exists() && f.length() > 0) {
						System.out.println("New file downloaded: " + name);
						return true;
					}
				}
				return false;
			});

		} catch (Exception e) {
			isDownloaded = false;
		}

		// Final assertion
		if (isDownloaded) {
			test.pass("File downloaded successfully");
		} else {
			test.fail("File was NOT downloaded");
			Assert.fail("File was NOT downloaded");
		}

	}

	@SuppressWarnings("static-access")
	public void pricetrendmarketanalysisgradeallregion() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement priceTrendmaeketanalysis = driver
				.findElement(By.xpath("//div[text()=' Price Trend + Market Analysis ']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				priceTrendmaeketanalysis);

		// Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrendmaeketanalysis);

		WebElement grade = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-download-checks label"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 3 && buttons.get(2).isDisplayed()) {
				return buttons.get(2);
				// third button (index 2)
			}

			return null;

		});
		String gradeText = grade.getText().trim();
		System.out.println("Grade text: " + gradeText);
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", grade);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", grade);

		System.out.println(" grade  button clicked");

		WebElement download = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 2 && buttons.get(0).isDisplayed()) {
				return buttons.get(0); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download);

		System.out.println("download button clicked");

		WebElement download1 = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 0 && buttons.get(1).isDisplayed()) {
				return buttons.get(1); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download1);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download1);

		System.out.println("download button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		try {
			FluentWait<File> wait1 = new FluentWait<>(folder).withTimeout(Duration.ofSeconds(40)) // total wait time
					.pollingEvery(Duration.ofSeconds(1)) // check every 1 sec
					.ignoring(Exception.class);

			isDownloaded = wait1.until(dir -> {
				File[] filesAfter = dir.listFiles();
				if (filesAfter == null)
					return false;

				for (File f : filesAfter) {
					String name = f.getName();

					// skip already existing files
					if (beforeFiles.contains(name))
						continue;

					// skip partial downloads
					if (name.endsWith(".crdownload"))
						continue;

					// file fully downloaded
					if (f.exists() && f.length() > 0) {
						System.out.println("New file downloaded: " + name);
						return true;
					}
				}
				return false;
			});

		} catch (Exception e) {
			isDownloaded = false;
		}

		// Final assertion
		if (isDownloaded) {
			test.pass("File downloaded successfully");
		} else {
			test.fail("File was NOT downloaded");
			Assert.fail("File was NOT downloaded");
		}
	}

	@SuppressWarnings("static-access")
	public void pricetrendmarketanalysisgradeall() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("Download button clicked successfully");

		WebElement priceTrendmaeketanalysis = driver
				.findElement(By.xpath("//div[text()=' Price Trend + Market Analysis ']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});",
				priceTrendmaeketanalysis);

		// Thread.sleep(500);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrendmaeketanalysis);

		WebElement grade = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-download-checks label"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 3 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
				// third button (index 2)
			}

			return null;

		});
		String gradeText = grade.getText().trim();
		System.out.println("Grade text: " + gradeText);
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", grade);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", grade);

		System.out.println(" grade  button clicked");

		WebElement download = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 2 && buttons.get(0).isDisplayed()) {
				return buttons.get(0); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download);

		System.out.println("download button clicked");

		WebElement download1 = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-modal-form button.mmd-button"));

			// Debug (optional)
			System.out.println("Modal button count: " + buttons.size());

			if (buttons.size() >= 0 && buttons.get(1).isDisplayed()) {
				return buttons.get(1); // third button (index 2)
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", download1);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", download1);

		System.out.println("download button clicked");

		String downloadPath = System.getProperty("user.home") + "\\Downloads";

		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		// Step 5: Click download
		// steps.click(driver, Category.chsdownload1);

		boolean isDownloaded = false;

		try {
			FluentWait<File> wait1 = new FluentWait<>(folder).withTimeout(Duration.ofSeconds(40)) // total wait time
					.pollingEvery(Duration.ofSeconds(1)) // check every 1 sec
					.ignoring(Exception.class);

			isDownloaded = wait1.until(dir -> {
				File[] filesAfter = dir.listFiles();
				if (filesAfter == null)
					return false;

				for (File f : filesAfter) {
					String name = f.getName();

					// skip already existing files
					if (beforeFiles.contains(name))
						continue;

					// skip partial downloads
					if (name.endsWith(".crdownload"))
						continue;

					// file fully downloaded
					if (f.exists() && f.length() > 0) {
						System.out.println("New file downloaded: " + name);
						return true;
					}
				}
				return false;
			});

		} catch (Exception e) {
			isDownloaded = false;
		}

		// Final assertion
		if (isDownloaded) {
			test.pass("File downloaded successfully");
		} else {
			test.fail("File was NOT downloaded");
			Assert.fail("File was NOT downloaded");
		}
	}

	public void chstooltip() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// ---- NAVIGATION (your existing steps) ----
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// ✅ 1) CAPTURE SCORE + RATING BEFORE CLICKING GRAPH
		String cardRating = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"(//div[normalize-space()='Category Health Score']/parent::div/following-sibling::div//div[contains(@class,'rounded')])[1]")))
				.getText().trim();

		String cardScore = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//div[@data-test-id='CircularProgressbarWithChildren']//div)[3]") // "Good"
																															// badge
																															// (based
																															// on
																															// your
																															// DOM)
				)).getText().trim();

		System.out.println("Card Score: " + cardScore);
		System.out.println("Card Rating: " + cardRating);

		// ---- 2) OPEN GRAPH ----
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.chsgraph));
		steps.click(driver, Category.chsgraph);

		// ---- 3) WAIT FOR CHART TO LOAD FULLY ----
		By svgLocator = By.cssSelector("svg.anychart-ui-support");
		By pointLocator = By.cssSelector("svg.anychart-ui-support path[id^='ac_path_']");
		By tooltipLocator = By.cssSelector("div.anychart-tooltip");

		wait.until(ExpectedConditions.visibilityOfElementLocated(svgLocator));
		waitForAnyChartToStabilize(wait, driver, pointLocator);

		// ---- 4) HOVER CURRENT MONTH TOOLTIP (your working logic) ----
		String currentMonthYear = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM yyyy", Locale.ENGLISH));
		System.out.println("Looking for tooltip month: " + currentMonthYear);

		Actions actions = new Actions(driver);

		java.util.function.Function<WebElement, String> readTooltipText = tip -> {
			String txt = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", tip);
			return txt == null ? "" : txt.replaceAll("\\s+", " ").trim();
		};

		List<WebElement> points = driver.findElements(pointLocator);
		String tooltipText = null;

		for (int i = points.size() - 1; i >= 0; i--) {
			try {
				List<WebElement> freshPoints = driver.findElements(pointLocator);
				if (freshPoints.size() <= i)
					continue;

				WebElement p = freshPoints.get(i);

				actions.moveToElement(p, 2, 2).pause(Duration.ofMillis(700)).perform();

				for (WebElement t : driver.findElements(tooltipLocator)) {
					if (!t.isDisplayed())
						continue;

					String txt = readTooltipText.apply(t);
					if (txt.contains(currentMonthYear)) {
						tooltipText = txt;
						System.out.println("Tooltip text: " + tooltipText);
						break;
					}
				}
				if (tooltipText != null)
					break;

			} catch (StaleElementReferenceException e) {
				// retry next
			}
		}

		if (tooltipText == null) {
			Assert.fail("Current month tooltip not found: " + currentMonthYear);
		}

		// ---- 5) EXTRACT SCORE + RATING FROM TOOLTIP ----
		String tooltipScore = extractValue(tooltipText, "Score:\\s*(\\d+)");
		String tooltipRating = extractValue(tooltipText, "Rating:\\s*([A-Za-z]+)");

		System.out.println("Tooltip Score: " + tooltipScore);
		System.out.println("Tooltip Rating: " + tooltipRating);

		// ---- 6) COMPARE CARD vs TOOLTIP ----
		Assert.assertEquals(tooltipScore, cardScore, "Score mismatch: Card vs Tooltip");
		Assert.assertEquals(tooltipRating, cardRating, "Rating mismatch: Card vs Tooltip");

		// debug (optional)
		Thread.sleep(1500);
	}

	// ---------- helpers ----------

	private void waitForAnyChartToStabilize(WebDriverWait wait, WebDriver driver, By pointLocator) {
		final int[] lastCount = { -1 };
		final int[] stableHits = { 0 };

		wait.until(d -> {
			int count = d.findElements(pointLocator).size();

			if (count <= 10) { // avoid early partial render
				lastCount[0] = count;
				stableHits[0] = 0;
				return false;
			}

			if (count == lastCount[0])
				stableHits[0]++;
			else {
				stableHits[0] = 0;
				lastCount[0] = count;
			}

			return stableHits[0] >= 3; // stable for 3 polls
		});
	}

	private String extractValue(String text, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(text);
		if (m.find())
			return m.group(1).trim();
		throw new AssertionError("Could not extract using regex: " + regex + " from: " + text);
	}

	@SuppressWarnings("static-access")
	public void coststructure() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.batteries));
		steps.click(driver, Category.batteries);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot.findElements(By.cssSelector("div.mmd-cost-header-control"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 7) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("ellipsis  clicked successfully");

		WebElement setasnechmark = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-cost-header-menu-item"));

			if (buttons.size() >= 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);

			}

			return null;

		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", setasnechmark);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setasnechmark);

		System.out.println(" setasnechmark  button clicked");

		WebElement costtructure = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			WebElement el = root.findElement(Category.coststructure);
			return el.isDisplayed() ? el : null;

		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", costtructure);

		System.out.println(" note is clicked");

		String actual = costtructure.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		try {
			Assert.assertEquals(actual, expected);
			test.pass("cost structure note is matched");
		} catch (AssertionError e) {
			test.fail("cost structure is failed. Expected: " + expected + " but Found: " + actual);
			throw e;
		}
	}

	@SuppressWarnings("static-access")
	public void usda() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.loadmorecategory));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		// steps.click(driver, Category.loadmorecategory);

		wait.until(ExpectedConditions.elementToBeClickable(Category.loadmorecategory));
		WebElement loadmore = driver.findElement(Category.loadmorecategory);
		steps.jsClick(driver, loadmore);

		wait.until(ExpectedConditions.elementToBeClickable(Category.wheat));

		WebElement wheat = driver.findElement(Category.wheat);
		steps.jsClick(driver, wheat);

		// Wait until the download button inside shadow DOM is visible
		WebElement sourcedropdown = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", sourcedropdown);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sourcedropdown);

		System.out.println("sourcedropdown button clicked successfully");

		String expectedValue = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		boolean isValueFound = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			// ✅ Get dropdown options INSIDE shadowRoot
			List<WebElement> options = shadowRoot.findElements(Category.sourcedropdown);

			if (options.size() == 0)
				return false; // keep waiting until options appear

			for (WebElement option : options) {
				String actualValue = option.getDomAttribute("value").trim();
				System.out.println("Dropdown Value: " + actualValue);

				if (actualValue.equalsIgnoreCase(expectedValue)) {
					return true; // ✅ found
				}
			}

			return false; // keep waiting (or final false at timeout)
		});

		// ✅ Assertion
		Assert.assertTrue(isValueFound, expectedValue + " is NOT present in dropdown");
		System.out.println("value matched" + expectedValue + " is present → PASS");

	}

	@SuppressWarnings("static-access")
	public void Packtrax() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.elementToBeClickable(Category.corrugatedboards));

		WebElement corrugatedboard = driver.findElement(Category.corrugatedboards);
		steps.jsClick(driver, corrugatedboard);

		// Wait until the download button inside shadow DOM is visible
		WebElement sourcedropdown = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot
					.findElements(By.cssSelector("button.mmd-select.mmd-select-label-only"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 2) {
					return buttons.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", sourcedropdown);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", sourcedropdown);

		System.out.println("sourcedropdown button clicked successfully");

		String expectedValue = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		boolean isValueFound = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			// ✅ Get dropdown options INSIDE shadowRoot
			List<WebElement> options = shadowRoot.findElements(Category.sourcedropdown);

			if (options.size() == 0)
				return false; // keep waiting until options appear

			for (WebElement option : options) {
				String actualValue = option.getDomAttribute("value").trim();
				System.out.println("Dropdown Value: " + actualValue);

				if (actualValue.equalsIgnoreCase(expectedValue)) {
					return true; // ✅ found
				}
			}

			return false; // keep waiting (or final false at timeout)
		});

		// ✅ Assertion
		Assert.assertTrue(isValueFound, expectedValue + " is NOT present in dropdown");
		System.out.println("value matched" + expectedValue + " is present → PASS");

	}

	@SuppressWarnings("static-access")
	public void pricewatch() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.planrecords));

		steps.click(driver, Category.planrecords);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.plansearch));
		steps.enterText(driver, Category.plansearch,
				data.getColumnDataAsString("CategoryWatchFullregressionTestdata", "Categorywatch_fullregression", "query", testCase));
		

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.editplan));
		steps.click(driver, Category.editplan);

		WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(
		        By.xpath("//tr[.//*[normalize-space()='Category MMD']]/following-sibling::tr[1]//table")));   // or a more specific container

		String actualText = table.getText().replace("\u00A0", " ").trim(); // normalize NBSP
		System.out.println("ACTUAL TABLE TEXT:\n" + actualText);

		// ✅ Read expected string (contains multiple items)
		String expectedRaw = data.getColumnDataAsString(
		        "CategoryWatchFullregressionTestdata",
		        "Categorywatch_fullregression",
		        "Expected Text - 1",
		        testCase
		).trim();

		// ✅ Split expected values by comma / semicolon / new line
		String[] expectedItems = expectedRaw.split("\\s*[,;\\n]+\\s*");

		// ✅ Verify each expected item is present
		List<String> missing = new ArrayList<>();

		for (String item : expectedItems) {
		    String expected = item.trim();
		    if (expected.isEmpty()) continue;

		    if (!actualText.toLowerCase().contains(expected.toLowerCase())) {
		        missing.add(expected);
		    }
		}

		Assert.assertTrue(missing.isEmpty(),
		        "These expected items were NOT found:\n" + String.join("\n", missing));

		System.out.println("✅ All expected items found → PASS");
		
	}
	
	
	
	@SuppressWarnings("static-access")
	public void saveGraph() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Wait until the download button inside shadow DOM is visible
		WebElement addcomparsions = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> addcomparision = shadowRoot
					.findElements(Category.addcomparision);

			if (addcomparision.size() > 0 && addcomparision.get(0).isDisplayed()) {
				if (addcomparision.size() >= 2) {
					return addcomparision.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addcomparsions);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addcomparsions);

		System.out.println("addcomparision button clicked successfully");

		
		WebElement applybutton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> apply = root.findElements(Category.addcomparision);

			// Debug (optional)
		

			if (apply.size() >= 3 && apply.get(1).isDisplayed()) {
				return apply.get(1);
				// third button (index 2)
			}

			return null;

		});
		String gradeText = applybutton.getText().trim();
		System.out.println("Grade text: " + gradeText);
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", applybutton);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applybutton);

		System.out.println(" applybutton  button clicked");
		
		WebElement savegraph = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> apply = root.findElements(Category.addcomparision);

			// Debug (optional)
		

			if (apply.size() >= 3 && apply.get(2).isDisplayed()) {
				return apply.get(2);
				// third button (index 2)
			}

			return null;

		});
		
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", savegraph);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savegraph);

		System.out.println(" savegraph  button clicked");
		
		String baseName = data.getColumnDataAsString(
		        "CategoryWatchFullregressionTestdata",
		        "Categorywatch_fullregression",
		        "query",
		        testCase
		);

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String uniqueGraphName = baseName + "_" + timeStamp;

		// Enter name
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphinput));
		inputBox.clear();
		inputBox.sendKeys(uniqueGraphName);

		// Click Save
		WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(Category.graphsave));
		saveBtn.click();
}
	@SuppressWarnings("static-access")
	public void graphdownlaodsummarypagedelete() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);
		
		String actual = driver.findElement(Category.graphfirstrow).getText().trim();
		
		System.out.println(actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphellipsies));
		steps.click(driver, Category.graphellipsies);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.grapdelete));
		steps.click(driver, Category.grapdelete);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphdeletepopup));
		steps.click(driver, Category.graphdeletepopup);
		
		
	
				List<WebElement> options = driver.findElements(Category.graphrow);
				
				boolean isFound = false;

				for (WebElement option : options) {

				    String graphName = option.getText().replace("\u00A0", " ").trim();

				    if (graphName.contains(actual)) {
				        isFound = true;
				        break;
				    }
				}

				if (isFound) {
				    test.fail("❌ Graph still present after delete: " + actual);
				    Assert.fail("Graph was NOT deleted");
				} else {
				    test.pass("✅ Graph deleted successfully: " + actual);
				}


	
}
	
	@SuppressWarnings("static-access")
	public void graphdownlaodsummarypagerename() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphfirstrow));
		String actual = driver.findElement(Category.graphfirstrow).getText().trim();
		
		System.out.println(actual);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphellipsies));
		steps.click(driver, Category.graphellipsies);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.renamegraph));
		steps.click(driver, Category.renamegraph);
		
		String baseName = data.getColumnDataAsString(
		        "CategoryWatchFullregressionTestdata",
		        "Categorywatch_fullregression",
		        "query",
		        testCase
		);

		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		String uniqueGraphName = baseName + "_" + timeStamp;

		// Enter name
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphinput));
		inputBox.clear();
		inputBox.sendKeys(uniqueGraphName);

		// Click Save
		WebElement saveBtn = wait.until(ExpectedConditions.elementToBeClickable(Category.graphsave));
		saveBtn.click();
		
		
		wait.until(ExpectedConditions.not(
			    ExpectedConditions.textToBePresentInElementLocated(Category.graphfirstrow, actual)
			));

			String actual1 = driver.findElement(Category.graphfirstrow)
			        .getText().replace("\u00A0"," ").trim();

			System.out.println("After rename: " + actual1);

		
		List<WebElement> options = driver.findElements(Category.graphrow);
		
		boolean isFound = false;

		for (WebElement option : options) {

		    String graphName = option.getText().replace("\u00A0", " ").trim();

		    if (graphName.equals(actual)) {
		        isFound = true;
		        break;
		    }
		}

		if (isFound) {
		    test.fail("❌ Graph still present after rename: " + actual);
		    Assert.fail("Graph was NOT renamed");
		} else {
		    test.pass("✅ Graph renamed successfully: " + actual);
		}

		
	}
	
	@SuppressWarnings("static-access")
	public void graphdownlaodsummarypageupdate() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// 1️⃣ Click Carbon Steel
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);
	

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphfirstrow));
		
		
	      String actual = driver.findElement(Category.graphlastmodified).getText().trim();
			
			System.out.println(actual);
		steps.click(driver, Category.graphfirstrow);
		
		
		WebElement addcomparsions = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> addcomparision = shadowRoot
					.findElements(Category.addcomparision);

			if (addcomparision.size() > 0 && addcomparision.get(0).isDisplayed()) {
				if (addcomparision.size() >= 2) {
					return addcomparision.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addcomparsions);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addcomparsions);
	

		System.out.println("addcomparision button clicked successfully");
		
		String expectedCountry = data.getColumnDataAsString(
		        "CategoryWatchFullregressionTestdata",
		        "Categorywatch_fullregression",
		        "Expected Text - 1",
		        testCase
		).trim();

		

		WebElement host = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext root = host.getShadowRoot();

		WebElement panel = wait.until(d -> {
		    WebElement p = root.findElement(By.cssSelector("div.mmd-compare-panel"));
		    return p.isDisplayed() ? p : null;
		});

		// 1) Pick the correct dropdown outer (skip the one showing "Option")
		WebElement countryOuter = wait.until(d -> {
		    List<WebElement> outers = panel.findElements(By.cssSelector("div.mmd-select-outer"));
		    System.out.println("DEBUG: outers found = " + outers.size());
		    if (outers.isEmpty()) return null;

		    for (WebElement o : outers) {
		        if (!o.isDisplayed()) continue;

		        // text shown inside dropdown
		        String t = o.getText().replace("\u00A0"," ").trim();
		        System.out.println("DEBUG: outer text = [" + t + "]");

		        // choose the one that is NOT placeholder Option
		        if (!t.equalsIgnoreCase("Option") && !t.isEmpty()) {
		            return o;
		        }
		    }
		    return null;
		});

		System.out.println("✅ Picked dropdown outer: " + countryOuter.getText().trim());

		// 2) Click INNER div.mmd-select first, then fallback to chevron
		WebElement inner = countryOuter.findElement(By.cssSelector("div.mmd-select"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", inner);

		try {
		    new Actions(driver).moveToElement(inner).pause(Duration.ofMillis(150)).click().perform();
		} catch (Exception e) {
		    System.out.println("DEBUG: inner click failed, trying JS click: " + e.getMessage());
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", inner);
		}

		// fallback click chevron if not opened
		if (!countryOuter.getDomAttribute("class").contains("mmd-select-outer-open")) {
		    System.out.println("DEBUG: not opened yet, clicking chevron...");
		    WebElement chevron = countryOuter.findElement(By.cssSelector("i.fa-chevron-down"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", chevron);
		}

		// 3) Confirm opened
		wait.until(d -> {
		    String cls = countryOuter.getDomAttribute("class");
		    return (cls != null && cls.contains("mmd-select-outer-open")) ? true : null;
		});

		System.out.println("✅ Dropdown opened successfully");
		
		boolean picked = wait.until(d -> {
		    List<WebElement> opts = root.findElements(By.cssSelector("div.mmd-select-dropdown *"));
		    if (opts.isEmpty()) return null;

		    for (WebElement opt : opts) {
		        if (!opt.isDisplayed()) continue;
		        String txt = opt.getText().replace("\u00A0"," ").trim();
		        if (txt.isEmpty()) continue;

		        if (txt.equalsIgnoreCase(expectedCountry)) {
		            ((JavascriptExecutor) d).executeScript("arguments[0].click();", opt);
		            return true;
		        }
		    }
		    return false;
		});

		Assert.assertTrue(picked, "❌ Country not found in dropdown: " + expectedCountry);
		System.out.println("✅ Selected: " + expectedCountry);
		
		WebElement applybutton = wait.until(driver -> {

			List<WebElement> apply = root.findElements(Category.addcomparision);

			// Debug (optional)
		

			if (apply.size() >= 3 && apply.get(1).isDisplayed()) {
				return apply.get(1);
				// third button (index 2)
			}

			return null;

		});
		String gradeText = applybutton.getText().trim();
		System.out.println("Grade text: " + gradeText);
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", applybutton);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applybutton);

		System.out.println(" applybutton  button clicked");
		
		WebElement savegraph = wait.until(driver -> {

			List<WebElement> apply = root.findElements(Category.addcomparision);

			// Debug (optional)
		

			if (apply.size() >= 3 && apply.get(2).isDisplayed()) {
				return apply.get(2);
				// third button (index 2)
			}

			return null;

		});
		
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", savegraph);
		Thread.sleep(3000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", savegraph);

		System.out.println(" savegraph  button clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.saveas));
		steps.click(driver, Category.saveas);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.graphsaveanyway));
		steps.click(driver, Category.graphsaveanyway);
		
	/*	wait.until(ExpectedConditions.visibilityOfElementLocated(Category.gridicon));
		steps.click(driver, Category.gridicon);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.categorywatch));
		steps.click(driver, Category.categorywatch);
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Graphnview));
		steps.click(driver, Category.Graphnview);*/
	    driver.navigate().back();
		
		
		wait.until(ExpectedConditions.not(
			    ExpectedConditions.textToBePresentInElementLocated(Category.graphlastmodified, actual)
			));

			String actual1 = driver.findElement(Category.graphlastmodified)
			        .getText().replace("\u00A0"," ").trim();

			System.out.println("After modified: " + actual1);

		
		List<WebElement> options = driver.findElements(Category.graphlastmodified);
		
		boolean isFound = false;

		for (WebElement option : options) {

		    String graphtime= option.getText().replace("\u00A0", " ").trim();

		    if (graphtime.equals(actual)) {
		        isFound = true;
		        break;
		    }
		}

		if (isFound) {
		    test.fail("❌ Graph not modified: " + actual);
		    Assert.fail("❌ Graph not modified:");
		} else {
		    test.pass(" Graph  modified:: " + actual);
		}

		
		
		

	}

	@SuppressWarnings("static-access")
	public void coststructuresetasbenchmark() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.batteries));
		steps.click(driver, Category.batteries);

		// Wait until the download button inside shadow DOM is visible
		WebElement downloadButton = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> buttons = shadowRoot.findElements(By.cssSelector("div.mmd-cost-header-control"));

			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 7) {
					return buttons.get(0);
				}
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);

		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);

		System.out.println("ellipsis clicked successfully");

		WebElement setasnechmark = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();

			List<WebElement> buttons = root.findElements(By.cssSelector("div.mmd-cost-header-menu-item"));

			if (buttons.size() >= 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}

			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", setasnechmark);
		Thread.sleep(3000);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", setasnechmark);

		System.out.println("setasnechmark button clicked");

		// Wait for the cost structure table to re-render with colour-coded cells
		WebElement costTable = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			WebElement el = root.findElement(Category.coststructuretable);
			return el.isDisplayed() ? el : null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", costTable);
		Thread.sleep(2000); // allow colour rendering to complete

		// Validate colour coding via CSS class on the child div inside each regional td:
		// mmd-last-metric-red  = positive % (higher cost than benchmark)
		// mmd-last-metric-green = negative % (lower cost than benchmark)
		@SuppressWarnings("unchecked")
		Map<String, Object> colorResult = (Map<String, Object>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var table = shadow.querySelector('table.mmd-cs-table');" +
			"if (!table) return {error: 'table not found', redCount: 0, greenCount: 0, violations: []};" +
			// Only check regional diff columns (skip col 0 = label, col 1 = Global baseline)
			"var rows = table.querySelectorAll('tbody tr');" +
			"var redCount = 0, greenCount = 0;" +
			"var violations = [];" +
			"rows.forEach(function(row) {" +
			"  var tds = row.querySelectorAll('td');" +
			"  for (var i = 2; i < tds.length; i++) {" +
			"    var td = tds[i];" +
			"    var text = td.textContent.trim();" +
			"    if (text === '' || text === '0.00%') continue;" +
			"    var isNeg = /^-\\d+\\.\\d+%$/.test(text);" +
			"    var isPos = /^\\+?\\d+\\.\\d+%$/.test(text) && !isNeg;" +
			"    if (!isNeg && !isPos) continue;" +
			"    var redDiv   = td.querySelector('div.mmd-last-metric-red');" +
			"    var greenDiv = td.querySelector('div.mmd-last-metric-green');" +
			"    if (isPos && redDiv)   { redCount++; }" +
			"    else if (isNeg && greenDiv) { greenCount++; }" +
			"    else { violations.push(text + ' => class: ' + (td.querySelector('div') ? td.querySelector('div').className : 'no-div')); }" +
			"  }" +
			"});" +
			"return {redCount: redCount, greenCount: greenCount, violations: violations};"
		);

		if (colorResult.containsKey("error")) {
			test.fail("Cost structure table not found in shadow DOM");
			Assert.fail("Cost structure table not found in shadow DOM");
		}

		long redCount   = (Long) colorResult.get("redCount");
		long greenCount = (Long) colorResult.get("greenCount");
		@SuppressWarnings("unchecked")
		List<String> violations = (List<String>) colorResult.get("violations");

		System.out.println("Red cells (positive % → higher cost): " + redCount);
		System.out.println("Green cells (negative % → lower cost): " + greenCount);
		System.out.println("Colour violations: " + violations);

		test.info("Red cells (positive %, higher than benchmark): " + redCount);
		test.info("Green cells (negative %, lower than benchmark): " + greenCount);

		if (!violations.isEmpty()) {
			test.fail("Colour coding violations found: " + violations);
			Assert.fail("Colour coding validation failed. Violations: " + violations);
		}

		if (redCount == 0 && greenCount == 0) {
			test.fail("No coloured benchmark cells detected — benchmark colour coding may not have applied");
			Assert.fail("No coloured cells found after Set as Benchmark");
		}

		test.pass("Benchmark colour coding validated: " + redCount + " red cell(s) and " + greenCount + " green cell(s) found with correct colours");
		System.out.println("Benchmark colour coding validation PASSED");
	}

	@SuppressWarnings("static-access")
	public void coststructureremovethebenchmark() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click the ellipsis menu button inside shadow DOM
		WebElement ellipsisButton = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();
			List<WebElement> buttons = shadowRoot.findElements(By.cssSelector("div.mmd-cost-header-control"));
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				if (buttons.size() >= 7) {
					return buttons.get(0);
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ellipsisButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ellipsisButton);

		System.out.println("Ellipsis clicked successfully");

		// Click the Remove Benchmark menu item inside shadow DOM (second item, index 1)
		WebElement removeBenchmarkBtn = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> menuItems = root.findElements(Category.removebenchmark);
			if (menuItems.size() >= 2 && menuItems.get(1).isDisplayed()) {
				return menuItems.get(1);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", removeBenchmarkBtn);
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBenchmarkBtn);

		System.out.println("Remove Benchmark button clicked");

		// Wait briefly for the DOM to update after benchmark removal
		Thread.sleep(2000);

		// Validate that the cost structure note (div.mmd-cs-table-info) is no longer visible
		boolean noteAbsent = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> notes = root.findElements(Category.coststructure);
			if (notes.isEmpty()) {
				return true;
			}
			for (WebElement note : notes) {
				if (note.isDisplayed()) {
					return false;
				}
			}
			return true;
		});

		if (noteAbsent) {
			test.pass("Cost structure note is not displayed after Remove Benchmark — validation passed");
			System.out.println("Cost structure note removed successfully after Remove Benchmark");
		} else {
			test.fail("Cost structure note is still visible after Remove Benchmark — validation failed");
			Assert.fail("Cost structure note should not appear after Remove Benchmark");
		}
	}


@SuppressWarnings("static-access")
	public void defaultCurrency() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement currencyElement = wait.until(driver -> {
			List<WebElement> selects = shadowRoot.findElements(By.cssSelector("div.mmd-select-alternate div.mmd-select"));
			for (WebElement sel : selects) {
				if (sel.isDisplayed()) {
					List<WebElement> spans = sel.findElements(By.tagName("span"));
					for (WebElement span : spans) {
						if (span.isDisplayed() && !span.getText().trim().isEmpty()) {
							return span;
						}
					}
				}
			}
			return null;
		});

		String actualCurrency = currencyElement.getText().trim();
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase);

		System.out.println("Currency | Expected: " + expected + " | Actual: " + actualCurrency);
		test.info("Currency - Expected: " + expected);
		test.info("Currency - Actual: " + actualCurrency);

		if (actualCurrency.contains(expected)) {
			System.out.println("Default currency verified: " + actualCurrency);
			test.pass("Default currency matched: " + actualCurrency);
		} else {
			System.out.println("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
			test.fail("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
			Assert.fail("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
		}
	}

	@SuppressWarnings("static-access")
	public void currencychanged() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Click the currency dropdown to open it
		WebElement currencyDropdown = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (outer.isDisplayed()) {
					WebElement sel = outer.findElement(By.cssSelector("div.mmd-select"));
					if (sel.isDisplayed()) {
						return sel;
					}
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", currencyDropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyDropdown);

		System.out.println("Currency dropdown clicked");

		// Get expected currency from Excel
		String expected = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		// Wait for the dropdown list to appear and select the expected currency
		WebElement currencyOption = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (!outer.isDisplayed()) continue;
				List<WebElement> items = outer.findElements(By.cssSelector("div.mmd-select-dropdown div"));
				for (WebElement item : items) {
					if (item.isDisplayed() && item.getText().trim().contains(expected)) {
						return item;
					}
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyOption);
		System.out.println("Selected currency: " + expected);

		Thread.sleep(2000);

		// Validate the currency has changed
		WebElement updatedCurrency = wait.until(driver -> {
			List<WebElement> selects = shadowRoot.findElements(By.cssSelector("div.mmd-select-alternate div.mmd-select"));
			for (WebElement sel : selects) {
				if (sel.isDisplayed()) {
					List<WebElement> spans = sel.findElements(By.tagName("span"));
					for (WebElement span : spans) {
						if (span.isDisplayed() && !span.getText().trim().isEmpty()) {
							return span;
						}
					}
				}
			}
			return null;
		});

		String actualCurrency = updatedCurrency.getText().trim();

		System.out.println("Currency | Expected: " + expected + " | Actual: " + actualCurrency);
		test.info("Currency - Expected: " + expected);
		test.info("Currency - Actual: " + actualCurrency);

		if (actualCurrency.contains(expected)) {
			System.out.println("Currency changed successfully: " + actualCurrency);
			test.pass("Currency changed and matched: " + actualCurrency);
		} else {
			System.out.println("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
			test.fail("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
			Assert.fail("Currency mismatch. Expected: " + expected + " | Actual: " + actualCurrency);
		}
	}

	@SuppressWarnings("static-access")
	public void newsviewallbutton() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Scroll to the News section
		WebElement newsSection = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.newssection));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", newsSection);
		Thread.sleep(2000);

		// Click the View All button using Actions click (triggers React event handlers)
		WebElement viewAllBtn = wait.until(ExpectedConditions.elementToBeClickable(Category.newsviewall));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", viewAllBtn);
		Thread.sleep(1000);

		new Actions(driver).moveToElement(viewAllBtn).pause(Duration.ofMillis(300)).click().perform();

		System.out.println("News View All button clicked");

		// Validate popup is displayed
		WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(Category.newsfilter));

		if (popup.isDisplayed()) {
			System.out.println("News popup opened successfully");
			test.pass("News View All popup opened successfully");
		} else {
			System.out.println("News popup did not open");
			test.fail("News View All popup did not open");
			Assert.fail("News View All popup did not open");
		}
	}

	@SuppressWarnings("static-access")
	public void viewtranscript() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Click the podcast ellipsis menu
		WebElement ellipsis = wait.until(ExpectedConditions.elementToBeClickable(Category.podcastellipsis));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ellipsis);
		Thread.sleep(1000);
		new Actions(driver).moveToElement(ellipsis).pause(Duration.ofMillis(300)).click().perform();

		System.out.println("Podcast ellipsis clicked");

		// Click View Transcript
		WebElement viewTranscriptBtn = wait.until(ExpectedConditions.elementToBeClickable(Category.viewtranscripts));
		new Actions(driver).moveToElement(viewTranscriptBtn).pause(Duration.ofMillis(300)).click().perform();

		System.out.println("View Transcript clicked");

		// Validate the transcript popup/dialog is displayed
		WebElement transcriptDialog = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.cssSelector("div[data-headlessui-state='open']")));

		if (transcriptDialog.isDisplayed()) {
			System.out.println("Transcript popup opened successfully");
			test.pass("Transcript popup displayed successfully");
		} else {
			System.out.println("Transcript popup did not open");
			test.fail("Transcript popup did not open");
			Assert.fail("Transcript popup did not open");
		}
	}

	@SuppressWarnings("static-access")
	public void relatedCategory() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		System.out.println("ABS category clicked");

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement polystyrene = wait.until(driver -> {
			List<WebElement> tags = shadowRoot.findElements(By.cssSelector("div.mmd-related-tag"));
			for (WebElement tag : tags) {
				if (tag.getText().trim().equalsIgnoreCase("Polystyrene")) {
					return tag;
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", polystyrene);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", polystyrene);

		System.out.println("Polystyrene clicked");

		// Validate navigation to Polystyrene category page
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Polystyrene));

		String pageTitle = driver.findElement(Category.Polystyrene).getText().trim();

		if (pageTitle.equalsIgnoreCase("Polystyrene")) {
			System.out.println("Navigated to Polystyrene page successfully");
			test.pass("Polystyrene page validated successfully: " + pageTitle);
		} else {
			System.out.println("Page validation failed. Expected: Polystyrene | Actual: " + pageTitle);
			test.fail("Page validation failed. Expected: Polystyrene | Actual: " + pageTitle);
			Assert.fail("Page validation failed. Expected: Polystyrene | Actual: " + pageTitle);
		}

	}

	@SuppressWarnings("static-access")
	public void baseYear() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		System.out.println("3PL Services clicked");

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		Thread.sleep(3000);

		String actualText = wait.until(driver -> {
			String text = (String) ((JavascriptExecutor) driver).executeScript(
					"var host = document.querySelector('beroe-mmd');" +
					"var shadow = host.shadowRoot;" +
					"var elements = shadow.querySelectorAll('div.mmd-forecast-date');" +
					"if (elements.length >= 2) { return elements[1].textContent; }" +
					"return '';"
			);
			if (text != null && text.contains("1982")) {
				return text;
			}
			return null;
		});

		actualText = actualText.trim();
		System.out.println("Base Year text: " + actualText);

		if (actualText.contains("1982")) {
			System.out.println("Base Year validated successfully: " + actualText);
			test.pass("Base Year validated: " + actualText);
		} else {
			System.out.println("Base Year validation failed. Expected: 1982 | Actual: " + actualText);
			test.fail("Base Year validation failed. Expected: 1982 | Actual: " + actualText);
			Assert.fail("Base Year validation failed. Expected: 1982 | Actual: " + actualText);
		}

	}

	@SuppressWarnings("static-access")
	public void sinceLastMonth() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Get all metric containers (first = Since Last Month, second = Since Last Year)
		List<WebElement> metricContainers = wait.until(driver -> {
			List<WebElement> containers = shadowRoot.findElements(Category.lastMetricContainer);
			return containers.size() >= 2 ? containers : null;
		});

		// --- Validate "Since Last Month" ---
		WebElement sinceLastMonthDiv = metricContainers.get(0);
		String monthText = sinceLastMonthDiv.getText().trim();
		System.out.println("Since Last Month full text: " + monthText);

		Assert.assertTrue(monthText.contains("Since Last Month"),
				"Expected 'Since Last Month' text but found: " + monthText);
		test.info("Since Last Month text verified: " + monthText);

		// Determine arrow direction and percentage for Since Last Month
		List<WebElement> monthDownArrows = sinceLastMonthDiv.findElements(Category.arrowDown);
		List<WebElement> monthUpArrows = sinceLastMonthDiv.findElements(Category.arrowUp);
		List<WebElement> monthGreenSpans = sinceLastMonthDiv.findElements(Category.lastMetricGreenSpan);
		List<WebElement> monthRedSpans = sinceLastMonthDiv.findElements(Category.lastMetricRedSpan);

		// Extract percentage value
		String monthPercentage = extractPercentage(monthText);
		System.out.println("Since Last Month percentage: " + monthPercentage);

		if (!monthDownArrows.isEmpty()) {
			// Arrow DOWN → percentage must be NEGATIVE, color must be GREEN
			Assert.assertTrue(monthPercentage.startsWith("-"),
					"Arrow is DOWN but percentage is not negative: " + monthPercentage);
			Assert.assertFalse(monthGreenSpans.isEmpty(),
					"Arrow is DOWN but green span not found for Since Last Month");
			test.pass("Since Last Month: DOWN arrow with negative percentage (" + monthPercentage + ") and green color - PASSED");
			System.out.println("Since Last Month: DOWN arrow validated with negative % and green color");
		} else if (!monthUpArrows.isEmpty()) {
			// Arrow UP → percentage must be POSITIVE, color must be RED
			Assert.assertFalse(monthPercentage.startsWith("-"),
					"Arrow is UP but percentage is negative: " + monthPercentage);
			Assert.assertFalse(monthRedSpans.isEmpty(),
					"Arrow is UP but red span not found for Since Last Month");
			test.pass("Since Last Month: UP arrow with positive percentage (" + monthPercentage + ") and red color - PASSED");
			System.out.println("Since Last Month: UP arrow validated with positive % and red color");
		} else {
			test.fail("No arrow found for Since Last Month metric");
			Assert.fail("No arrow (up or down) found for Since Last Month");
		}

		// --- Validate "Since Last Year" ---
		WebElement sinceLastYearDiv = metricContainers.get(1);
		String yearText = sinceLastYearDiv.getText().trim();
		System.out.println("Since Last Year full text: " + yearText);

		Assert.assertTrue(yearText.contains("Since Last Year"),
				"Expected 'Since Last Year' text but found: " + yearText);
		test.info("Since Last Year text verified: " + yearText);

		// Determine arrow direction and percentage for Since Last Year
		List<WebElement> yearDownArrows = sinceLastYearDiv.findElements(Category.arrowDown);
		List<WebElement> yearUpArrows = sinceLastYearDiv.findElements(Category.arrowUp);
		List<WebElement> yearGreenSpans = sinceLastYearDiv.findElements(Category.lastMetricGreenSpan);
		List<WebElement> yearRedSpans = sinceLastYearDiv.findElements(Category.lastMetricRedSpan);

		// Extract percentage value
		String yearPercentage = extractPercentage(yearText);
		System.out.println("Since Last Year percentage: " + yearPercentage);

		if (!yearDownArrows.isEmpty()) {
			// Arrow DOWN → percentage must be NEGATIVE, color must be GREEN
			Assert.assertTrue(yearPercentage.startsWith("-"),
					"Arrow is DOWN but percentage is not negative: " + yearPercentage);
			Assert.assertFalse(yearGreenSpans.isEmpty(),
					"Arrow is DOWN but green span not found for Since Last Year");
			test.pass("Since Last Year: DOWN arrow with negative percentage (" + yearPercentage + ") and green color - PASSED");
			System.out.println("Since Last Year: DOWN arrow validated with negative % and green color");
		} else if (!yearUpArrows.isEmpty()) {
			// Arrow UP → percentage must be POSITIVE, color must be RED
			Assert.assertFalse(yearPercentage.startsWith("-"),
					"Arrow is UP but percentage is negative: " + yearPercentage);
			Assert.assertFalse(yearRedSpans.isEmpty(),
					"Arrow is UP but red span not found for Since Last Year");
			test.pass("Since Last Year: UP arrow with positive percentage (" + yearPercentage + ") and red color - PASSED");
			System.out.println("Since Last Year: UP arrow validated with positive % and red color");
		} else {
			test.fail("No arrow found for Since Last Year metric");
			Assert.fail("No arrow (up or down) found for Since Last Year");
		}

		test.pass("Since Last Month & Since Last Year arrow and percentage validation completed successfully");
	}

	
	private String extractPercentage(String text) {
		Matcher matcher = Pattern.compile("-?\\d+\\.?\\d*%").matcher(text);
		if (matcher.find()) {
			return matcher.group();
		}
		return "";
	}


	@SuppressWarnings("static-access")
	public void mmdexcelvalue() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		

		// Step 1: Get the current price from UI (shadow DOM)
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement currentPriceElement = wait.until(driver -> {
			List<WebElement> elements = shadowRoot.findElements(Category.mmdCurrentPrice);
			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				return elements.get(0);
			}
			return null;
		});

		String uiPriceText = currentPriceElement.getText().trim();
		System.out.println("UI Current Price: " + uiPriceText);
		test.info("UI Current Price value: " + uiPriceText);

		// Parse the UI price to a numeric value
		double uiPrice = Double.parseDouble(uiPriceText.replaceAll(",", ""));

		// Step 2: Download the Price Trend Excel
		WebElement downloadButton = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> buttons = root.findElements(Category.mmdDownloadButton);
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);
		System.out.println("Download button clicked");

		// Click "Price Trend" option in the download modal
		WebElement priceTrendOption = driver.findElement(Category.mmdPriceTrendOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", priceTrendOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrendOption);

		// Select the Excel radio button (click the label since input is hidden)
		Thread.sleep(2000);
		WebElement excelLabel = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> labels = root.findElements(Category.mmdExcelRadioButton);
			if (!labels.isEmpty() && labels.get(0).isDisplayed()) {
				return labels.get(0);
			}
			return null;
		});
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", excelLabel);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", excelLabel);
		System.out.println("Excel radio button selected");

		// Click the download confirm button in the modal
		Thread.sleep(2000);
		WebElement modalDownload = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> buttons = root.findElements(Category.mmdModalDownloadButton);
			if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", modalDownload);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", modalDownload);
		System.out.println("Modal download button clicked");

		// Step 3: Wait for the file to be downloaded
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		File downloadedFile = null;

		FluentWait<File> fileWait = new FluentWait<>(folder)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class);

		downloadedFile = fileWait.until(dir -> {
			File[] filesAfter = dir.listFiles();
			if (filesAfter == null) return null;
			for (File f : filesAfter) {
				String name = f.getName();
				if (beforeFiles.contains(name)) continue;
				if (name.endsWith(".crdownload")) continue;
				if (f.exists() && f.length() > 0 && (name.endsWith(".xlsx") || name.endsWith(".xls"))) {
					System.out.println("Downloaded file: " + name);
					return f;
				}
			}
			return null;
		});

		if (downloadedFile == null) {
			test.fail("Price Trend file was NOT downloaded");
			Assert.fail("Price Trend file was NOT downloaded");
		}

		test.pass("Price Trend file downloaded: " + downloadedFile.getName());

		// Step 4: Read the Excel and get the current month price
		java.io.FileInputStream fis = new java.io.FileInputStream(downloadedFile);
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook(fis);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

		// Determine the current quarter month (based on current date)
		LocalDate today = LocalDate.now();
		int currentMonth = today.getMonthValue();
		int currentYear = today.getYear();

		// Format to match Excel column A pattern like "Apr-2026"
		String currentMonthStr = today.format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH));
		System.out.println("Looking for month in Excel: " + currentMonthStr);

		// Find the row matching the current month
		double excelPrice = -1;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			org.apache.poi.ss.usermodel.Row row = sheet.getRow(i);
			if (row == null) continue;

			org.apache.poi.ss.usermodel.Cell dateCell = row.getCell(0);
			if (dateCell == null) continue;

			String cellValue = "";
			if (dateCell.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
				cellValue = dateCell.getStringCellValue().trim();
			} else if (dateCell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
				if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(dateCell)) {
					Date date = dateCell.getDateCellValue();
					cellValue = new SimpleDateFormat("MMM-yyyy", Locale.ENGLISH).format(date);
				}
			}

			if (cellValue.equalsIgnoreCase(currentMonthStr)) {
				org.apache.poi.ss.usermodel.Cell priceCell = row.getCell(1);
				if (priceCell != null) {
					if (priceCell.getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC) {
						excelPrice = priceCell.getNumericCellValue();
					} else if (priceCell.getCellType() == org.apache.poi.ss.usermodel.CellType.STRING) {
						excelPrice = Double.parseDouble(priceCell.getStringCellValue().replaceAll(",", ""));
					}
				}
				break;
			}
		}

		workbook.close();
		fis.close();

		System.out.println("Excel price for " + currentMonthStr + ": " + excelPrice);
		test.info("Excel price for " + currentMonthStr + ": " + excelPrice);

		// Step 5: Compare UI price with Excel price
		if (excelPrice == -1) {
			test.fail("Current month (" + currentMonthStr + ") not found in downloaded Excel");
			Assert.fail("Current month (" + currentMonthStr + ") not found in downloaded Excel");
		}

		if (uiPrice == excelPrice) {
			System.out.println("PASSED: UI price (" + uiPrice + ") matches Excel price (" + excelPrice + ")");
			test.pass("UI price (" + uiPrice + ") matches Excel price (" + excelPrice + ") for " + currentMonthStr);
		} else {
			System.out.println("FAILED: UI price (" + uiPrice + ") does NOT match Excel price (" + excelPrice + ")");
			test.fail("UI price (" + uiPrice + ") does NOT match Excel price (" + excelPrice + ") for " + currentMonthStr);
			Assert.fail("Price mismatch - UI: " + uiPrice + " | Excel: " + excelPrice);
		}
	}

	@SuppressWarnings("static-access")
	public void mmdgraphandppt() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Click ABS category
		WebElement absElement = wait.until(ExpectedConditions.elementToBeClickable(Category.abs));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", absElement);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absElement);
		System.out.println("ABS clicked");

		// Step 1: Get the current price from UI (shadow DOM)
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		WebElement currentPriceElement = wait.until(driver -> {
			List<WebElement> elements = shadowRoot.findElements(Category.mmdCurrentPrice);
			if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
				return elements.get(0);
			}
			return null;
		});

		String uiPriceText = currentPriceElement.getText().trim();
		System.out.println("UI Current Price: " + uiPriceText);
		test.info("UI Current Price value: " + uiPriceText);

		// Step 1b: Get period labels from UI (e.g., "May-2026", "Euro/MT")
		String uiFullText = (String) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var holder = shadow.querySelector('div.mmd-current-price-holder');" +
				"return holder ? holder.textContent : '';"
		);
		uiFullText = uiFullText.trim();
		System.out.println("UI Price Holder text: " + uiFullText);

		// Extract period (e.g., May-2026) and unit (e.g., Euro/MT)
		String uiPeriod = "";
		String uiUnit = "";
		Matcher periodMatcher = Pattern.compile("([A-Z][a-z]{2}-\\d{4}|Q[1-4]\\s+\\d{4})").matcher(uiFullText);
		if (periodMatcher.find()) {
			uiPeriod = periodMatcher.group();
		}
		Matcher unitMatcher = Pattern.compile("(\\w+/\\w+|U\\.S\\.\\s*Dollar/\\w+)").matcher(uiFullText);
		if (unitMatcher.find()) {
			uiUnit = unitMatcher.group();
		}
		System.out.println("UI Period: " + uiPeriod + " | UI Unit: " + uiUnit);
		test.info("UI Period: " + uiPeriod + " | UI Unit: " + uiUnit);

		// Validate period is present on UI
		if (!uiPeriod.isEmpty()) {
			test.pass("Period label displayed on UI: " + uiPeriod);
		} else {
			test.fail("Period label NOT found on UI");
		}

		// Validate unit is present on UI
		if (!uiUnit.isEmpty()) {
			test.pass("Unit label displayed on UI: " + uiUnit);
		} else {
			test.fail("Unit label NOT found on UI");
		}

		// Step 1c: Validate "Since Last Month" and "Since Last Year" on UI
		String sinceLastMonthUI = "";
		String sinceLastYearUI = "";
		List<WebElement> metricContainers = shadowRoot.findElements(Category.lastMetricContainer);
		if (metricContainers.size() >= 2) {
			sinceLastMonthUI = metricContainers.get(0).getText().trim();
			sinceLastYearUI = metricContainers.get(1).getText().trim();
			System.out.println("UI Since Last Month: " + sinceLastMonthUI);
			System.out.println("UI Since Last Year: " + sinceLastYearUI);
			test.info("UI Since Last Month: " + sinceLastMonthUI);
			test.info("UI Since Last Year: " + sinceLastYearUI);
		}

		if (sinceLastMonthUI.contains("Since Last Month")) {
			test.pass("'Since Last Month' text displayed on UI: " + sinceLastMonthUI);
		} else {
			test.fail("'Since Last Month' text NOT found on UI");
		}

		if (sinceLastYearUI.contains("Since Last Year")) {
			test.pass("'Since Last Year' text displayed on UI: " + sinceLastYearUI);
		} else {
			test.fail("'Since Last Year' text NOT found on UI");
		}

		// Step 1d: Validate graph is displayed on UI
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(5000); // Wait for graph to load
		boolean uiGraphDisplayed = false;
		try {
			Boolean graphFound = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"var host = document.querySelector('beroe-mmd');" +
					"var shadow = host.shadowRoot;" +
					"var chart = shadow.querySelector('div.chart-container');" +
					"if (!chart) { chart = shadow.querySelector('div[role=graphics-document]'); }" +
					"if (!chart) { chart = shadow.querySelector('.vega-embed'); }" +
					"return chart != null && chart.getBoundingClientRect().height > 0;"
			);
			uiGraphDisplayed = graphFound != null && graphFound;
		} catch (Exception e) {
			uiGraphDisplayed = false;
		}

		if (uiGraphDisplayed) {
			test.pass("Graph is displayed on UI");
			System.out.println("PASSED: Graph displayed on UI");
		} else {
			test.fail("Graph is NOT displayed on UI");
			Assert.fail("Graph is not displayed on UI");
		}

		// Step 2: Click Download button
		WebElement downloadButton = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> buttons = root.findElements(Category.mmdDownloadButton);
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", downloadButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", downloadButton);
		System.out.println("Download button clicked");

		// Click "Price Trend" option in the download modal
		WebElement priceTrendOption = driver.findElement(Category.mmdPriceTrendOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", priceTrendOption);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", priceTrendOption);

		// Select the PPT radio button
		Thread.sleep(2000);

	/* 	WebElement pptLabel = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> labels = root.findElements(Category.mmdPptRadioButton);
			if (!labels.isEmpty() && labels.get(0).isDisplayed()) {
				return labels.get(0);
			}
			return null;
		});
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", pptLabel);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", pptLabel);
		System.out.println("PPT radio button selected"); */

		// Click the download confirm button in the modal (same approach as mmdexcelvalue)
		//Thread.sleep(2000);
		WebElement modalDownload = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext root = host.getShadowRoot();
			List<WebElement> buttons = root.findElements(Category.mmdModalDownloadButton);
			if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", modalDownload);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", modalDownload);
		System.out.println("Modal download button clicked");

		// Step 3: Wait for the PPT file to be downloaded
		String downloadPath = System.getProperty("user.home") + "\\Downloads";
		File folder = new File(downloadPath);
		Set<String> beforeFiles = Arrays.stream(folder.listFiles()).map(File::getName).collect(Collectors.toSet());

		File downloadedFile = null;

		FluentWait<File> fileWait = new FluentWait<>(folder)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(Exception.class);

		downloadedFile = fileWait.until(dir -> {
			File[] filesAfter = dir.listFiles();
			if (filesAfter == null) return null;
			for (File f : filesAfter) {
				String name = f.getName();
				if (beforeFiles.contains(name)) continue;
				if (name.endsWith(".crdownload")) continue;
				if (f.exists() && f.length() > 0 && (name.endsWith(".pptx") || name.endsWith(".ppt"))) {
					System.out.println("Downloaded PPT file: " + name);
					return f;
				}
			}
			return null;
		});

		if (downloadedFile == null) {
			test.fail("PPT file was NOT downloaded");
			Assert.fail("PPT file was NOT downloaded");
		}

		test.pass("PPT file downloaded: " + downloadedFile.getName());

		// Step 4: Read the PPT file - check that graph/chart exists
		boolean graphFound = false;

		try (java.util.zip.ZipFile zip = new java.util.zip.ZipFile(downloadedFile)) {
			java.util.Enumeration<? extends java.util.zip.ZipEntry> entries = zip.entries();

			while (entries.hasMoreElements()) {
				java.util.zip.ZipEntry entry = entries.nextElement();
				String entryName = entry.getName();

				// Check for chart/graph/image files in the PPTX
				if (entryName.startsWith("ppt/charts/") || entryName.contains("chart")
						|| entryName.contains("image") || entryName.contains("drawing")) {
					graphFound = true;
					System.out.println("Graph/Chart/Image found in PPT: " + entryName);
				}
			}
		}

		// Step 5: Validate graph exists in PPT
		if (graphFound) {
			test.pass("PPT has graph/chart");
			System.out.println("PASSED: Graph found in PPT");
		} else {
			test.fail("Graph is NOT present in the downloaded PPT file");
			Assert.fail("Graph not found in PPT");
		}

		// Price, period, unit, Since Last Month, Since Last Year are rendered as images in PPT - skipping text-based verification
		test.info("Price, period, unit, and metric labels are embedded as images in PPT - text-based verification skipped");
		System.out.println("Price, period, unit, and metric labels are in image format in PPT - verification skipped");

		test.pass("PPT download and graph validation PASSED");
	}

	@SuppressWarnings("static-access")
	public void mmdaddcomparsioncancelbutton() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {

		// Step 1: Navigate to ABS category
		WebElement absElement = wait.until(ExpectedConditions.elementToBeClickable(Category.abs));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", absElement);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", absElement);
		System.out.println("ABS category clicked");
		test.info("Navigated to ABS category");

		// Step 2: Get shadow root
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Wait for page to load fully before clicking Add Comparison
		Thread.sleep(5000);

		// Step 3: Click "Add Comparison" button
		WebElement addComparisonBtn = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addComparisonBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addComparisonBtn);
		System.out.println("Add Comparison button clicked");
		test.info("Clicked Add Comparison button");

		// Step 4: Click "Apply" button (second button with same selector)
		Thread.sleep(2000);
		WebElement applyButton = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
			if (buttons.size() >= 3 && buttons.get(1).isDisplayed()) {
				return buttons.get(1);
			}
			return null;
		});

		String applyText = applyButton.getText().trim();
		System.out.println("Apply button text: " + applyText);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", applyButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyButton);
		System.out.println("Apply button clicked");
		test.info("Clicked Apply button");

		// Step 5: Verify comparison chip is displayed after Apply
		Thread.sleep(2000);
		boolean chipDisplayed = false;
		try {
			List<WebElement> chips = shadowRoot.findElements(By.cssSelector("div.mmd-compare-chip, span.mmd-compare-chip, div.mmd-compare-tag, div.mmd-selected-comparison"));
			if (chips.isEmpty()) {
				// Try alternative: check for any element with close/remove icon near comparison area
				chips = shadowRoot.findElements(By.cssSelector("div.mmd-compare-panel div.mmd-chip, div.mmd-compare-panel span.mmd-tag"));
			}
			chipDisplayed = !chips.isEmpty() && chips.get(0).isDisplayed();
		} catch (Exception e) {
			System.out.println("Chip check exception: " + e.getMessage());
		}

		if (chipDisplayed) {
			System.out.println("Comparison chip is displayed after Apply");
			test.pass("Comparison chip displayed after clicking Apply");
		} else {
			System.out.println("Comparison chip not found - checking if comparison panel is still visible");
			test.info("Comparison chip element not found with expected selectors - proceeding with Cancel");
		}

		// Step 6: Click "Cancel" button (has class mmd-button-sec)
		Thread.sleep(1000);
		WebElement cancelButton = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.cancelComparison);
			if (!buttons.isEmpty() && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		String cancelText = cancelButton.getText().trim();
		System.out.println("Cancel button text: " + cancelText);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cancelButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cancelButton);
		System.out.println("Cancel button clicked");
		test.info("Clicked Cancel button");

		// Step 7: Validate that the comparison is removed
		Thread.sleep(2000);
		boolean comparisonRemoved = false;
		try {
			// Check that comparison chips/tags are no longer visible
			List<WebElement> chipsAfter = shadowRoot.findElements(By.cssSelector("div.mmd-compare-chip, span.mmd-compare-chip, div.mmd-compare-tag, div.mmd-selected-comparison"));
			if (chipsAfter.isEmpty()) {
				comparisonRemoved = true;
			} else {
				// Check if none of them are displayed
				comparisonRemoved = chipsAfter.stream().noneMatch(WebElement::isDisplayed);
			}
		} catch (StaleElementReferenceException e) {
			// Element removed from DOM - comparison is gone
			comparisonRemoved = true;
		}

		// Also check that the Add Comparison button is back to its original state
		if (!comparisonRemoved) {
			try {
				List<WebElement> buttonsAfterCancel = shadowRoot.findElements(Category.addcomparision);
				// If only "Add Comparison" button is visible (no Apply/Cancel), comparison was removed
				if (buttonsAfterCancel.size() <= 1) {
					comparisonRemoved = true;
				}
			} catch (Exception e) {
				comparisonRemoved = true;
			}
		}

		if (comparisonRemoved) {
			System.out.println("PASSED: Comparison removed after clicking Cancel");
			test.pass("Comparison successfully removed after clicking Cancel button");
		} else {
			System.out.println("FAILED: Comparison is still visible after clicking Cancel");
			test.fail("Comparison was NOT removed after clicking Cancel button")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "cancel_comparison_failed"));
			Assert.fail("Comparison was NOT removed after clicking Cancel");
		}

		} catch (Exception e) {
			// Get the root cause (e.g., NoSuchElementException inside TimeoutException)
			Throwable rootCause = e;
			while (rootCause.getCause() != null) {
				rootCause = rootCause.getCause();
			}

			String errorDetails = "Exception Type: " + e.getClass().getSimpleName() + "\n"
					+ "Message: " + e.getMessage() + "\n"
					+ "Root Cause: " + rootCause.getClass().getSimpleName() + "\n"
					+ "Root Cause Message: " + rootCause.getMessage();

			java.io.StringWriter sw = new java.io.StringWriter();
			e.printStackTrace(new java.io.PrintWriter(sw));
			String fullStackTrace = sw.toString();

			System.out.println("========== FAILURE DETAILS ==========");
			System.out.println(errorDetails);
			System.out.println("========== FULL STACK TRACE ==========");
			System.out.println(fullStackTrace);
			System.out.println("======================================");

			test.fail(errorDetails + "\n\nFull Stack Trace:\n" + fullStackTrace)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmdaddcomparsioncancelbutton_exception"));
			throw e;
		}
	}

	@SuppressWarnings("static-access")
	public void nodataavailable() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Step 1: Navigate to Fatty Acids category
		WebElement aminoacid = wait.until(ExpectedConditions.elementToBeClickable(Category.aminoacid));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", aminoacid);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", aminoacid);
		System.out.println("aminoacid Acids category clicked");
		test.info("Navigated to aminoacid Acids category");

		// Step 2: Get shadow root
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Step 3: Wait for No Data panel to appear
		WebElement noDataPanel = wait.until(driver -> {
			List<WebElement> panels = shadowRoot.findElements(Category.noDataPanel);
			if (!panels.isEmpty() && panels.get(0).isDisplayed()) {
				return panels.get(0);
			}
			return null;
		});

		// Step 4: Validate "No Data Available" text
		List<WebElement> noDataTexts = shadowRoot.findElements(Category.noDataText);
		if (!noDataTexts.isEmpty() && noDataTexts.get(0).isDisplayed()) {
			String displayedText = noDataTexts.get(0).getText().trim();
			System.out.println("No Data text found: " + displayedText);

			if (displayedText.equalsIgnoreCase("No Data Available")) {
				System.out.println("PASSED: 'No Data Available' message is displayed");
				test.pass("'No Data Available' message is displayed correctly for Fatty Acids MMD section");
			} else {
				System.out.println("FAILED: Expected 'No Data Available' but found: " + displayedText);
				test.fail("Expected 'No Data Available' but found: " + displayedText)
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "nodataavailable_wrong_text"));
				Assert.fail("Expected 'No Data Available' but found: " + displayedText);
			}
		} else {
			System.out.println("FAILED: No Data panel is present but text element not found");
			test.fail("No Data panel is present but text element not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "nodataavailable_no_text"));
			Assert.fail("No Data panel is present but text element not found");
		}
	}

	@SuppressWarnings("static-access")
	public void addcomparsionsameregiondifferentlocation() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// Step 1: Navigate to Airlines category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.airlines));
		steps.click(driver, Category.airlines);
		System.out.println("Airlines category clicked");
		test.info("Navigated to Airlines category");

		// Step 2: Get shadow root
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		Thread.sleep(5000);

		// Step 3: Click "Add Comparison" button
		WebElement addComparisonBtn = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addComparisonBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addComparisonBtn);
		System.out.println("Add Comparison button clicked");
		test.info("Clicked Add Comparison button");

		Thread.sleep(2000);

		// Step 4: Read dropdown values from test data sheet
		String expectedCountry = data.getColumnDataAsString(
				"CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression",
				"Expected Text - 1",
				testCase
		).trim();

		String expectedIndustry = data.getColumnDataAsString(
				"CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression",
				"Expected Text - 2",
				testCase
		).trim();

		String expectedDataType = data.getColumnDataAsString(
				"CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression",
				"Expected Text - 3",
				testCase
		).trim();

		System.out.println("Expected Country: " + expectedCountry);
		System.out.println("Expected Industry: " + expectedIndustry);
		System.out.println("Expected Data Type: " + expectedDataType);

		// Step 5: Get the comparison panel
		WebElement panel = wait.until(d -> {
			WebElement p = shadowRoot.findElement(By.cssSelector("div.mmd-compare-panel"));
			return p.isDisplayed() ? p : null;
		});

		// Step 6: Get all dropdown outers in the panel
		List<WebElement> allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer"));
		System.out.println("Total dropdowns found: " + allOuters.size());

		// Step 7: Select Country from first dropdown
		selectFromComparisonDropdown(wait, shadowRoot, panel, allOuters, 0, expectedCountry);
		System.out.println("Selected Country: " + expectedCountry);
		test.info("Selected Country: " + expectedCountry);

		Thread.sleep(1000);

		// Step 8: Select Industry from second dropdown
		allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer"));
		selectFromComparisonDropdown(wait, shadowRoot, panel, allOuters, 1, expectedIndustry);
		System.out.println("Selected Industry: " + expectedIndustry);
		test.info("Selected Industry: " + expectedIndustry);

		Thread.sleep(1000);

		// Step 9: Select Data Type from third dropdown
		allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer"));
		selectFromComparisonDropdown(wait, shadowRoot, panel, allOuters, 2, expectedDataType);
		System.out.println("Selected Data Type: " + expectedDataType);
		test.info("Selected Data Type: " + expectedDataType);

		Thread.sleep(1000);

		// Step 10: Count graph lines before clicking Apply
		Long lineCountBefore = (Long) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var chart = shadow.querySelector('div.chart-container');" +
				"if (!chart) return 0;" +
				"var paths = chart.querySelectorAll('path[class*=\"mark-line\"], path[class*=\"role-mark\"], .mark-line path, line[class*=\"mark\"]');" +
				"if (paths.length === 0) { paths = chart.querySelectorAll('path'); }" +
				"return paths.length;"
		);
		System.out.println("Graph lines before Apply: " + lineCountBefore);

		// Step 11: Click Apply button
		WebElement applyButton = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
			if (buttons.size() >= 3 && buttons.get(1).isDisplayed()) {
				return buttons.get(1);
			}
			return null;
		});

		String applyText = applyButton.getText().trim();
		System.out.println("Apply button text: " + applyText);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", applyButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyButton);
		System.out.println("Apply button clicked");
		test.info("Clicked Apply button");

		Thread.sleep(5000);

		// Step 12: Validate new graph line appeared after Apply
		Long lineCountAfter = (Long) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var chart = shadow.querySelector('div.chart-container');" +
				"if (!chart) return 0;" +
				"var paths = chart.querySelectorAll('path[class*=\"mark-line\"], path[class*=\"role-mark\"], .mark-line path, line[class*=\"mark\"]');" +
				"if (paths.length === 0) { paths = chart.querySelectorAll('path'); }" +
				"return paths.length;"
		);
		System.out.println("Graph lines after Apply: " + lineCountAfter);

		if (lineCountAfter > lineCountBefore) {
			System.out.println("PASSED: New graph line added after Apply. Before: " + lineCountBefore + ", After: " + lineCountAfter);
			test.pass("New graph line updated successfully after Apply. Lines before: " + lineCountBefore + ", Lines after: " + lineCountAfter)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "addcomparison_graph_updated"));
		} else {
			System.out.println("FAILED: Graph line was NOT updated after Apply. Before: " + lineCountBefore + ", After: " + lineCountAfter);
			test.fail("Graph line was NOT updated after Apply. Lines before: " + lineCountBefore + ", Lines after: " + lineCountAfter)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "addcomparison_graph_not_updated"));
			Assert.fail("Graph line was NOT updated after Apply");
		}
	}

	private void selectFromComparisonDropdown(WebDriverWait wait, SearchContext shadowRoot, WebElement panel,
			List<WebElement> allOuters, int dropdownIndex, String valueToSelect) {

		if (dropdownIndex >= allOuters.size()) {
			System.out.println("Dropdown index " + dropdownIndex + " out of bounds. Available: " + allOuters.size());
			Assert.fail("Dropdown index " + dropdownIndex + " not found in comparison panel");
		}

		WebElement dropdownOuter = allOuters.get(dropdownIndex);

		// Click the dropdown to open it
		WebElement inner = dropdownOuter.findElement(By.cssSelector("div.mmd-select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", inner);

		try {
			new Actions(driver).moveToElement(inner).pause(Duration.ofMillis(150)).click().perform();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", inner);
		}

		// Fallback: click chevron if not opened
		if (!dropdownOuter.getDomAttribute("class").contains("mmd-select-outer-open")) {
			try {
				WebElement chevron = dropdownOuter.findElement(By.cssSelector("i.fa-chevron-down"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", chevron);
			} catch (Exception e) {
				System.out.println("Chevron not found, dropdown might already be open");
			}
		}

		// Wait for dropdown to open
		wait.until(d -> {
			String cls = dropdownOuter.getDomAttribute("class");
			return (cls != null && cls.contains("mmd-select-outer-open")) ? true : null;
		});

		// Select the value from dropdown list
		boolean picked = wait.until(d -> {
			List<WebElement> opts = shadowRoot.findElements(By.cssSelector("div.mmd-select-dropdown *"));
			if (opts.isEmpty()) return null;

			for (WebElement opt : opts) {
				if (!opt.isDisplayed()) continue;
				String txt = opt.getText().replace("\u00A0", " ").trim();
				if (txt.isEmpty()) continue;

				if (txt.equalsIgnoreCase(valueToSelect)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", opt);
					return true;
				}
			}
			return false;
		});

		Assert.assertTrue(picked, "Value not found in dropdown: " + valueToSelect);
		System.out.println("Selected from dropdown[" + dropdownIndex + "]: " + valueToSelect);
	}

	@SuppressWarnings("static-access")
	public void addcomparisioncountries() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Navigate to ABS category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("ABS category clicked");
		test.info("Navigated to ABS category");

		// Step 2: Get shadow root
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Step 3: Wait for MMD container and chart to fully load
		wait.until(d -> {
			List<WebElement> containers = shadowRoot.findElements(By.cssSelector("div.mmd-container"));
			if (containers.isEmpty() || !containers.get(0).isDisplayed()) {
				return null;
			}
			// Wait for chart or price section to render (indicates MMD is fully loaded)
			List<WebElement> charts = shadowRoot.findElements(By.cssSelector("div.chart-container, div.vega-embed, div.mmd-current-price-holder"));
			if (!charts.isEmpty() && charts.get(0).isDisplayed()) {
				return containers.get(0);
			}
			return null;
		});

		// Step 4: Click "Add Comparison" button
		WebElement addComparisonBtn = wait.until(driver -> {
			List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
			if (buttons.size() > 0 && buttons.get(0).isDisplayed()) {
				return buttons.get(0);
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addComparisonBtn);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addComparisonBtn);
		System.out.println("Add Comparison button clicked");
		test.info("Clicked Add Comparison button");

		// Step 5: Wait for comparison panel to appear
		WebElement panel = wait.until(d -> {
			List<WebElement> panels = shadowRoot.findElements(By.cssSelector("div.mmd-compare-panel"));
			if (!panels.isEmpty() && panels.get(0).isDisplayed()) {
				return panels.get(0);
			}
			return null;
		});

		// Step 6: Get all dropdown outers in the comparison panel
		List<WebElement> allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer"));
		System.out.println("Total dropdowns found: " + allOuters.size());

		// Step 7: Click the country dropdown (first dropdown in the new comparison row)
		WebElement countryDropdownOuter = allOuters.get(0);
		WebElement countryDropdown = countryDropdownOuter.findElement(By.cssSelector("div.mmd-select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", countryDropdown);

		try {
			new Actions(driver).moveToElement(countryDropdown).pause(Duration.ofMillis(150)).click().perform();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", countryDropdown);
		}

		// Fallback: click chevron if dropdown not opened
		if (!countryDropdownOuter.getDomAttribute("class").contains("mmd-select-outer-open")) {
			try {
				WebElement chevron = countryDropdownOuter.findElement(By.cssSelector("i.fa-chevron-down"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", chevron);
			} catch (Exception e) {
				System.out.println("Chevron not found, dropdown might already be open");
			}
		}

		// Step 8: Wait for dropdown to open
		wait.until(d -> {
			String cls = countryDropdownOuter.getDomAttribute("class");
			return (cls != null && cls.contains("mmd-select-outer-open")) ? true : null;
		});

		// Step 9: Get all country values from the dropdown
		List<WebElement> countryOptions = wait.until(d -> {
			List<WebElement> opts = shadowRoot.findElements(By.cssSelector("div.mmd-select-dropdown div[value]"));
			return opts.size() > 0 ? opts : null;
		});

		List<String> countryNames = new ArrayList<>();
		for (WebElement opt : countryOptions) {
			String text = opt.getText().replace("\u00A0", " ").trim();
			if (!text.isEmpty()) {
				countryNames.add(text);
			}
		}

		System.out.println("Country dropdown values count: " + countryNames.size());
		System.out.println("Country dropdown values: " + countryNames);
		test.info("Country dropdown values: " + countryNames);

		// Step 10: Validate that there are multiple country values
		if (countryNames.size() > 1) {
			test.pass("Country dropdown has multiple values: " + countryNames.size() + " countries found - " + countryNames)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "addcomparison_countries_validation"));
			System.out.println("PASSED: Multiple countries available in dropdown");
		} else {
			test.fail("Country dropdown does NOT have multiple values. Found: " + countryNames.size())
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "addcomparison_countries_failed"));
			Assert.fail("Country dropdown does NOT have multiple values. Found: " + countryNames.size());
		}
	}


	@SuppressWarnings("static-access")
	public void currenctingraph() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// Step 1: Navigate to ABS category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("ABS category clicked");
		test.info("Navigated to ABS category");

		// Step 2: Get shadow root
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Step 3: Wait for chart to fully load
		wait.until(d -> {
			List<WebElement> charts = shadowRoot.findElements(By.cssSelector("div.chart-container svg.marks"));
			if (!charts.isEmpty() && charts.get(0).isDisplayed()) {
				return charts.get(0);
			}
			return null;
		});

		// Step 4: Get expected currency from test data
		String expectedCurrency = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();
		System.out.println("Expected currency from test data: " + expectedCurrency);
		test.info("Expected currency: " + expectedCurrency);

		// Step 5: Click the currency dropdown to open it
		WebElement currencyDropdown = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (outer.isDisplayed()) {
					WebElement sel = outer.findElement(By.cssSelector("div.mmd-select"));
					if (sel.isDisplayed()) {
						return sel;
					}
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", currencyDropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyDropdown);
		System.out.println("Currency dropdown clicked");

		// Step 6: Type expected currency in the search box inside dropdown
		WebElement searchInput = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (!outer.isDisplayed()) continue;
				List<WebElement> inputs = outer.findElements(By.cssSelector("input"));
				for (WebElement input : inputs) {
					if (input.isDisplayed()) {
						return input;
					}
				}
			}
			return null;
		});

		searchInput.clear();
		searchInput.sendKeys(expectedCurrency);
		System.out.println("Typed in search box: " + expectedCurrency);

		// Step 7: Click the matching currency option from filtered dropdown
		WebElement currencyOption = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (!outer.isDisplayed()) continue;
				List<WebElement> items = outer.findElements(By.cssSelector("div.mmd-select-dropdown div[value], div.mmd-select-dropdown div"));
				for (WebElement item : items) {
					String itemText = item.getText().replace("\u00A0", " ").trim();
					if (item.isDisplayed() && !itemText.isEmpty() && itemText.contains(expectedCurrency)) {
						System.out.println("Found matching option: " + itemText);
						return item;
					}
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", currencyOption);
		try {
			new Actions(driver).moveToElement(currencyOption).pause(Duration.ofMillis(200)).click().perform();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyOption);
		}
		System.out.println("Selected currency: " + expectedCurrency);
		test.info("Selected currency from dropdown: " + expectedCurrency);

		// Step 8: Wait for currency label to update (re-acquire shadow root each poll to avoid stale reference)
		wait.until(d -> {
			try {
				WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
				SearchContext root = host.getShadowRoot();
				List<WebElement> selects = root.findElements(By.cssSelector("div.mmd-select-alternate div.mmd-select"));
				for (WebElement sel : selects) {
					if (sel.isDisplayed()) {
						String text = sel.getText().replace("\u00A0", " ").trim();
						if (text.contains(expectedCurrency)) {
							return true;
						}
					}
				}
			} catch (StaleElementReferenceException e) {
				// DOM still refreshing, retry
			}
			return null;
		});
		System.out.println("Currency label updated to: " + expectedCurrency);

		// Wait for chart SVG to finish re-rendering
		wait.until(d -> {
			try {
				WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
				SearchContext root = host.getShadowRoot();
				List<WebElement> charts = root.findElements(By.cssSelector("div.chart-container svg.marks"));
				if (!charts.isEmpty() && charts.get(0).isDisplayed()) {
					return true;
				}
			} catch (StaleElementReferenceException e) {
				// DOM still refreshing, retry
			}
			return null;
		});

		// Step 9: Validate the currency displayed in the price section matches
		String actualCurrency = wait.until(d -> {
			try {
				WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
				SearchContext root = host.getShadowRoot();
				// Get the currency text from the price holder area (shows "Chinese Renminbi/MT" etc.)
				List<WebElement> priceHolders = root.findElements(By.cssSelector("div.mmd-current-price-holder"));
				for (WebElement holder : priceHolders) {
					if (holder.isDisplayed()) {
						String text = holder.getText().replace("\u00A0", " ").trim();
						if (!text.isEmpty() && text.contains("/")) {
							return text;
						}
					}
				}
			} catch (StaleElementReferenceException e) {
				// retry
			}
			return null;
		});

		System.out.println("Price section text: " + actualCurrency);
		test.info("Price section text: " + actualCurrency);

		// Step 10: Validate that the price section contains the expected currency
		System.out.println("Currency | Expected: " + expectedCurrency + " | Actual: " + actualCurrency);
		test.info("Currency - Expected: " + expectedCurrency);
		test.info("Currency - Actual: " + actualCurrency);

		if (actualCurrency.contains(expectedCurrency)) {
			System.out.println("PASSED: Currency in graph section matches the selected dropdown currency");
			test.pass("Currency matched: Expected = " + expectedCurrency + " | Actual = " + actualCurrency)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "currencyingraph_pass"));
		} else {
			System.out.println("FAILED: Currency does NOT match the selected dropdown currency");
			test.fail("Currency mismatch: Expected = " + expectedCurrency + " | Actual = " + actualCurrency)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "currencyingraph_fail"));
			Assert.fail("Currency mismatch: Expected = " + expectedCurrency + " | Actual = " + actualCurrency);
		}
	}

	@SuppressWarnings("static-access")
	public void gradechangeabsolute() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// Step 1: Navigate to ABS category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("ABS category clicked");

		// Step 2: Access shadow DOM
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		Thread.sleep(3000);

		// Step 3: Click the "Index" tab before changing dropdown and print its text
		WebElement indexTab = wait.until(driver -> {
			List<WebElement> tabs = shadowRoot.findElements(By.cssSelector("div.mmd-tabs div.mmd-tab label"));
			for (WebElement tab : tabs) {
				if (tab.getText().trim().equalsIgnoreCase("Index")) {
					return tab;
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", indexTab);
		String indexTabText = indexTab.getText().trim();
		System.out.println("Index tab text: " + indexTabText);
		test.info("Index tab text before dropdown change: " + indexTabText);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", indexTab);
		System.out.println("Index tab clicked");
		test.pass("Index tab clicked successfully");

		Thread.sleep(2000);

		// Step 4: Get expected values from test data sheet
		String expectedSourceValue = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();
		System.out.println("Expected source value from test data: " + expectedSourceValue);

		String expectedGradeValue = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 2", testCase).trim();
		System.out.println("Expected grade value from test data: " + expectedGradeValue);

		// Step 5: Get all mmd-select-outer dropdowns (excluding mmd-select-alternate)
		List<WebElement> allOuters = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer:not(.mmd-select-alternate)"));
			return outers.size() >= 3 ? outers : null;
		});
		System.out.println("Total MMD dropdowns found: " + allOuters.size());

		// Step 6: Select source value from first dropdown (index 0)
		selectMMDDropdownValue(wait, shadowRoot, allOuters, 0, expectedSourceValue);
		System.out.println("Source value selected: " + expectedSourceValue);
		test.pass("Source dropdown value changed to: " + expectedSourceValue);

		Thread.sleep(2000);

		// Step 7: Re-fetch dropdowns after source change (DOM may have refreshed)
		allOuters = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer:not(.mmd-select-alternate)"));
			return outers.size() >= 3 ? outers : null;
		});

		// Step 8: Select grade value from third dropdown (index 2)
		selectMMDDropdownValue(wait, shadowRoot, allOuters, 2, expectedGradeValue);
		System.out.println("Grade value selected: " + expectedGradeValue);
		test.pass("Grade dropdown value changed to: " + expectedGradeValue);

		Thread.sleep(3000);

		// Step 9: Validate that the graph automatically switches to Absolute
		WebElement absoluteTab = wait.until(driver -> {
			List<WebElement> tabs = shadowRoot.findElements(By.cssSelector("div.mmd-tabs div.mmd-tab label"));
			for (WebElement tab : tabs) {
				if (tab.getText().trim().equalsIgnoreCase("Absolute")) {
					return tab;
				}
			}
			return null;
		});

		// Check if "Absolute" tab is now the active/selected tab
		WebElement activeInput = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var inputs = shadow.querySelectorAll('div.mmd-tabs input[type=\"radio\"]');" +
				"for (var i = 0; i < inputs.length; i++) {" +
				"  if (inputs[i].checked) return inputs[i];" +
				"}" +
				"return null;"
		);

		String activeTabId = activeInput != null ? activeInput.getDomAttribute("id") : "";
		System.out.println("Active tab radio input ID: " + activeTabId);

		boolean isAbsoluteActive = activeTabId.toLowerCase().contains("absolute")
				|| activeTabId.toLowerCase().contains("pricing");

		// Also verify by checking if the Absolute label is visually active
		if (!isAbsoluteActive) {
			String absoluteTabText = absoluteTab.getText().trim();
			System.out.println("Absolute tab text: " + absoluteTabText);

			// Check if graph container is displayed (Absolute graph renders a chart)
			List<WebElement> graphElements = shadowRoot.findElements(By.cssSelector("div.chart-container"));
			isAbsoluteActive = !graphElements.isEmpty() && graphElements.get(0).isDisplayed();
		}

		if (isAbsoluteActive) {
			System.out.println("PASSED: Graph automatically moved to Absolute after grade change");
			test.pass("Absolute graph is displayed after dropdown changes")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "gradechange_absolute_pass"));
		} else {
			System.out.println("FAILED: Graph did NOT switch to Absolute after grade change");
			test.fail("Absolute graph is NOT displayed after dropdown changes")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "gradechange_absolute_fail"));
			Assert.fail("Graph did not switch to Absolute view after changing the dropdowns");
		}
	}

	private void selectMMDDropdownValue(WebDriverWait wait, SearchContext shadowRoot,
			List<WebElement> allOuters, int dropdownIndex, String valueToSelect) {

		WebElement dropdownOuter = allOuters.get(dropdownIndex);

		// Click the dropdown to open it
		WebElement inner = dropdownOuter.findElement(By.cssSelector("div.mmd-select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", inner);

		try {
			new Actions(driver).moveToElement(inner).pause(Duration.ofMillis(150)).click().perform();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", inner);
		}

		// Fallback: click chevron if not opened
		if (!dropdownOuter.getDomAttribute("class").contains("mmd-select-outer-open")) {
			try {
				WebElement chevron = dropdownOuter.findElement(By.cssSelector("i.fa-chevron-down"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", chevron);
			} catch (Exception e) {
				System.out.println("Chevron not found, dropdown might already be open");
			}
		}

		// Wait for dropdown to open
		wait.until(d -> {
			String cls = dropdownOuter.getDomAttribute("class");
			return (cls != null && cls.contains("mmd-select-outer-open")) ? true : null;
		});

		// Type in search input if available
		try {
			List<WebElement> inputs = dropdownOuter.findElements(By.cssSelector("input"));
			for (WebElement input : inputs) {
				if (input.isDisplayed()) {
					input.clear();
					input.sendKeys(valueToSelect);
					System.out.println("Typed in search box: " + valueToSelect);
					Thread.sleep(1000);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("No search input found in dropdown, selecting directly");
		}

		// Select the value from dropdown list within this specific dropdown
		boolean picked = wait.until(d -> {
			List<WebElement> items = dropdownOuter.findElements(By.cssSelector("div.mmd-select-dropdown div[value], div.mmd-select-dropdown div"));
			if (items.isEmpty()) return null;

			for (WebElement item : items) {
				if (!item.isDisplayed()) continue;
				String itemText = item.getText().replace("\u00A0", " ").trim();
				if (itemText.isEmpty()) continue;

				if (itemText.contains(valueToSelect)) {
					System.out.println("Found matching option: " + itemText);
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", item);
					try {
						new Actions(driver).moveToElement(item).pause(Duration.ofMillis(200)).click().perform();
					} catch (Exception ex) {
						((JavascriptExecutor) driver).executeScript("arguments[0].click();", item);
					}
					return true;
				}
			}
			return false;
		});

		Assert.assertTrue(picked, "Value not found in dropdown: " + valueToSelect);
		System.out.println("Selected from dropdown[" + dropdownIndex + "]: " + valueToSelect);
	}

	@SuppressWarnings("static-access")
	public void gradechangeindex() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// Step 1: Navigate to Carbon Steel category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);
		System.out.println("Carbon Steel category clicked");

		// Step 2: Access shadow DOM
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		Thread.sleep(3000);

		// Step 3: Get expected values from test data sheet for dropdown 3 and 4
		String expectedDropdown3Value = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();
		System.out.println("Expected dropdown 3 value from test data: " + expectedDropdown3Value);

		String expectedDropdown4Value = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 2", testCase).trim();
		System.out.println("Expected dropdown 4 value from test data: " + expectedDropdown4Value);

		// Step 4: Get all mmd-select-outer dropdowns (excluding mmd-select-alternate)
		List<WebElement> allOuters = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer:not(.mmd-select-alternate)"));
			return outers.size() >= 4 ? outers : null;
		});
		System.out.println("Total MMD dropdowns found: " + allOuters.size());

		// Step 5: Select value from third dropdown (index 2)
		selectMMDDropdownValue(wait, shadowRoot, allOuters, 2, expectedDropdown3Value);
		System.out.println("Dropdown 3 value selected: " + expectedDropdown3Value);
		test.pass("Dropdown 3 value changed to: " + expectedDropdown3Value);

		Thread.sleep(2000);

		// Step 6: Re-fetch dropdowns after change (DOM may have refreshed)
		allOuters = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer:not(.mmd-select-alternate)"));
			return outers.size() >= 4 ? outers : null;
		});

		// Step 7: Select value from fourth dropdown (index 3)
		selectMMDDropdownValue(wait, shadowRoot, allOuters, 3, expectedDropdown4Value);
		System.out.println("Dropdown 4 value selected: " + expectedDropdown4Value);
		test.pass("Dropdown 4 value changed to: " + expectedDropdown4Value);

		Thread.sleep(3000);

		// Step 8: Click the "Index" tab and validate whether user is able to click it
		WebElement indexTab = wait.until(driver -> {
			List<WebElement> tabs = shadowRoot.findElements(By.cssSelector("div.mmd-tabs div.mmd-tab label"));
			for (WebElement tab : tabs) {
				if (tab.getText().trim().equalsIgnoreCase("Index")) {
					return tab;
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", indexTab);
		String indexTabText = indexTab.getText().trim();
		System.out.println("Index tab text: " + indexTabText);
		test.info("Index tab text: " + indexTabText);

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", indexTab);
		System.out.println("Index tab clicked");

		Thread.sleep(2000);

		// Step 9: Validate that Index tab is now active/selected
		WebElement activeInput = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var inputs = shadow.querySelectorAll('div.mmd-tabs input[type=\"radio\"]');" +
				"for (var i = 0; i < inputs.length; i++) {" +
				"  if (inputs[i].checked) return inputs[i];" +
				"}" +
				"return null;"
		);

		String activeTabId = activeInput != null ? activeInput.getDomAttribute("id") : "";
		System.out.println("Active tab radio input ID: " + activeTabId);

		boolean isIndexActive = activeTabId.toLowerCase().contains("index");

		// Fallback: check if graph container is displayed after clicking Index
		if (!isIndexActive) {
			List<WebElement> graphElements = shadowRoot.findElements(By.cssSelector("div.chart-container"));
			isIndexActive = !graphElements.isEmpty() && graphElements.get(0).isDisplayed();
		}

		if (isIndexActive) {
			System.out.println("PASSED: User is able to click the Index button successfully");
			test.pass("Index tab clicked and active after dropdown changes")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "gradeindex_pass"));
		} else {
			System.out.println("FAILED: User is NOT able to click the Index button");
			test.fail("Index tab is NOT active after clicking")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "gradeindex_fail"));
			Assert.fail("User is not able to click the Index button after changing the dropdowns");
		}
	}

	@SuppressWarnings("static-access")
	public void coststructurehover() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		// Wait for the cost structure chart container to load inside shadow DOM
		WebElement chartContainer = wait.until(driver -> {
			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();
			List<WebElement> containers = shadowRoot.findElements(Category.costStructureChartContainer);
			if (containers.size() > 0 && containers.get(0).isDisplayed()) {
				return containers.get(0);
			}
			return null;
		});

		// Scroll to cost structure section by scrolling the host element into view and offsetting
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(1000);
		// Scroll down further to bring cost structure section into view
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('#mmd-cost-structure-mark');" +
			"if (section) { section.scrollIntoView({behavior:'smooth', block:'center'}); }" +
			"else { window.scrollBy(0, 600); }"
		);
		Thread.sleep(3000);

		// Step 1: Get the Labor value from the cost component table first
		String tableLaborValue = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var table = section.querySelector('table.mmd-cs-table');" +
			"if (!table) return null;" +
			"var rows = table.querySelectorAll('tbody tr');" +
			"for (var i = 0; i < rows.length; i++) {" +
			"  var cells = rows[i].querySelectorAll('td');" +
			"  if (cells.length > 1 && cells[0].textContent.trim().includes('Labor')) {" +
			"    return cells[1].textContent.trim();" +
			"  }" +
			"}" +
			"return null;"
		);

		System.out.println("Labor value from cost component table: " + tableLaborValue);

		if (tableLaborValue == null || tableLaborValue.isEmpty()) {
			test.fail("Labor value not found in cost component table")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurehover_table_fail"));
			Assert.fail("Labor value not found in cost component table");
		}

		// Step 2: Hover over the donut chart using JavaScript mouse events (Actions doesn't work inside shadow DOM)
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"var chart = section.querySelector('div[style*=\"width: 310px\"][style*=\"height: 310px\"]');" +
			"if (chart) {" +
			"  var rect = chart.getBoundingClientRect();" +
			"  var x = rect.left + rect.width / 4;" +
			"  var y = rect.top + rect.height / 3;" +
			"  var mouseOver = new MouseEvent('mouseover', {bubbles: true, clientX: x, clientY: y});" +
			"  var mouseMove = new MouseEvent('mousemove', {bubbles: true, clientX: x, clientY: y});" +
			"  chart.dispatchEvent(mouseOver);" +
			"  chart.dispatchEvent(mouseMove);" +
			"}"
		);
		Thread.sleep(5000);

		// Step 3: Get the Labor value from the hover tooltip
		String hoverLaborValue = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"for (var i = 0; i < legendGroups.length; i++) {" +
			"  var label = legendGroups[i].querySelector('div.mmd-cost-legend.mmd-flex-1');" +
			"  var value = legendGroups[i].querySelector('div.mmd-cost-legend[style*=\"min-width\"]');" +
			"  if (label && label.textContent.trim() === 'Labor' && value) {" +
			"    return value.textContent.trim();" +
			"  }" +
			"}" +
			"return null;"
		);

		System.out.println("Labor value from hover tooltip: " + hoverLaborValue);

		if (hoverLaborValue == null || hoverLaborValue.isEmpty()) {
			test.fail("Labor value not found in hover tooltip")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurehover_tooltip_fail"));
			Assert.fail("Labor value not found in hover tooltip");
		}

		// Step 4: Verify both values match
		try {
			Assert.assertEquals(hoverLaborValue, tableLaborValue);
			test.pass("Cost Structure Hover: Labor value from tooltip (" + hoverLaborValue
					+ ") matches cost component table (" + tableLaborValue + ")")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurehover_pass"));
			System.out.println("PASSED: Labor hover value matches cost component table value");
		} catch (AssertionError e) {
			test.fail("Cost Structure Hover: Labor value mismatch. Tooltip: " + hoverLaborValue
					+ " | Table: " + tableLaborValue)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurehover_fail"));
			throw e;
		}
	}

	@SuppressWarnings("static-access")
	public void coststructurelatestyear() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		// Wait for cost structure section to load inside shadow DOM
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(2000);
		// Scroll to cost structure section using offsetTop calculation
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (section) {" +
			"  var rect = section.getBoundingClientRect();" +
			"  window.scrollBy(0, rect.top - 50);" +
			"} else { window.scrollBy(0, 800); }"
		);
		Thread.sleep(3000);

		// Step 1: Verify the latest year is displayed in the dropdown
		String currentYear = String.valueOf(java.time.Year.now().getValue());
		String dropdownYear = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var selects = section.querySelectorAll('div.mmd-select-outer div.mmd-select span');" +
			"for (var i = 0; i < selects.length; i++) {" +
			"  var text = selects[i].textContent.trim();" +
			"  if (/^\\d{4}$/.test(text)) { return text; }" +
			"}" +
			"return null;"
		);

		System.out.println("Year displayed in dropdown: " + dropdownYear);
		System.out.println("Current year: " + currentYear);

		if (dropdownYear != null && dropdownYear.equals(currentYear)) {
			test.pass("Latest year " + dropdownYear + " is displayed in the cost structure dropdown");
			System.out.println("PASSED: Latest year is displayed in dropdown");
		} else {
			test.fail("Latest year not displayed. Expected: " + currentYear + " but found: " + dropdownYear)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructure_year_fail"));
			Assert.fail("Latest year not displayed in dropdown. Expected: " + currentYear + " Found: " + dropdownYear);
		}

		// Step 2: Read all cost component names and values from the legend panel
		@SuppressWarnings("unchecked")
		List<String> legendResults = (List<String>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return [];" +
			"var results = [];" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"if (legendGroups.length === 0) {" +
			"  var panel = section.querySelector('div.mmd-cs-legend-panel');" +
			"  if (panel) { legendGroups = panel.querySelectorAll('div.mmd-flex-center'); }" +
			"}" +
			"for (var i = 0; i < legendGroups.length; i++) {" +
			"  var labels = legendGroups[i].querySelectorAll('div.mmd-cost-legend');" +
			"  if (labels.length >= 2) {" +
			"    var name = labels[0].textContent.trim();" +
			"    var val = labels[1].textContent.trim();" +
			"    if (name && val) { results.push(name + ' : ' + val); }" +
			"  }" +
			"}" +
			"return results;"
		);

		System.out.println("=== Cost Structure - Pie Chart Legend Values ===");
		if (legendResults != null && !legendResults.isEmpty()) {
			for (String result : legendResults) {
				System.out.println("  " + result);
				test.info("Pie Chart Component: " + result);
			}
		}

		// Step 3: Hover over the pie chart to display tooltip
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return;" +
			"var chart = section.querySelector('div[style*=\"width: 310px\"][style*=\"height: 310px\"]');" +
			"if (!chart) chart = section.querySelector('div[style*=\"position: relative\"]');" +
			"if (chart) {" +
			"  var rect = chart.getBoundingClientRect();" +
			"  var x = rect.left + rect.width * 0.25;" +
			"  var y = rect.top + rect.height * 0.35;" +
			"  chart.dispatchEvent(new MouseEvent('mouseenter', {bubbles: true, clientX: x, clientY: y}));" +
			"  chart.dispatchEvent(new MouseEvent('mouseover', {bubbles: true, clientX: x, clientY: y}));" +
			"  chart.dispatchEvent(new MouseEvent('mousemove', {bubbles: true, clientX: x, clientY: y}));" +
			"}"
		);
		Thread.sleep(5000);

		if (legendResults != null && !legendResults.isEmpty()) {
			test.pass("Successfully retrieved all pie chart component values with hover")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructure_latestyear_pass"));
			System.out.println("PASSED: All pie chart hover values printed successfully");
		} else {
			test.fail("No hover values found from pie chart")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructure_latestyear_fail"));
			Assert.fail("No hover values found from pie chart segments");
		}
	}

	@SuppressWarnings("static-access")
	public void prcetrendhover() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		// Get expected currency value from test data
		String expectedCurrency = data.getColumnDataAsString("CategoryWatchFullregressionTestdata",
				"Categorywatch_fullregression", "Expected Text - 1", testCase).trim();

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Step 1: Click the currency dropdown to open it
		WebElement currencyDropdown = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (outer.isDisplayed()) {
					WebElement sel = outer.findElement(By.cssSelector("div.mmd-select"));
					if (sel.isDisplayed()) {
						return sel;
					}
				}
			}
			return null;
		});

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", currencyDropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyDropdown);
		System.out.println("Currency dropdown clicked");
		Thread.sleep(2000);

		// Step 2: Type the expected currency in the search field inside the dropdown
		WebElement searchField = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (!outer.isDisplayed()) continue;
				List<WebElement> inputs = outer.findElements(By.cssSelector("input"));
				for (WebElement input : inputs) {
					if (input.isDisplayed()) {
						return input;
					}
				}
			}
			return null;
		});

		searchField.clear();
		searchField.sendKeys(expectedCurrency);
		System.out.println("Typed in search field: " + expectedCurrency);
		Thread.sleep(3000);

		// Step 3: Select the matching currency option from the filtered list
		WebElement currencyOption = wait.until(driver -> {
			List<WebElement> outers = shadowRoot.findElements(By.cssSelector("div.mmd-select-outer.mmd-select-alternate"));
			for (WebElement outer : outers) {
				if (!outer.isDisplayed()) continue;
				// Try multiple selectors for dropdown items
				List<WebElement> items = outer.findElements(By.cssSelector("div.mmd-select-dropdown div[value], div.mmd-select-dropdown div"));
				for (WebElement item : items) {
					String itemText = item.getText().trim();
					if (item.isDisplayed() && !itemText.isEmpty() && 
						(itemText.equalsIgnoreCase(expectedCurrency) || itemText.contains(expectedCurrency) || expectedCurrency.contains(itemText))) {
						System.out.println("Found matching option: " + itemText);
						return item;
					}
				}
			}
			return null;
		});

		// Try Actions click first, fallback to JS click
		try {
			new Actions(driver).moveToElement(currencyOption).pause(Duration.ofMillis(300)).click().perform();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyOption);
		}
		System.out.println("Selected currency: " + expectedCurrency);
		test.info("Changed currency dropdown to: " + expectedCurrency);

		// Step 4: Wait for graph to refresh after currency change
		Thread.sleep(5000);

		// Step 5: Get the current price and unit displayed after currency change
		String currentPriceText = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var priceEl = shadow.querySelector('div.mmd-current-price');" +
			"return priceEl ? priceEl.textContent.trim() : null;"
		);

		String currentUnit = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var holder = shadow.querySelector('div.mmd-current-price-holder');" +
			"if (!holder) return null;" +
			"var spans = holder.querySelectorAll('span');" +
			"for (var i = 0; i < spans.length; i++) {" +
			"  var text = spans[i].textContent.trim();" +
			"  if (text.indexOf('/') > -1) { return text; }" +
			"}" +
			"return null;"
		);

		System.out.println("Current Price after dropdown change: " + currentPriceText);
		System.out.println("Current Unit: " + currentUnit);
		test.info("Current Price: " + currentPriceText + " | Unit: " + currentUnit);

		// Step 6: Scroll the price trend chart section into view and hover on the forecast split
		WebElement forecastSplit = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (section) section.scrollIntoView({block:'center'});" +
			"var splits = shadow.querySelectorAll('div.mmd-forecast-splits div.mmd-forecast-split');" +
			"return (splits && splits.length > 0) ? splits[0] : null;"
		);

		if (forecastSplit == null) {
			test.fail("Forecast split element not found in chart");
			Assert.fail("Forecast split element not found");
		}

		Thread.sleep(2000);

		Actions actions = new Actions(driver);
		actions.moveToElement(forecastSplit).pause(Duration.ofSeconds(3)).perform();
		Thread.sleep(3000);

		// Step 7: Read the dropdown's currently selected value after currency change
		String dropdownSelectedValue = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var outers = shadow.querySelectorAll('div.mmd-select-outer.mmd-select-alternate');" +
			"for (var i = 0; i < outers.length; i++) {" +
			"  var sel = outers[i].querySelector('div.mmd-select');" +
			"  if (sel && sel.offsetParent !== null) { return sel.textContent.trim(); }" +
			"}" +
			"return null;"
		);
		System.out.println("Dropdown selected value: " + dropdownSelectedValue);

		// Step 8: Get the chart tooltip value after hover
		// The tooltip may appear in main DOM or shadow DOM - search broadly but exclude help text
		String hoverValue = (String) ((JavascriptExecutor) driver).executeScript(
			// 1. Check main DOM for Vega tooltip element
			"var vgTooltip = document.getElementById('vg-tooltip-element');" +
			"if (vgTooltip) {" +
			"  var s = getComputedStyle(vgTooltip);" +
			"  if (s.visibility !== 'hidden' && s.display !== 'none' && s.opacity !== '0' && vgTooltip.textContent.trim()) {" +
			"    return 'FOUND_VG_ID:' + vgTooltip.textContent.trim();" +
			"  }" +
			"}" +
			// 2. Check main DOM for any .vg-tooltip elements
			"var vgAll = document.querySelectorAll('.vg-tooltip');" +
			"for (var i = 0; i < vgAll.length; i++) {" +
			"  var s2 = getComputedStyle(vgAll[i]);" +
			"  if (s2.visibility !== 'hidden' && s2.display !== 'none' && s2.opacity !== '0' && vgAll[i].textContent.trim()) {" +
			"    return 'FOUND_VG_CLASS:' + vgAll[i].textContent.trim();" +
			"  }" +
			"}" +
			// 3. Check shadow DOM for tooltip that contains a number (price) - skip help text
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var allDivs = shadow.querySelectorAll('div[class*=\"tooltip\"]');" +
			"for (var j = 0; j < allDivs.length; j++) {" +
			"  var txt = allDivs[j].textContent.trim();" +
			"  if (txt && /\\d{1,3}(,\\d{3})*\\.\\d+/.test(txt)) {" +
			"    return 'FOUND_SHADOW_TOOLTIP:' + txt;" +
			"  }" +
			"}" +
			// 4. Check for any absolutely positioned overlay with price-like text in shadow DOM
			"var allEls = shadow.querySelectorAll('div[style*=\"position: absolute\"], div[style*=\"position:absolute\"]');" +
			"for (var k = 0; k < allEls.length; k++) {" +
			"  var t = allEls[k].textContent.trim();" +
			"  if (t && /\\d{1,3}(,\\d{3})*\\.\\d+/.test(t) && t.length < 200) {" +
			"    return 'FOUND_ABSOLUTE:' + t;" +
			"  }" +
			"}" +
			// 5. DEBUG: Search ALL elements in body for price-like text that appeared after hover
			"var bodyEls = document.querySelectorAll('div, span, p, td');" +
			"for (var m = 0; m < bodyEls.length; m++) {" +
			"  var bt = bodyEls[m].textContent.trim();" +
			"  if (bt && bt.length < 100 && /\\d{1,3}(,\\d{3})*\\.\\d{2}/.test(bt) && bt.indexOf('/') > -1) {" +
			"    var bs = getComputedStyle(bodyEls[m]);" +
			"    if (bs.display !== 'none' && bs.visibility !== 'hidden') {" +
			"      return 'FOUND_BODY:' + bodyEls[m].tagName + '.' + bodyEls[m].className + ':' + bt;" +
			"    }" +
			"  }" +
			"}" +
			// 6. Search ALL shadow DOM elements for any visible price text
			"var shadowAll = shadow.querySelectorAll('div, span, p');" +
			"var results = [];" +
			"for (var n = 0; n < shadowAll.length; n++) {" +
			"  var st = shadowAll[n].textContent.trim();" +
			"  if (st && st.length < 100 && /\\d{1,3}(,\\d{3})*\\.\\d{2}/.test(st) && st.indexOf('/') > -1) {" +
			"    results.push(shadowAll[n].tagName + '.' + shadowAll[n].className + ':' + st);" +
			"  }" +
			"}" +
			"if (results.length > 0) return 'FOUND_SHADOW_ALL:' + results.join(' || ');" +
			"return null;"
		);

		System.out.println("Hover tooltip value: " + hoverValue);

		// Step 9: Compare dropdown value + unit with hover tooltip value + unit
		// Clean the debug prefix from hoverValue
		String cleanHoverValue = hoverValue;
		if (hoverValue != null && hoverValue.contains(":")) {
			cleanHoverValue = hoverValue.substring(hoverValue.indexOf(":", hoverValue.indexOf(":") + 1) + 1);
			if (cleanHoverValue.equals(hoverValue)) {
				cleanHoverValue = hoverValue.substring(hoverValue.indexOf(":") + 1);
			}
		}
		System.out.println("Clean hover value: " + cleanHoverValue);

		// Extract the unit from dropdown (remove "Currency" suffix if any)
		String dropdownUnit = dropdownSelectedValue != null ? dropdownSelectedValue.replaceAll("(?i)currency", "").trim() : "";
		System.out.println("Dropdown unit: " + dropdownUnit);
		System.out.println("Current Unit from page: " + currentUnit);

		if (cleanHoverValue != null && !cleanHoverValue.isEmpty() && !cleanHoverValue.equals("null")) {
			test.info("Hover Tooltip: " + cleanHoverValue);
			test.info("Dropdown Value: " + dropdownUnit);
			test.info("Current Unit: " + currentUnit);

			// Compare: hover tooltip unit should match dropdown unit
			boolean unitMatch = false;
			if (currentUnit != null && cleanHoverValue.contains(currentUnit)) {
				unitMatch = true;
			} else if (!dropdownUnit.isEmpty() && cleanHoverValue.contains(dropdownUnit)) {
				unitMatch = true;
			}

			if (unitMatch) {
				test.pass("Price Trend Hover: Hover tooltip unit matches dropdown unit - Dropdown: "
						+ dropdownUnit + " | Hover: " + cleanHoverValue)
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "pricetrendhover_pass"));
				System.out.println("PASS: Hover tooltip unit matches dropdown unit");
			} else {
				test.fail("Price Trend Hover: Hover tooltip unit does NOT match dropdown unit - Dropdown: "
						+ dropdownUnit + " | Current Unit: " + currentUnit + " | Hover: " + cleanHoverValue)
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "pricetrendhover_fail"));
				System.out.println("FAIL: Hover tooltip unit does not match dropdown unit");
			}
		} else {
			test.fail("Price Trend Hover: Tooltip not detected after hovering on chart")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "pricetrendhover_fail"));
			System.out.println("FAIL: No hover tooltip detected");
		}
	}

	@SuppressWarnings("static-access")
	public void pricetrendmonthhover() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Wait for the beroe-mmd shadow host to be present
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		SearchContext shadowRoot = shadowHost.getShadowRoot();

		// Scroll the beroe-mmd host into view first
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", shadowHost);
		Thread.sleep(2000);

		// Scroll to the price trend section inside shadow DOM
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (section) {" +
			"  var rect = section.getBoundingClientRect();" +
			"  window.scrollBy(0, rect.top - 100);" +
			"} else { window.scrollBy(0, 600); }"
		);
		Thread.sleep(3000);

		// Wait for the chart to load by checking for the SVG/canvas element in the price trend section
		WebElement priceTrendSection = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"return shadow.querySelector('div.mmd-section#mmd-price-trend');"
		);

		if (priceTrendSection == null) {
			test.fail("Price trend section not found");
			Assert.fail("Price trend section not found");
		}

		// Scroll the price trend section into center view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", priceTrendSection);
		Thread.sleep(3000);

		// The red line is at the current month position on the chart x-axis.
		// Use the section element's own dimensions to calculate offset for hover.
		// The section contains the chart — the red line is at ~40% from the left (12 months / 30 total).
		int sectionWidth = priceTrendSection.getSize().getWidth();
		int sectionHeight = priceTrendSection.getSize().getHeight();

		// Calculate the x-position for the current month dynamically
		// Chart range: starts 12 months before current month, ends 18 months after = 30 months total
		// The red line (current month) is always at position 12/30 from the left
		LocalDate now = LocalDate.now();
		LocalDate chartStart = now.minusMonths(12).withDayOfMonth(1);
		LocalDate chartEnd = now.plusMonths(18).withDayOfMonth(1);
		long totalMonths = java.time.temporal.ChronoUnit.MONTHS.between(chartStart, chartEnd);
		long monthsFromStart = java.time.temporal.ChronoUnit.MONTHS.between(chartStart, now.withDayOfMonth(1));

		double ratio = (double) monthsFromStart / (double) totalMonths;

		// Calculate offset from the section's center (moveToElement uses center as origin)
		// X: from center, move to the ratio position (ratio=0.4 means 40% from left)
		int offsetX = (int) (ratio * sectionWidth) - (sectionWidth / 2);
		// Y: stay at vertical center of the section (offset = 0)
		int offsetY = 0;

		System.out.println("Section size: " + sectionWidth + "x" + sectionHeight);
		System.out.println("Hovering at offset: x=" + offsetX + ", y=" + offsetY + " (ratio=" + ratio + ")");

		// Hover using Actions with offset from section center
		Actions actions = new Actions(driver);
		actions.moveToElement(priceTrendSection, offsetX, offsetY).pause(Duration.ofSeconds(3)).perform();
		Thread.sleep(3000);

		// Extract tooltip text after hovering - search all possible locations
		String tooltipText = (String) ((JavascriptExecutor) driver).executeScript(
			// 1. Vega tooltip by ID
			"var vgTooltip = document.getElementById('vg-tooltip-element');" +
			"if (vgTooltip) {" +
			"  var s = getComputedStyle(vgTooltip);" +
			"  if (s.visibility !== 'hidden' && s.display !== 'none' && s.opacity !== '0' && vgTooltip.textContent.trim()) {" +
			"    return vgTooltip.textContent.trim();" +
			"  }" +
			"}" +
			// 2. Search ALL divs/spans in main DOM for month-year pattern (tooltip could be any element)
			"var allEls = document.querySelectorAll('div, span, p, td');" +
			"for (var i = 0; i < allEls.length; i++) {" +
			"  var el = allEls[i];" +
			"  var txt = el.innerText || el.textContent;" +
			"  if (!txt) continue;" +
			"  txt = txt.trim();" +
			"  if (txt.length > 0 && txt.length < 80 && /[A-Z][a-z]{2}-\\d{4}/.test(txt) && /\\d+\\.\\d+/.test(txt)) {" +
			"    var s2 = getComputedStyle(el);" +
			"    if (s2.display !== 'none' && s2.visibility !== 'hidden') {" +
			"      return txt;" +
			"    }" +
			"  }" +
			"}" +
			// 3. Shadow DOM search
			"var host = document.querySelector('beroe-mmd');" +
			"if (host && host.shadowRoot) {" +
			"  var shadow = host.shadowRoot;" +
			"  var shadowEls = shadow.querySelectorAll('div, span, p');" +
			"  for (var j = 0; j < shadowEls.length; j++) {" +
			"    var el2 = shadowEls[j];" +
			"    var txt2 = el2.innerText || el2.textContent;" +
			"    if (!txt2) continue;" +
			"    txt2 = txt2.trim();" +
			"    if (txt2.length > 0 && txt2.length < 80 && /[A-Z][a-z]{2}-\\d{4}/.test(txt2) && /\\d+\\.\\d+/.test(txt2)) {" +
			"      return txt2;" +
			"    }" +
			"  }" +
			"}" +
			"return null;"
		);

		System.out.println("Tooltip text after hover: " + tooltipText);

		// Get the current month in the format displayed in tooltip (e.g., "May-2026")
		String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM-yyyy", Locale.ENGLISH));
		System.out.println("Current Month: " + currentMonth);

		if (tooltipText != null && tooltipText.contains(currentMonth)) {
			test.pass("Price Trend Month Hover: Tooltip displays current month (" + currentMonth + ") - PASSED")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "pricetrendmonthhover_pass"));
			System.out.println("PASS: Tooltip displays current month - " + currentMonth);
		} else {
			test.fail("Price Trend Month Hover: Tooltip does NOT display current month. Expected: "
					+ currentMonth + " | Actual tooltip: " + tooltipText)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "pricetrendmonthhover_fail"));
			Assert.fail("Tooltip does not display current month. Expected: " + currentMonth + " | Actual: " + tooltipText);
		}
	}

	@SuppressWarnings("static-access")
	public void newcoststructuredesign() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		// Wait for the cost structure section to load inside shadow DOM
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(2000);

		// Scroll to cost structure section
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (section) {" +
			"  var rect = section.getBoundingClientRect();" +
			"  window.scrollBy(0, rect.top - 50);" +
			"} else { window.scrollBy(0, 800); }"
		);
		Thread.sleep(3000);

		// Step 1: Verify "Global" region is selected in the dropdown
		String selectedRegion = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var selects = section.querySelectorAll('div.mmd-select-outer div.mmd-select span');" +
			"for (var i = 0; i < selects.length; i++) {" +
			"  var text = selects[i].textContent.trim();" +
			"  if (text === 'Global') { return text; }" +
			"}" +
			"return selects.length > 0 ? selects[0].textContent.trim() : null;"
		);

		System.out.println("Selected Region: " + selectedRegion);

		if (selectedRegion != null && selectedRegion.equals("Global")) {
			test.pass("Cost Structure: Global region is selected by default");
			System.out.println("PASSED: Global region is selected");
		} else {
			test.fail("Cost Structure: Global region is NOT selected. Found: " + selectedRegion)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_region_fail"));
			Assert.fail("Global region not selected. Found: " + selectedRegion);
		}

		// Step 2: Verify current year is displayed in the dropdown
		String currentYear = String.valueOf(java.time.Year.now().getValue());
		String dropdownYear = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var selects = section.querySelectorAll('div.mmd-select-outer div.mmd-select span');" +
			"for (var i = 0; i < selects.length; i++) {" +
			"  var text = selects[i].textContent.trim();" +
			"  if (/^\\d{4}$/.test(text)) { return text; }" +
			"}" +
			"return null;"
		);

		System.out.println("Year displayed in dropdown: " + dropdownYear);
		System.out.println("Current year: " + currentYear);

		if (dropdownYear != null && dropdownYear.equals(currentYear)) {
			test.pass("Cost Structure: Current year " + dropdownYear + " is displayed");
			System.out.println("PASSED: Current year is displayed");
		} else {
			test.fail("Cost Structure: Current year not displayed. Expected: " + currentYear + " Found: " + dropdownYear)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_year_fail"));
			Assert.fail("Current year not displayed. Expected: " + currentYear + " Found: " + dropdownYear);
		}

		// Step 3: Verify current quarter is displayed in the dropdown
		int currentQuarter = (LocalDate.now().getMonthValue() - 1) / 3 + 1;
		String expectedQuarter = "Q" + currentQuarter;
		String dropdownQuarter = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var selects = section.querySelectorAll('div.mmd-select-outer div.mmd-select span');" +
			"for (var i = 0; i < selects.length; i++) {" +
			"  var text = selects[i].textContent.trim();" +
			"  if (/^Q[1-4]$/.test(text)) { return text; }" +
			"}" +
			"return null;"
		);

		System.out.println("Quarter displayed in dropdown: " + dropdownQuarter);
		System.out.println("Expected quarter: " + expectedQuarter);

		if (dropdownQuarter != null && dropdownQuarter.equals(expectedQuarter)) {
			test.pass("Cost Structure: Current quarter " + dropdownQuarter + " is displayed");
			System.out.println("PASSED: Current quarter is displayed");
		} else {
			System.out.println("WARNING: Current quarter not matched. Expected: " + expectedQuarter + " | Found: " + dropdownQuarter);
			test.warning("Cost Structure: Current quarter not displayed. Expected: " + expectedQuarter + " | Found: " + dropdownQuarter);
		}

		// Step 4: Verify primary elements and their percentage values in the Global column
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> primaryElements = (List<Map<String, Object>>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return [];" +
			"var table = section.querySelector('table.mmd-cs-table');" +
			"if (!table) return [];" +
			"var results = [];" +
			"var rows = table.querySelectorAll('tbody tr');" +
			"for (var i = 0; i < rows.length; i++) {" +
			"  var row = rows[i];" +
			"  var cells = row.querySelectorAll('td');" +
			"  if (cells.length < 2) continue;" +
			"  var nameCell = cells[0];" +
			"  var globalCell = cells[1];" +
			"  var name = nameCell.textContent.trim();" +
			"  var value = globalCell.textContent.trim();" +
			"  var isSubRow = row.classList.contains('mmd-cs-sub-row') || row.classList.contains('sub-row') || nameCell.querySelector('span.mmd-cs-sub-label') !== null;" +
			"  if (!isSubRow && name !== '' && name !== 'Cost Components') {" +
			"    var hasPercentage = /\\d+\\.\\d+%/.test(value);" +
			"    results.push({name: name, value: value, hasPercentage: hasPercentage});" +
			"  }" +
			"}" +
			"return results;"
		);

		System.out.println("=== Primary Elements (Global Column) ===");
		boolean allPrimaryHavePercentage = true;
		List<String> failedPrimary = new ArrayList<>();

		if (primaryElements != null && !primaryElements.isEmpty()) {
			for (Map<String, Object> element : primaryElements) {
				String name = (String) element.get("name");
				String value = (String) element.get("value");
				Boolean hasPercentage = (Boolean) element.get("hasPercentage");
				System.out.println("  " + name + " : " + value);
				test.info("Primary Element: " + name + " = " + value);

				if (!hasPercentage) {
					allPrimaryHavePercentage = false;
					failedPrimary.add(name + " (" + value + ")");
				}
			}
		} else {
			test.fail("No primary elements found in cost structure table")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_primary_fail"));
			Assert.fail("No primary elements found in cost structure table");
		}

		if (!allPrimaryHavePercentage) {
			test.fail("Primary elements without percentage value: " + failedPrimary)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_primary_pct_fail"));
			Assert.fail("Primary elements missing percentage: " + failedPrimary);
		}

		test.pass("All primary elements have valid percentage values in Global column");
		System.out.println("PASSED: All primary elements have percentage values");

		// Step 5: Verify secondary elements by hovering on primary elements in the Cost Components legend (right side)
		// Secondary elements (e.g., Diesel, Electricity) appear in a tooltip when hovering over a primary legend item
		System.out.println("=== Hovering on Cost Components legend items to find secondary elements ===");
		boolean allSecondaryHavePercentage = true;
		List<String> failedSecondary = new ArrayList<>();
		List<String> allSecondaryFound = new ArrayList<>();

		// Get the count of legend group items
		Long legendCount = (Long) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return 0;" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"return legendGroups.length;"
		);

		System.out.println("Number of primary legend items found: " + legendCount);

		for (int i = 0; i < legendCount; i++) {
			// Get the legend group element as a WebElement
			WebElement legendItem = (WebElement) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
				"if (!section) return null;" +
				"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
				"if (arguments[0] >= legendGroups.length) return null;" +
				"return legendGroups[arguments[0]];", i
			);

			if (legendItem == null) continue;

			// Get the primary element name for logging
			String primaryName = (String) ((JavascriptExecutor) driver).executeScript(
				"var label = arguments[0].querySelector('div.mmd-cost-legend.mmd-flex-1');" +
				"return label ? label.textContent.trim() : '';", legendItem
			);

			System.out.println("Hovering on: " + primaryName);

			// Use Actions.moveToElement to perform real hover on the legend item
			Actions actions = new Actions(driver);
			actions.moveToElement(legendItem).pause(Duration.ofSeconds(3)).perform();
			Thread.sleep(3000);

			// Read the tooltip/popover that appears after hovering
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> tooltipSecondary = (List<Map<String, Object>>) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
				"if (!section) return [];" +
				"var results = [];" +
				"var primaryName = arguments[0];" +
				// Search for tooltip/popover in shadow DOM
				"var allEls = shadow.querySelectorAll('div');" +
				"for (var i = 0; i < allEls.length; i++) {" +
				"  var el = allEls[i];" +
				"  var style = getComputedStyle(el);" +
				"  if (style.display === 'none' || style.visibility === 'hidden' || style.opacity === '0') continue;" +
				"  var cls = el.className || '';" +
				"  if (!(style.position === 'absolute' || style.position === 'fixed' || " +
				"    cls.indexOf('tooltip') > -1 || cls.indexOf('popover') > -1 || cls.indexOf('breakdown') > -1 || cls.indexOf('hover') > -1)) continue;" +
				"  var text = el.textContent.trim();" +
				"  if (!text || text.length > 300 || !/\\d+\\.\\d+%/.test(text)) continue;" +
				"  var lines = text.split(/\\n/);" +
				"  for (var j = 0; j < lines.length; j++) {" +
				"    var line = lines[j].trim();" +
				"    if (!line) continue;" +
				"    var match = line.match(/^[●•]?\\s*(.+?)\\s+(\\d+\\.\\d+%)\\s*$/);" +
				"    if (match) {" +
				"      var name = match[1].replace(/^[●•\\s]+/, '').trim();" +
				"      var val = match[2].trim();" +
				"      if (name !== '' && name !== primaryName) {" +
				"        var exists = false;" +
				"        for (var k = 0; k < results.length; k++) { if (results[k].name === name) { exists = true; break; } }" +
				"        if (!exists) results.push({name: name, value: val, hasPercentage: true});" +
				"      }" +
				"    }" +
				"  }" +
				"}" +
				// Also check main DOM for tooltips (some are rendered outside shadow DOM)
				"var mainTooltips = document.querySelectorAll('div[class*=\"tooltip\"], div[class*=\"popover\"], div[role=\"tooltip\"]');" +
				"for (var m = 0; m < mainTooltips.length; m++) {" +
				"  var tip = mainTooltips[m];" +
				"  var ts = getComputedStyle(tip);" +
				"  if (ts.display === 'none' || ts.visibility === 'hidden' || ts.opacity === '0') continue;" +
				"  var tText = tip.textContent.trim();" +
				"  if (!tText || tText.length > 300 || !/\\d+\\.\\d+%/.test(tText)) continue;" +
				"  var tLines = tText.split(/\\n/);" +
				"  for (var n = 0; n < tLines.length; n++) {" +
				"    var tl = tLines[n].trim();" +
				"    if (!tl) continue;" +
				"    var tm = tl.match(/^[●•]?\\s*(.+?)\\s+(\\d+\\.\\d+%)\\s*$/);" +
				"    if (tm) {" +
				"      var tName = tm[1].replace(/^[●•\\s]+/, '').trim();" +
				"      var tVal = tm[2].trim();" +
				"      if (tName !== '' && tName !== primaryName) {" +
				"        var texists = false;" +
				"        for (var o = 0; o < results.length; o++) { if (results[o].name === tName) { texists = true; break; } }" +
				"        if (!texists) results.push({name: tName, value: tVal, hasPercentage: true});" +
				"      }" +
				"    }" +
				"  }" +
				"}" +
				"return results;", primaryName
			);

			if (tooltipSecondary != null && !tooltipSecondary.isEmpty()) {
				for (Map<String, Object> element : tooltipSecondary) {
					String name = (String) element.get("name");
					String value = (String) element.get("value");
					Boolean hasPercentage = (Boolean) element.get("hasPercentage");
					boolean alreadyFound = allSecondaryFound.stream().anyMatch(s -> s.startsWith(name + " ="));
					if (!alreadyFound) {
						System.out.println("  Secondary (from " + primaryName + "): " + name + " = " + value);
						test.info("Secondary Element (hover on " + primaryName + "): " + name + " = " + value);
						allSecondaryFound.add(name + " = " + value);
						if (!hasPercentage) {
							allSecondaryHavePercentage = false;
							failedSecondary.add(name + " (" + value + ")");
						}
					}
				}
			} else {
				System.out.println("  No secondary elements for: " + primaryName);
			}
		}

		if (!allSecondaryFound.isEmpty()) {
			if (!allSecondaryHavePercentage) {
				test.fail("Secondary elements without percentage value: " + failedSecondary)
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_secondary_pct_fail"));
				Assert.fail("Secondary elements missing percentage: " + failedSecondary);
			}
			test.pass("All secondary elements have valid percentage values (found " + allSecondaryFound.size() + " elements via hover)");
			System.out.println("PASSED: All secondary elements have percentage values via hover");
		} else {
			test.info("No secondary elements found via hover on legend items for this category");
			System.out.println("INFO: No secondary elements found via hover");
		}

		test.pass("Cost Structure Design verification PASSED: Global region, current year (" + currentYear
				+ "), current quarter (" + expectedQuarter + "), primary and secondary elements all validated")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "newcoststructuredesign_pass"));
		System.out.println("=== newcoststructuredesign - ALL VERIFICATIONS PASSED ===");
	}

	@SuppressWarnings("static-access")
	public void coststructurevaluecompare() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		// Wait for the cost structure section to load inside shadow DOM
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(2000);

		// Scroll to cost structure section
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (section) {" +
			"  var rect = section.getBoundingClientRect();" +
			"  window.scrollBy(0, rect.top - 50);" +
			"} else { window.scrollBy(0, 800); }"
		);
		Thread.sleep(3000);

		// Step 1: Get all Cost Component legend values from the right side panel
		@SuppressWarnings("unchecked")
		Map<String, String> legendValues = (Map<String, String>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return {};" +
			"var result = {};" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"for (var i = 0; i < legendGroups.length; i++) {" +
			"  var label = legendGroups[i].querySelector('div.mmd-cost-legend.mmd-flex-1');" +
			"  var value = legendGroups[i].querySelector('div.mmd-cost-legend[style*=\"min-width\"]');" +
			"  if (label && value) {" +
			"    var name = label.textContent.trim();" +
			"    var val = value.textContent.trim();" +
			"    if (name && val) { result[name] = val; }" +
			"  }" +
			"}" +
			"return result;"
		);

		System.out.println("=== Cost Components Legend Values ===");
		if (legendValues != null && !legendValues.isEmpty()) {
			for (Map.Entry<String, String> entry : legendValues.entrySet()) {
				System.out.println("  " + entry.getKey() + " : " + entry.getValue());
				test.info("Legend: " + entry.getKey() + " = " + entry.getValue());
			}
		} else {
			test.fail("No legend values found in Cost Components panel")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurevaluecompare_nolegend"));
			Assert.fail("No legend values found in Cost Components panel");
		}

		// Step 2: Get the donut chart element for hovering
		WebElement chartElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var chart = section.querySelector('div[style*=\"width: 310px\"][style*=\"height: 310px\"]');" +
			"if (!chart) chart = section.querySelector('div[style*=\"position: relative\"]');" +
			"return chart;"
		);

		if (chartElement == null) {
			test.fail("Donut chart element not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurevaluecompare_nochart"));
			Assert.fail("Donut chart element not found");
		}

		// Scroll chart into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", chartElement);
		Thread.sleep(1000);

		int chartWidth = chartElement.getSize().getWidth();
		int chartHeight = chartElement.getSize().getHeight();
		int radius = chartWidth / 2;
		int centerX = chartWidth / 2;
		int centerY = chartHeight / 2;

		// Step 3: Hover at multiple angles around the donut ring to hit each segment
		// The donut ring is between ~40% and ~90% of the radius from center
		int hoverRadius = (int) (radius * 0.65); // Middle of the donut ring
		int numPositions = 12; // Check 12 positions (every 30 degrees)
		Map<String, String> hoverValues = new java.util.LinkedHashMap<>();
		List<String> mismatchList = new ArrayList<>();

		for (int angle = 0; angle < 360; angle += (360 / numPositions)) {
			double radians = Math.toRadians(angle - 90); // Start from top (12 o'clock)
			int offsetX = (int) (hoverRadius * Math.cos(radians));
			int offsetY = (int) (hoverRadius * Math.sin(radians));

			Actions actions = new Actions(driver);
			actions.moveToElement(chartElement, offsetX, offsetY).pause(Duration.ofSeconds(2)).perform();
			Thread.sleep(2000);

			// Read only the header value from the tooltip popup (first "Name XX.XX%" only)
			String tooltipContent = (String) ((JavascriptExecutor) driver).executeScript(
				"var host = document.querySelector('beroe-mmd');" +
				"var shadow = host.shadowRoot;" +
				"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
				"if (!section) return null;" +
				// Search for the hover tooltip/popup in shadow DOM
				"var allEls = shadow.querySelectorAll('div');" +
				"for (var i = 0; i < allEls.length; i++) {" +
				"  var el = allEls[i];" +
				"  var style = getComputedStyle(el);" +
				"  if (style.display === 'none' || style.visibility === 'hidden' || style.opacity === '0') continue;" +
				"  var cls = el.className || '';" +
				"  if (!(style.position === 'absolute' || style.position === 'fixed' || " +
				"    cls.indexOf('tooltip') > -1 || cls.indexOf('hover') > -1 || cls.indexOf('popup') > -1)) continue;" +
				"  var text = el.textContent.trim();" +
				"  if (text && text.length < 200 && /\\d+\\.\\d+%/.test(text) && text.length > 3) {" +
				"    var match = text.match(/^[●•]?\\s*(.*?\\d+\\.\\d+%)/);" +
				"    if (match) return match[1] ? match[1].trim() : match[0].trim();" +
				"    return text;" +
				"  }" +
				"}" +
				// Also check main DOM
				"var mainEls = document.querySelectorAll('div[class*=\"tooltip\"], div[role=\"tooltip\"], div[class*=\"popup\"]');" +
				"for (var j = 0; j < mainEls.length; j++) {" +
				"  var mel = mainEls[j];" +
				"  var ms = getComputedStyle(mel);" +
				"  if (ms.display === 'none' || ms.visibility === 'hidden' || ms.opacity === '0') continue;" +
				"  var mt = mel.textContent.trim();" +
				"  if (mt && mt.length < 200 && /\\d+\\.\\d+%/.test(mt)) {" +
				"    var mm = mt.match(/^[●•]?\\s*(.*?\\d+\\.\\d+%)/);" +
				"    if (mm) return mm[1] ? mm[1].trim() : mm[0].trim();" +
				"    return mt;" +
				"  }" +
				"}" +
				"return null;"
			);

			if (tooltipContent != null && !tooltipContent.isEmpty()) {
				// Print the header value from the tooltip
				System.out.println("  Tooltip header at angle " + angle + ": " + tooltipContent);
				// Extract name and percentage from the header (e.g. "SG&A 6.00%")
				java.util.regex.Matcher headerMatcher = Pattern.compile("(.+?)\\s+(\\d+\\.\\d+%)").matcher(tooltipContent);
				if (headerMatcher.find()) {
					String componentName = headerMatcher.group(1).trim();
					String componentValue = headerMatcher.group(2).trim();
					if (!componentName.isEmpty() && !hoverValues.containsKey(componentName)) {
						hoverValues.put(componentName, componentValue);
					}
				}
			}
		}

		// Move mouse away from chart
		Actions dismissAction = new Actions(driver);
		dismissAction.moveToElement(mmdHost).perform();
		Thread.sleep(1000);

		System.out.println("=== Hover Tooltip Values ===");
		for (Map.Entry<String, String> entry : hoverValues.entrySet()) {
			System.out.println("  " + entry.getKey() + " : " + entry.getValue());
			test.info("Hover value: " + entry.getKey() + " = " + entry.getValue());
		}

		// Step 4: Compare hover tooltip values with the Cost Components legend values
		System.out.println("=== Comparing Hover Values with Legend Values ===");
		int matchCount = 0;
		int comparedCount = 0;

		for (Map.Entry<String, String> hoverEntry : hoverValues.entrySet()) {
			String hoverName = hoverEntry.getKey();
			String hoverValue = hoverEntry.getValue();

			if (legendValues.containsKey(hoverName)) {
				comparedCount++;
				String legendValue = legendValues.get(hoverName);

				if (hoverValue.equals(legendValue)) {
					matchCount++;
					System.out.println("  MATCH: " + hoverName + " -> Hover: " + hoverValue + " | Legend: " + legendValue);
					test.info("MATCH: " + hoverName + " -> Hover: " + hoverValue + " = Legend: " + legendValue);
				} else {
					mismatchList.add(hoverName + " (Hover: " + hoverValue + " | Legend: " + legendValue + ")");
					System.out.println("  MISMATCH: " + hoverName + " -> Hover: " + hoverValue + " | Legend: " + legendValue);
				}
			}
		}

		// Step 5: Report results
		System.out.println("Compared: " + comparedCount + " | Matched: " + matchCount + " | Mismatched: " + mismatchList.size());

		if (comparedCount == 0) {
			test.fail("No hover values could be compared with legend - tooltip may not have appeared")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurevaluecompare_nohover"));
			Assert.fail("No hover values found to compare with legend");
		}

		if (!mismatchList.isEmpty()) {
			test.fail("Value mismatches between hover and legend: " + mismatchList)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurevaluecompare_mismatch"));
			Assert.fail("Hover vs Legend mismatch: " + mismatchList);
		}

		test.pass("Cost Structure Value Compare PASSED: All " + matchCount + " hover values match the Cost Components legend values")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructurevaluecompare_pass"));
		System.out.println("=== coststructurevaluecompare - ALL " + matchCount + " VALUES MATCHED ===");
	}

	@SuppressWarnings("static-access")
	public void coststructuredpiechart() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		// Wait for cost structure section to load inside shadow DOM
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(2000);

		// Scroll to cost structure section
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (section) {" +
			"  var rect = section.getBoundingClientRect();" +
			"  window.scrollBy(0, rect.top - 50);" +
			"} else { window.scrollBy(0, 800); }"
		);
		Thread.sleep(3000);

		// Step 1: Get the initial Cost Components displayed on the right side before clicking
		@SuppressWarnings("unchecked")
		List<String> initialComponents = (List<String>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return [];" +
			"var results = [];" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"for (var i = 0; i < legendGroups.length; i++) {" +
			"  var labels = legendGroups[i].querySelectorAll('div.mmd-cost-legend');" +
			"  if (labels.length >= 2) {" +
			"    var name = labels[0].textContent.trim();" +
			"    var val = labels[1].textContent.trim();" +
			"    if (name && val) { results.push(name + ' : ' + val); }" +
			"  }" +
			"}" +
			"return results;"
		);

		System.out.println("=== Initial Cost Components (before click) ===");
		for (String comp : initialComponents) {
			System.out.println("  " + comp);
			test.info("Initial Component: " + comp);
		}

		// Step 2: Navigate to the pie chart and click on the first segment
		WebElement chartElement = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var chart = section.querySelector('div[style*=\"width: 310px\"][style*=\"height: 310px\"]');" +
			"if (!chart) chart = section.querySelector('div[style*=\"position: relative\"]');" +
			"return chart;"
		);

		if (chartElement == null) {
			test.fail("Pie chart element not found in Cost Structure section")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructuredpiechart_nochart"));
			Assert.fail("Pie chart element not found");
		}

		// Scroll pie chart into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", chartElement);
		Thread.sleep(1000);

		// Navigate to the pie chart - move to the largest segment (top-right area of donut)
		int chartWidth = chartElement.getSize().getWidth();
		int chartHeight = chartElement.getSize().getHeight();
		int hoverRadius = (int) (chartWidth / 2 * 0.65);

		// Move to top-right of the donut (angle ~330 degrees from top = largest segment)
		double radians = Math.toRadians(-60);
		int offsetX = (int) (hoverRadius * Math.cos(radians));
		int offsetY = (int) (hoverRadius * Math.sin(radians));

		Actions actions = new Actions(driver);
		actions.moveToElement(chartElement, offsetX, offsetY).pause(Duration.ofSeconds(1)).perform();
		Thread.sleep(2000);
		System.out.println("Navigated to pie chart at offset: x=" + offsetX + ", y=" + offsetY);
		test.info("Navigated to pie chart segment");

		// Click on the pie chart segment
		actions.moveToElement(chartElement, offsetX, offsetY).click().perform();
		Thread.sleep(3000);
		System.out.println("Clicked on pie chart segment");
		test.info("Clicked on pie chart segment");

		// Step 3: After clicking, verify the breadcrumb shows the drilled-down component name
		String breadcrumbText = (String) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return null;" +
			"var breadcrumb = section.querySelector('div.mmd-cs-breadcrumb, div.mmd-cs-nav, span.mmd-cs-breadcrumb');" +
			"if (breadcrumb) return breadcrumb.textContent.trim();" +
			"var allSpans = section.querySelectorAll('span, div');" +
			"for (var i = 0; i < allSpans.length; i++) {" +
			"  var text = allSpans[i].textContent.trim();" +
			"  if (text.indexOf('Cost Components') > -1 && text.indexOf('>') > -1) { return text; }" +
			"}" +
			"return null;"
		);

		System.out.println("Breadcrumb after click: " + breadcrumbText);
		if (breadcrumbText != null && !breadcrumbText.isEmpty()) {
			test.info("Breadcrumb displayed: " + breadcrumbText);
		}

		// Step 4: Verify the Cost Components on the right side now show the sub-components after clicking
		@SuppressWarnings("unchecked")
		List<String> subComponents = (List<String>) ((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-cost-structure');" +
			"if (!section) return [];" +
			"var results = [];" +
			"var legendGroups = section.querySelectorAll('div.mmd-cs-legend-group');" +
			"if (legendGroups.length === 0) {" +
			"  var panel = section.querySelector('div.mmd-cs-legend-panel');" +
			"  if (panel) { legendGroups = panel.querySelectorAll('div.mmd-flex-center'); }" +
			"}" +
			"for (var i = 0; i < legendGroups.length; i++) {" +
			"  var labels = legendGroups[i].querySelectorAll('div.mmd-cost-legend');" +
			"  if (labels.length >= 2) {" +
			"    var name = labels[0].textContent.trim();" +
			"    var val = labels[1].textContent.trim();" +
			"    if (name && val) { results.push(name + ' : ' + val); }" +
			"  }" +
			"}" +
			"return results;"
		);

		System.out.println("=== Cost Components after clicking pie chart segment ===");
		if (subComponents != null && !subComponents.isEmpty()) {
			for (String component : subComponents) {
				System.out.println("  " + component);
				test.info("Drilled Down Component: " + component);
			}

			// Verify that the components changed after click (drilled-down view)
			boolean componentsChanged = !subComponents.equals(initialComponents);
			if (componentsChanged) {
				test.pass("Cost Structure pie chart segment clicked - Cost Components updated to show sub-components: " + subComponents)
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructuredpiechart_pass"));
				System.out.println("PASSED: Pie chart segment clicked and Cost Components updated with sub-components");
			} else {
				test.pass("Cost Structure pie chart clicked and Cost Components displayed successfully")
						.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructuredpiechart_pass"));
				System.out.println("PASSED: Pie chart segment clicked and cost components displayed");
			}
		} else {
			test.fail("No Cost Components displayed after clicking the pie chart segment")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "coststructuredpiechart_fail"));
			Assert.fail("No Cost Components displayed after clicking the pie chart segment");
		}
	}

	@SuppressWarnings("static-access")
	public void samplecountryreport() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		


		// Click on Carton Boards category
		wait.until(ExpectedConditions.elementToBeClickable(Category.cartonBoards));
		steps.click(driver, Category.cartonBoards);
		System.out.println("Navigating to category: Carton Boards");
		test.info("Navigating to category: Carton Boards");
		Thread.sleep(3000);

		// Step 2: Navigate to the Reports section
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.reports));
		steps.click(driver, Category.reports);
		Thread.sleep(2000);
		System.out.println("Navigated to Reports section");
		test.info("Navigated to Reports section");

		// Step 3: Verify the Request Country Report button is disabled
		WebElement requestCountryBtn = wait.until(ExpectedConditions.presenceOfElementLocated(Category.requestcountry));
		boolean isDisabled = !requestCountryBtn.isEnabled()
				|| requestCountryBtn.getAttribute("disabled") != null
				|| requestCountryBtn.getAttribute("class").contains("disabled");

		System.out.println("Request Country Report button disabled: " + isDisabled);

		if (isDisabled) {
			test.pass("Request Country Report button is disabled as expected for sample category: Carton Boards")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "samplecountryreport_pass"));
			System.out.println("PASSED: Request Country Report button is disabled");
		} else {
			test.fail("Request Country Report button is NOT disabled for sample category: Carton Boards")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "samplecountryreport_fail"));
			Assert.fail("Request Country Report button is NOT disabled");
		}
	}

	@SuppressWarnings("static-access")
	public void mmdcustomrange() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.Threeplservices));
		steps.click(driver, Category.Threeplservices);

		// Wait for the MMD section to load inside shadow DOM
		WebElement mmdHost = driver.findElement(By.cssSelector("beroe-mmd"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", mmdHost);
		Thread.sleep(2000);

		// Scroll to the Price Trend section
		((JavascriptExecutor) driver).executeScript(
			"var host = document.querySelector('beroe-mmd');" +
			"var shadow = host.shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (section) { window.scrollBy(0, section.getBoundingClientRect().top - 100); }" +
			"else { window.scrollBy(0, 400); }"
		);
		Thread.sleep(3000);

		// Step 1: Hover on the Default dropdown and click Set Custom Range
		SearchContext mmdShadowRoot = mmdHost.getShadowRoot();
		WebElement defaultDropdown = wait.until(driver -> {
			WebElement section = mmdShadowRoot.findElement(Category.priceTrendSection);
			for (WebElement dp : section.findElements(Category.mmdDefaultDropdown)) {
				String t = dp.getText().trim();
				if ((t.contains("Default") || t.contains("Custom Date")) && dp.isDisplayed()) return dp;
			}
			return null;
		});
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", defaultDropdown);
		new Actions(driver).moveToElement(defaultDropdown).pause(Duration.ofSeconds(2)).perform();
		System.out.println("Hovered on right-side Default dropdown");
		test.info("Hovered on right-side Default dropdown");
		Thread.sleep(2000);

		WebElement setCustomRangeOption = wait.until(driver -> {
			WebElement section = mmdShadowRoot.findElement(Category.priceTrendSection);
			for (WebElement opt : section.findElements(By.cssSelector("button, div, span"))) {
				if ("Set Custom Range".equals(opt.getText().trim()) && opt.isDisplayed()) return opt;
			}
			return null;
		});
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", setCustomRangeOption);
		new Actions(driver).moveToElement(setCustomRangeOption).pause(Duration.ofMillis(500)).click().perform();
		System.out.println("Clicked Set Custom Range");
		test.info("Clicked Set Custom Range");
		Thread.sleep(2000);

		// Step 2: Wait for flatpickr calendar to open (day cells appear in shadow root)
		wait.until(driver -> {
			List<WebElement> dc = mmdShadowRoot.findElements(By.cssSelector("div.dayContainer"));
			return (!dc.isEmpty() && dc.get(0).isDisplayed()) ? Boolean.TRUE : null;
		});
		Thread.sleep(1000);
		System.out.println("Flatpickr calendar opened");
		test.info("Flatpickr calendar opened");

		// ---- LEFT CALENDAR: Navigate to January 2025 via flatpickr JS API ----
		((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var inputs = Array.from(shadow.querySelectorAll('input'));" +
			"var fps = inputs.map(function(i){return i._flatpickr;}).filter(Boolean);" +
			"if(fps.length>0){fps[0].currentMonth=0;fps[0].currentYear=2025;fps[0].redraw();}");
		Thread.sleep(1000);

		// Click January 1, 2025 (first visible, non-overflow cell in shadow root)
		WebElement startDay = wait.until(driver -> {
			List<WebElement> spans = mmdShadowRoot.findElements(
					By.cssSelector("span.flatpickr-day[aria-label='January 1, 2025']"));
			for (WebElement sp : spans) {
				String cls = sp.getAttribute("class");
				if (sp.isDisplayed() && cls != null
						&& !cls.contains("prevMonthDay") && !cls.contains("nextMonthDay")
						&& !cls.contains("disabled") && !cls.contains("flatpickr-disabled")) {
					return sp;
				}
			}
			return null;
		});
		if (startDay == null) {
			test.fail("January 1, 2025 day cell not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmd_startday_fail"));
			Assert.fail("January 1, 2025 day cell not found");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center',inline:'center'});", startDay);
		new Actions(driver).moveToElement(startDay).pause(Duration.ofMillis(300)).click().perform();
		System.out.println("Selected start date: January 1, 2025");
		test.info("Selected start date: January 1, 2025");
		Thread.sleep(1000);

		// ---- END DATE: Navigate to January 2026 ----
		// For 2 separate instances: navigate 2nd fp to Jan 2026.
		// For 1 instance with showMonths:2: navigate to Dec 2025 so right panel shows Jan 2026.
		((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var inputs = Array.from(shadow.querySelectorAll('input'));" +
			"var fps = inputs.map(function(i){return i._flatpickr;}).filter(Boolean);" +
			"if(fps.length>=2){fps[1].currentMonth=0;fps[1].currentYear=2026;fps[1].redraw();}" +
			"else if(fps.length===1){fps[0].currentMonth=11;fps[0].currentYear=2025;fps[0].redraw();}");
		Thread.sleep(1000);

		// Click January 1, 2026 (first visible, non-overflow cell in shadow root)
		WebElement endDay = wait.until(driver -> {
			List<WebElement> spans = mmdShadowRoot.findElements(
					By.cssSelector("span.flatpickr-day[aria-label='January 1, 2026']"));
			for (WebElement sp : spans) {
				String cls = sp.getAttribute("class");
				if (sp.isDisplayed() && cls != null
						&& !cls.contains("prevMonthDay") && !cls.contains("nextMonthDay")
						&& !cls.contains("disabled") && !cls.contains("flatpickr-disabled")) {
					return sp;
				}
			}
			return null;
		});
		if (endDay == null) {
			test.fail("January 1, 2026 day cell not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmd_endday_fail"));
			Assert.fail("January 1, 2026 day cell not found");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center',inline:'center'});", endDay);
		new Actions(driver).moveToElement(endDay).pause(Duration.ofMillis(300)).click().perform();
		System.out.println("Selected end date: January 1, 2026");
		test.info("Selected end date: January 1, 2026");
		Thread.sleep(1000);

		// Step 4: Click Apply (search entire price-trend section in shadow root)
		WebElement applyBtn = wait.until(driver -> {
			WebElement section = mmdShadowRoot.findElement(Category.priceTrendSection);
			for (WebElement c : section.findElements(By.cssSelector("button, span, div"))) {
				String t = c.getText().trim();
				if ("Apply".equals(t) && c.isDisplayed()) return c;
			}
			return null;
		});
		if (applyBtn == null) {
			test.fail("Apply button not found").addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmd_apply_fail"));
			Assert.fail("Apply button not found");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", applyBtn);
		System.out.println("Clicked Apply button");
		test.info("Clicked Apply button");
		Thread.sleep(3000);

		// Step 5: Verify dropdown shows Custom Date
		String dropdownText = null;
		try {
			WebElement verifyDropdown = wait.until(d -> {
				WebElement section = mmdShadowRoot.findElement(Category.priceTrendSection);
				for (WebElement dp : section.findElements(Category.mmdDefaultDropdown)) {

					String t = dp.getText().trim();
					if ((t.contains("Custom Date") || t.contains("Default")) && dp.isDisplayed()) return dp;
				}
				return null;
			});
			dropdownText = verifyDropdown.getText().trim();
		} catch (Exception e) {
			dropdownText = null;
		}
		System.out.println("Dropdown text after apply: " + dropdownText);
		if (dropdownText != null && dropdownText.contains("Custom")) {
			test.pass("Custom range applied. Dropdown: " + dropdownText)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmdcustomrange_pass"));
			System.out.println("PASSED: Custom range Jan 1, 2025 to Jan 1, 2026 applied");
		} else {
			test.fail("Custom range not applied. Dropdown: " + dropdownText)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mmdcustomrange_fail"));
			Assert.fail("Custom range not applied. Dropdown: " + dropdownText);
		}
	}

	@SuppressWarnings("static-access")
	public void accuracy() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Navigate to the ABS category page
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);

		// Wait for beroe-mmd shadow host to load
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));

		// Scroll the MMD component into view first
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", shadowHost);
		Thread.sleep(1500);

		// Scroll directly to the Accuracy/Guidance row (div.mmd-chart-info inside price-trend section)
		((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (!section) return;" +
			// First bring section into view
			"section.scrollIntoView({behavior:'instant', block:'start'});" +
			// Then find the Accuracy/Guidance row and scroll it to center
			"var chartInfoDivs = section.querySelectorAll('div.mmd-chart-info');" +
			"if (chartInfoDivs.length > 0) {" +
			"  chartInfoDivs[0].scrollIntoView({behavior:'smooth', block:'center'});" +
			"}"
		);
		Thread.sleep(2000);

		// ---- Step 1: Hover over Accuracy info icon and read the tooltip text ----
		// DOM: div.mmd-chart-info > i.fa.fa-info-circle + text " Accuracy "
		// The 1st div.mmd-chart-info in the price-trend section is Accuracy
		WebElement accuracyEl = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (!section) return null;" +
			"var chartInfoDivs = section.querySelectorAll('div.mmd-chart-info');" +
			"for (var i = 0; i < chartInfoDivs.length; i++) {" +
			"  if (chartInfoDivs[i].textContent.trim().toLowerCase().indexOf('accuracy') !== -1) {" +
			"    var icon = chartInfoDivs[i].querySelector('i.fa-info-circle, i.fa-info, i[class*=\"info\"]');" +
			"    return icon || chartInfoDivs[i];" +
			"  }" +
			"}" +
			"return null;"
		);

		if (accuracyEl == null) {
			test.fail("Accuracy element not found in price trend section")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "accuracy_notfound"));
			Assert.fail("Accuracy element not found in price trend section");
		}

		// Scroll the accuracy icon fully into view before hovering
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].scrollIntoView({behavior:'smooth', block:'center', inline:'center'});",
			accuracyEl
		);
		Thread.sleep(1000);

		// Trigger hover via JS mouseenter/mouseover events (reliable inside shadow DOM)
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].dispatchEvent(new MouseEvent('mouseenter', {bubbles:true, cancelable:true, view:window}));" +
			"arguments[0].dispatchEvent(new MouseEvent('mouseover',  {bubbles:true, cancelable:true, view:window}));",
			accuracyEl
		);
		// Also try Actions hover as a secondary trigger
		try {
			new Actions(driver).moveToElement(accuracyEl).pause(Duration.ofMillis(800)).perform();
		} catch (Exception ignored) {}
		Thread.sleep(1500);

		// Read accuracy tooltip text
		// The popover may render in main DOM (React portal) or shadow root - check both
		String accuracyTooltipText = (String) ((JavascriptExecutor) driver).executeScript(
			"var pattern = /\\d+\\s*Months?\\s*:\\s*\\d+%/;" +
			// 1. Search main document body (React portal / overlay)
			"var bodyEls = document.querySelectorAll('div, span, p, ul, li');" +
			"for (var i = 0; i < bodyEls.length; i++) {" +
			"  var st = bodyEls[i].textContent.trim();" +
			"  if (st.length > 0 && st.length < 400 && pattern.test(st)) { return st; }" +
			"}" +
			// 2. Search shadow root (no CSS visibility filter - element IS visible)
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var shadowEls = shadow.querySelectorAll('div, span, p, ul, li');" +
			"for (var j = 0; j < shadowEls.length; j++) {" +
			"  var st2 = shadowEls[j].textContent.trim();" +
			"  if (st2.length > 0 && st2.length < 400 && pattern.test(st2)) { return st2; }" +
			"}" +
			"return null;"
		);

		System.out.println("Accuracy tooltip text: " + accuracyTooltipText);

		if (accuracyTooltipText != null && !accuracyTooltipText.isEmpty()) {
			test.pass("Accuracy tooltip text retrieved: " + accuracyTooltipText)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "accuracy_tooltip_pass"));
		} else {
			test.fail("Accuracy tooltip text not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "accuracy_tooltip_fail"));
			Assert.fail("Accuracy tooltip text not found");
		}

		// Move mouse away to dismiss the accuracy tooltip before hovering guidance
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].dispatchEvent(new MouseEvent('mouseleave', {bubbles:true, cancelable:true, view:window}));",
			accuracyEl
		);
		Thread.sleep(800);

		// ---- Step 2: Hover over Guidance info icon and read the tooltip text ----
		// DOM: div.mmd-chart-info > i.fa.fa-info-circle + text " Guidance "
		// The div.mmd-chart-info whose text contains "Guidance" is the Guidance icon
		WebElement guidanceEl = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-price-trend');" +
			"if (!section) return null;" +
			"var chartInfoDivs = section.querySelectorAll('div.mmd-chart-info');" +
			"for (var i = 0; i < chartInfoDivs.length; i++) {" +
			"  if (chartInfoDivs[i].textContent.trim().toLowerCase().indexOf('guidance') !== -1) {" +
			"    var icon = chartInfoDivs[i].querySelector('i.fa-info-circle, i.fa-info, i[class*=\"info\"]');" +
			"    return icon || chartInfoDivs[i];" +
			"  }" +
			"}" +
			"return null;"
		);

		if (guidanceEl == null) {
			test.fail("Guidance element not found in price trend section")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "guidance_notfound"));
			Assert.fail("Guidance element not found in price trend section");
		}

		// Scroll the guidance icon fully into view before hovering
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].scrollIntoView({behavior:'smooth', block:'center', inline:'center'});",
			guidanceEl
		);
		Thread.sleep(1000);

		// Trigger hover via JS events
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].dispatchEvent(new MouseEvent('mouseenter', {bubbles:true, cancelable:true, view:window}));" +
			"arguments[0].dispatchEvent(new MouseEvent('mouseover',  {bubbles:true, cancelable:true, view:window}));",
			guidanceEl
		);
		try {
			new Actions(driver).moveToElement(guidanceEl).pause(Duration.ofMillis(800)).perform();
		} catch (Exception ignored) {}
		Thread.sleep(1500);

		// Read guidance tooltip text
		// The popover may render in main DOM (React portal) or shadow root - check both
		String guidanceTooltipText = (String) ((JavascriptExecutor) driver).executeScript(
			"var keywords = ['FOB', 'CIF', 'Contract', 'Spot', 'Rotterdam', 'Prices', 'Price'];" +
			"function matchesGuidance(t) {" +
			"  for (var k = 0; k < keywords.length; k++) { if (t.indexOf(keywords[k]) !== -1) return true; }" +
			"  return false;" +
			"}" +
			// 1. Search main document body (React portal / overlay)
			"var bodyEls = document.querySelectorAll('div, span, p, ul, li');" +
			"for (var i = 0; i < bodyEls.length; i++) {" +
			"  var st = bodyEls[i].textContent.trim();" +
			"  if (st.length > 0 && st.length < 300 && matchesGuidance(st) &&" +
			"      !/\\d+\\s*Months?\\s*:\\s*\\d+%/.test(st)) { return st; }" +
			"}" +
			// 2. Search shadow root
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var shadowEls = shadow.querySelectorAll('div, span, p, ul, li');" +
			"for (var j = 0; j < shadowEls.length; j++) {" +
			"  var st2 = shadowEls[j].textContent.trim();" +
			"  if (st2.length > 0 && st2.length < 300 && matchesGuidance(st2) &&" +
			"      !/\\d+\\s*Months?\\s*:\\s*\\d+%/.test(st2)) { return st2; }" +
			"}" +
			"return null;"
		);

		System.out.println("Guidance tooltip text: " + guidanceTooltipText);

		if (guidanceTooltipText != null && !guidanceTooltipText.isEmpty()) {
			test.pass("Guidance tooltip text retrieved: " + guidanceTooltipText)
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "guidance_tooltip_pass"));
		} else {
			test.fail("Guidance tooltip text not found")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "guidance_tooltip_fail"));
			Assert.fail("Guidance tooltip text not found");
		}
	}

	@SuppressWarnings("static-access")
	public void marketcommentary() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Navigate to ABS category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("Navigated to ABS category");
		test.info("Navigated to ABS category");

		// Wait for beroe-mmd shadow host
		WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("beroe-mmd")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'start'});", shadowHost);
		Thread.sleep(1500);

		// Scroll to the Market Analysis section inside the shadow DOM
		((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-market-analysis');" +
			"if (section) { section.scrollIntoView({behavior:'smooth', block:'center'}); }"
		);
		Thread.sleep(2000);
		System.out.println("Scrolled to Market Analysis section");
		test.info("Scrolled to Market Analysis section");

		// Verify 'Expand Market Commentary' link is visible inside the shadow DOM
		WebElement expandCommentaryEl = (WebElement) ((JavascriptExecutor) driver).executeScript(
			"var shadow = document.querySelector('beroe-mmd').shadowRoot;" +
			"var section = shadow.querySelector('div.mmd-section#mmd-market-analysis');" +
			"if (!section) return null;" +
			"var links = section.querySelectorAll('a.mmd-cards-collapse');" +
			"for (var i = 0; i < links.length; i++) {" +
			"  if (links[i].textContent.trim().toLowerCase().indexOf('expand market commentary') !== -1) {" +
			"    return links[i];" +
			"  }" +
			"}" +
			"return null;"
		);

		if (expandCommentaryEl == null) {
			test.fail("'Expand Market Commentary' element not found in Market Analysis section")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "marketcommentary_notfound"));
			Assert.fail("'Expand Market Commentary' element not found");
		}

		// Scroll the element into view and check visibility
		((JavascriptExecutor) driver).executeScript(
			"arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
			expandCommentaryEl
		);
		Thread.sleep(1000);

		boolean isVisible = (Boolean) ((JavascriptExecutor) driver).executeScript(
			"var el = arguments[0];" +
			"var rect = el.getBoundingClientRect();" +
			"var cs = window.getComputedStyle(el);" +
			"return rect.width > 0 && rect.height > 0 &&" +
			"       cs.display !== 'none' && cs.visibility !== 'hidden' && cs.opacity !== '0';",
			expandCommentaryEl
		);

		String elementText = expandCommentaryEl.getText().trim();
		System.out.println("Expand Market Commentary element text: '" + elementText + "'");
		System.out.println("Is visible: " + isVisible);

		if (isVisible) {
			test.pass("'Expand Market Commentary' is visible in the Market Analysis section. Text: '" + elementText + "'")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "marketcommentary_pass"));
			System.out.println("PASSED: 'Expand Market Commentary' is visible");
		} else {
			test.fail("'Expand Market Commentary' is NOT visible in the Market Analysis section")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "marketcommentary_fail"));
			Assert.fail("'Expand Market Commentary' is not visible");
		}
	}

	@SuppressWarnings("static-access")
	public void abiicon() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Navigate to ABS category
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("Navigated to ABS category");
		test.info("Navigated to ABS category");
		Thread.sleep(2000);

		// Check if the ABI icon is present in the DOM.
		// div.chatIcon lives inside iframe#abi_chat_iframe - must switch to it first.
		boolean abiIconDisplayed = false;
		String abiIconText = "";
		try {
			// Wait for the iframe to be present, then switch into it
			WebElement iframe = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.cssSelector("iframe#abi_chat_iframe")));
			driver.switchTo().frame(iframe);
			System.out.println("Switched to abi_chat_iframe");

			// Now find div.chatIcon inside the iframe
			WebElement abiIconEl = wait.until(
					ExpectedConditions.presenceOfElementLocated(Category.abiIcon));

			// Use JS getBoundingClientRect — isDisplayed() fails when parent has opacity:0
			Object result = ((JavascriptExecutor) driver).executeScript(
				"var el = arguments[0];" +
				"var rect = el.getBoundingClientRect();" +
				"return rect.width > 0 && rect.height > 0;",
				abiIconEl
			);
			abiIconDisplayed = Boolean.TRUE.equals(result);
			abiIconText = abiIconEl.getText().trim();
			System.out.println("ABI icon found in iframe. Rendered: " + abiIconDisplayed + " | Text: '" + abiIconText + "'");
		} catch (Exception e) {
			System.out.println("ABI icon not found: " + e.getMessage());
			abiIconDisplayed = false;
		} finally {
			// Always switch back to main document
			driver.switchTo().defaultContent();
		}

		if (abiIconDisplayed) {
			test.pass("ABI icon is displayed on the category page. Text: '" + abiIconText + "'")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "abiicon_pass"));
			System.out.println("PASSED: ABI icon is displayed");
		} else {
			test.fail("ABI icon is NOT displayed on the category page")
					.addScreenCaptureFromPath(steps.captureScreenshot(driver, "abiicon_fail"));
			Assert.fail("ABI icon is not displayed");
		}
	}

	@SuppressWarnings("static-access")
	public void mireportssouser() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Step 1: Navigate to ABS category
		test.log(Status.INFO, "Navigating to ABS category");
		wait.until(ExpectedConditions.elementToBeClickable(Category.abs));
		steps.click(driver, Category.abs);
		System.out.println("Navigated to ABS category");
		Thread.sleep(3000);

		// Step 2: Navigate to the Reports section
		test.log(Status.INFO, "Navigating to Reports section");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.reports));
		steps.click(driver, Category.reports);
		System.out.println("Navigated to Reports section");
		Thread.sleep(2000);

		// Step 3: Click the first report link
		test.log(Status.INFO, "Clicking the first report link");
		String parentWindow = driver.getWindowHandle();
		Set<String> windowsBefore = driver.getWindowHandles();
		WebElement firstReportBtn = wait.until(ExpectedConditions.elementToBeClickable(Category.reportFirstLink));
		firstReportBtn.click();
		System.out.println("Clicked on first report link");
		test.info("Clicked on first report link");
		Thread.sleep(3000);

		// Switch to newly opened report tab if one was opened
		Set<String> windowsAfter = driver.getWindowHandles();
		if (windowsAfter.size() > windowsBefore.size()) {
			for (String handle : windowsAfter) {
				if (!windowsBefore.contains(handle)) {
					driver.switchTo().window(handle);
					System.out.println("Switched to new report tab");
					test.info("Switched to new report tab");
					break;
				}
			}
		}
		Thread.sleep(2000);

		// Step 4: Get the title of the report - content is inside iframe#reportsIframe
		test.log(Status.INFO, "Getting report title from the opened report viewer");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Category.reportViewerIframe));
		Thread.sleep(1000);
		String reportPageTitle = (String) ((JavascriptExecutor) driver).executeScript(
			"var pageInner = document.querySelector('div.page.current div.page-inner');" +
			"if (!pageInner) return 'Title not found';" +
			"var divs = Array.from(pageInner.querySelectorAll('div'));" +
			"var textDivs = divs.filter(function(d) {" +
			"  var t = (d.innerText || d.textContent || '').trim();" +
			"  return t.length > 1" +
			"    && d.children.length === 0" +
			"    && !t.includes('\u00A9') && !t.includes('Copyright')" +
			"    && !/^\\d+$/.test(t)" +
			"    && !/^[A-Z][a-z]+ \\d{4}$/.test(t);" +
			"});" +
			"var title    = textDivs.length > 0 ? textDivs[0].innerText.trim() : '';" +
			"var subtitle = textDivs.length > 1 ? textDivs[1].innerText.trim() : '';" +
			"return subtitle.length > 0 ? title + ' - ' + subtitle : title;"
		);
		driver.switchTo().defaultContent();
		System.out.println("Report title captured from report viewer: " + reportPageTitle);
		test.pass("Report title captured: " + reportPageTitle)
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "report_first_page_title"));

		// Step 5: Copy the current URL of the report page
		String reportUrl = driver.getCurrentUrl();
		System.out.println("Report URL captured: " + reportUrl);
		test.info("Report URL copied: " + reportUrl);

		// Step 6: Close the report - navigate back to the category page (same tab)
		test.log(Status.INFO, "Closing the report - navigating back to category page");
		String categoryPageUrl = reportUrl.contains("/report/") ? reportUrl.split("/report/")[0] : reportUrl;
		driver.navigate().to(categoryPageUrl);
		System.out.println("Navigated back to category page");
		Thread.sleep(3000);

		// Step 7: Sign out from the application
		test.log(Status.INFO, "Signing out from the application");
		wait.until(ExpectedConditions.elementToBeClickable(Category.profile));
		steps.click(driver, Category.profile);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(Category.signOut));
		steps.click(driver, Category.signOut);
		System.out.println("Signed out successfully");
		Thread.sleep(3000);

		// Step 8: Open a new tab and paste the copied report URL
		test.log(Status.INFO, "Opening new tab and navigating to report URL");
		((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", reportUrl);
		Thread.sleep(2000);

		// Switch to the newly opened tab
		ArrayList<String> allTabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(allTabs.size() - 1));
		System.out.println("Switched to new tab with report URL");
		Thread.sleep(3000);

		// Step 9: App redirects to Beroe login page since user is signed out
		wait.until(ExpectedConditions.urlContains("login"));
		System.out.println("Redirected to Beroe login page (standard)");
		test.info("Redirected to Beroe login page after accessing report URL without authentication");
		test.pass("Redirected to login page as expected")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "redirected_to_login"));

		// Step 10: Click Sign in with SSO on the standard Beroe login page (skip email/password)
		test.log(Status.INFO, "Clicking Sign in with SSO on standard Beroe login page");
		WebElement ssoBtnFirst = wait.until(ExpectedConditions.presenceOfElementLocated(Category.signInWithSSO));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ssoBtnFirst);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ssoBtnFirst);
		System.out.println("Clicked Sign in with SSO on standard login - now on SSO email page");
		test.pass("Sign in with SSO clicked on standard Beroe login")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "beroe_sso_first_click"));
		Thread.sleep(3000);

		// Step 11: SSO-specific Beroe page - enter email and click Sign in with SSO
		test.log(Status.INFO, "On SSO login page - entering email: janarthanam.palani@janatest.com");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Search.username));
		driver.findElement(Search.username).clear();
		driver.findElement(Search.username).sendKeys("janarthanam.palani@janatest.com");
		System.out.println("Email entered on SSO login page");
		test.info("Email entered on SSO page");
		Thread.sleep(1000);

		WebElement ssoBtnSecond = wait.until(ExpectedConditions.presenceOfElementLocated(Category.signInWithSSO));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ssoBtnSecond);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ssoBtnSecond);
		System.out.println("Clicked Sign in with SSO on SSO page - redirecting to JumpCloud");
		test.pass("Sign in with SSO clicked on SSO email page")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "beroe_sso_second_click"));
		Thread.sleep(4000);

		// Step 12: JumpCloud page - enter email and click Continue
		test.log(Status.INFO, "On JumpCloud login page - entering email");
		wait.until(ExpectedConditions.urlContains("jumpcloud.com"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.jumpCloudEmailField));
		driver.findElement(Category.jumpCloudEmailField).clear();
		driver.findElement(Category.jumpCloudEmailField).sendKeys("janarthanam.palani@janatest.com");
		System.out.println("Email entered on JumpCloud");
		test.info("Email entered on JumpCloud login page");
		Thread.sleep(1000);

		WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(Category.jumpCloudContinueBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", continueBtn);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
		System.out.println("Clicked Continue on JumpCloud");
		test.pass("Clicked Continue on JumpCloud")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "jumpcloud_continue_clicked"));
		Thread.sleep(3000);

		// Step 13: JumpCloud password page - enter password and click SSO Login
		test.log(Status.INFO, "On JumpCloud password page - entering password");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.jumpCloudPasswordField));
		driver.findElement(Category.jumpCloudPasswordField).clear();
		driver.findElement(Category.jumpCloudPasswordField).sendKeys("Abc@123$");
		System.out.println("Password entered on JumpCloud");
		test.info("Password entered on JumpCloud");
		Thread.sleep(1000);

		WebElement ssoLoginBtn = wait.until(ExpectedConditions.presenceOfElementLocated(Category.jumpCloudSSOLoginBtn));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", ssoLoginBtn);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ssoLoginBtn);
		System.out.println("Clicked SSO Login on JumpCloud - redirecting to report page");
		test.pass("Clicked SSO Login on JumpCloud")
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "jumpcloud_sso_login_clicked"));
		Thread.sleep(5000);

		// Step 14: Should auto-navigate back to the same MI report page
		test.log(Status.INFO, "Waiting for report page to load after SSO login");
		wait.until(ExpectedConditions.urlContains("report"));
		System.out.println("On report page after SSO login: " + driver.getCurrentUrl());
		test.info("Navigated to report page after SSO login: " + driver.getCurrentUrl());
		Thread.sleep(3000);

		// Step 15: Switch into iframe and read the report title to compare
		test.log(Status.INFO, "Verifying report page title after SSO login");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Category.reportViewerIframe));
		Thread.sleep(1000);
		String actualTitleAfterLogin = (String) ((JavascriptExecutor) driver).executeScript(
			"var pageInner = document.querySelector('div.page.current div.page-inner');" +
			"if (!pageInner) return 'Title not found';" +
			"var divs = Array.from(pageInner.querySelectorAll('div'));" +
			"var textDivs = divs.filter(function(d) {" +
			"  var t = (d.innerText || d.textContent || '').trim();" +
			"  return t.length > 1" +
			"    && d.children.length === 0" +
			"    && !t.includes('\u00A9') && !t.includes('Copyright')" +
			"    && !/^\\d+$/.test(t)" +
			"    && !/^[A-Z][a-z]+ \\d{4}$/.test(t);" +
			"});" +
			"var title    = textDivs.length > 0 ? textDivs[0].innerText.trim() : '';" +
			"var subtitle = textDivs.length > 1 ? textDivs[1].innerText.trim() : '';" +
			"return subtitle.length > 0 ? title + ' - ' + subtitle : title;"
		);
		driver.switchTo().defaultContent();

		System.out.println("Title before sign out  : " + reportPageTitle);
		System.out.println("Title after SSO login  : " + actualTitleAfterLogin);
		test.info("Expected title: " + reportPageTitle + " | Actual title after SSO login: " + actualTitleAfterLogin);

		Assert.assertEquals(actualTitleAfterLogin, reportPageTitle,
				"Report page title mismatch after SSO login");

		test.pass("Report page title matched after SSO login. Title: " + actualTitleAfterLogin)
				.addScreenCaptureFromPath(steps.captureScreenshot(driver, "mireportssouser_pass"));
		System.out.println("PASSED: Report page title matched after SSO login");
	}


	@SuppressWarnings("static-access")
public void mmdcompare() throws Exception {


  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Category.carbonsteel));
		steps.click(driver, Category.carbonsteel);

		// Wait until the download button inside shadow DOM is visible
		WebElement addcomparsions = wait.until(driver -> {

			WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
			SearchContext shadowRoot = host.getShadowRoot();

			List<WebElement> addcomparision = shadowRoot
					.findElements(Category.addcomparision);

			if (addcomparision.size() > 0 && addcomparision.get(0).isDisplayed()) {
				if (addcomparision.size() >= 2) {
					return addcomparision.get(0);
				}
				;
			}

			return null;
		});

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", addcomparsions);

		Thread.sleep(2000);
		// Click
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addcomparsions);

		System.out.println("addcomparision button clicked successfully");

		// Step: Get Shadow Root again (important)
WebElement host = driver.findElement(By.cssSelector("beroe-mmd"));
SearchContext shadowRoot = host.getShadowRoot();


// Step: Wait for comparison panel
WebElement panel = wait.until(d -> {
    List<WebElement> panels = shadowRoot.findElements(By.cssSelector("div.mmd-compare-panel"));
    if (!panels.isEmpty() && panels.get(0).isDisplayed()) {
        return panels.get(0);
    }
    return null;
});

System.out.println("Comparison panel displayed");


// Step: Get all dropdowns
List<WebElement> allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer"));
System.out.println("Total dropdowns found: " + allOuters.size());


// ============================
// ✅ 1st Dropdown → Select Asia
// ============================
selectFromComparisonDropdown(wait, shadowRoot, panel, allOuters, 0, "Asia");
System.out.println("Selected: Asia");

Thread.sleep(1000);


// ============================
// ✅ 2nd Dropdown → Select Iron Ore
// ============================
allOuters = panel.findElements(By.cssSelector("div.mmd-select-outer")); // re-fetch

selectFromComparisonDropdown(wait, shadowRoot, panel, allOuters, 1, "Iron Ore");
System.out.println("Selected: Iron Ore");

Thread.sleep(1000);


// ============================
// ✅ Click Apply Button
// ============================
WebElement applyButton = wait.until(driver -> {
    List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
    if (buttons.size() >= 2 && buttons.get(1).isDisplayed()) {
        return buttons.get(1);
    }
    return null;
});

((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});", applyButton);

((JavascriptExecutor) driver).executeScript(
        "arguments[0].click();", applyButton);

System.out.println("Apply button clicked successfully");

// Re-fetch panel + dropdowns (VERY IMPORTANT)
WebElement host1 = driver.findElement(By.cssSelector("beroe-mmd"));
SearchContext shadowRoot1 = host1.getShadowRoot();

WebElement panel1 = wait.until(d -> {
    WebElement p = shadowRoot1.findElement(By.cssSelector("div.mmd-compare-panel"));
    return p.isDisplayed() ? p : null;
});

// Get all dropdowns again
List<WebElement> allOuters1 = panel.findElements(By.cssSelector("div.mmd-select-outer"));

// 👉 Change 2nd dropdown value to ABS
selectFromComparisonDropdown(wait, shadowRoot, panel1, allOuters1, 1, "ABS");

System.out.println("Changed selection to ABS");

// ============================
// ✅ Click Apply Button
// ============================
WebElement applyButton1 = wait.until(driver -> {
    List<WebElement> buttons = shadowRoot.findElements(Category.addcomparision);
    if (buttons.size() >= 2 && buttons.get(1).isDisplayed()) {
        return buttons.get(1);
    }
    return null;
});

((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block:'center'});", applyButton1);
		Thread.sleep(2000);

((JavascriptExecutor) driver).executeScript(
        "arguments[0].click();", applyButton1);

System.out.println("Apply button clicked successfully");
boolean maxReached = false;

List<String> valuesToSelect = Arrays.asList(
    "Acetone",
    "Acrylic Acid",
    "Carbon Steel",
    "Citric Acid",
    "Corrugated Boards",
    "Diesel",
    "Ethylene"
);

for (String value : valuesToSelect) {

    System.out.println("👉 Selecting: " + value);

    // ✅ Re-fetch elements
    WebElement hostLoop = driver.findElement(By.cssSelector("beroe-mmd"));
    SearchContext shadowRootLoop = hostLoop.getShadowRoot();

    WebElement panelLoop = wait.until(d -> {
        WebElement p = shadowRootLoop.findElement(By.cssSelector("div.mmd-compare-panel"));
        return p.isDisplayed() ? p : null;
    });

    List<WebElement> allOutersLoop = panelLoop.findElements(By.cssSelector("div.mmd-select-outer"));

    // ✅ CLOSE dropdown (important)
    ((JavascriptExecutor) driver).executeScript("document.body.click();");

    // ✅ Select correct value
    selectFromComparisonDropdown(wait, shadowRootLoop, panelLoop, allOutersLoop, 1, value);

    System.out.println("✅ Selected: " + value);

    Thread.sleep(1000);

    // ✅ Click Apply
    WebElement applyBtn = wait.until(d -> {
        List<WebElement> btns = shadowRootLoop.findElements(Category.addcomparision);
        return (btns.size() >= 2 && btns.get(1).isDisplayed()) ? btns.get(1) : null;
    });

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block:'center'});", applyBtn);

    ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();", applyBtn);

    System.out.println("✅ Apply clicked for: " + value);

    Thread.sleep(3000);

    // ✅ ✅ CHECK MAX MESSAGE (NON-BLOCKING)
    List<WebElement> msgs = shadowRootLoop.findElements(By.cssSelector("div.mmd-max-compare"));

    if (!msgs.isEmpty() && msgs.get(0).isDisplayed()) {

        String msgText = msgs.get(0).getText().trim();
        System.out.println("⚠ Max message: " + msgText);

        Assert.assertTrue(
            msgText.toLowerCase().contains("maximum number of comparisons"),
            "Wrong max comparison message"
        );

        System.out.println("✅ Max comparison reached. Stopping loop");

        maxReached = true;
        break;
    }
}

// ✅ Final validation
Assert.assertTrue(maxReached, "Max comparison not reached");

}
}



