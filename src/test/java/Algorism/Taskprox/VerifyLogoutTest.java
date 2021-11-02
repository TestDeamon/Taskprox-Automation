package Algorism.Taskprox;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POM.Homepage;
import POM.Landingpage;
import POM.Loginpage;
import resources.Base;

public class VerifyLogoutTest extends Base {
	public WebDriver driver;
	By logout = By.cssSelector("div.auth-container-cover:nth-child(2) div.home-bg div.header-controller:nth-child(1) div.navbar-main.false.false div.test div.nav-log.desktop:nth-child(2) div.user-setting-main:nth-child(7) div.dropdown-main.open ul.dropdown-ul li:nth-child(3) > span:nth-child(1)");

	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 driver.manage().window().maximize();
	}
	
	@Test
	public void verifyLogOut() throws IOException, InterruptedException{
		driver.get("https://www.taskprox.com");
		Homepage hp = new Homepage(driver);
		
		//Click login Btn 
		Loginpage lp = hp.clickLoginBtn();
		
		lp.getEmail().sendKeys("davorigaga@mailinator.com");
		lp.getPassword().sendKeys("password");


		Landingpage landingpage = lp.submitLoginDetails();
		Assert.assertTrue(landingpage.howItWorks().isDisplayed());
		log.info("Verify Login is successful by ensuring it's lands on Taskprox Main page and sees How it works Nav Menu");

		
		log.info("Click profile icon image");
		Thread.sleep(3000);
		landingpage.clickProfileImage();
		log.info("Profile Icon image clicked");
		
		Thread.sleep(3000);
		log.info("Click Logout Link");
		hp = landingpage.logOut();
		
		log.info("Logout Link clicked!");
	}

	@AfterTest
	public void teardown() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
}

