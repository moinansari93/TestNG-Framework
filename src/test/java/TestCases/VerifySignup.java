package TestCases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import pageObjectModel.LoginPagePage_objects;
import pageObjectModel.SignUpPageObjects;
import resources.BaseClass;
import resources.Constants;

public class VerifySignup extends BaseClass{
	@Test
	public void signUp() throws IOException, InterruptedException {
		
		driver=driverInitialization();
		Thread.sleep(5000);
		//driver.get(prop.getProperty("url2"));
		
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().window().maximize();
		
		LoginPagePage_objects lp=new LoginPagePage_objects(driver);
		lp.tryForfree().click();
		
		SignUpPageObjects sp=new SignUpPageObjects(driver);
		Thread.sleep(2000);
		sp.enterFirstname().sendKeys(Constants.firstname);
		
		Select s=new Select(sp.selectJobTitle());
		s.selectByIndex(1);
		
		
		
	}

}
