package com.comCast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Pratyusha
 * contains Home   page webElements and logout business library
 */
public class HomePage {
	
	@FindBy(linkText="Calendar")
	private WebElement calendarLink;

	@FindBy(linkText="Leads")
	private WebElement LeadsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLink;
	
	@FindAll({@FindBy(linkText="Contacts"),@FindBy(xpath="//td[@class='tabUnSelected']/ancestor::tr/descendant::a[text()='Organizations']")})
	private WebElement ContactsLink;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(linkText="Documents")
	private WebElement DocumentsLink;
	
	@FindBy(linkText="Email")
	private WebElement EmailLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement TroubleTicketsLink;
	
	@FindBy(linkText="Dashboard")
	private WebElement DashboardLink;
	
	@FindBy(xpath="//a[text()='More']")
	private WebElement MoreLink;
	
	@FindBy(name="Campaigns")
	private WebElement campaignLink;
	
	
	@FindBy(xpath="//tbody/descendant::img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement Adminstratorimg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutButton;

	
	

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}

	public WebElement getEmailLink() {
		return EmailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return TroubleTicketsLink;
	}

	public WebElement getDashboardLink() {
		return DashboardLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}
	public WebElement getAdminstratorimg() {
		return Adminstratorimg;
	}
	public WebElement getSignoutButton() {
		return signoutButton;
	}
	
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}

	

	
		public void clickCampaignLink(WebDriver driver) {
			
			Actions act=new Actions(driver);
			act.moveToElement(getMoreLink()).perform();
			 getCampaignLink().click();
		}
		public void logoutOperation() {
			Adminstratorimg.click();
			signoutButton.click();
		}
	}

	
	

