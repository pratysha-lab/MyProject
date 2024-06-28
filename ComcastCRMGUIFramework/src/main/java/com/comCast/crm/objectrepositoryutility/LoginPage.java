package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.webDriverUtility.WebDriverUtility;
/**
 * @author Pratyusha
 * Contains login page elements and login business library
 */
public class LoginPage extends WebDriverUtility {
	
	// here declaring a WebDriver objects because if we want to perform any WebDriver methods 
	WebDriver driver=null;
	@FindBy(name="user_name")
	private WebElement userEdit;
	
	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	//here WebDriver object is local to Construtor
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this );
		
	}
	
	
	public WebElement getUserEdit() {
		return userEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	/**
	 * @author Pratyusha
	 * Login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginOperation(String url,String username,String password) {
		
		driver.get(url);
		implicityWaitForPageLoad(driver);
		maximize(driver);
		userEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginButton.click();
	}
}
