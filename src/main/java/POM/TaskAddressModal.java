package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TaskAddressModal {
	public WebDriver driver;
	
	By generalDetails = By.cssSelector(".containerSetup ul li:nth-child(1)");
	By address = By.cssSelector(".containerSetup ul li:nth-child(2)");
	By dateNdBudget = By.cssSelector(".containerSetup ul li:nth-child(3)");
	By street = By.cssSelector("input[name='address']");
	By city = By.cssSelector("input[name='city']");
	By nextStep = By.cssSelector(".footerContent button");
	By previous = By.cssSelector("#footerContent > span");

	
	public TaskAddressModal(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getStreet() {
		return driver.findElement(street);
	}
	public WebElement getCity() {
		return driver.findElement(city);
	}
	
	public void enterAddress(String streetAdd, String city) throws InterruptedException{
/*		
		// Returns height, width, x and y coordinates referenced element
		Rectangle res =  driver.findElement(By.cssSelector("h1")).getRect();

		// Rectangle class provides getX,getY, getWidth, getHeight methods
		System.out.println(res.getX());
		
		*/
		
		Select dropCountry = new Select(driver.findElement(By.name("country")));
		Thread.sleep(2000);
		dropCountry.selectByVisibleText("Nigeria");
		Thread.sleep(2000);
		Select dropState = new Select(driver.findElement(By.name("state")));
		Thread.sleep(2000);
		dropState.selectByVisibleText("Lagos");
		Thread.sleep(2000);
		
		getStreet().sendKeys(streetAdd);
		Thread.sleep(1000);
		getCity().sendKeys(city);
	}

	public void clickPrevious() {
		driver.findElement(previous).click();
	}
	
	public DateAndBudgetModalPage clickNextStep() {
		driver.findElement(nextStep).click();
		return new DateAndBudgetModalPage(driver);
	}
	

}
