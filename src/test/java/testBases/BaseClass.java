package testBases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
  public WebDriver driver;
  public Logger logger;
  public ResourceBundle rb;
	@BeforeClass(groups= {"regression","sanity","master"})
	@Parameters({"Browser"})
	public void setUP(String br)
	{    
		 logger=LogManager.getLogger(this.getClass());
		 rb=ResourceBundle.getBundle("config");
		 if(br.equals("Chrome"))
		 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 logger.info("Chrome Browser lunched");
	     }
		 else if(br.equals("Edge"))
		 {
			 WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
			 logger.info("Edge Browser lunched");
		 }
		 else if(br.equals("Firefox"))
		 {
			 WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 logger.info("Firefox Browser lunched");
		 }
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	 @AfterClass(groups= {"regression","sanity","master"})
	    public void tearDown()
	    {
	    	driver.close();
	    }
	    
	    public String randomString()
	    {
	    	String random=RandomStringUtils.randomAlphabetic(5);
	    	return(random);
	    }
	    
	    public String randomNum()
	    {
	    	String random=RandomStringUtils.randomNumeric(10);
	    	return(random);
	    }
	    
	    public void captureScreen(WebDriver driver, String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File( ".\\screenshots\\" + tname + ".png");
			FileUtils.copyFile(source, target);
		}
	    

}
