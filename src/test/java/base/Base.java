package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.apache.logging.log4j.Logger;
public class Base {
 public WebDriver driver;
 public Logger log;
 Properties prop;
 public void loadsetting() throws IOException {
	 FileInputStream load=new FileInputStream("./src//test//resources//config.properties");
 prop=new Properties();
prop.load(load);
 }
@BeforeTest
public void setconfiguration() throws IOException

{
	log=LogManager.getLogger(this.getClass());
	loadsetting();
	String browser = prop.getProperty("browser");
	String url = prop.getProperty("url");
	
	 if (browser.equalsIgnoreCase("chrome")) {
         driver = new ChromeDriver();
     } else if (browser.equalsIgnoreCase("firefox")) {
         driver = new FirefoxDriver();
     } else if (browser.equalsIgnoreCase("edge")) {
         driver = new EdgeDriver();
     } else {
         System.out.println("Invalid browser name in config file.");
         return;}
	driver.get(prop.getProperty("url"));
	driver.manage().deleteAllCookies();
	 driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
}



}
