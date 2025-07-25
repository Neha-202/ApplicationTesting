package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class Login 
{

	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}

	public void FlipkartLogin() throws InterruptedException
	{
	    

	
	            // Wait for the login popup to load
	            Thread.sleep(2000);

	            // Enter mobile number
	            WebElement Login = driver.findElement(By.xpath("//span[text()='Login']"));
	            Login.click();
	}
	public void EnterMobile(String Mobile)
	{
		
		 WebElement mobileInput = driver.findElement(By.xpath("//input[@class='r4vIwl BV+Dqf']"));
         mobileInput.sendKeys(Mobile); 

	            // Click on 'Request OTP' button
	            WebElement requestOtpBtn = driver.findElement(By.xpath("//button[@type='submit' and contains(.,'Request OTP')]"));
	            requestOtpBtn.click();

	            System.out.println("OTP Requested. Cannot proceed further without manual OTP.");

	}

	public void verifydashboardpage() 
	{
		// TODO Auto-generated method stub
		 WebElement dashboardHeader = driver.findElement(By.xpath("//span[text()='Ruby Nazreen K K']"));
	        Assert.assertTrue(dashboardHeader.isDisplayed(), "Dashboard header is not displayed.");
	        System.out.println("Login Success");


	}

public void wishlist()
{
	 WebElement dash = driver.findElement(By.xpath("//span[text()='Ruby Nazreen K K']"));
	dash.click();
	
	WebElement vishlist = driver.findElement(By.xpath("//a[@title='Wishlist (1)']"));
	vishlist.click();
	 WebElement WishlistHeader = driver.findElement(By.xpath("//span[text()='My Wishlist (1)']"));
     Assert.assertTrue(WishlistHeader.isDisplayed(), "Dashboard header is not displayed.");
     System.out.println("Wishlist reached Success");
	


}

public void addtowish(String prod)
{
	 WebElement input = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
		input.sendKeys(prod);
		WebElement submit= driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		 WebElement search = driver.findElement(By.xpath("//a[text()='Mobiles']"));
	     Assert.assertTrue(search.isDisplayed(), "Dashboard header is not displayed.");
	     System.out.println("mobiles search reached Success");
		 WebElement add = driver.findElement(By.xpath("(//div[@class='+7E521'])[1]"));
			add.click();	
			
}
}
