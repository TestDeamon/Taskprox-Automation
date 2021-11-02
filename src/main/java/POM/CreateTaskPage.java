package POM;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CreateTaskPage {
	public WebDriver driver;
	
	By generalDetails = By.cssSelector(".containerSetup ul li:nth-child(1)");
	By address = By.cssSelector(".containerSetup ul li:nth-child(2)");
	By dateNdBudget = By.cssSelector(".containerSetup ul li:nth-child(3)");
	By searchTask = By.cssSelector(".input-field input");
	By orderDetails = By.tagName("textarea");
	By publicOptions = By.cssSelector("div.form-group:nth-child(3) div.input-radio");
	By attachment = By.cssSelector(".file-upload-button");
	By cancel = By.cssSelector(".footerContent > span");
	By nextStep = By.cssSelector(".footerContent button");
	By closeModal = By.cssSelector(".logoWhite.logout");
	
	public CreateTaskPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getDetails() {
		return driver.findElement(generalDetails);
	}
	public WebElement getAddress() {
		return driver.findElement(address);
	}
	public WebElement getDateAndBudget() {
		return driver.findElement(dateNdBudget);
	}
	
	public WebElement getSearchField() {
		WebElement taskField = driver.findElement(searchTask);
		return taskField; 
	}
	
	public void getSearchListOfTask() {
		WebElement el = getSearchField();
        Rectangle rect = el.getRect();

        Dimension windowSize = driver.manage().window().getSize();
		Actions action = new Actions(driver);
		getSearchField().click();
		action.moveByOffset((rect.getX() + 180), (rect.getY() + (rect.getHeight() * 2))).click().build().perform();
	}
	
	
	public WebElement getOrderDetails() {
		return driver.findElement(orderDetails);
	}
	
	public List<WebElement> getPostStatus() {
		return driver.findElements(publicOptions);
	}
	public WebElement attachTaskPicture() {
		return driver.findElement(attachment);
	}
	public void clickCancel() {
		driver.findElement(cancel).click();;
	}
	public TaskAddressModal clickNextStep() {
		driver.findElement(nextStep).click();
		return new TaskAddressModal(driver);
	}
	public void closeTaskModal() {
		driver.findElement(closeModal).click();
	}
	public void typeInField(WebElement el, String value){
	    String val = value; 
	
	    for (int i = 0; i < val.length(); i++){
	        char c = val.charAt(i);
	        String s = new StringBuilder().append(c).toString();
	        el.sendKeys(s);
	    }       
	}
	public void sendHumanKeys(WebElement element, String text) {
	    Random r = new Random();
	    for(int i = 0; i < text.length(); i++) {
	        try {
	            Thread.sleep((int)(r.nextGaussian() * 15 + 100));
	        } catch(InterruptedException e) {}
	        String s = new StringBuilder().append(text.charAt(i)).toString();
	        element.sendKeys(s);
	    }
	}

}
