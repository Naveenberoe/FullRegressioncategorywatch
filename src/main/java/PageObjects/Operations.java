package PageObjects;

import org.openqa.selenium.By;

public class Operations {

	public static final By usernameop = By.xpath("//input[@ng-reflect-name='username']");
	public static final By pswdop = By.xpath("//input[@ng-reflect-name='password']");
	public static final By loginop = By.xpath("//button[text()='Sign in']");
	public static final By operationclcikliveai = By.xpath("//button[text()='Go to LiVE.Ai']");
	public static final By userManagementMenu = By.xpath("//span[normalize-space()='User Management']");

	public static final By searchUserEmail = By.xpath("//input[@placeholder='Enter user email' or @ng-reflect-placeholder='Enter user email']");
	public static final By managePlanIcon = By.xpath("//fa-icon[@ng-reflect-message='Manage Plan']");
	public static final By planrecords = By.xpath("//span[text()='Plan Management']");
	public static final By plansearch = By.xpath("//input[@ng-reflect-placeholder='Enter Plan Name']");
	public static final By editplan = By.xpath("//fa-icon[@ng-reflect-icon='pencil-alt']");
	public static final By citricAcidCheckboxInPlan = By.xpath("//tr[.//td[contains(normalize-space(),'Citric Acid')]]//td[contains(@class,'category-selected-checked')]//label[contains(@class,'mat-checkbox-layout')]");
	public static final By citricAcidCategoryAccessDropdown = By.xpath("//tr[.//td[contains(normalize-space(),'Citric Acid')]]//td[3]//ng-select");
	public static final By dropdownNoOption = By.xpath("//ng-dropdown-panel//div[@role='option']//span[normalize-space()='No']");
	public static final By updateButton = By.xpath("//button[.//span[normalize-space()='Update']]");
	public static final By confirmButton = By.xpath("//button[contains(@class,'btn-ok') and normalize-space()='Confirm']");
	public static final By toastmessage = By.xpath("//div[contains(@class,'toast-message')] | //span[contains(normalize-space(),'Subscription Plan updated')]");
	public static final By categoriesSection = By.xpath("//mat-expansion-panel-header[.//span[normalize-space()='Categories']]");
	public static final By categoriesDropdownArrow = By.xpath("//mat-expansion-panel-header[.//span[normalize-space()='Categories']]//span[contains(@class,'mat-expansion-indicator')]");
	public static final By categoriesSelectAllCheckbox = By.xpath("//span[contains(@class,'selectall-chkbox')]//mat-checkbox");
	public static final By categoriesSelectAllContainer = By.xpath("//span[contains(@class,'selectall-chkbox')]//label[contains(@class,'mat-checkbox-layout') and contains(normalize-space(.),'Select all')]");
	public static final By categoriesSelectAllLabel = By.xpath("//span[contains(@class,'selectall-chkbox')]//label[contains(@class,'mat-checkbox-layout')]");
	public static final By categoriesSelectAllInnerBox = By.xpath("//span[contains(@class,'selectall-chkbox')]//label[contains(@class,'mat-checkbox-layout')]//div[contains(@class,'mat-checkbox-inner-container')]");
	public static final By unsubscribeButton = By.xpath("//button[normalize-space()='Unsubscribe']");
	public static final By yesButton = By.xpath("//button[normalize-space()='Yes']");
	public static final By removedTab = By.xpath("//div[starts-with(normalize-space(),'Removed')]");
	public static final By restrictedTab = By.xpath("//div[text()='Restricted']");
	public static final By restrictedSulfuricAcid = By.xpath("//span[contains(text(),'Sulfuric Aci')]");
	public static final By restrictedThreeplServices = By.xpath("//div[@title='3PL Services'] | //span[normalize-space()='3PL Services']");
	public static final By addcategory = By.xpath("//span[text()='Add Category']");
	public static final By addcategorysearchclick = By.xpath("//div[normalize-space()='Search Categories by Name or NAICS/UNSPSC Code...']");
	public static final By addcategorysearch = By.xpath("//input[@autocomplete='off']");
	public static final By searchedcategory = By.xpath("//span[text()='AI Servers']");
	public static final By searchedcategory1 = By.xpath("//span[text()='Rice']");
	public static final By addCategorySuggestion = By.xpath("//mat-option//span[contains(@class,'mat-option-text')]");
	public static final By addCategoryNextButton = By.xpath("//button[normalize-space()='Next']");
	public static final By addCategorySkipButton = By.xpath("//button[normalize-space()='Skip']");
	public static final By addCategoryYesButton = By.xpath("//button[normalize-space()='No']");
	  public static final By gridicon = By.xpath("//div[@class='grid-icon']");
	public static final By categorywatch = By.xpath("//span[text()='Category Watch']");
	public static final By categorypage = By.xpath("//div[text()='Total Spend :']");
}