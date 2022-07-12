package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver driverInitialization() throws IOException {
	
	//to read the file
	
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
	
//to access the data.properties
    prop=new Properties();
	prop.load(fis);
	
	String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromiumdriver().setup();
	    driver = new ChromeDriver();
		
	}
	else if(browserName.equalsIgnoreCase("firefox")) {
		//firefox code
	}
	else if(browserName.equalsIgnoreCase("edge")) {
		// edge code
		
	}
	else {
		System.out.println("please enter valid browser name");
		
	}
	return driver;
	}
	
   @BeforeMethod
   public void browserLaunch() throws IOException {
	   driver=driverInitialization();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	
	
}
   @AfterMethod
   public void closeBrowser() throws IOException {
	    driver.quit();
   }}

