package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{ 
	
    @Test(groups= {"regression","master"})
    public void test_account_Registration()
    {   
    	try
    	{
    	
        logger.info("Starting TC_001_AccountRegistration");
    	
    	driver.get(rb.getString("appUrl"));
    	driver.manage().window().maximize();
    	
    	HomePage hp=new HomePage(driver);
    	hp.clickMyAccount();
    	logger.info("Clicked Myaccount");
    	hp.clickRegister();
    	logger.info("clicked on registration");
    	
    	AccountRegistrationPage rp=new AccountRegistrationPage(driver);
    	rp.setFirstName("abc");
    	logger.info("Provided the first name");
    	rp.setLastName("xyz");
    	logger.info("Provided the last name");
    	rp.setEmail(randomString()+"@gmail.com");
    	logger.info("Provided the gmail");
    	rp.setTelephone(randomNum());
    	logger.info("Provided the phone number");
    	rp.setPassword("abcxyz");
    	logger.info("Provided the password");
    	rp.setConfirmPassword("abcxyz");
    	logger.info("Provided the confirmation password");
    	rp.setPrivacyPolicy();
    	logger.info("Accept the privacy policy");
    	rp.clickContinue();
    	logger.info("clicked on continue button to get the confiramtion msg");
    	
    	String confmsg=rp.getConfirmationMsg();
    	
    	if(confmsg.equals("Your Account Has Been Created!"))
    	{ 
    		logger.info("Account registration passed");
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		logger.info("Account registration failed");
    		captureScreen(driver, "test_accout_Registration");
    		
    		Assert.assertTrue(false);
    	}
    
    }
    	
    	catch(Exception e)
    	{
    		logger.fatal("Account registration failed");
    		Assert.fail();
    	}
    	
    	logger.info("Finished  TC_001_AccountRegistration");
    	
    }
    
   
}
