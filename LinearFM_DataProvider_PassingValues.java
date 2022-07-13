package TestNG_Package.TestNG_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

public class LinearFM_DataProvider_PassingValues {
	WebDriver driver;
	
  @Test(dataProvider = "getdata")
  public void login(String ID, String PW) {
	  
	  driver.findElement(By.id("txtUsername")).sendKeys(ID);
		driver.findElement(By.id("txtPassword")).sendKeys(PW);
		driver.findElement(By.id("btnLogin")).click();
  }
  
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\New folder\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Thread.sleep(2000);
	  System.out.println("B4 Method");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider(name="getdata")
  public Object[][] getdata() {
    return new Object[][] { { "Admin", "admin123" },{ "shanthi", "shanthi1234" },{" "," "} };
  }
 

}
