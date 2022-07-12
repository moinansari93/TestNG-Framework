package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjectModel.LoginPagePage_objects;
import resources.BaseClass;
import resources.Constants;

public class verifyLoginPage extends BaseClass {
	
	@Test(dataProvider="testData")
	public void logInVerification(String username, String password) throws IOException, InterruptedException {
	
	
	LoginPagePage_objects Lp=new LoginPagePage_objects(driver);
	Lp.enterUsername().sendKeys(username);
	Lp.enterPassword().sendKeys(password);
	Lp.clickOnlogin().click();
	
	Thread.sleep(5000);
	
	String actualText=driver.findElement(By.xpath("//div[@id='error']")).getText();
	String expectedText="Plea check your username and password. If you still can't log in, contact your Salesforce administrator.";
	
		Assert.assertEquals(actualText, expectedText);
	}



@DataProvider
public Object[][] testData(){
	Object[][]data=new Object[2][2];
	data[0][0]=Constants.username1;
	data[0][1]=Constants.password1;
	data[1][0]=Constants.username2;
	data[1][1]=Constants.password2;
	return data;
}
}
