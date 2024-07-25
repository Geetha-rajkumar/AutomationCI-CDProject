package DheekshaAcedemy;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import DheekshaAcedemy.PageObjects.CartPage;
import DheekshaAcedemy.PageObjects.Productcatalogue;
import DheekshaAcedemy.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer=DheekshaAcedemy.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
landing.loginApplication("geetha027.babu@gmail.com", "Dheeha21!");
Assert.assertEquals("Incorrect email or password.",landing.errorMessage());
	}
	
	@Test
	public void ProductErrorValidaion() throws IOException, InterruptedException
	{
String productname="ZARA COAT 3";
Productcatalogue productcatalogue = landing.loginApplication("geetha027.babu@gmail.com", "Dheeksha21!");
List<WebElement> products = productcatalogue.getProductList();
 productcatalogue.addProductTocart(productname);
CartPage cartpage = productcatalogue.clickCart();
Boolean check =	cartpage.verifyProductDisplay("ZARA COAT 3");
Assert.assertTrue(check);
}
}