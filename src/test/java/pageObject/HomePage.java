package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//WebDriver driver;
	//constructor
	public HomePage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myaccountbutton;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerbutton;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginlink;
	
	//actionmethods

	public void clickmyaccount()
	{
		myaccountbutton.click();
	}
	
	public void clickregister()
	{
		registerbutton.click();
	}
	
	public void clicklogin()
	{
		loginlink.click();
	}
	
}
