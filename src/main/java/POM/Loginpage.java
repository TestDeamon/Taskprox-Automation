package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	public WebDriver driver;
	
	By email = By.cssSelector("input[autocomplete='username']");
	By password = By.cssSelector("input[type='password']");
	By loginBtn = By.cssSelector("button:nth-child(4)");
	By forgotPassword = By.cssSelector(".forget-pass-con");


	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

	public Forgotpassword forgotPassword(){
		driver.findElement(forgotPassword).click();
		return new Forgotpassword(driver);
	}
	
	public WebElement getEmail(){
		return driver.findElement(email);
	}
	

	public WebElement getPassword(){
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
	
	public Landingpage submitLoginDetails(){
		driver.findElement(loginBtn).click();
		return new Landingpage(driver);
	}

}
