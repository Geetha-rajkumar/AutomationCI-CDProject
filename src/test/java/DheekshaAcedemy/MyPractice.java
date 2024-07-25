package DheekshaAcedemy;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DheekshaAcedemy.PageObjects.CartPage;
import DheekshaAcedemy.PageObjects.CheckOutPage;
import DheekshaAcedemy.PageObjects.OrderPage;
import DheekshaAcedemy.PageObjects.Productcatalogue;
import DheekshaAcedemy.PageObjects1.CartPage1;
import DheekshaAcedemy.PageObjects1.CheckoutPage1;
import DheekshaAcedemy.PageObjects1.ConfirmationPage1;
import DheekshaAcedemy.PageObjects1.ProductCatalogue1;
import DheekshaAcedemy.TestComponents.BaseTest1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyPractice extends BaseTest1{

		
		String productname="ZARA COAT 3";
		//String countryname = "India";
		
		@Test(dataProvider="getData1",groups= {"purchase1"})
		public void submitPractice(HashMap<String,String> inputs)throws IOException, InterruptedException
		{
			
ProductCatalogue1 productcatalogue1 = landingpage1.loginDetails(inputs.get("email"),inputs.get("password"));
List<WebElement> productlist = productcatalogue1.getProductList();
productcatalogue1.clickCartButton(inputs.get("product"));
CartPage1 cartpage1=productcatalogue1.clickCart();
Boolean matching = cartpage1.verifyProductDisplay(inputs.get("product"));
Assert.assertTrue(matching);

CheckoutPage1 checkoutpage1=cartpage1.clickCheckout();
checkoutpage1.selectCountry("India" );
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,500)");
 
ConfirmationPage1 confirmationpage1=checkoutpage1.placeTheOrder();
String finalmessage2 =confirmationpage1.getFinalMessage();
	Assert.assertTrue(finalmessage2.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		}
		
		@Test(dependsOnMethods="submitPractice")
		public void orderHistoryTest() throws InterruptedException
		{
			ProductCatalogue1 productcatalogue1 = landingpage1.loginDetails("geetha027.babu@gmail.com", "Dheeksha21!");
			OrderPage orderpage = productcatalogue1.goToOrdersPage();
			Assert.assertTrue(orderpage.verifyOrderDisplay(productname));
			}
		/*
		@DataProvider
		public Object[][] getData1() throws IOException
		{
			List<HashMap<String,String>> data = getJsonDatamap(System.getProperty("user.dir") +"\\src\\test\\java\\DheekshaAcedemy\\Data\\Purchaseorder1.json" );
		return new Object[][] {{data.get(0),data.get(1)}};
		}getJsonDatamap
		*/
		@DataProvider
		public Object[][] getData1() throws IOException
		{
			List<HashMap<String,String>> data = getJsonDatamap(System.getProperty("user.dir")+"\\src\\test\\java\\DheekshaAcedemy\\Data\\PurchaseOrder1.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		}
		
			
		
		
}	
