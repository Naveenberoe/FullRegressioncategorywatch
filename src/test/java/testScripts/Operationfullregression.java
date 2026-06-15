package testScripts;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import PageObjects.Constants;
import PageObjects.Operations;
import PageObjects.Search;
import utils.DataInputProvider;
import utils.ExtentManager;
import utils.TestDataManager;

public class Operationfullregression {

	public WebDriver driver;
	public ExtentTest test;

	Constants cnstnt = new Constants(driver);
	CommonSteps steps = new CommonSteps(driver);
	DataInputProvider data = new DataInputProvider();

	public Operationfullregression(WebDriver driver) {
		this.driver = driver;
		this.test = ExtentManager.getTest();
	}

	@SuppressWarnings("static-access")
	public void loginoperations() throws InterruptedException {
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
	}

	@SuppressWarnings("static-access")
	public void loginoperations1() throws InterruptedException {
		test.log(Status.INFO, "Navigating to login page");
		driver.navigate().to(cnstnt.STG_Url);
		driver.manage().window().maximize();

		String username = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Loginopersation1username");
		String password = data.getColumnValuesAsString("LoginCredentials", "Category_Credentials", "Loginopersation1Password");

		test.log(Status.INFO, "Entering Username");
		steps.enterText(driver, Search.username, username);
		System.out.println("Username Entered");

		test.log(Status.INFO, "Entering Password");
		driver.findElement(Search.pswd).sendKeys(password);
		System.out.println("Password Entered");

		test.log(Status.INFO, "Clicking Login");
		driver.findElement(Search.loginop).click();
		System.out.println("Login Successful");
		Thread.sleep(20000);
	}

	@SuppressWarnings("static-access")
	public void categoryrestricted() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		

