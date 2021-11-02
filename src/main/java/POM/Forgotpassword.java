package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpassword {
	public WebDriver driver;
	
	By email = By.cssSelector("input[type='text']");
	By recoverPassword = By.cssSelector("form:nth-child(1) > button.btn.primary.false.block.auth-button:nth-child(4)");
	

	public Forgotpassword(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement getEmail(){
		return driver.findElement(email);
	}
	
	public WebElement resetPassword(){
		return driver.findElement(recoverPassword);
	}
	
	
}
