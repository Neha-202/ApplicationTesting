package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Testdata;

public class Home {


WebDriver driver;
public Home (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//input[@type='text']")
WebElement srch_butn;
@FindBy(xpath="//span[text()='Account']")
WebElement name;
@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button")
WebElement butn_click;

public void Clicksearch(String product) {
	srch_butn.sendKeys(product);
butn_click.click();
}

public String getPagename() {
	try {
		return name.getText();
		
	}
	catch(Exception e) {
	
	return (e.getMessage());}
	
}

	
}
















	

	
	
	
	












