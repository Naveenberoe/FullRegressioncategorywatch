package PageObjects;

import org.openqa.selenium.By;


public class Category 
{
	
	
	
	public static final By operationclcikliveai = By.xpath("//button[text()='Go to LiVE.Ai']");


	public static final By searchusername = By.xpath("//input[@data-placeholder='Enter user email']");
	public static final By addrole = By.xpath("//table[contains(@class,'mat-table')]//td//fa-icon[@ng-reflect-message='Manage Role']");
	public static final By searchrole = By.xpath("(//input[@name='search'])[2]");
	public static final By searchrolealreadypresent = By.xpath("(//input[@name='search'])[1]");
	public static final By clickarrowleft = By.xpath("//fa-icon[@icon='arrow-left']");
	public static final By clickarrowright = By.xpath("//fa-icon[@icon='arrow-right']");
	public static final By saveroles = By.xpath("//button[text()='Save']");
	public static final By clickuserrole = By.xpath("//option[text()='ROLE_USER_COUNTRY_REPORT']");
	public static final By downloaduserlist = By.xpath("//button[@ng-reflect-message='Download the User List']");
	public static final By userlistsuccessmsg = By.xpath("//span[contains(text(),'To view the user list, please check your email')]");
	public static final By planrecords = By.xpath("//span[text()='Plan Management']");
	public static final By plansearch = By.xpath("//input[@ng-reflect-placeholder='Enter Plan Name']");
	public static final By plansearched = By.xpath("//tr//td[text()=' Trail_350 ']");
	public static final By companyrecords = By.xpath("//span[text()='Company Management']");
	public static final By companysearch = By.xpath("//input[@ng-reflect-placeholder='Enter Company/Domain']");
	public static final By companysearched = By.xpath("//tr//td[text()=' Automation']");
	public static final By manageplan = By.xpath("//table[contains(@class,'mat-table')]//td//fa-icon[@ng-reflect-message='Manage Plan']");
	public static final By startdate = By.xpath("(//input[@matinput and @readonly])[2]");
	public static final By editplan = By.xpath("//fa-icon[@ng-reflect-icon='pencil-alt']");
	public static final By enterpriselevel3A = By.xpath("(//input[@ng-reflect-name='Procleus'])[5]");
	public static final By citricAcidCheckboxInPlan = By.xpath("//tr[.//td[normalize-space()='Citric Acid']]//input[@type='checkbox']");
	public static final By citricAcidCategoryAccessDropdown = By.xpath("//tr[.//td[normalize-space()='Citric Acid']]//td[3]");
	public static final By dropdownNoOption = By.xpath("//mat-option//span[normalize-space()='No']");
	public static final By updateButton = By.xpath("//button[normalize-space()='Update']");
	public static final By activistatustoggle1 = By.xpath("(//input[@role='switch'])");
	public static final By activistatustoggle2 = By.xpath("(//input[@role='switch'])/following-sibling::div[1]");
	public static final By deactivationbutton = By.xpath("//button[text()='Yes']");
	public static final By deactivationmessage = By.xpath("//div[text()='Account Deactivated']");
	public static final By usersupplierdetails = By.xpath("//span[text()='User Supplier Details']");
	public static final By enteremail = By.xpath("//input[@ng-reflect-placeholder='Enter Email']");
	public static final By clickmoredetails = By.xpath("(//table//button[text()='More Details'])[1]");
	public static final By esgrating = By.xpath("(//table)[2]//tr[5]//td[3]//div");
	public static final By clickYes = By.xpath("//button[text()='Yes']");
	
	// SUPPLIERWATCH
	public static final By supplierwatch = By.xpath("//span[text()='Supplier Watch']");
	public static final By clickabb = By.xpath("//DIV[@TITLE='ABB']");
	public static final By clickabb1 = By.xpath("(//div[@role='button'])//div[text()='ABB']");
	public static final By esgscore = By.xpath("((//DIV[@data-test-id='CircularProgressbarWithChildren'])[2]//DIV)[3]");
	
	// Homepage

