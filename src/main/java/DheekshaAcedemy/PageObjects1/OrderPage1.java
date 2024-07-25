package DheekshaAcedemy.PageObjects1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage1 extends AbstractComponents1 {
	WebDriver driver;
	
	 public OrderPage1(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}

	@FindBy(css="tr td:nth-child(3)")
		List<WebElement> orderslist;

	public Boolean verifyOrderDisplay(String product)
	{		
	Boolean check =	orderslist.stream().anyMatch(s->s.getText().equalsIgnoreCase(product));
	return check;	
	}
		

}
