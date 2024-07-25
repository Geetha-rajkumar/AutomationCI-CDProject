package DheekshaAcedemy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DheekshaAcedemy.AbstractComponents.AbstractComponents;

import org.openqa.selenium.support.FindBy;


public class Productcatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public Productcatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
@FindBy(css=".mb-3")
List<WebElement> products;

@FindBy(css=".ng-animating")
WebElement spinner;

By productsBy = By.cssSelector(".mb-3");
By addToCart = By.cssSelector(".card-body button:last-of-type");
 By toastmessage = By.cssSelector("#toast-container");
 By cartSection = By.cssSelector(".cartSection h3");
 
 
public List<WebElement> getProductList()
{
	waitForElementToAppear(productsBy);
	return products;
}

public WebElement getProductByName(String productName)
{
	WebElement prod = getProductList().stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productName))
			.findFirst().orElse(null);
	return prod;

}
public void addProductTocart(String productName) throws InterruptedException
{
	WebElement prod = getProductByName(productName);
	
prod.findElement(addToCart).click();
waitForElementToAppear(toastmessage);
waitForElementToDisappear(spinner);
}




}



