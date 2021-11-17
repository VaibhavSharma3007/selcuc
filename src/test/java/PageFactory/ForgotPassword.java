package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	WebDriver driver;
    @FindBy(xpath="/html/body/section[5]/div/div/div[1]/p[4]/a")
    WebElement fpbutton;
    @FindBy(xpath="/html/body/div[2]/div/div/form/input[1]")
    WebElement entry;
    @FindBy(xpath="/html/body/div[2]/div/div[3]/form/div/input[1]")
    WebElement id;
    @FindBy(xpath="/html/body/div[2]/div/div[3]/form/div/input[2]")
    WebElement pass;
    @FindBy(xpath="/html/body/div[2]/div/div[3]/form/div/div/input")
    WebElement sub;
    public void clickonforgotpassword(){
       // entry.sendKeys(fp1);
        fpbutton.click();
    }
    public void enterusername(String e1) {

        entry.sendKeys(e1);
    }
    public void entername(String u1){

        id.sendKeys(u1);
    }
    public void enterpassword(String p1){

        pass.sendKeys(p1);
    }
    public void clickonsubmit(){

        sub.click();
    }
    public ForgotPassword(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);


    }

}
