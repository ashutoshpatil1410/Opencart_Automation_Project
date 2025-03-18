package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testbase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups = {"regression","sanity","master"})
	public void verifymyaccountpagedisplayed()
	{
		try 
		{
			log.info("**HomePage Started**");
			HomePage hp=new HomePage(driver);
			hp.clickmyaccount();
			hp.clicklogin();
			
			log.info("**LoginPage Started**");
			LoginPage lp=new LoginPage(driver);
			lp.setemail(p.getProperty("email"));
			lp.setpassword(p.getProperty("password"));
			lp.clicklogin();
			
			log.info("**MyaccountPage Started**");
			MyAccountPage mp=new MyAccountPage(driver);
			boolean status=mp.ismyaccountdisplayed();
			Assert.assertTrue(status);//Assert.asserEquals(status,true,"Test Failed")
		} catch (Exception e) 
		{
			Assert.fail();
		}
		
	}
	
}
