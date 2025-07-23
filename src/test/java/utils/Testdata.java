package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Testdata {
public static final String
Search_name="saree",
Product_name="_saree";

	static Logger log=LogManager.getLogger(Testdata.class);
	
	public static void assertUrlContain(WebDriver driver, String expectedUrlpart) {
	    String actualUrl = driver.getCurrentUrl();

	    Assert.assertTrue(
	        actualUrl.toLowerCase().contains(expectedUrlpart.toLowerCase()),
	        "URL doesn't contain expected: '" + expectedUrlpart + "', but got: " + actualUrl
	    );
 log.info(" URL contains expected value: " + expectedUrlpart);
	}
	public static WebElement pickRandomOption(List<WebElement> options) {
        if (options == null || options.isEmpty()) {
            System.out.println("No options to choose from.");
            return null;
        }

        System.out.println(" Total options: " + options.size());
        for (int i = 0; i < options.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + options.get(i).getText().trim());
        }

        Random random = new Random();
        WebElement selected = options.get(random.nextInt(options.size()));
        System.out.println(" Selected: " + selected.getText().trim());
        return selected;
}
	public static void  getfullpagescreenshot(WebDriver driver){
		//TakesScreenshot ts=(TakesScreenshot)driver;
		WebElement featureproduct=driver.findElement(By.xpath("//html[@lang='en']"));
		File soucefile=featureproduct.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"\\screenshot\\fullpage.png");
soucefile.renameTo(targetfile);
    
	}	     
	}

	
	


