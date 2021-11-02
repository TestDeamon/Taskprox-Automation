package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//First Page 

public class Homepage {
	
	private WebDriver driver;
	
	By login = By.cssSelector(".nav-log.desktop .login-nav");
	By register = By.cssSelector("div.nav-log.desktop a.register-nav");
	By searchTaskField =By.cssSelector("input.react-autosuggest__input"); //Input should be typed one by one, there is autosuggest
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}

	public Loginpage clickLoginBtn(){
		 driver.findElement(login).click();
		 Loginpage lp = new Loginpage(driver);
		 return lp;
	}
}
