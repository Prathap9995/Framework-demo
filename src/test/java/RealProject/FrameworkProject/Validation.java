package RealProject.FrameworkProject;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

import pageObject.landingPage;
	import pageObject.loginPage;

	//These steps should executes before the every test 
	
	
	
	//By using the inheriatnce concept we are inheriting the property of base class
	public class Validation extends Base{     //here we are doing validation
		public static Logger log = LogManager.getLogger(Base.class.getName());
		
		//To avoid the override of drivers---> When we run parallely the driver will overrride
		public WebDriver driver;   //Initializing driver
		
		
		
		@BeforeTest
		public void initialize() throws IOException {
			driver = initilizeDriver();
			log.info("Driver is initialized");
			driver.get(pro.getProperty("url")); //Here we not hardcoding the
			log.info("Getting url");
		}
		
		
		
		
		
		//Then by calling method
		@Test
		
		public void homepageNavigation() throws IOException {
			
		landingPage lan = new landingPage(driver);               //By using pageO  bject factory
	System.out.println(	lan.getTitle().getText() );  // -->Getting the text
Assert.assertEquals(lan.getTitle().getText(), "Lifetime access");
		Assert.assertTrue(lan.getHeader().isDisplayed());
		log.info("Is displaying");
		}

		//To close a test after the execution
		@AfterTest
		public void closeWindow() {
			driver.close();
		}
		
		
		
}
