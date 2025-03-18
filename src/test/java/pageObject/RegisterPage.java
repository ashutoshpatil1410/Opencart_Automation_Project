package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage
{

	//WebDriver driver;
	//constructor
	public RegisterPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstnamefield;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastnamefield;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailfield;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement telephonefield;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confirmpasswordfield;
	
	@FindBy(xpath = "//input[@type='checkbox' or @name='agree']")
	WebElement agreeconditionscheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebtn;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement confirmmessage;
	
	//Action methods
	public void setfirstname(String fname)
	{
		firstnamefield.sendKeys(fname);
	}
	
	public void setlastname(String lname)
	{
		lastnamefield.sendKeys(lname);
	}
	
	public void setemail(String email)
	{
		emailfield.sendKeys(email);
	}
	
	public void settelephone(String telephone)
	{
		telephonefield.sendKeys(telephone);
	}
	
	public void setpassword(String password)
	{
		passwordfield.sendKeys(password);
	}
	
	public void setconfirmpassword(String confirmpassword)
	{
		confirmpasswordfield.sendKeys(confirmpassword);
	}
	
	public void clickagreecheckbox()
	{
		agreeconditionscheckbox.click();
	}
	
	public void clickcontinuebutton()
	{
		continuebtn.click();
	}
	
	public String confirmmessage()
	{
		try {return (confirmmessage.getText());}
		catch (Exception e) {
			return (e.getMessage());
		}
		
	}
	
	
	
}
