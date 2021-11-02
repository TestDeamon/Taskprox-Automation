package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Howitworkspage {
	public WebDriver driver;
	
	By login = By.cssSelector(".nav-log.desktop .login-nav");
	By register = By.cssSelector("div.nav-log.desktop a.register-nav");
	By searchTaskField = By.cssSelector("input.react-autosuggest__input"); //Input should be typed one by one, there is autosuggest
	By howItWorks = By.cssSelector(".nav-log.desktop a:nth-child(2)");
	By myTasks = By.cssSelector(".nav-log.desktop a:nth-child(3)");
	By myJobs = By.cssSelector(".nav-log.desktop a:nth-child(4)");
	By myListing = By.cssSelector(".nav-log.desktop a:nth-child(5)");
	By myWallet = By.cssSelector(".nav-log.desktop a:nth-child(6)");
	
	
	public Howitworkspage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement howItWorks() {
		return driver.findElement(howItWorks);
	}
	public WebElement myTasks() {
		return driver.findElement(myTasks);
	}
	
	public WebElement myJobs() {
		return driver.findElement(myJobs);
	}
	public WebElement myListing() {
		return driver.findElement(myListing);
	}
	public WebElement myWallet() {
		return driver.findElement(myWallet);
	}
}
