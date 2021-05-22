package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
	WebDriver driver;
	 public loginPage(WebDriver driver) {
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	 }
	
	 @FindBy(id="user_email")
	 WebElement usermail;
	 
	 @FindBy(id="user_password")
	 WebElement Userpasswrd;
	 
	 @FindBy(name="commit")
	 WebElement Proceed;
	 
	 public WebElement Email() {
		 return usermail;
		  }
	 public WebElement PAssword() {
		 return Userpasswrd;
		  }
	 public WebElement Commit() {
		 return Proceed;
		 
		 
	 }

}
