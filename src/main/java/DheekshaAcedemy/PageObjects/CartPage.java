package DheekshaAcedemy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DheekshaAcedemy.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(css=".cartSection h3")
List<WebElement> cartproducts;

@FindBy(xpath="//li[@class='totalRow']/button")
WebElement checkoutele;

By cartSection = By.cssSelector(".cartSection h3");

By checkoutelement = By.xpath("//li[@class='totalRow']/button");

public Boolean verifyProductDisplay(String productname)
{

Boolean check = cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));	

	return check;
}

public CheckOutPage goToCheckout()
{
	waitForElementToAppear(checkoutelement);
	checkoutele.click();
	CheckOutPage checkoutpage = new CheckOutPage(driver);
	return checkoutpage;
}



}