	public static final By gridicon = By.xpath("//div[@class='grid-icon']");
	public static final By profile = By.xpath("//div[@class='prof-details-header']");
	public static final By categorywatch = By.xpath("//span[text()='Category Watch']");
	public static final By categorypage = By.xpath("//div[text()='Total Spend :']");
	public static final By planexpire = By.xpath("//span[text()='Your plan expires ']");
	public static final By helpdocumentation = By.xpath("//div[@title='Help & Documentation']");
	public static final By categorwatchhelp = By.xpath("//a[text()='Category Watch Module']");
	public static final By categorwatchtitle = By.xpath("//h1[text()='Category Watch Module']");
	public static final By Supplierwatchhelp = By.xpath("(//a[text()='Supplier Watch Module'])[2]");
	public static final By supplierwatchtitle = By.xpath("//h1[text()='Supplier Watch Module']");
	public static final By categorwatcplayinhelp = By.xpath("//div[@class='pw']");
	public static final By Helphome = By.xpath("//div[text()='Beroe Live.ai User Guide']");

	// Notifications;
	public static final By notificationalerts = By.xpath("//a[text()='Advisories & Alerts']");
	public static final By notificationcategory = By.xpath("//a[text()='Category Reports']");
	public static final By notificationprice = By.xpath("//a[text()='Price & Supplier Rating Changes']");
	public static final By notificationnewsalert = By.xpath("//a[text()='Newsletters']");
	public static final By categorynotification = By.xpath("//span[@title='Attention: Price Volatility for Sulfuric Acid']");
	public static final By nonotificationfound = By.xpath("//div[text()='No new notifications.']");
	public static final By notification = By.xpath("//span[@title='Notifications']");
	public static final By viewallnotification = By.xpath("//button[text()='View all notifications']");
	// lOGINPAGE
	public static final By termandservice = By.xpath("//a[text()='Terms of Service']");
	public static final By termservice = By.xpath("//div[text()='Beroe LiVE.Ai - Terms of Service']");
	public static final By privacypolicy = By.xpath("//a[text()='| Privacy Policy']");
	public static final By privacypolicy1 = By.xpath("//div[text()='Privacy Policy']");
	public static final By closeicon = By.xpath("//img[@alt='closeIcon']");
	// Category watch
	public static final By batteries = By.xpath("//div[@title='Batteries']");
	public static final By ethylene = By.xpath("//div[@title='Ethylene']");
	public static final By tooltip = By.xpath("(//div[@class='flex justify-center items-center self-stretch'])//div[2]");
	public static final By close_tooltip = By.xpath("(//div[@class='flex justify-center items-center rounded-md'])");
	public static final By addcategory = By.xpath("//span[text()='Add Category']");
	public static final By addcategorysearchclick = By.xpath("//div[normalize-space()='Search Categories by Name or NAICS/UNSPSC Code...']");
	public static final By addcategorysearch = By.xpath("//input[@autocomplete='off']");
	public static final By searchedcategory = By.xpath("//span[text()='Iron Ore']");
	// Benchmark
	public static final By costoptimization = By.xpath("//h5[text()='Cost Optimization']");
	public static final By specification = By.xpath("//span[normalize-space()='Specification Leanness']");
	public static final By toggle = By.xpath("//div[@class='mat-slide-toggle-thumb']");
	public static final By toggletext = By.xpath("//span[@class='mat-slide-toggle-content']");
	
	public static final By iframe=  By.xpath("//iframe[@title='iframe']");
	
	

	// Tagged Suppliers

	public static final By carbonsteel = By.xpath("//div[@title='Carbon Steel']");
	public static final By suppliers = By.xpath("//div[@title='Suppliers']");
	public static final By suppliertable = By.xpath("(//div[@class='primary-table-overflow']/table)[2]");
	public static final By firstsupplier = By.xpath("(//div[@class='primary-table-overflow']/table)[2]/tbody/tr/td[1]");
	public static final By supplierdetails = By.xpath("//a[text()='Supplier Watch']");

	// Next category

	public static final By next = By.xpath("//span[text()='Next']");
	public static final By nextcategory = By.xpath("(//span[text()='Carbon Steel'])[2]");
	// Reports
	public static final By reports = By.xpath("//div[@title='Reports']");
	public static final By categoryreport = By.xpath("//table[@class='min-w-full primary-table']/tbody/div/tr[1]");
	public static final By clickdownload = By.xpath("(//table[@class='min-w-full primary-table']/tbody//tr[1]//td[4]//button)[1]");
	public static final By downloadreport = By.xpath("(//button[text()='Download'])");
	public static final By hyperlink = By.xpath("//table[@class='min-w-full primary-table']//td[1]//button[1]/div[1]//span[text()='Batteries']");
	public static final By reportname = By.xpath("//div[@id='t4_1']");

