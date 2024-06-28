package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comCast.crm.generic.fileUtility.ExcelUtility;
import com.comCast.crm.generic.webDriverUtility.JavaUtility;
/**
 * @author Pratyusha
 * contains  create Contact  page webElements
 */
public class CreateContactPage {
	
	
	
	@FindBy(name="lastname")
	private WebElement lastNameTextBox;

	@FindBy(xpath="//td[text()='Organization Name 			']/ancestor::tr[@style='height:25px']/descendant::img")
	private WebElement orgPlusSign;

	@FindBy(name="search_text")
	private WebElement OrgNameTextBox;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBtn;
	
	@FindBy(xpath="//a[@id='1']")
	private WebElement orgNameinlookUp;
	
	@FindBy(name="support_start_date")
	private WebElement supportDateTextBox;

	@FindBy(name="support_end_date")
	private WebElement endDateTextBox;
	
	@FindBy(xpath="//tr/td[@class='detailedViewHeader']/../preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	@FindBy(xpath="//tr/td[@class='detailedViewHeader']/../preceding-sibling::tr/descendant::input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;


	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}


	public WebElement getLastNameTextBox() {
		return lastNameTextBox;
	}


	public WebElement getOrgPlusSign() {
		return orgPlusSign;
	}
	


	public WebElement getOrgNameTextBox() {
		return OrgNameTextBox;
	}


	public WebElement getSearchBtn() {
		return searchBtn;
	}


	public WebElement getOrgNameinlookUp() {
		return orgNameinlookUp;
	}


	public WebElement getSupportDateTextBox() {
		return supportDateTextBox;
	}


	public WebElement getEndDateTextBox() {
		return endDateTextBox;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	
	

}
