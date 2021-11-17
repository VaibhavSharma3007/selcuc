package GlueCodeHome;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.functions.Hyperlink;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import PageFactory.Hyperlinks;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomeTestrunner {
	public static WebDriver driver;
    Hyperlinks hl;

    @Given("^user is on home page$")
    public void user_is_on_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "C:\\grid\\chromedriver.exe");
        driver = new ChromeDriver();
        hl = new Hyperlinks(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://classic.freecrm.com/index.html");
    }

    @When("^user clicks on sign up$")
    public void user_clicks_on_sign_up() {
        // Write code here that turns the phrase above into concrete actions
        hl.clickonsignup();
    }

    @Then("^sign up page is displayed$")
    public void sign_up_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement signup = driver.findElement(By.xpath("/html/body/section[1]/div[1]/form/div[1]/div"));
        assertTrue(signup.getText().contains("Select edition above"));
        driver.quit();
    }



    @When("^user clicks on pricing$")
    public void user_clicks_on_pricing() {
        // Write code here that turns the phrase above into concrete actions
        hl.clickonpricing();


    }

    @Then("^pricing page is displayed$")
    public void pricing_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement pricing = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[1]/h1"));
        assertTrue(pricing.getText().contains("Free OR $25"));
        driver.quit();

    }

    @When("^user clicks on features$")
    public void user_clicks_on_features() {
        // Write code here that turns the phrase above into concrete actions
        hl.clickonfeatures();

    }

    @Then("^features page is displayed$")
    public void features_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement features = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/h1"));
        assertTrue(features.getText().contains("The Professional CRM Solution"));
        driver.quit();
    }

    @When("^user clicks on customer$")
    public void user_clicks_on_customer() {
        // Write code here that turns the phrase above into concrete actions
        hl.clickoncustomers();
    }

    @Then("^customer page is displayed$")
    public void customer_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement customers = driver.findElement(By.xpath("/html/body/section[1]/div/div/div[1]/p"));
        assertTrue(customers.getText().contains(" Our job is to keep your data safe and available to you anytime and we've been doing that for over 10 years"));
        driver.quit();
    }

    @When("^user clicks on contact$")
    public void user_clicks_on_contact() {
        // Write code here that turns the phrase above into concrete actions
        hl.clickoncontent();
    }

    @Then("^contact page is displayed$")
    public void contact_page_is_displayed() {
        // Write code here that turns the phrase above into concrete actions
        WebElement content = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div/h1"));
        assertTrue(content.getText().contains("Contact us"));
        driver.quit();
    }


}