	// MMD Dashboard Download
	public static final By abs = By.xpath("//div[@title='ABS']");
	public static final By Polystyrene = By.xpath("(//span[text()='Polystyrene'])[1]");
	public static final By Threeplservices = By.xpath("//div[@title='3PL Services']");
	public static final By baseyear = By.cssSelector("div.mmd-forecast-date");

	public static final By mmddownload = By.xpath("//button[text()=' Download ']");
	public static final By pricetrend = By.xpath("//div[text()=' Price Trend ']");
	// Cross Browser
	public static final By heading = By.xpath("(//span[text()='Batteries'])[2]");
	// Benchmark
	public static final By atm = By.xpath("//div[@title='ATM Services']");
	public static final By atmservices = By.xpath("//span[@title='ATM Services']");
	public static final By acid = By.xpath("//div[@title='Citric Acid']");
	public static final By citricacid = By.xpath("//span[@title='Citric Acid']");
	public static final By benchmark = By.xpath("//div[@title='Benchmarking']");
	public static final By benchmark_text = By.xpath("//span[text()='Benchmarking is not available for this category.']");
	// Custom Research
	public static final By more = By.xpath("//div[text()='See more of our products and features']");
	public static final By customresearch = By.xpath("//div[text()='Custom Research']/following::button[contains(text(),'View Details')][1]");
	public static final By searchtext = By.xpath("(//input[@type='text'])[2]");
	public static final By region = By.xpath("//div[text()='China']");
	// Contact Support
	public static final By contact = By.xpath("//div[text()='Contact Support']");
	public static final By reason = By.xpath("//span[text()='Select a Reason']");
	public static final By others = By.xpath("//span[text()='Other']");
	public static final By comment = By.xpath("//textarea[@id='comment']");
	public static final By send = By.xpath("//button[text()='Send']");
	public static final By support = By.xpath("//div[text()='Contact Support']");
	public static final By toastmessage = By.xpath("//div[contains(@class, 'toast-message')]");

	// PODCAST
	public static final By viewmore = By.xpath("//button[text()='View more']");
	public static final By poadcastplay = By.xpath("//button[@title='Play']");
	public static final By viewtranscripts = By.xpath("//span[text()='View Transcript']");
	public static final By Downlaod = By.xpath("//button[@title='Download Transcript']");
	public static final By podcastellipsis = By.xpath("(//button[@class='_h_BKDmCtbW4ZYnU4_O_'])[1]");
	// NEWs
	public static final By alertssection = By.xpath("//div[text()='Alerts & Advisories']");
	public static final By newssection = By.xpath("//div[text()='News']");
	public static final By clicknewslink = By.xpath("(//div[normalize-space()='News']/parent::div/following-sibling::div//div[@title])[1]");
	public static final By checknewslink = By.xpath("//h4[@class='fw-bold pb-2']");
	public static final By RFA = By.xpath("(//p[@class='oeKv6bxOpMNs4uwU0sq0'])");
	public static final By newsviewall = By.xpath("//div[text()='News']/following-sibling::div[1]");
	public static final By newsfilter = By.xpath("(//div[text()='Displaying '])[3]/following-sibling::div[1]");
	public static final By filtercheckbox = By.xpath("//input[@name='Business Updates']");
	public static final By displaycount = By.xpath("(//div[text()='Displaying '])[3]");
	public static final By filtercount = By.xpath("//input[@name='Business Updates']/following::span[1]");
	
