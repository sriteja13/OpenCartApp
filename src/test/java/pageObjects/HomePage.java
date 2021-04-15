package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
   WebDriver driver;
   public HomePage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath="//span[contains(text(),'My Account')]")
   WebElement lnkMyaccount;
   
   @FindBy(xpath="//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
   WebElement lnkRegister;
   
   @FindBy(linkText="Login")
   WebElement lnkLogin;
   
  public void clickMyAccount()
  {
	  lnkMyaccount.click();
  }
   public void clickRegister()
   {
	   lnkRegister.click();
   }
   public void clickLogin()
   {
	   lnkLogin.click();
   }
}
