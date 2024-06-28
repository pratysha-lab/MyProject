package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Pratyusha
 * contains Organization info page webElements
 */
public class OrganizationInformationPage {
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualOrgNameHeader;
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement actualOrgNameBox;

	@FindBy(id="mouseArea_Industry")
	private WebElement actualindustry;
	
	@FindBy(id="mouseArea_Type")
	private WebElement actualtypeCheck;
	
	@FindBy(id="dtlview_Phone")
	private WebElement actualphoneNumber;

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	public WebElement getActualOrgNameHeader() {
		return actualOrgNameHeader;
	}

	public WebElement getActualOrgNameBox() {
		return actualOrgNameBox;
	}

	public WebElement getActualindustry() {
		return actualindustry;
	}

	public WebElement getActualtypeCheck() {
		return actualtypeCheck;
	}

	public WebElement getActualphoneNumber() {
		return actualphoneNumber;
	}
	
	



}
