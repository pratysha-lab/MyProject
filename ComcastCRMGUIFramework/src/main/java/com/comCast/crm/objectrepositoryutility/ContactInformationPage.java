package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Pratyusha
 * contains Contact info page webElements
 */
public class ContactInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualHeadermsg;

	
	@FindBy(id="dtlview_Last Name")
	private WebElement actuallastName;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement actualOrgName;

	@FindBy(id="dtlview_Support Start Date")
	private WebElement actualStartsupportDate;

	@FindBy(id="dtlview_Support End Date")
	private WebElement actualendDate;
	
	

	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}



	public WebElement getActualHeadermsg() {
		return actualHeadermsg;
	}



	public WebElement getActuallastName() {
		return actuallastName;
	}



	public WebElement getActualOrgName() {
		return actualOrgName;
	}



	public WebElement getActualStartsupportDate() {
		return actualStartsupportDate;
	}



	public WebElement getActualendDate() {
		return actualendDate;
	}

	
}
