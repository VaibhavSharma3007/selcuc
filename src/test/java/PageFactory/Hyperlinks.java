package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Hyperlinks {
	WebDriver driver;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[2]/a")
    WebElement su;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[3]/a")
    WebElement pg;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[4]/a")
    WebElement fs;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[5]/a")
    WebElement cs;
    @FindBy(xpath="/html/body/div[2]/div/div[2]/ul/li[6]/a")
    WebElement ct;
    public void clickonsignup(){
        su.click();
    }
    public void clickonpricing(){
        pg.click();

    }
    public void clickonfeatures(){
        fs.click();
    }
    public void clickoncustomers(){
        cs.click();
    }
    public void clickoncontent(){
        ct.click();
    }
    public Hyperlinks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }
}

