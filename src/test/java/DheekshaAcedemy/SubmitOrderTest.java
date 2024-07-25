package DheekshaAcedemy;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
import DheekshaAcedemy.PageObjects.ConfirmationPage;
import DheekshaAcedemy.PageObjects.Landingpage;
import DheekshaAcedemy.PageObjects.OrderPage;
import DheekshaAcedemy.PageObjects.Productcatalogue;
import DheekshaAcedemy.TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {

	String productname="ZARA COAT 3";
	
	@Test(dataProvider="getData", groups={"purchase"})
	public void submitordermethod(HashMap<String,String> input) throws IOException, InterruptedException
	{

Productcatalogue productcatalogue = landing.loginApplication(input.get("email"),input.get("password"));
List<WebElement> products = productcatalogue.getProductList();
productcatalogue.addProductTocart(input.get("product"));
CartPage cartpage = productcatalogue.clickCart();
Boolean check =	cartpage.verifyProductDisplay(input.get("product"));
Assert.assertTrue(check);
CheckOutPage checkoutpage = cartpage.goToCheckout();
checkoutpage.selectCountry("India");
JavascriptExecutor js=(JavascriptExecutor)driver;
js.executeScript("window.scrollBy(0,500)");
ConfirmationPage confirmationpage = checkoutpage.submitbutton();
String finalmessage = confirmationpage.getConfirmationMessage();
Assert.assertTrue(finalmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	@Test(dependsOnMethods= {"submitordermethod"})
	public void orderHistoryTest() throws InterruptedException
	{
		Productcatalogue productcatalogue = landing.loginApplication("geetha027.babu@gmail.com", "Dheeksha21!");
		OrderPage orderpage = productcatalogue.goToOrdersPage();
		Assert.assertTrue(orderpage.verifyOrderDisplay(productname));
		}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\DheekshaAcedemy\\Data\\PurchaseOrder.json");
	return new Object[][] {{data.get(0)},{data.get(1)}};
	}
	
	/*@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"geetha027.babu@gmail.com", "Dheeksha21!","ZARA COAT 3"} , {"dheekshashree@gmail.com", "Dheeksha21!",
			"ADIDAS ORIGINAL"}};
		}*/
	/*		
	HashMap<String,String> map = new HashMap<String,String>();
	map.put("email","geetha027.babu@gmail.com");
	map.put("password","Dheeksha21!");
	map.put("product","ZARA COAT 3");
	
	HashMap<String,String> map1 = new HashMap<String,String>();
	map1.put("email","dheekshashree@gmail.com");
	map1.put("password","Dheeksha21!");
	map1.put("product","ADIDAS ORIGINAL");
*/

}
