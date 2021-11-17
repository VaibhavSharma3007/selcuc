package PageFactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Caseslinks {
	WebDriver driver;
	JavascriptExecutor js;
	
	
	
	@FindBy(xpath="//*[@id=\"title\"]")
	WebElement title;
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input")
	WebElement save;
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[1]/td/input[1]")
	WebElement search;
	@FindBy(xpath="/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/fieldset/form/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input")
	WebElement searchtitle;
	public void entertitle(String s1) {
		title.sendKeys(s1);
	}
	public void clickonsave() {
		save.click();
	}
	public void clickonsearch() {
		search.click();
	}
	public void entersearchtitle(String s2) {
		searchtitle.sendKeys(s2);
	}
	
    public Caseslinks(WebDriver driver){
	        this.driver=driver;
	        js = (JavascriptExecutor)driver;
	        PageFactory.initElements(driver,this);


	    
	}

}

/*
 public void clickonnewcase() {
		js.executeScript("document.querySelector(\\\"#navmenu > ul > li:nth-child(7) > ul > li:nth-child(1) > a\\\").click()");
	} */