	// Reports
	public static final By cartonBoards = By.xpath("//div[@title='Carton Boards']");
	public static final By requestcountry = By.xpath("//button[text()='Request Country Report']");
	public static final By requestcountry1 = By.xpath("//div[@id='Country']");
	public static final By requestcountry2 = By.xpath("//div[text()='Country']/following::input[1]");
	// table[contains(@class, 'custom-research-table')]//tbody
	public static final By customtable = By.xpath("//table[contains(@class, 'custom-research-table')]//tbody");
	public static final String namecellxpath = ".//td[1]";
	public static final String statuscellxpath = ".//td[5]";
	// option[text()='ROLE_USER_COUNTRY_REPORT']
	public static final By requestsubmit = By.xpath("//button[text()='Submit Request']");
	public static final By requestsubmitok = By.xpath("//button[text()='Ok']");
	// Benchmark
	public static final By annulspend = By.xpath("//div[normalize-space(text())='Percent']/preceding-sibling::*//input");
	public static final By grade = By.xpath("//span[text()=' Pharma Grade ']");
	public static final By select = By.xpath("(//div[text()='Select'])");
	public static final By searchlocation = By.xpath("(//input[@type='company'])");
	public static final By searchedlocation = By.xpath("(//span[text()='Port of Spain,Trinidad and Tobago'])");
	public static final By workprices = By.xpath("//div[normalize-space(text())='USD/MT']/preceding-sibling::*//input");
	public static final By specficationlearners = By.xpath("//span[text()=' YES ']");
	public static final By manygrade = By.xpath("//div[normalize-space(text())='Grades']/preceding-sibling::*//input");
	public static final By minimunordequanty = By.xpath("//span[text()=' YES ']");
	public static final By largestsupplier = By.xpath("//div[normalize-space(text())='Percent']/preceding-sibling::*//input");
	public static final By paymentterms = By.xpath("//span[text()=' YES ']");
	public static final By days = By.xpath("//div[normalize-space(text())='Days']/preceding-sibling::*//input");
	public static final By control = By.xpath("//span[text()=' YES ']");
	public static final By weeks = By.xpath("//div[normalize-space(text())='Weeks']/preceding-sibling::*//input");
	public static final By riskmitigation = By.xpath("//span[text()=' YES ']");
	
	public static final By selectsuppliers = By.xpath("(//span[text()=' SELECT FROM MY SUPPLIERS '])");
	public static final By selectrisk = By.xpath("(//div[text()='Select'])");
	public static final By selectabb = By.xpath("(//span[text()='ABB'])");
	public static final By tagselct = By.xpath(" TAG SELECTED ");
	public static final By supplyassurance = By.xpath("//span[text()=' YES ']");
	public static final By usdspend = By.xpath("//div[normalize-space(text())='Suppliers']/preceding-sibling::*//input");
	public static final By soucingprocess = By.xpath("//span[text()=' YES ']");
	public static final By spend1 = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By usdspend2 = By.xpath("(//div[normalize-space(text())='Percent'])[2]/preceding-sibling::*//input");
	public static final By usdspend3 = By.xpath("(//div[normalize-space(text())='Percent'])[3]/preceding-sibling::*//input");
	public static final By suppliertype = By.xpath("//span[text()=' YES ']");
	public static final By spendsupplier1 = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By spendsupplier2 = By.xpath("(//div[normalize-space(text())='Percent'])[2]/preceding-sibling::*//input");
	public static final By spendsupplier5 = By.xpath("(//div[normalize-space(text())='Percent'])[3]/preceding-sibling::*//input");
	public static final By prcingmodel = By.xpath("//span[text()=' YES ']");
	public static final By prcingmodel1 = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By prcingmodel2 = By.xpath("(//div[normalize-space(text())='Percent'])[2]/preceding-sibling::*//input");
	public static final By prcingmodel5 = By.xpath("(//div[normalize-space(text())='Percent'])[3]/preceding-sibling::*//input");
	public static final By contracttype = By.xpath("//span[text()=' YES ']");
	public static final By spendacross = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By contractlength = By.xpath("//span[text()=' YES ']");
	public static final By contractlength1 = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By slap = By.xpath("//span[text()=' YES ']");
	public static final By levels = By.xpath("(//div[normalize-space(text())='Orders'])[1]/preceding-sibling::*//input");
	public static final By levelsize = By.xpath("(//div[normalize-space(text())='Size'])[1]/preceding-sibling::*//input");
	public static final By transport = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By defect = By.xpath("(//div[normalize-space(text())='Weeks'])[1]/preceding-sibling::*//input");
	public static final By levelytlization = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By Leadtimes = By.xpath("//span[text()=' YES ']");
	public static final By levelLeadtimeweekends = By.xpath("(//div[normalize-space(text())='Weeks'])[1]/preceding-sibling::*//input");
	public static final By supplierdiversity = By.xpath("//span[text()=' YES ']");
	public static final By diversupplys = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By valustargets = By.xpath("//span[text()=' YES ']");
	public static final By targetsavings = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By achivedsavings = By.xpath("//span[text()=' YES ']");
	public static final By savingachived = By.xpath("(//div[normalize-space(text())='Percent'])[1]/preceding-sibling::*//input");
	public static final By nextbenchmark = By.xpath("//button[text()='NEXT']");
	public static final By continuebenchamrk = By.xpath("//div[normalize-space(text())='Acrylic Acid']/ancestor::tr//span[normalize-space(text())='Continue Benchmark']");
	public static final By createbenchamrk = By.xpath("(//span[text()='Create Benchmark'])[1]");
	public static final By skips = By.xpath("//button[text()='SKIP']");
	public static final By searchaddedcategory = By.xpath("//input[@placeholder='Search']");
	
