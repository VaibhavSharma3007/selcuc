package GlueCode;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.ForgotPassword;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TestLogin {
	public static WebDriver driver;
	ForgotPassword fp;
	
	
	@Given("^user is on login page$")
    public void user_is_on_login_page() {
        System.setProperty("webdriver.chrome.driver", "C:\\grid\\chromedriver.exe");
        driver = new ChromeDriver();
        fp = new ForgotPassword(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://classic.freecrm.com/index.html");
    }

    @When("^user  clicks on forgot password$")
    public void user_enters_username_and_password() {
        fp.clickonforgotpassword();


    }

    @Then("^reset password page is displayed$")
    public void success_message_is_displayed() {
        WebElement YourLogin = driver.findElement(By.xpath("/html/body/div[2]/div/div/form"));
        assertTrue(YourLogin.getText().contains("Enter your username or your email address:"));


    }


    @When("^user enter valid VaibhavSharma$")
    public void user_enter_valid_email_or_valid_VaibhavSharma() {
        fp.enterusername("VaibhavSharma");


    }

    @Then("^click on get password and it should accept the details and show success message$")
    public void click_on_get_password_and_it_should_accept_the_details_and_show_success_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        WebElement get = driver.findElement(By.id("message"));
        assertTrue(get.getText().contains("Your login detail have been sent to the email address on file."));
        driver.quit();
    }
    //scenario2


    @When("^user enter invalid username$")
    public void user_enters_invalid_email_or_invalid_username() {
        fp.enterusername("Vai");
    }

    @Then("^click on get password and it should not accept the details and show error message1$")
    public void click_on_get_password_it_should_not_accept_the_details_and_show_error_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        WebElement get1 = driver.findElement(By.id("message"));
        assertTrue(get1.getText().contains("We could not retrieve your login details. Please contact us at info@crmpro.com."));
        driver.quit();
    }


    @When("^user enter null username$")
    public void user_enters_null_values_in_email_or_username() {

        fp.enterusername(" ");
    }

    @Then("^click on get password and it should not accept the details and show error message2$")
    public void click_on_get_password_and_it_should_not_accept_the_details_and_show_error_message() {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/input[2]")).click();
        WebElement get2 = driver.findElement(By.id("message"));
        assertTrue(get2.getText().contains("We could not retrieve your login details. Please contact us at info@crmpro.com."));
        driver.quit();
    }

    @When("^user enters valid username and valid password$")
    public void user_enters_valid_username_and_valid_password() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://classic.freecrm.com/index.html");
        fp.entername("VaibhavSharma");
        fp.enterpassword("Nakshyash");
        fp.clickonsubmit();
    }

    @Then("^user is successfully logged in$")
    public void user_is_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
    	if(driver.getTitle().contains("CRMPRO")){
    		  System.out.println("Valid login credentials");
    		driver.manage().deleteAllCookies(); 
    		  //driver.close();
    	  
    	  }
    	  else{
    		  System.out.println("invalid login credentials");
    		
    		  //driver.close(); 
    		  } 

        driver.quit();

    }
}
