package DheekshaAcedemy.PageObjects1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LandingPage1 extends AbstractComponents1{
WebDriver driver;

public LandingPage1(WebDriver driver)
{
	super(driver);
this.driver=driver;	
PageFactory.initElements(driver,this);
}


@FindBy(id = "userEmail")
WebElement emailid;

@FindBy(id="userPassword")
WebElement passwordele;

@FindBy(css = "input[type='submit']")
WebElement login;

public ProductCatalogue1 loginDetails(String email, String password)
{
	emailid.sendKeys(email);
	passwordele.sendKeys(password);
	login.click();
	ProductCatalogue1 productcatalogue1 = new ProductCatalogue1(driver);
	return productcatalogue1;
	
}
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");

}




}
