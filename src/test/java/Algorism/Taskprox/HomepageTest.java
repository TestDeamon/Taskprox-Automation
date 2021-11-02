package Algorism.Taskprox;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class HomepageTest extends Base{
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 driver.manage().window().maximize();
	}
	
	@Test(dataProvider="getData")
	public void verifyLogin(String Username, String Password, String text) throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		Homepage hp = new Homepage(driver);
		
		//Click login Btn 
		Loginpage lp = hp.clickLoginBtn();
		
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);

		log.info(text);
		

		Landingpage tp = lp.submitLoginDetails();
		Assert.assertTrue(tp.howItWorks().isDisplayed());
		log.info("Verify Login is successful by ensuring it's lands on Taskprox Main page and sees How it works Nav Menu");

	}

	@AfterTest
	public void teardown() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}

	
	
	@DataProvider
	public Object[][] getData(){
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="davorigaga@gmail.com";
		data[0][1]="davorigaga@gmail.com dkdkldk";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="davorigaga@mailinator.com";
		data[1][1]="password";
		data[1][2]= "Non restricted user";
		
		return data;
	}
}

