package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass 
{
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "datadriven")
	public void verify_loginDDT(String email,String pwd,String exp) throws InterruptedException
	{
		try 
		{
		log.info("***TC_003_LoginDDT Started***");
		HomePage hp=new HomePage(driver);
		hp.clickmyaccount();
		hp.clicklogin();
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clicklogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
		boolean status=mp.ismyaccountdisplayed();
		
		/*Data is valid - login - success test pass - logout

							login failed - test fail

		Data is invalid - login success - test fail - logout

		                   login failed test pass
		*/ 
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{
				mp.logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(status==true)
			{
				mp.logout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch (Exception e) {
			Assert.fail();
		}
		log.info("***TC_003_LoginDDT Finished***");
		Thread.sleep(3000);
	}
}
