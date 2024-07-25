package DheekshaAcedemy.PageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage1 extends AbstractComponents1 {
	
	WebDriver driver;
	
	public CheckoutPage1(WebDriver driver) {
		super(driver);
	this.driver=driver;	
	PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(css="button[class*='ta-item']:nth-child(3)")
	WebElement selectcoun;
	
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	public void selectCountry(String countryname)
	{
Actions a = new Actions(driver);
	a.sendKeys(country,countryname).build().perform();
waitForWebElementAppear(selectcoun);
selectcoun.click();
	}

	public ConfirmationPage1 placeTheOrder()
	{
		waitForWebElementAppear(placeorder);
		placeorder.click();
		ConfirmationPage1 confirmationpage1 = new ConfirmationPage1(driver);
	return confirmationpage1;	
	}

	
}
