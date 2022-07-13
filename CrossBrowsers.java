package TestNG_Package.TestNG_Project;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class CrossBrowsers {
	WebDriver driver;
	
  @Test
  public void openUrl() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  @BeforeMethod
 @Parameters("browser")//({"browser","foxbrowser"})
  public WebDriver browserSetup(String browser) throws Exception {
	 	  
	  if(browser.equalsIgnoreCase("ie"))
		{
		    //create IE instance
			System.setProperty("webdriver.ie.driver","C:\\Users\\admin\\Downloads\\New folder\\IEDriverServer_Win32_4.0.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
		
		//Verify if parameter passed from TestNG is Chrome
		else if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\New folder\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver","C:\\Users\\admin\\Downloads\\New folder\\geckodriver-v0.30.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else
		{
			//If no browser passed throw exception
			throw new Exception("No browser specified");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
  @AfterMethod
  public void teardown()
  {
	  driver.close();
  }
  }


