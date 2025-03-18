package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegisterPage;
import testbase.BaseClass;


public class TC_001_Registration extends BaseClass
{	
	@Test(groups = {"sanity","regression","master"})
	void verifyregistration() throws InterruptedException
	{
		log.info("Test case 001 is Started");
		try { 
		
		HomePage hp=new HomePage(driver);
		log.info("Clicked on myaccount");
		hp.clickmyaccount();
		hp.clickregister();
		
		RegisterPage rp=new RegisterPage(driver);
		log.info("Registering the user");
		rp.setfirstname(randomstring().toUpperCase());
		rp.setlastname(randomstring().toUpperCase());
		rp.setemail(randomstring()+"@gmail.com");
		rp.settelephone(randomnumber());
		
		String password=randomalphanumeric();
		
		rp.setpassword(password);
		rp.setconfirmpassword(password);
		rp.clickagreecheckbox();
		rp.clickcontinuebutton();
		log.info("Clicked on continue button");
		
		String confmsg=rp.confirmmessage();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			log.error("Test Failed");
			log.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		log.info("Test 001 is finished");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
}
	
}
