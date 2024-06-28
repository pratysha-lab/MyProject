package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Pratyusha
 * contains Organization   page webElements
 */
public class OrganizationPage {
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement plusSign;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchBox;
	
	@FindBy(name="submit")
	private WebElement search;
	
	@FindBy(xpath="//select[ @name='search_field' and @id='bas_searchfield']")
	private WebElement Indropdown;
	
	

	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getPlusSign() {
		return plusSign;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getIndropdown() {
		return Indropdown;
	}




}
