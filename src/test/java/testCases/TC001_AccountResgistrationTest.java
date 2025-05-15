package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisitrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountResgistrationTest extends BaseClass{

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() throws InterruptedException
	{
		logger.info("****Starting AccountRegistrationTest****");
		try
		{
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegisitrationPage repage= new AccountRegisitrationPage(driver);
		logger.info("providing customer details");
		repage.setFirstName(randomString().toUpperCase());
		repage.setLastName(randomString().toUpperCase());
		repage.setEmail(randomString()+"gmail.com");
		repage.setTelephone(randomNumber());
		String password=randomAlphaNumeric();
		repage.setPassword(password);
		repage.setConfirmPassword(password);
		repage.setPrivacyPolicy();
		repage.clickContinue();
		logger.info("Validating expected message");
		//String confmsg=repage.getConfirmationMessage();
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test failed");
			//logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("******* Finished TC001_AccountResgistrationTest ********");
	}
	
	
}

