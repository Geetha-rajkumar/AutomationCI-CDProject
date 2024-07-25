package DheekshaAcedemy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import DheekshaAcedemy.AbstractComponents.AbstractComponents;

public class Landingpage extends AbstractComponents {

	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement Passwordele;
	
	@FindBy(id="login")
	WebElement login;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	public Productcatalogue loginApplication(String email, String Password)
	{
		userEmail.sendKeys(email);
		Passwordele.sendKeys(Password);
		login.click();
		Productcatalogue productcatalogue= new Productcatalogue(driver);
		return productcatalogue;
	}
	
	public String errorMessage()
	{
		waitFoWebElementToAppear(errormessage);
	return errormessage.getText();	
	}
public void goTo()
{
	driver.get("https://rahulshettyacademy.com/client");

}

}