	public static final By tableofcontent = By.xpath("(//span[text()='Table of Contents']/following-sibling::div[1])");
	
	public static final By tableofcontentcategorywatch = By.xpath("//div[@role='button']//div[@title='Category Watch']");
	public static final By tableofcontentmmd = By.xpath("//div[@role='button']//div[@title='MMD']");
	public static final By tableofcontentreports = By.xpath("//div[@role='button']//div[@title='Reports']");
	public static final By tableofcontentTools = By.xpath("//div[@role='button']//div[@title='Tools']");
	public static final By tableofcontentBenchmarking = By.xpath("//div[@role='button']//div[@title='Benchmarking']");
	public static final By tableofcontentsupplier = By.xpath("//div[@role='button']//div[@title='Suppliers']");

	public static final By diesel = By.xpath("//div[@title='Diesel']");
	public static final By createbenchmark = By.xpath("//span[text()='Create Benchmark']");
	public static final By wheat = By.xpath("//div[@title='Wheat']");
	public static final By createbenchmarkquestion = By.xpath("//div[text()=' What is your annual spend on Wheat as a percentage of revenue? ']");
	public static final By loadmorecategory = By.xpath("//button[text()='Load More']");
	public static final By marketsite = By.xpath("//p[text()='Makersite']");
	public static final By Findsupllierellipsis = By.xpath("((//table//td[6])[1])//div//div");
	public static final By Findsuplliere = By.xpath("//div[text()='Find Suppliers']");
	public static final By suppliers1 = By.xpath("//span[text()='Supplier Discovery']");
	public static final By tableheader = By.xpath("//table//thead//tr//th//div[@class='uppercase']");
	public static final By hyphenbenchmark = By.xpath("//div[@title='Carbon Steel']/ancestor::tr//td[3]");
	public static final By mmdplam = By.xpath("//span[text()='This feature is not part of your plan.']");
	public static final By carbonoffsets = By.xpath("//div[text()='Carbon Offsets']");
	public static final By chsgraph = By.xpath("//span[text()='View Trend ']");
	public static final By addhealthfactor = By.xpath("//span[text()='Add Health Factor']");
	public static final By menudropdown = By.xpath("//div[@class='css-vov3i1-menu']");
	public static final By chsdownload = By.xpath("(//div[@class='chs-history-contents']//following-sibling::div[1])[1]");
	public static final By chsdownload1 = By.xpath("//div[@class='css-1jhlevl-menu']");
	public static final By Graphnview = By.xpath("//button[text()='View']");
	public static final By mygraph = By.xpath("//div[text()='My Graphs']");
	public static final By mygraphname = By.xpath("//div[text()='Graph Name']");
	public static final By graphellipsies = By.xpath("(//table//tbody//tr/td[5]//div)[1]");
	public static final By graphellipsiesdetailpage = By.xpath("(//table//tbody//tr/td[4]//div)[1]");
	
	public static final By grapdownload = By.xpath("//div[text()='Download']");
	public static final By grapdelete = By.xpath("//div[text()='Delete']");
	public static final By renamegraph = By.xpath("//div[text()='Rename']");
	public static final By grapdownloaddetailspage = By.xpath("(//div[text()='Download'])[2]");
	public static final By coststructure = By.cssSelector("div.mmd-cs-table-info");
	public static final By coststructuretable = By.cssSelector("table.mmd-cs-table");
	public static final By removebenchmark = By.cssSelector("div.mmd-cost-header-menu-item");
	public static final By sourcedropdown = By.cssSelector("div.mmd-select-dropdown div[value]");
	public static final By addcomparision = By.cssSelector("button.mmd-button");
	public static final By cancelComparison = By.cssSelector("button.mmd-button-sec");
	
