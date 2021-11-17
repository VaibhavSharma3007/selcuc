package parametrization2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageFactory.Caseslinks;
import PageFactory.ForgotPassword;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Cases {
	public static WebDriver driver;
	

    @Test
    public void para() throws IOException, InterruptedException  {


        FileInputStream fs = new FileInputStream(new File("C:\\grid\\data2.xlsx"));
        //create workbook
        @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fs);
        //access worksheet
        XSSFSheet sh = wb.getSheetAt(0);
 
        
        int lastrow = sh.getLastRowNum();
        System.out.println("last row used is :" + lastrow);
        
        	driver.get("https://classic.crmpro.com/index.html");
        	
        	driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[1]")).sendKeys("VaibhavSharma");
        	
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/input[2]")).sendKeys("Nakshyash");
            driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
            JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(1) > a\").click()");
			String un = sh.getRow(1).getCell(0).toString();
			driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input")).sendKeys(un);
			
			//String mn = sh.getRow(i).getCell(1).toString();
			driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[1]")).click();
			//driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
			/*JavascriptExecutor js1 = (JavascriptExecutor)driver;
			js1.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(2) > a\").click()");
			String mn = sh.getRow(i).getCell(1).toString();
			driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[1]")).sendKeys(mn);
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input")).click();
            */
            
            
             
            
            
       
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
    


public void Caseslinks(WebDriver driver){
    this.driver=driver;
    JavascriptExecutor js = (JavascriptExecutor)driver;
    PageFactory.initElements(driver,this);



}
}


