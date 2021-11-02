package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyTasksPage {
	public WebDriver driver;
	
	By addTaskBtn = By.tagName("button");
	By dropDown = By.id("ctkOzkUBN");
	By dropDownContent =By.cssSelector("#BPiTaRHIN0 li");
	By taskCard = By.cssSelector(".task-card-container .TaskCard");
	
	public MyTasksPage(WebDriver driver) {
		this.driver = driver;
	}

	public CreateTaskPage clickAddTaskBtn() {
		driver.findElement(addTaskBtn).click();
		return new CreateTaskPage(driver);
	}
	
	public void clickDropDown() {
		driver.findElement(dropDown).click();
	}
	
	public List<WebElement> getDropDownContents() {
		return driver.findElements(dropDownContent);
	}
	
	public List<WebElement> getCards() {
		return driver.findElements(taskCard);
	}
	public MyTasksPage deleteTasks() {
		driver.findElement(addTaskBtn).click();
		
		return null;
	}

}
