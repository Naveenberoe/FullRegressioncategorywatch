package PageObjects;

import org.openqa.selenium.By;


public class Search {
	
	//Login
	
	public static final By username = By.id("email");
	public static final By pswd = By.id("password");
	public static final By login = By.xpath("//button[@type='submit']");
	public static final By welcome = By.xpath("//span[@class='clash-grotesk welcomeFont']");
	
	
	public static final By usernameop = By.xpath("//input[@ng-reflect-name='username']");
	public static final By pswdop = By.xpath("//input[@ng-reflect-name='password']");
	public static final By loginop = By.xpath("//button[text()='Sign in']");
	
	
	
	public static final By search_icon = By.xpath("//button[@class='search-icon m-auto']");
	public static final By search_textbox = By.xpath("(//input[@type='text'])[1]");
	public static final By welcome_search = By.xpath("(//input[@type='text'])[2]");
	public static final By search_submit = By.xpath("//button[@class='submit-btn2']");
	public static final By welcome_search_submit = By.xpath("//button[@class='submit-btn1']");
	
	public static final By batteries = By.xpath("(//h3[contains(text(),Batteries)])[1]");
	public static final By baterias = By.xpath("(//div/div/h3/strong[contains(text(), baterías)])[1]");
	
	public static final By supplier = By.xpath("//input[@placeholder='Find your supplier']");
	
	//Search result Headers
	
	public static final By button_all = By.xpath("(//button/span[contains(text(),All)])[1]");
	public static final By button_categories = By.xpath("(//button/span[contains(text(),All)])[3]");
	public static final By button_suppliers = By.xpath("(//button/span[contains(text(),All)])[5]");
	public static final By button_thoughts = By.xpath("(//button/span[contains(text(),All)])[7]");
	public static final By button_reports = By.xpath("(//button/span[contains(text(),All)])[9]");
	
	public static final By button_all_num = By.xpath("(//button/span[contains(text(),All)])[2]");
	public static final By button_categories_num = By.xpath("(//button/span[contains(text(),All)])[4]");
	public static final By button_suppliers_num = By.xpath("(//button/span[contains(text(),All)])[6]");
	public static final By button_thoughts_num = By.xpath("(//button/span[contains(text(),All)])[8]");
	public static final By button_reports_num = By.xpath("(//button/span[contains(text(),All)])[10]");
	
	//Abi connect in Search results
	
	public static final By abiconnect = By.xpath("//img[@alt='abiConnect']");
	public static final By abichat = By.xpath("//div[@class='chatIcon']");
	
	//Search Results
	
	public static final By plus_icon = By.xpath("(//div[@class='C3beQOl7YQESMfzu2axN']/div/button)[1]");
	public static final By reports_icon = By.xpath("//img[@alt='Reports icon']");
	public static final By first_report = By.xpath("(//h3//strong[text()='ABS'])[6]");
	public static final By ppttext = By.xpath("//div[@id='t4_1']");
	
	//Add Category page
	
	public static final By category_search = By.xpath("(//div[@role='option']/span)[1]");
	public static final By first_result = By.xpath("(//h3)[1]");
	
	//Products Tab
	
	public static final By products = By.xpath("(//button/span)[2]");
	public static final By categorywatch = By.xpath("(//h4)[2]");
	public static final By supplierwatch = By.xpath("(//h4)[3]");
	public static final By thoughtleadership = By.xpath("(//h4)[5]");
	public static final By inflationwatch = By.xpath("(//h4)[4]");
	public static final By training = By.xpath("(//h4)[6]");
	
	//Category watch
	
	public static final By categorywatch_header = By.xpath("//a[@href='/categories']");
	public static final By categoryname = By.xpath("(//span)[26]");
	public static final By catcount = By.xpath("(//div[@class='s_A6pYMHR7j1GX3PULvF'])[2]");
	public static final By catgrylist = By.xpath("(//div[@class='flex hyper-link'])");
	public static final By catgryspend = By.xpath("(//span[@class='flex items-center']//span)");
	public static final By loadmore = By.xpath("(//button[@class='G4TUQ71IGuV64bICfCm8'])[1]");
	public static final By summary = By.xpath("//table[@class='table-auto border-collapse bg-white text-sm primary-table']");
			
	//button[text()='Load More'])[1]");
	
	//Supplier watch
	
	public static final By supplierwatch_header = By.xpath("//a[@href='/suppliers']");
	public static final By supplierrisk = By.xpath("(//span)[3]");
	public static final By supplierrisklevel = By.xpath("(//div[contains(text(),Suppliers)])[63]");
	public static final By supplierriskfactor = By.xpath("(//div[contains(text(),Suppliers)])[90]");
	public static final By suppliercount = By.xpath("(//span[@class='font-medium'])[1]");
	public static final By suppliersummary = By.xpath("//div[@data-name='suppliers']");
	public static final By supplierlist = By.xpath("(//div[@class='hyper-link flex justify-between'])");
	public static final By dunslist = By.xpath("(//td[@class='w-[140px]  py-[18px] pl-[5px]'])");
	public static final By locationlist = By.xpath("//td[@tabindex=-1]//span//span[2]");
	public static final By srslist = By.xpath("//p[@class='xg4HNWDRkHVp6RSsPlHK']");
	
	public static final By supplierdiscovery = By.xpath("(//span)[1]");
	
	//Inflation watch
	
	public static final By inflation_header = By.xpath("//a[@href='/general-inflation/my_portfolio']");
	
	//Quick Actions
	
	public static final By quickactions = By.xpath("//div[@class = 'neLCN5M1jLQbISiJDDr4' and contains(text(), Quick )]");
	public static final By quick1 = By.xpath("(//pre)[1]");
	public static final By quick2 = By.xpath("(//pre)[2]");
	public static final By quick3 = By.xpath("(//pre)[3]");
	public static final By quick4 = By.xpath("(//pre)[4]");
	
	public static final By resquick1 = By.xpath("//div[@title = 'Review latest trends for my categories']");
	public static final By resquick2 = By.xpath("//div[@title = 'Track risk across my suppliers']");
	public static final By resquick3 = By.xpath("//div[@title = 'Monitor inflation across my portfolio']");
	public static final By resquick4 = By.xpath("//div[@title = 'Find a new or alternate supplier']");
	
	public static final By qa_categories = By.xpath("//input[@aria-autocomplete='list']");
	public static final By proceed_btn = By.xpath("//div[@class='sz1EVmVQOy7BVvIO6uFm actions']/button");
	
	//Menu
	
	public static final By menu = By.xpath("//button[@id='headlessui-menu-button-1']");
	public static final By categorywatch_menu = By.xpath("//span[text()='Category Watch']");
	public static final By supplierwatch_menu= By.xpath("//span[text()='Supplier Watch']");
	
	
	
}

