package DheekshaAcedemy.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import DheekshaAcedemy.PageObjects1.LandingPage1;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest1 {

	public WebDriver driver;
	public LandingPage1 landingpage1;
	public WebDriver initializeDriver() throws IOException
	{		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\DheekshaAcedemy\\Resources\\GlobalData1.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		return driver;
	}

@BeforeMethod(alwaysRun=true)
public LandingPage1 initialize() throws IOException
{
	driver = initializeDriver();
 landingpage1 = new LandingPage1(driver);
	landingpage1.goTo();	
	return landingpage1;
}
public List<HashMap<String,String>> getJsonDatamap(String filepath) throws IOException
{
	
String jsonContent = FileUtils.readFileToString(new File(filepath)
		,StandardCharsets.UTF_8);
ObjectMapper mapper = new ObjectMapper();
List<HashMap<String,String>> data =mapper.readValue(jsonContent,new TypeReference<List<HashMap<String,String>>>(){
});

return data;
}
@AfterMethod(alwaysRun=true)
public void closeTheDriver()
{
driver.quit();	
}

}