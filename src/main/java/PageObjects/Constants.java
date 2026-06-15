package PageObjects;

import org.openqa.selenium.WebDriver;

public class Constants {
	
	public final String STG_Url = "https://staging.beroelive.ai/login";
	
	public final String Op_Url = "https://stage-ops-support.beroelive.ai/signin";
	
	public static String firsttile = "Review latest trends for my categories";
	public static String secondtile = "Track risk across my suppliers";
	public static String thirdtile = "Monitor inflation across my portfolio";
	public static String fourthtile = "Find a new or alternate supplier";
	
	public static String toggletext = "Build/View your Benchmark";
	
	static WebDriver driver;
	
	public Constants(WebDriver driver) 
	{
		Constants.driver = driver;
	}

}
