package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	public WebDriver driver;
	
	By login = By.cssSelector(".nav-log.desktop .login-nav");
	By register = By.cssSelector("div.nav-log.desktop a.register-nav");
	By searchTaskField = By.cssSelector("input.react-autosuggest__input"); //Input should be typed one by one, there is autosuggest
	By howItWorks = By.cssSelector("div.test div.nav-log.desktop:nth-child(2) > a.nav-link.undefined:nth-child(2)");
	By myTasks = By.cssSelector("div.test div.nav-log.desktop:nth-child(2) > a.nav-link.undefined:nth-child(3)");
	By myJobs = By.cssSelector("div.test div.nav-log.desktop:nth-child(2) > a.nav-link.undefined:nth-child(4)");
	By myListing = By.cssSelector("div.test div.nav-log.desktop:nth-child(2) > a.nav-link.undefined:nth-child(5)");
	By myWallet = By.cssSelector("div.test div.nav-log.desktop:nth-child(2) > a.nav-link.undefined:nth-child(6)");
	By profileIcon = By.cssSelector("div.auth-container-cover:nth-child(2) div.home-bg div.header-controller:nth-child(1) div.navbar-main.false.false div.test div.nav-log.desktop:nth-child(2) div.user-setting-main:nth-child(7) div.dropdown-main div.imageCon > img:nth-child(2)");
	By logout = By.cssSelector("div.auth-container-cover:nth-child(2) div.home-bg div.header-controller:nth-child(1) div.navbar-main.false.false div.test div.nav-log.desktop:nth-child(2) div.user-setting-main:nth-child(7) div.dropdown-main.open ul.dropdown-ul li:nth-child(3) > span:nth-child(1)");
	
	
	public Landingpage(WebDriver driver) {
		this.driver = driver;
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
	
	//Go To My Tasks Page
	public MyTasksPage clickMyTaskMenu() {
		myTasks().click();
		return new MyTasksPage(driver);
	}
	
	
	public void clickProfileImage() {
		driver.findElement(profileIcon).click();
	}
	
	public WebElement getLogoutLink() {
		return driver.findElement(logout);
	}
	public Homepage logOut() {
		driver.findElement(logout).click();
		return new Homepage(driver);
	}
	public Listingpage clickListingsMenu() {
		driver.findElement(myListing).click();
		return new Listingpage(driver);
	}
	
}
