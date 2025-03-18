package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{

	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email_field;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement passwordfield;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement loginbutton;
	
	public void setemail(String email)
	{
		email_field.sendKeys(email);
	}
	
	public void setpassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void clicklogin()
	{
		loginbutton.click();
	}
}
