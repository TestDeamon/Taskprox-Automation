package Algorism.Taskprox;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM.CreateTaskPage;
import POM.DateAndBudgetModalPage;
import POM.Homepage;
import POM.Loginpage;
import POM.MyTasksPage;
import POM.TaskAddressModal;
import POM.Landingpage;
import resources.Base;

public class CreateTaskTest extends Base{
	public WebDriver driver;
	WebDriverWait wait;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException{
		 driver = initializeDriver();
		 wait = new WebDriverWait(driver, 4);
		 driver.manage().window().maximize();
	}
	
	@SuppressWarnings("unused")
	@Test
	public void verifyCreateTask() throws IOException, InterruptedException{
		driver.get(prop.getProperty("url"));
		Homepage hp = new Homepage(driver);
		
		//click login Btn
		log.info("About to Click Login Menu Button and return to Login page");
		Loginpage lp = hp.clickLoginBtn();
		log.info("Login Menu Button Successfully clicked");
		
		//Enter Email and Password
		lp.getEmail().sendKeys("davorigaga@mailinator.com");
		log.info("Successfully Entered email address");
		lp.getPassword().sendKeys("password");
		log.info("Successfully entered user password");
		
		Landingpage landingpage = lp.submitLoginDetails();
		
		log.info("Successfully Submit email and password and return to Taskproxmainpage");

		Assert.assertTrue(landingpage.howItWorks().isDisplayed());
		log.info("Verify Login is successful by ensuring it's lands on Taskprox Main page and sees How it works Nav Menu");

		
//		//Click Task NavBar 
		System.out.println("clicks my task menu");
		WebElement myTaskMenu = landingpage.myTasks();
		wait.until(ExpectedConditions.visibilityOf(myTaskMenu));
		MyTasksPage myTasksPage = landingpage.clickMyTaskMenu();
		System.out.println("Clicked");
		
		//Click Add Task Btn 
		System.out.println("Click Add Task Btn");
		CreateTaskPage ctp = myTasksPage.clickAddTaskBtn();
		System.out.println("Clicked");
		
		
		//Enter Task
		ctp.getSearchListOfTask();

		
		//Enter Order Description 
		ctp.typeInField(ctp.getOrderDetails(), "Tests");
//		ctp.sendHumanKeys(ctp.getOrderDetails(), "Tests");
//		ctp.getOrderDetails().sendKeys("Tests");
		
		//Get Array of Public Option element (Yes or No)
		
		List<WebElement> publicOptions = ctp.getPostStatus();
		WebElement no = publicOptions.get(1);
		
		no.click();
		
		
		//Send Picture 
		
		TaskAddressModal tam = ctp.clickNextStep();
		tam.enterAddress("Adeniyi Jones Street", "Gbagada");
		DateAndBudgetModalPage dbmp = tam.clickNextStep();
		
		//Click ASAP
		dbmp.clickAsap();
		
		//Click Create Task
		dbmp.createTask();
	}
	

	@AfterTest
	public void teardown(){
		driver.quit();
	}

	
	
	@DataProvider
	public Object[][] getData(){
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="davorigaga@gmail.com";
		data[0][1]="davorigaga@gmail.com";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="davorigaga@mailinator.com";
		data[1][1]="password";
		data[1][2]= "Non restricted user";
		
		return data;
	}
}