		test.log(Status.INFO, "Searching user email in Operations");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.searchUserEmail));
		steps.enterText(driver, Operations.searchUserEmail, data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query", testCase));
        

		test.log(Status.INFO, "Clicking Manage Plan icon");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.managePlanIcon));
		steps.click(driver, Operations.managePlanIcon);

		test.log(Status.INFO, "Navigating to Categories Restricted tab");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.categoriesDropdownArrow));
		steps.click(driver, Operations.categoriesDropdownArrow);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.restrictedTab));
		steps.click(driver, Operations.restrictedTab);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.restrictedSulfuricAcid));
		WebElement sulfuricAcid = driver.findElement(Operations.restrictedSulfuricAcid);
		Assert.assertTrue(sulfuricAcid.isDisplayed(), "Sulfuric Acid is not present under Restricted tab");

		test.pass("Restricted category validated: Sulfuric Acid is present");
	}

	@SuppressWarnings("static-access")
	public void benchmarkaccesno() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		test.log(Status.INFO, "Opening Plan Management from Operations");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.planrecords));
		steps.click(driver, Operations.planrecords);

		test.log(Status.INFO, "Searching the target plan");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.plansearch));
		steps.enterText(driver, Operations.plansearch, data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query", testCase));

		test.log(Status.INFO, "Opening Edit Plan");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.editplan));
		steps.click(driver, Operations.editplan);

		test.log(Status.INFO, "Scrolling to and clicking Citric Acid checkbox");
		WebElement citricCheckbox = wait.until(ExpectedConditions.presenceOfElementLocated(Operations.citricAcidCheckboxInPlan));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", citricCheckbox);
		Thread.sleep(500);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(citricCheckbox));
			citricCheckbox.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", citricCheckbox);
		}

		test.log(Status.INFO, "Changing Category Access to No");
		WebElement accessDropdown = wait.until(ExpectedConditions.elementToBeClickable(Operations.citricAcidCategoryAccessDropdown));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", accessDropdown);
		steps.click(driver, Operations.citricAcidCategoryAccessDropdown);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.dropdownNoOption));
		steps.click(driver, Operations.dropdownNoOption);
		driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE);

		test.log(Status.INFO, "Clicking Update");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.updateButton));
		steps.click(driver, Operations.updateButton);

		test.log(Status.INFO, "Confirming update in dialog");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.confirmButton));
		steps.click(driver, Operations.confirmButton);

		test.log(Status.INFO, "Validating success message");
		WebDriverWait successWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		successWait.pollingEvery(Duration.ofMillis(100));
		boolean successMessageSeen = successWait.until(d -> {
			List<WebElement> messages = d.findElements(Operations.toastmessage);
			for (WebElement message : messages) {
				String messageText = message.getText();
				if (message.isDisplayed() || (messageText != null && !messageText.trim().isEmpty())) {
					return true;
				}
			}
			return d.getPageSource().contains("Subscription Plan updated successfully");
		});
		Assert.assertTrue(successMessageSeen, "Update confirmation message not displayed");
		test.pass("Plan updated successfully and confirmation message displayed");
	}

	@SuppressWarnings("static-access")
	public void Deletemutiplecategory() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		test.log(Status.INFO, "Searching user email in Operations from test data");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.searchUserEmail));
		steps.enterText(driver, Operations.searchUserEmail, data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query", testCase));

		test.log(Status.INFO, "Opening Manage Plan for searched user");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.managePlanIcon));
		steps.click(driver, Operations.managePlanIcon);

		test.log(Status.INFO, "Expanding Categories section");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.categoriesDropdownArrow));
		steps.click(driver, Operations.categoriesDropdownArrow);

		test.log(Status.INFO, "Selecting all categories");
		WebElement selectAllContainer = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Operations.categoriesSelectAllContainer));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", selectAllContainer);

		WebElement selectAllCheckbox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Operations.categoriesSelectAllCheckbox));
		boolean isSelectAllChecked = selectAllCheckbox.getAttribute("class").contains("mat-checkbox-checked")
				|| "true".equalsIgnoreCase(selectAllCheckbox.getAttribute("ng-reflect-checked"));

		if (!isSelectAllChecked) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(Operations.categoriesSelectAllInnerBox));
				steps.click(driver, Operations.categoriesSelectAllInnerBox);
			} catch (Exception e) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						driver.findElement(Operations.categoriesSelectAllLabel));
			}
		}

		test.log(Status.INFO, "Clicking Unsubscribe");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.unsubscribeButton));
		steps.click(driver, Operations.unsubscribeButton);

		test.log(Status.INFO, "Confirming category delete popup with Yes");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.yesButton));
		steps.click(driver, Operations.yesButton);

		test.log(Status.INFO, "Re-opening Categories section after popup closes the dropdown");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.categoriesDropdownArrow));
		steps.click(driver, Operations.categoriesDropdownArrow);

		test.log(Status.INFO, "Opening Removed tab and validating categories are listed");
		WebElement removedTabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.removedTab));
		steps.click(driver, Operations.removedTab);

		Matcher matcher = Pattern.compile("\\((\\d+)\\)").matcher(removedTabElement.getText());
		int removedCount = (matcher.find()) ? Integer.parseInt(matcher.group(1)) : 0;
		Assert.assertTrue(removedCount > 0,
				"Removed tab count is not greater than zero after unsubscribe action");

		test.pass("Categories unsubscribed successfully and visible in Removed tab");
	}

	@SuppressWarnings("static-access")
	public void categoryWatch() throws Exception {

		test.log(Status.INFO, "Category Watch");
		//Thread.sleep(3000);
		steps.click(driver, Operations.gridicon);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.categorywatch));

		steps.click(driver, Operations.categorywatch);
		System.out.println("Category watch");

		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.categorypage));
		WebElement category = driver.findElement(Operations.categorypage);
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
    public void searchCategory() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.addcategory));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		test.log(Status.INFO, "Opening Add Category modal");
		steps.click(driver, Operations.addcategory);

		test.log(Status.INFO, "Searching first category");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.addcategorysearchclick));
		steps.click(driver, Operations.addcategorysearchclick);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.addcategorysearch));
		String firstCategory = data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query1", testCase);
		steps.enterText(driver, Operations.addcategorysearch, firstCategory);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.searchedcategory));
		String actualtext = driver.findElement(Operations.searchedcategory).getText();
		Assert.assertTrue(actualtext.equalsIgnoreCase(firstCategory),
				" Category mismatch.<br><b>Expected:</b> " + firstCategory + "<br><b>Actual:</b> " + actualtext);
		System.out.println("Category found correctly");
		test.pass(" Category matched correctly.<br><b>Expected:</b> " + firstCategory + "<br><b>Actual:</b> " + actualtext);

		test.log(Status.INFO, "Selecting first category and navigating Next -> Skip");
		WebElement firstSearchInput = wait.until(ExpectedConditions.elementToBeClickable(Operations.addcategorysearch));
		firstSearchInput.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.addCategoryNextButton));
		steps.click(driver, Operations.addCategoryNextButton);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.addCategorySkipButton));
		steps.click(driver, Operations.addCategorySkipButton);

		
		test.log(Status.INFO, "Clicking Yes to confirm adding second category");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.addCategoryYesButton));
		steps.click(driver, Operations.addCategoryYesButton);

		test.log(Status.INFO, "Opening Add Category modal");
		steps.click(driver, Operations.addcategory);

		test.log(Status.INFO, "Searching first category");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.addcategorysearchclick));
		steps.click(driver, Operations.addcategorysearchclick);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.addcategorysearch));
		String firstCategory1 = data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query2", testCase);
		steps.enterText(driver, Operations.addcategorysearch, firstCategory1);

		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.searchedcategory1));
		String actualtext1 = driver.findElement(Operations.searchedcategory1).getText();
		Assert.assertTrue(actualtext1.equalsIgnoreCase(firstCategory1),
				" Category mismatch.<br><b>Expected:</b> " + firstCategory1 + "<br><b>Actual:</b> " + actualtext);
		System.out.println("Category found correctly");
		test.pass(" Category matched correctly.<br><b>Expected:</b> " + firstCategory1 + "<br><b>Actual:</b> " + actualtext);

		test.log(Status.INFO, "Selecting first category and navigating Next -> Skip");
		WebElement firstSearchInput1 = wait.until(ExpectedConditions.elementToBeClickable(Operations.addcategorysearch));
		firstSearchInput1.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.addCategoryNextButton));
		steps.click(driver, Operations.addCategoryNextButton);
		
		wait.until(ExpectedConditions.elementToBeClickable(Operations.addCategorySkipButton));
		steps.click(driver, Operations.addCategorySkipButton);


		
	}

	@SuppressWarnings("static-access")
	public void threeplrestricted() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Map<String, String> testData = TestDataManager.getCurrentTestData();
		String testCase = testData.get("TestCase");

		test.log(Status.INFO, "Navigating to User Management");
		//wait.until(ExpectedConditions.elementToBeClickable(Operations.userManagementMenu));
		//steps.click(driver, Operations.userManagementMenu);

		test.log(Status.INFO, "Searching user email in Operations");
		wait.until(ExpectedConditions.visibilityOfElementLocated(Operations.searchUserEmail));
		steps.enterText(driver, Operations.searchUserEmail, data.getColumnDataAsString("OperationfullregressionTestdata",
				"Operationfullregression", "query", testCase));

		test.log(Status.INFO, "Clicking Manage Plan icon");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.managePlanIcon));
		steps.click(driver, Operations.managePlanIcon);

		test.log(Status.INFO, "Opening Categories and Restricted tab");
		wait.until(ExpectedConditions.elementToBeClickable(Operations.categoriesDropdownArrow));
		steps.click(driver, Operations.categoriesDropdownArrow);
		wait.until(ExpectedConditions.elementToBeClickable(Operations.restrictedTab));
		steps.click(driver, Operations.restrictedTab);

		test.log(Status.INFO, "Validating 3PL Services is displayed in Restricted tab");
		WebElement threePlServices = wait
				.until(ExpectedConditions.visibilityOfElementLocated(Operations.restrictedThreeplServices));
		Assert.assertTrue(threePlServices.isDisplayed(), "3PL Services is not present under Restricted tab");

		test.pass("Restricted category validated: 3PL Services is present");
	}
}