package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DateAndBudgetModalPage {
	public WebDriver driver;
	
	By asap = By.cssSelector(".dateSection .dateCard:first-child");
	By budget = By.id("budget");
	By customDateAndBudget = By.cssSelector(".dateSection .dateCard:nth-child(6)");
	By customCalenderIcon = By.name("scheduleDate");

	By previous = By.cssSelector("#footerContent > span");
	By createTask = By.cssSelector("#footerContent > button");
	By closeModal = By.cssSelector(".logoWhite.logout");
	
	public DateAndBudgetModalPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAsap() {
		driver.findElement(asap).click();
	}
	public void clickPrevious() {
		driver.findElement(previous).click();
	}
	public void closeModal() {
		driver.findElement(closeModal).click();
	}
	public void clickCustomDateCard() {
		driver.findElement(customDateAndBudget).click();
	}
	public void setCustomDateAndTime() {
		WebElement el = driver.findElement(customCalenderIcon); 
		int height = (int) (el.getSize().getHeight() * 0.5);
		int width = (int) (el.getSize().getWidth() * 0.9);
		
		Actions action = new Actions(driver);
		//Move Mouse to Calendar icon to set Custom Time 
//		action.moveToElement(el).moveByOffset(width, height).build().perform();
			
	}
	public void enterBudget(String optionalBudget) {
		driver.findElement(budget).sendKeys(optionalBudget);
	}
	public void createTask() {
		driver.findElement(createTask).click();
	}

}
