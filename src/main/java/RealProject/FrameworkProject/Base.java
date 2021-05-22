package RealProject.FrameworkProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//We are creating a method to invoke a driver globally....If we have multiple testcases we are not preferred to invoke it every time

public class Base {
	
	//Here we are initializing a driver -->Driver property or name will be in property file
	//To define webdriver globally we are creating driver object
    public	WebDriver driver;
    public Properties pro;
	public WebDriver initilizeDriver() throws IOException {
		 pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Prathap\\eclipse-workspace\\Prathap\\Prathap.java\\CoreJava\\FrameworkProject\\src\\main\\java\\data1.properties");
	pro.load(file);  //assigning the value
String BrowserName =pro.getProperty("browser"); //Gettinf the property of the browser
System.out.println(BrowserName);

System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathap\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
WebDriver driver = new ChromeDriver();



//Following method should we follow...Iam getting error here
/*	if(BrowserName.equals("chrome")) {    //(BrowserName=="chrome") ==> it will throws error because we cannot use == in extractiong value from property 
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prathap\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}
	else {
	//	driver = new FirefoxDriver();
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prathap\\Downloads\\Selenium\\geckodriver.exe");
		System.out.println("Error")	;
	}   */
	
	//Giving wait mechanism
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//returning back the driver object
	return driver;
	}
	//reusable utilities should store in base class
	
	public void getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
	TakesScreenshot TS =	(TakesScreenshot)driver;
File fi =	TS.getScreenshotAs(OutputType.FILE);
   String Destination = System.getProperty("user.dir")+"\\results\\"+testCaseName+".png";
 //    FileUtils.copyFile(fi,"Destination");
	   //Here we have to import a package called apache common io
	}
	

	
	
	}


