package Algorism.Taskprox;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.Homepage;
import POM.Loginpage;
import POM.Landingpage;
import resources.Base;

public class HowitworkspageTest extends Base{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 driver.manage().window().maximize();
	}
	
	@Test
	public void verifyLogin() throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		Homepage hp = new Homepage(driver);
		
		Loginpage lp = hp.clickLoginBtn();
		
		lp.getEmail().sendKeys("davorigaga@mailinator.com");
		lp.getPassword().sendKeys("password");

		
		Landingpage tp = lp.submitLoginDetails();
		System.out.println("Submit button clicked");
		tp.howItWorks().click();
		Thread.sleep(5000);
	}


	@AfterTest
	public void teardown(){
		driver.quit();
	}

	
}

