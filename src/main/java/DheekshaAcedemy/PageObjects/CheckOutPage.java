package DheekshaAcedemy.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DheekshaAcedemy.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents {
	
	WebDriver driver;
public CheckOutPage(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}


@FindBy(css="input[placeholder='Select Country']")
WebElement selectcountry;

@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
WebElement clickcountry;

@FindBy(css=".action__submit")
WebElement submit;

By countryresults = By.cssSelector(".ta-results");


By submitbut = By.cssSelector(".action__submit");


public void selectCountry(String countryname)
{

Actions a = new Actions(driver);
a.sendKeys(selectcountry,countryname).build().perform();
waitForElementToAppear(countryresults);
clickcountry.click();

}

public ConfirmationPage submitbutton()
{
	waitForElementToAppear(submitbut);
	submit.click();
	ConfirmationPage confirmationpage = new ConfirmationPage(driver);
	return confirmationpage;
}

}