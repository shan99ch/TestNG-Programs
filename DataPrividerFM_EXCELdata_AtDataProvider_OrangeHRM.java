package TestNG_Package.TestNG_Project;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.format.CellFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class DataPrividerFM_EXCELdata_AtDataProvider_OrangeHRM {
	
	WebDriver driver;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	File f= new File("C:\\home\\AST\\data.xlsx");
	
	DataFormatter formatter= new DataFormatter();
	
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
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }


  @DataProvider(name="getdata")
  public Object[][] getdata() throws IOException {
	  
	  fis = new FileInputStream(f);
	  workbook = new XSSFWorkbook(fis);
	  sheet = workbook.getSheetAt(0);
	  Row row1 = sheet.getRow(0);
	  
	  int RowNum = sheet.getPhysicalNumberOfRows();
  	  int ColNum= row1.getLastCellNum(); 
  	
  	Object Data[][]= new Object[RowNum-1][ColNum]; 
  	
   for(int i=0; i<RowNum-1; i++) 
   {  
   Row row= sheet.getRow(i+1);
   
   for (int j=0; j<ColNum; j++) 
   {
   if(row==null)
   Data[i][j]= "";
   else 
   {
   Cell cell= row.getCell(j);
   if(cell==null)
   Data[i][j]= "";                                                                                           //if it get Null value it pass no data 
   else
   {
   String value=formatter.formatCellValue(cell);
   Data[i][j]=value;                                                           //This formatter get my all values as string i.e integer, float all type data value
   }
   }
   }
   }

  	return Data;
  }
}
