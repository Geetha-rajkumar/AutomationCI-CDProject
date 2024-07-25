package DheekshaAcedemy.PageObjects1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage1 extends AbstractComponents1 {

	WebDriver driver;
	
	public CartPage1(WebDriver driver)
	{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="div[class='cartSection'] h3")
	List<WebElement> cartitemlist;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	By cartlist = By.cssSelector("div[class='cartSection'] h3");
	
	public Boolean verifyProductDisplay(String productname)
	{
		//waitForElementAppear(cartlist);
		Boolean matching  = cartitemlist.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));
		return matching;
	}
	
	public CheckoutPage1 clickCheckout()
	{
		waitForWebElementAppear(checkout);
		checkout.click();
		CheckoutPage1 checkoutpage1 = new CheckoutPage1(driver);
		return checkoutpage1;
	}


}