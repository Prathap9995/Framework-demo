package RealProject.FrameworkProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;

//By using the inheriatnce concept we are inheriting the property of base class
public class HomePage extends Base{
	//To avoid the override of drivers---> When we run parallely the driver will overrride
			public WebDriver driver;   //Initializing driver
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initilizeDriver();
		driver.get(pro.getProperty("url"));       //Here we not hardcoding the 
	}
	
	//Then by calling method
	@Test(dataProvider = "getData")
	
	public void homepageNavigation(String Username, String Password) throws IOException {
		Logger log = LogManager.getLogger(Base.class.getName()); //To use logging mechanisma
	driver.get(pro.getProperty("url"));
		
	landingPage lan = new landingPage(driver);               //By using pageO  bject factory
	lan.Signinbtn().click();
	loginPage login = new loginPage(driver);
	login.Email().sendKeys(Username);
	login.PAssword().sendKeys(Password);
	login.Commit().click();
	log.debug("Succefully clicked");
	}

//We should not hardcode the values hence by using Dataprovider or we can pass parameter in pom.xml file
	
	//Rows stands for how many different data should test run
	//Columns stands for how many values per each test
	//By using data provider
	//Script will run two times
	@DataProvider
	public Object[][] getData() {
		//Here we are passing two parameters 
		Object[][] data = new Object[2][2];       //We are passing one data set with two values   
		data[0][0]="Prathapbarkur97@gmail.com";
		data[0][1]="Prastha@9995";
	//If we have to run multiple objects we have to declare it and set index respectively	
		data[1][0] = "Shwethaprathap@gmail.com";
		data[1][1] = "Prastha@9995";  
	return data;
	}
	
	@AfterTest
	public void closeWindow() {
		driver.close();
	}




}
//To access the dat from another clas in two ways
//By inheritance and creating object

/*Some of the exception we are getting while executing:-
*Null pointer==>there was nno value assigned for respective object
*FileNot Found
*No frames
*No Elements
*/