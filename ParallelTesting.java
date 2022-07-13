package TestNG_Package.TestNG_Project;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class ParallelTesting {
 @Test
  public void parellelOnChrome() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\New folder\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		System.out.println("chrome");
		driver.close();
	  
  }
  @Test
  public void parellelOnFirefox() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\Downloads\\New folder\\geckodriver-v0.30.0-win64\\geckodriver.exe");
	  WebDriver driver1 = new FirefoxDriver();
	  driver1.manage().window().maximize();
	  driver1.get("https://opensource-demo.orangehrmlive.com/");
	  driver1.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver1.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver1.findElement(By.id("btnLogin")).click();
		System.out.println("Firefox");
		driver1.close();
	  
  }
  @AfterClass
  public void tearDown() {
  }
//driver.close();
}
