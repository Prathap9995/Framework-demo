package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class landingPage {
	
	
	public WebDriver driver;
	
	public landingPage(WebDriver driver) {  //To expects argument we are creating constructors 
		this.driver=driver;
		
		
	}
	
	By signin = By.cssSelector("a[href*=sign_in]");
	//Validationg weather text is present or not
	
	By title = By.cssSelector("tr th:nth-child(1)");   //Check path
	By header = By.cssSelector("div[class=\"nav-outer clearfix\"] nav");
	
	public WebElement Signinbtn() {
		return driver.findElement(signin);
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getHeader(){
		return driver.findElement(header);
	}

}
