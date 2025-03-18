package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage 
{
	public MyAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myaccounttext;
	
	@FindBy(xpath = "//a[text()='Logout' and @class='list-group-item']")
	WebElement logout;
	
	public boolean ismyaccountdisplayed()
	{
		try {
			return (myaccounttext.isDisplayed());
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public void logout()
	{
		logout.click();
	}
}
