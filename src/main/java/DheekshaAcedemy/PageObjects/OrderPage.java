package DheekshaAcedemy.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.stream.*;
import java.lang.Boolean;

import DheekshaAcedemy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
	WebDriver driver;
	
	 public OrderPage(WebDriver driver) {
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
