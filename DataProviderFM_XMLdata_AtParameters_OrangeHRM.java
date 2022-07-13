package TestNG_Package.TestNG_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class DataProviderFM_XMLdata_AtParameters_OrangeHRM {
	WebDriver driver;
  @Test(priority=1,enabled = false) 
  public void inValid() {
	  
	  driver.findElement(By.id("txtUsername")).sendKeys( "Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin124");
		driver.findElement(By.id("btnLogin")).click();
  }
  @Test
  @Parameters({"username","Password"})  //passing values from xml file
  public void valid(String username, String Password) {
	  driver.findElement(By.id("txtUsername")).sendKeys( username);
	  driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElement(By.id("btnLogin")).click();
  }
  @Test(priority=2,enabled=false)
  public void nullValue() {
	  driver.findElement(By.id("txtUsername")).sendKeys( " ");
	  driver.findElement(By.id("txtPassword")).sendKeys(" ");
		driver.findElement(By.id("btnLogin")).click();
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\New folder\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Thread.sleep(2000);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

 /* @BeforeClass
  public void beforeClass() throws IOException {
	  File f = new File("C:\\home\\AST\\data.xlsx");
	  FileInputStream fis = new FileInputStream(f);
	  XSSFWorkbook workbook = new XSSFWorkbook(fis);
	  XSSFSheet sheet =workbook.getSheetAt(0);
  }*/

}
