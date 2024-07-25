package DheekshaAcedemy.PageObjects1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCatalogue1 extends AbstractComponents1{

	WebDriver driver;
	
public ProductCatalogue1(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
	
@FindBy(css="h5 b")
List<WebElement> productlist;


@FindBy(css=".ng-animating")
WebElement invisible;

By toastcontainer = By.id("toast-container");

By prolist = By.cssSelector("h5 b");

By cartbutton = By.xpath("//div[@class='card-body']/button[2]");


public List<WebElement> getProductList()
{
	waitForElementAppear(prolist);
	return productlist;
	
}
	public WebElement getActualProduct(String productname)
	{
		WebElement actualproduct = getProductList().stream().filter(s->s.getText().equals(productname)).findFirst().orElse(null);
		return actualproduct;
	}
	
	public void clickCartButton(String productname)throws InterruptedException
	{
	WebElement prod = getActualProduct(productname);
	
	prod.findElement(cartbutton).click();
waitForElementAppear(toastcontainer);
waitForElementDisappear(invisible);
}
}
