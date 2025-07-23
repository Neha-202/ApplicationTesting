package testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.Base;
import pages.Home;
import pages.Product;
import utils.Testdata;

public class Testcase extends Base{


 public Home home;
 public Product pdt;
 
 String actualmessageforreachmainpage="Reached Main Page of flipkart";
 String actualmessageforproductsearch="Entered product name";
 String actualmessageforapplyingdiscount="Discount applied";
 String actualmessageforsortedbyfeatures="Sorted successfully using different feature";
 String actualmessageforproductselection="Product selected";
@BeforeClass
public void object() {
	home=new Home(driver);
	pdt=new Product(driver);
}
@Test
public void testlogin() throws InterruptedException {
	log.info("********Starting Automation******");
	log.info("Validating main page");
	Testdata.assertUrlContain(driver, "flipkart");
	Assert.assertEquals(actualmessageforreachmainpage,actualmessageforreachmainpage);
	System.out.println("Message displayed for enetering page:"+ actualmessageforreachmainpage);
	
	
	home.Clicksearch(Testdata.Search_name);
	Testdata.assertUrlContain(driver, Testdata.Search_name);
	Assert.assertEquals(actualmessageforproductsearch,actualmessageforproductsearch);
	System.out.println("Message displayed for searching the product:"+ actualmessageforproductsearch);
	
	

	pdt.filterByDiscount();
	Assert.assertEquals(actualmessageforapplyingdiscount,actualmessageforapplyingdiscount);
	System.out.println("Message displayed for product discount:"+ actualmessageforapplyingdiscount);
	
	
	pdt.sortbypopularity();
	pdt.sortbyprice();
	pdt.sortbynew();
	Testdata.getfullpagescreenshot(driver);
	Assert.assertEquals(actualmessageforsortedbyfeatures,actualmessageforsortedbyfeatures);
	System.out.println("Message displayed for sorting the product:"+ actualmessageforsortedbyfeatures);
	
	pdt.product();
Testdata.assertUrlContain(driver,Testdata.Product_name);
	Assert.assertEquals(actualmessageforproductselection,actualmessageforproductselection);
	System.out.println("Message displayed for selecting the product:"+ actualmessageforproductselection);
}
@AfterMethod
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }

}}