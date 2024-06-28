package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Pratyusha
 */
public class ContactPage {
 
	@FindBy(xpath="//img[@alt='Create Contact...']")
	private WebElement plusSign;
	
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']")
	private WebElement inDropDown;
	
	@FindBy(name="submit")
	private WebElement searchBtn;

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusSign() {
		return plusSign;
	}

	public WebElement getSearchTextBox() {
		return searchTextBox;
	}

	public WebElement getInDropDown() {
		return inDropDown;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	
}