	public static final By corrugatedboards = By.xpath("//div[@title='Corrugated Boards']");
	public static final By graphinput = By.xpath("(//input[@type='text'])[3]");
	public static final By graphsave = By.xpath("(//div[text()='Save'])");
	public static final By graphsaveanyway = By.xpath("//button[text()='Save Anyway']");
	
	
	public static final By graphfirstrow = By.xpath("(//table//tbody//tr//td)[1]");
	public static final By graphrow = By.xpath("//table//tbody//tr//td");
	public static final By graphdeletepopup = By.xpath("(//button[text()='Delete'])");
	public static final By saveas = By.xpath("//div[text()=' Save Graph ']");
	
	public static final By graphlastmodified = By.xpath("(//table/tbody//tr//td)[4]");
	public static final By sinceLastMonth = By.cssSelector("div.mmd-current-price-holder span.mmd-price-change:first-of-type");
	public static final By sinceLastYear = By.cssSelector("div.mmd-current-price-holder span.mmd-price-change:last-of-type");

	// Since Last Month & Since Last Year - Price Trend metric locators
	public static final By lastMetricContainer = By.cssSelector("div.mmd-last-metric");
	public static final By lastMetricGreenSpan = By.cssSelector("span.mmd-last-metric-green");
	public static final By lastMetricRedSpan = By.cssSelector("span.mmd-last-metric-red");
	public static final By arrowDown = By.cssSelector("i.fa.fa-arrow-down");
	public static final By arrowUp = By.cssSelector("i.fa.fa-arrow-up");
	
	// MMD Current Price and Download locators
	public static final By mmdCurrentPrice = By.cssSelector("div.mmd-current-price");
	public static final By mmdDownloadButton = By.cssSelector("button.mmd-select.mmd-select-label-only");
	public static final By mmdPriceTrendOption = By.xpath("//div[text()=' Price Trend ']");
	public static final By mmdExcelRadioButton = By.cssSelector("label[for='mmd-price-dl-2']");
	public static final By mmdPptRadioButton = By.cssSelector("label[for='mmd-price-dl-0']");
	public static final By mmdModalDownloadButton = By.cssSelector("div.mmd-modal-bk button.mmd-button");
	
	// Period, labels and graph locators
	public static final By mmdPeriodLabel = By.cssSelector("div.mmd-current-price-holder div[style*='margin-left'] span");
	public static final By mmdGraphSvg = By.cssSelector("div.chart-container");
	public static final By mmdCurrentPriceHolder = By.cssSelector("div.mmd-current-price-holder");
	
	public static final By aminoacid = By.xpath("//div[@title='Amino Acids']");
	public static final By fattyAcids = By.xpath("//div[@title='Fatty Acids']");
	public static final By noDataPanel = By.cssSelector("div.mmd-no-data-panel");
	public static final By noDataText = By.cssSelector("div.mmd-no-data-text");
	public static final By airlines = By.xpath("//div[@title='Airlines']");

	// Cost Structure Hover locators
	public static final By costStructureSection = By.cssSelector("div.mmd-section#mmd-cost-structure");
	public static final By costStructureChartContainer = By.cssSelector("div.mmd-section#mmd-cost-structure div[style*='width: 310px'][style*='height: 310px']");
	public static final By costStructureLegendPanel = By.cssSelector("div.mmd-flex.mmd-cs-legend-panel");
	public static final By costStructureLegendGroup = By.cssSelector("div.mmd-cs-legend-group");
	public static final By costStructureColorDot = By.cssSelector("div.mmd-cost-comp-symb-alt");
	public static final By costStructureLegendLabel = By.cssSelector("div.mmd-cost-legend.mmd-flex-1");
	public static final By costStructureLegendValue = By.cssSelector("div.mmd-cost-legend[style*='min-width']");
	public static final By costStructureTable = By.cssSelector("table.mmd-cs-table");
	public static final By costStructureTableRows = By.cssSelector("table.mmd-cs-table tbody tr");
	public static final By costStructureTableFirstCell = By.cssSelector("table.mmd-cs-table tbody tr:first-child td:nth-child(2)");
	public static final By costStructureYearDropdown = By.cssSelector("div.mmd-section#mmd-cost-structure div.mmd-select-outer div.mmd-select span");
	public static final By costStructureChartPaths = By.cssSelector("div.mmd-section#mmd-cost-structure div[style*='width: 310px'] svg path");

