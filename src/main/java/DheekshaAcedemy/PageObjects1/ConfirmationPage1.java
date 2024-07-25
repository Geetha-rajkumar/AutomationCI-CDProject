package DheekshaAcedemy.PageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage1 extends AbstractComponents1{
	
	WebDriver driver;

	public ConfirmationPage1(WebDriver driver) {
super(driver);
this.driver=driver;
PageFactory.initElements(driver,this);
	}
@FindBy(css=".hero-primary")
WebElement finalmessage2;

public String getFinalMessage()
{
//waitForWebElementAppear(finalmessage2);
return finalmessage2.getText();
}
}