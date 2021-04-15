package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistrationPage 
{
	 WebDriver driver;
	   public AccountRegistrationPage(WebDriver driver)
	   {
		   this.driver=driver;
		   PageFactory.initElements(driver, this);
	   }
     
	   @FindBy(xpath="//input[@id='input-firstname']")
	   WebElement txtFirstName;
	   
	   @FindBy(xpath="//input[@id='input-lastname']")
	   WebElement txtLastName;
	   
	   @FindBy(name="email")
	   WebElement txtEmail;
	  
	   @FindBy(xpath="//input[@id='input-telephone']")
	   WebElement txtTelephone;
	   
	   @FindBy(id="input-password")
	   WebElement txtpassword;
	   
	   @FindBy(name="confirm")
	   WebElement txtpwd;
	   
	   @FindBy(name="agree")
	   WebElement clickPlcy;
       
	   @FindBy(xpath="//input[@value='Continue']")
	   WebElement btnContinue;
	   
	   @FindBy(xpath="//div[@id='content']/h1")
	   WebElement  msgconfirmation;
	   
	   public void setFirstName(String fname)
	   {
		   txtFirstName.sendKeys(fname);
	   }
	   
	   public void setLastName(String lname)
	   {
		   txtLastName.sendKeys(lname);
	   }
	   
	   public void setEmail(String email)
	   {
		   txtEmail.sendKeys(email);
	   }
	   
	   public void setTelephone(String phn) 
	   {
		   txtTelephone.sendKeys(phn);
	   }
	   
	   public  void setPassword(String pwd) 
	   {
		   txtpassword.sendKeys(pwd);
	   }
	   
	   public  void setConfirmPassword(String cpwd) 
	   {
		   txtpwd.sendKeys(cpwd);
	   }
	   
	   public void setPrivacyPolicy()
	   {
		   clickPlcy.click();
	   }
	   
	   public void clickContinue()
	   {
		   btnContinue.click();
	   }
	   
	   public String getConfirmationMsg()
	   {
		   try
		   {
			  return( msgconfirmation.getText());
		   }
		   catch(Exception e)
		   {
			   return(e.getMessage());
		   }
	   }
}