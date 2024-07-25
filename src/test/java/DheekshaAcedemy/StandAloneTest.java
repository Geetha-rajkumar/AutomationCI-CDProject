package DheekshaAcedemy;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DheekshaAcedemy.PageObjects.Landingpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
WebDriver driver= new ChromeDriver();
String productname="ZARA COAT 3";

driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://rahulshettyacademy.com/client");

Landingpage landing= new Landingpage(driver);

driver.findElement(By.id("userEmail")).sendKeys("geetha027.babu@gmail.com");
driver.findElement(By.id("userPassword")).sendKeys("Dheeksha21!");
driver.findElement(By.id("login")).click();

WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(9));
wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

WebElement prod = products.stream().filter(s->s.findElement(By.cssSelector("b")).getText().equals(productname))
.findFirst().orElse(null);
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[routerlink*='cart']")));

driver.findElement(By.cssSelector("button[routerlink*='cart']")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cartSection h3")));
	
List<WebElement> cartproducts =	driver.findElements(By.cssSelector(".cartSection h3"));
	
Boolean check = cartproducts.stream().anyMatch(s->s.getText().equalsIgnoreCase(productname));	
	
Assert.assertTrue(check);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='totalRow']/button")));

driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
Actions a = new Actions(driver);

a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),"India").build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

Thread.sleep(15000);

//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action__submit")));

driver.findElement(By.cssSelector(".action__submit")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".hero-primary")));

String finalmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

Assert.assertTrue(finalmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

driver.close();

	}
	
	
	

}
