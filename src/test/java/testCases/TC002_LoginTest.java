package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login()
	{
		logger.info("Start of TC002_LoginTest...");
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on MyAccount link");
		hp.clickLogin();
		logger.info("clicked on Login link");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("Provided email and password and clicked on Login button");
		
		
		//MyAccount  page
		MyAccountPage macc=new MyAccountPage(driver);
		Boolean targetpage=macc.ismsgMyAccountExists();
		
		//Assert.assertEquals(targetpage,true,"Login Failed..");
		Assert.assertTrue(targetpage);
		logger.info("Logged into MyAccount page");
		}
		catch(Exception e)
		{
			Assert.fail();
			logger.info("NOT Logged into MyAccount page");
		}
		
		logger.info("End of TC002_LoginTest...");
	}
	
}