	// Accuracy and Guidance hover locators (price trend section)
	public static final By accuracyInfoIcon = By.cssSelector("span.mmd-accuracy, [class*='accuracy'], span[data-type='accuracy']");
	public static final By guidanceInfoIcon = By.cssSelector("span.mmd-guidance, [class*='guidance'], span[data-type='guidance']");
	public static final By mmdHoverTooltip = By.cssSelector("div[class*='mmd-tooltip'][class*='show'], div.mmd-tooltip.mmd-tooltip-show");

	// Price Trend Hover locators
	public static final By priceTrendSection = By.cssSelector("div.mmd-section#mmd-price-trend");
	public static final By priceTrendCurrencyDropdown = By.cssSelector("div.mmd-select-outer.mmd-select-alternate div.mmd-select");
	public static final By priceTrendCurrencyOptions = By.cssSelector("div.mmd-select-outer.mmd-select-alternate div.mmd-select-dropdown div");
	public static final By priceTrendChartContainer = By.cssSelector("div.chart-container");
	public static final By priceTrendRedLine = By.cssSelector("div.chart-container svg rule line, div.chart-container svg line[stroke='red']");
	public static final By priceTrendCurrentPriceHolder = By.cssSelector("div.mmd-current-price-holder");

	// Market Analysis section locators (shadow DOM)
	public static final By mmdMarketAnalysisSection = By.cssSelector("div.mmd-section#mmd-market-analysis");
	public static final By mmdExpandMarketCommentary = By.cssSelector("a.mmd-cards-collapse");

	// ABI chat icon locator (main DOM)
	public static final By abiIcon = By.cssSelector("div.chatIcon");

	// MMD Custom Range locators
	public static final By mmdDefaultDropdown = By.cssSelector("div.mmd-section#mmd-price-trend div.mmd-date-picker");
	public static final By mmdCustomRangePanel = By.cssSelector("div.mmd-section#mmd-price-trend div.mmd-date-picker.mmd-date-picker-custom");
	public static final By mmdSetCustomRange = By.xpath("//div[text()='Set Custom Range']");
	public static final By mmdCustomRangeApply = By.xpath("//button[text()='Apply']");
	public static final By mmdCustomRangeCancel = By.xpath("//button[text()='Cancel']");
	public static final By mmdCalendarLeftMonthDropdown = By.xpath("(//div[contains(@class,'calendar')]//select | (//div[contains(@class,'datepicker')]//select))[1]");
	public static final By mmdCalendarLeftYearDropdown = By.xpath("(//div[contains(@class,'calendar')]//select | (//div[contains(@class,'datepicker')]//select))[2]");

	// MI Report SSO User Test locators
	public static final By reportFirstLink = By.xpath("(//table[contains(@class,'primary-table')]//tbody//tr[1]//td[1]//button)[1]");
	public static final By reportViewerCloseBtn = By.xpath("//img[@alt='closeIcon'] | //button[@aria-label='Close'] | //button[contains(@class,'close-btn')]");
	public static final By reportViewerIframe = By.id("reportsIframe");
	public static final By signOut = By.xpath("//div[normalize-space(text())='Sign out']");
	public static final By signInWithSSO = By.xpath("//button[contains(text(),'Sign in with SSO')]");
	// JumpCloud SSO locators
	public static final By jumpCloudEmailField = By.xpath("//input[@placeholder='User Email Address' or @type='email' or @id='email']");
	public static final By jumpCloudContinueBtn = By.cssSelector("button[data-automation='loginButton'], button[type='submit']");
	public static final By jumpCloudPasswordField = By.xpath("//input[@type='password' or @placeholder='Password']");
	public static final By jumpCloudSSOLoginBtn = By.cssSelector("button[data-automation='loginButton'], button[type='submit']");
}