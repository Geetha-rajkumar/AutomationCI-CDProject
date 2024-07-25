package DheekshaAcedemy.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import DheekshaAcedemy.PageObjects.CartPage;
import DheekshaAcedemy.PageObjects.CheckOutPage;
import DheekshaAcedemy.PageObjects.ConfirmationPage;
import DheekshaAcedemy.PageObjects.Landingpage;
import DheekshaAcedemy.PageObjects.Productcatalogue;
import DheekshaAcedemy.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{
	public Landingpage landing;
    public Productcatalogue productcatalogue;
    public CartPage cartpage;
    public ConfirmationPage confirmationpage;
	
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException
	{
		landing = launchApplication();
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_and_password(String name, String password) {
		productcatalogue = landing.loginApplication(name, password);

	}
	
	 @When("^I add product (.+) to Cart$")
	 public void I_add_product_to_cart(String productName) throws InterruptedException
	 {
		 List<WebElement> products = productcatalogue.getProductList();
		 productcatalogue.addProductTocart(productName);

	 }

	@When("^Checkout (.+) and submit the Order$")
	public void checkout_submit_the_order(String productName) throws InterruptedException
	{
		cartpage = productcatalogue.clickCart();
		Boolean check =	cartpage.verifyProductDisplay(productName);
		Assert.assertTrue(check);
		CheckOutPage checkoutpage = cartpage.goToCheckout();
		checkoutpage.selectCountry("India");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		confirmationpage = checkoutpage.submitbutton();

	}
	 
	@Then("{string} message is displayed on ConfirmationPage") 
	public void message_displayed_confirmationpage(String string)
	{
		String finalmessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(finalmessage.equalsIgnoreCase(string));
driver.quit();
	}

	@Then("{string} message is displayed")
	public void error_message_is_displayed(String string)
	{
		Assert.assertEquals(string,landing.errorMessage());
		driver.quit();
	}
} 
	 
	 
	 
	 