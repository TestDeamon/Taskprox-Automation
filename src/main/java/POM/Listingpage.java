package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Listingpage {
	public WebDriver driver;
	
	By createListingBtn = By.cssSelector(".h-100.text-container .text-wrap.flex-1 .action a");
	By publishListingBtn = By.cssSelector(".HowItWorks .body .toggle-btn button:first-child");
	By requestListedService = By.cssSelector(".HowItWorks .body .toggle-btn button:nth-child(2)"); //Input should be typed one by one, there is autosuggest
	By profileIcon = By.cssSelector("div.auth-container-cover:nth-child(2) div.home-bg div.header-controller:nth-child(1) div.navbar-main.false.false div.test div.nav-log.desktop:nth-child(2) div.user-setting-main:nth-child(7) div.dropdown-main div.imageCon > img:nth-child(2)");
	By logout = By.cssSelector("div.auth-container-cover:nth-child(2) div.home-bg div.header-controller:nth-child(1) div.navbar-main.false.false div.test div.nav-log.desktop:nth-child(2) div.user-setting-main:nth-child(7) div.dropdown-main.open ul.dropdown-ul li:nth-child(3) > span:nth-child(1)");
	
	
	public Listingpage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getCreateListingbtn() {
		return driver.findElement(createListingBtn);
	}
	public WebElement getPublishListingBtn() {
		return driver.findElement(publishListingBtn);
	}
	
	public WebElement getRequestListedServiceBtn() {
		return driver.findElement(requestListedService);
	}

	
	//Don't Remove
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

}
