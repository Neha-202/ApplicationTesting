package pages;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Testdata;

public class Product extends Home {

	public Product(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//span[text()='Account']")
	WebElement name;
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/header/div[1]/div[2]/form/div/button")
	WebElement butn_click;
	@FindBy(xpath="//div[normalize-space()='Discount']")
	WebElement filter_btn;
	@FindBy(xpath="(//div[@class='zg-M3Z'])[1]")
	WebElement Sort_bypopularity;
	@FindBy(xpath="//div[normalize-space()='Price -- Low to High']")
	WebElement Sort_byprice;
	@FindBy(xpath="//div[normalize-space()='Newest First']")
	WebElement Sort_bynew;
	@FindBy(xpath="(//div[@class='wvIX4U'])[1]")
	WebElement selproduct;
	
public void filterByDiscount() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js = (JavascriptExecutor) driver;

    // Open filter dropdown
    wait.until(ExpectedConditions.elementToBeClickable(filter_btn)).click();

    // Find all visible discount options
    List<WebElement> discountOptions = wait.until(
        ExpectedConditions.presenceOfAllElementsLocatedBy(
            By.xpath("//div[contains(text(),'%') or contains(text(),'Buy')]")
        )
    );

    // Pick one randomly using utility
    WebElement selected = Testdata.pickRandomOption(discountOptions);
    if (selected != null) {
        js.executeScript("arguments[0].scrollIntoView(true);", selected);
        js.executeScript("arguments[0].click();", selected);
    }
}
public void sortbypopularity() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Sort_bypopularity);}
	
public void sortbyprice() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Sort_byprice);}
	
public void sortbynew() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", Sort_bynew);
	
}
public void product() {
	/*List<WebElement>products=driver.findElements(By.xpath("//a[contains(@href, '/p/' ) and descendant :: img]"));
	Random rand=new Random();
	int randomIndex=rand.nextInt(products.size());
	products.get(randomIndex).click();
	System.out.println("clicked product index: +randomIndex");
	//selproduct.click();*/


	List<WebElement> products =driver.findElements(By.xpath("(//div[@class='wvIX4U'])[1]"));
	Random rand = new Random();
	int randomIndex = rand.nextInt(products.size());
	products.get(randomIndex).click();


}
}
