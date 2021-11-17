package parametrization1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static WebDriver driver;

    @Test
    public void para() throws IOException  {


        FileInputStream fs = new FileInputStream(new File("C:\\grid\\data1.xlsx"));
        //create workbook
        @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fs);
        //access worksheet
        XSSFSheet sh = wb.getSheetAt(0);
 
        
        int lastrow = sh.getLastRowNum();
        System.out.println("last row used is :" + lastrow);
        for (int i = 1; i <= lastrow; i++) {

            
            
            
            
            driver.get("https://classic.crmpro.com/index.html");
            String un = sh.getRow(i).getCell(0).toString();
             
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[1]")).sendKeys(un);
            String mn = sh.getRow(i).getCell(1).toString();
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[2]")).sendKeys(mn);
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
            
            if(driver.getTitle().contains("CRMPRO")){
      		  System.out.println("Valid login credentials");
      		// driver.manage().deleteAllCookies(); 
      		  //driver.close();
      	  
      	  }
      	  else{
      		  System.out.println("invalid login credentials");
      		
      		  //driver.close(); 
      		  } 
        }
    }
    
        




    @BeforeClass
    public static void beforetest() {
        System.setProperty("webdriver.chrome.driver", "C:\\grid\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void aftertest() {
        driver.quit();
    }
}

