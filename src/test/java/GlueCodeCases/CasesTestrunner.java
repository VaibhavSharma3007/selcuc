package GlueCodeCases;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import PageFactory.Caseslinks;
import PageFactory.ForgotPassword;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CasesTestrunner {
	public static WebDriver driver;
	ForgotPassword fp;
	Caseslinks cl;
	JavascriptExecutor js;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "C:\\grid\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor)driver;
        fp = new ForgotPassword(driver);
        cl=new Caseslinks(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://classic.freecrm.com/index.html");
	    
	}

	@When("^user enters valid username and valid password$")
	public void user_enters_valid_username_and_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		fp.entername("VaibhavSharma");
        fp.enterpassword("Nakshyash");
        fp.clickonsubmit();
        driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
        
	   
	}

	@Then("^success message is displayed$")
	public void success_message_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		if(driver.getTitle().contains("CRMPRO")){
  		  System.out.println("Valid login credentials");
  		 
  		  //driver.close();
  	  
  	  }
  	  else{
  		  System.out.println("invalid login credentials");
  		
  		  //driver.close(); 
  		  } 
	    
	}



	@Given("^user is on home page after login$")
	public void user_is_on_home_page_after_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		//driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[2]")));
		
		
		
		System.out.println(driver.getTitle());
	    
	}

	@When("^user clicks on new cases$")
	public void user_clicks_on_new_cases() throws Throwable {
	    // Write code here that turns the phrase above into concrete action
		js = (JavascriptExecutor)driver;
		js.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(1) > a\").click()");
	    
	}

	@Given("^user is on add cases page$")
	public void user_is_on_add_cases_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(driver.getTitle());
	}

	@Given("^user enter title$")
	public void user_enter_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cl.entertitle("new");
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	   cl.clickonsave();
	}

	@Then("^data is saved$")
	public void data_is_saved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}



	@Given("^user enter null details in title$")
	public void user_enter_null_details_in_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(1) > a\").click()");
		cl.entertitle("");
	    
	}

	@Then("^alert box is shown$")
	public void alert_box_is_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().alert().accept();
	}


	@When("^user clicks on full search form button$")
	public void user_clicks_on_full_search_form_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		js.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(2) > a\").click()");
	}

	@Given("^user is on search cases page$")
	public void user_is_on_search_cases_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^user enter valid title$")
	public void user_enter_valid_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		cl.entersearchtitle("new");
	}

	@When("^user clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    cl.clickonsearch();
	}

	@Then("^search data is saved$")
	public void search_data_is_saved() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        System.out.println("Data found");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^user enter invalid title$")
	public void user_enter_invalid_title() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("document.querySelector(\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(2) > a\").click()");
		cl.entersearchtitle("old");
	}

	@Then("^no data is shown$")
	public void no_data_is_shown() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("No data found");
	    driver.quit();
	    
	}
	
	@Before
	public void beforeclass() {
		js = (JavascriptExecutor)driver;
        fp = new ForgotPassword(driver);
        cl=new Caseslinks(driver);
	}




}

