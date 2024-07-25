package DheekshaAcedemy.PageObjects1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DheekshaAcedemy.PageObjects.OrderPage;

public class AbstractComponents1 {

	WebDriver driver;
	
	public AbstractComponents1(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="button[routerlink*='cart']")
	WebElement clickthecart;	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orderHeader;
	

	public void waitForElementAppear(By FindBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
		
	}
	
	public void waitForWebElementAppear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementDisappear(WebElement element) throws InterruptedException
	{
		Thread.sleep(1000);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public CartPage1 clickCart() throws InterruptedException
	{
		clickthecart.click();
		CartPage1 cartpage1 = new CartPage1(driver);
		return cartpage1;
	}

	public OrderPage goToOrdersPage() throws InterruptedException
	{
		Thread.sleep(2000);
		orderHeader.click();
		
	OrderPage orderpage = new OrderPage(driver);
		
		return orderpage;
	}
	

}

