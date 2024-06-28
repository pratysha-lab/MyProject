package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Pratyusha
 * contains  create organization  page webElements and create org ,create org with industry and type business actions
 */
public class CreateOrganizationPage {
	
	@FindBy(name="accountname")
	private WebElement orgNameTextBox;
	
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(id="phone")
	private WebElement phoneTextBox;
	
	@FindBy(xpath="//tr/td[@class='detailedViewHeader']/../preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	

	@FindBy(xpath="//tr/td[@class='detailedViewHeader']/../preceding-sibling::tr/descendant::input[@title='Cancel [Alt+X]']")
	private WebElement cancelBtn;
	

	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
		
	}
	
	
public WebElement getOrgNameTextBox() {
		return orgNameTextBox;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getPhoneTextBox() {
		return phoneTextBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	public void createOrg(String orgName) {
		getOrgNameTextBox().sendKeys(orgName);
		getSaveBtn().click();
	}
	public void createOrg(String orgName,String industry,String type) {
		getOrgNameTextBox().sendKeys(orgName);
		Select s=new Select(getIndustryDropDown());
		s.selectByVisibleText(industry);
		
		Select s1=new Select(getTypeDropDown());
		s1.selectByVisibleText(type);
		getSaveBtn().click();
	}


	


}
