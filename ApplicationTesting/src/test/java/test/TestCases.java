package test;

import pages.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TestCases extends Base
{
	Login login;
    

  @BeforeMethod 
    public void objinit() throws InterruptedException {
        login = new Login(driver);
      login.FlipkartLogin();
      login.EnterMobile("9645823844");
            

    }

    @Test (priority=1)
    public void Login_positive()
    
    {
      
        login.verifydashboardpage();
       
    }
    @Test(priority=2)
    public void wishlist()
    {
    login.wishlist();
    
    }
   @Test(priority=3)
    
    public void addtowish()
    {
	   login.addtowish("mobile");
    }
}
