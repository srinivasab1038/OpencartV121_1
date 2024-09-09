package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	 
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		try
		{
		logger.info("Starting TC001_AccountRegistrationTest");
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on Register link");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details..");
		regpage.enterFirstname(randomString().toUpperCase());
		regpage.enterLastName(randomString().toUpperCase());
		regpage.enterEmail(randomString()+"@gmail.com");
		
		regpage.enterTelephone(randomNumber());
		
		String password = randomAlpanumeric();
		
		regpage.enterPassword(password);
		regpage.enterConfirmpassword(password);
		regpage.tickPrivacypolicy();
		regpage.clickContinue();
		
		
		logger.info("Validating expected message");
		String actualconfmsg=regpage.getConfirmationmsg();
		if(actualconfmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			logger.info("Validation is success");
		}
		else
		{
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(actualconfmsg,"Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("End of TC001_AccountRegistrationTest");
	}

}
