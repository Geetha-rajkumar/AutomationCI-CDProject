package DheekshaAcedemy.AbstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DheekshaAcedemy.PageObjects.CartPage;
import DheekshaAcedemy.PageObjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	
	public AbstractComponents(WebDriver driver) {
	
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css="button[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	public void waitForElementToAppear(By FindBy)
	{
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
}

	public void waitFoWebElementToAppear(WebElement findBy)
	{
	
	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
	wait.until(ExpectedConditions.visibilityOf(findBy));
}

	
	public void waitForElementToDisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(15));
		//wait.until(ExpectedConditions.invisibilityOf(ele));

		}
	public CartPage clickCart() throws InterruptedException
	{
		Thread.sleep(2000);
		cartButton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

	public OrderPage goToOrdersPage() throws InterruptedException
	{
		Thread.sleep(2000);
		orderHeader.click();
		
	OrderPage orderpage = new OrderPage(driver);
		
		return orderpage;
	}
	
	
}