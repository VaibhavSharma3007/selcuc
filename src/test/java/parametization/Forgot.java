package parametization;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forgot {
	public static WebDriver driver;

    @Test
    public void para() throws IOException  {


        FileInputStream fs = new FileInputStream(new File("C:\\grid\\data.xlsx"));
        //create workbook
        @SuppressWarnings("resource")
		XSSFWorkbook wb = new XSSFWorkbook(fs);
        //access worksheet
        XSSFSheet sh = wb.getSheetAt(0);
        int lastrow = sh.getLastRowNum();
        System.out.println("last row used is :" + lastrow);
        for (int i = 1; i <= lastrow; i++) {

            String un = sh.getRow(i).getCell(0).toString();
            
            driver.get("https://classic.freecrm.com/login.cfm?pr=1");

            driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[1]")).sendKeys(un);
        
            

            }
    }
            




    @BeforeClass
    public static void beforetest() {
    	System.out.println("12");
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
