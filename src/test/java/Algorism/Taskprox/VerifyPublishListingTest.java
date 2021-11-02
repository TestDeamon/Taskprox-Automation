package Algorism.Taskprox;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import POM.Listingpage;
import POM.Loginpage;
import resources.Base;

public class VerifyPublishListingTest extends Base {
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
		
		Thread.sleep(2000);
		Listingpage listingpage = landingpage.clickListingsMenu();
		
		Thread.sleep(5000);
		WebElement getPublishBtn = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(listingpage.getCreateListingbtn()));
		
		listingpage.getPublishListingBtn().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeAsyncScript("window.scrollBy(0,200)");
		Thread.sleep(1000);
		js.executeAsyncScript("window.scrollBy(0,400)");
		Thread.sleep(1000);
		js.executeAsyncScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		js.executeAsyncScript("window.scrollBy(0,800)");
		Thread.sleep(1000);
		js.executeAsyncScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
//		js.executeAsyncScript("window.scrollBy(0,1000)");
//		js.executeScript("arguments[0].scrollIntoView();", element1);
//		js.executeScript("window.scrollTo(1, document.body.scrollHeight)");
	}

	@AfterTest
	public void teardown() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
	}
}

