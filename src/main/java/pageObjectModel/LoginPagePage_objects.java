package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPagePage_objects {
	public WebDriver driver;
	private By username=By.xpath("//input[@id='username']");
	private By password=By.xpath("//input[@id='password']");
	private By logIn=By.xpath("//input[@id='Login']");
	private By tryFree=By.xpath("//a[@id='signup_link']");
	
	public LoginPagePage_objects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement enterUsername() {
		
		return driver.findElement(username);
	
		
	}
	
    public WebElement enterPassword() {
		
		return driver.findElement(password);
	
}
   public WebElement clickOnlogin() {
	
	return driver.findElement(logIn);
}
   public WebElement tryForfree() {
		
		return driver.findElement(tryFree);
}
}