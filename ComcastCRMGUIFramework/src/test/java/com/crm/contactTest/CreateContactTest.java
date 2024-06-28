package com.crm.contactTest;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comCast.crm.generic.ObjectUtility.UtilityClassObject;
import com.comCast.crm.generic.baseClassUtility.BaseClass;
import com.comCast.crm.generic.listenersUtility.ListenersPractice;
import com.comCast.crm.objectrepositoryutility.ContactInformationPage;
import com.comCast.crm.objectrepositoryutility.ContactPage;
import com.comCast.crm.objectrepositoryutility.CreateContactPage;
import com.comCast.crm.objectrepositoryutility.CreateOrganizationPage;
import com.comCast.crm.objectrepositoryutility.HomePage;
import com.comCast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comCast.crm.objectrepositoryutility.OrganizationPage;

import junit.framework.Assert;
/**
 * @author Pratyusha
 * ListenersPractice. class for create contact with different fileds
 */
//@Listeners(com.comCast.crm.generic.listenersUtility.ListenersPractice.class)
public class CreateContactTest extends BaseClass {
/**
 * ListenersPractice. for create contact
 * @throws InterruptedException
 * @throws IOException
 */
	@Test(groups="smoke")
	public void createContact() throws InterruptedException, IOException {

		String LASTNAME = elib.getDataFromExcel("Contacts", 7, 2) + jlib.getRandomNumber();

			UtilityClassObject.getTest().log(Status.INFO,LASTNAME);
		
		HomePage h = new HomePage(driver);
		ContactPage c = new ContactPage(driver);
		CreateContactPage cp = new CreateContactPage(driver);
		ContactInformationPage ci = new ContactInformationPage(driver);
/*navigate to contact page*/
		h.getContactsLink().click();
		c.getPlusSign().click();

		cp.getLastNameTextBox().sendKeys(LASTNAME);
/*saving the contact*/
		cp.getSaveBtn().click();
		Thread.sleep(3000);

		String  actualLastName = ci.getActuallastName().getText();
		boolean actualHeaderInfo = ci.getActualHeadermsg().getText().contains(LASTNAME);

		/* verifying Lastname*/
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualLastName, LASTNAME);
			UtilityClassObject.getTest().log(Status.INFO,LASTNAME+"  is verified Pass");

		s.assertAll();
		/* verifying Header Lastname*/
		Assert.assertEquals(actualHeaderInfo, true);
			UtilityClassObject.getTest().log(Status.INFO,LASTNAME+"  is verified in header info");
			UtilityClassObject.getTest().log(Status.INFO,"Done");

	}
/**
 * ListenersPractice. for create contact with dates
 * @throws InterruptedException
 * @throws IOException
 */
	@Test(groups="regression")
	public void createContactWithDates() throws InterruptedException, IOException {

		String LASTNAME = elib.getDataFromExcel("Contacts", 7, 2) + jlib.getRandomNumber();

		String startDate = jlib.getCurrentDate("yyyy-MM-dd");

		String endDate = jlib.getAfterOrBeforeDate("yyyy-MM-dd", 30);

		HomePage h = new HomePage(driver);
		ContactPage c = new ContactPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ContactInformationPage ci = new ContactInformationPage(driver);
		/*navigate to contact page*/
		h.getContactsLink().click();
		c.getPlusSign().click();

		ccp.getLastNameTextBox().sendKeys(LASTNAME);

		WebElement ele1 = ccp.getSupportDateTextBox();
		ele1.clear();
		ele1.sendKeys(startDate);

		WebElement ele2 = ccp.getEndDateTextBox();
		ele2.clear();
		ele2.sendKeys(endDate);
/*saving contact with dates*/
		ccp.getSaveBtn().click();
		Thread.sleep(3000);

		String actualStartDate = ci.getActualStartsupportDate().getText();
		String actualEndDate = ci.getActualendDate().getText();
		
		SoftAssert s=new SoftAssert();
		
		/*verifying start date*/
		
		s.assertEquals(actualStartDate, startDate);
		UtilityClassObject.getTest().log(Status.INFO,startDate+"  is verified pass");

		s.assertAll();
		/*verifying end date*/
		
		s.assertEquals(actualEndDate, endDate);
		UtilityClassObject.getTest().log(Status.INFO,endDate+"  is verified pass");

		s.assertAll();

		UtilityClassObject.getTest().log(Status.INFO,"Done");

	}
	/**
	 * ListenersPractice. for create contact with  newly created organization
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(groups="regression")
	public void createContactWithOrganization() throws InterruptedException, IOException {

		String ORGNAME = elib.getDataFromExcel("Organization", 1, 2) + jlib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO,ORGNAME);

		HomePage h = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);

		h.getOrganizationsLink().click();

		op.getPlusSign().click();

		cp.getOrgNameTextBox().sendKeys(ORGNAME);
		Thread.sleep(1000);
		cp.getSaveBtn().click();
		Thread.sleep(3000);

		/*verify header msg of org*/
		boolean actualData = oi.getActualOrgNameHeader().getText().contains(ORGNAME);
		Assert.assertEquals(actualData, true);
		UtilityClassObject.getTest().log(Status.INFO,ORGNAME+" is verified in header info pass");
		/*verify text box org name*/
		String actualTextboxData = oi.getActualOrgNameBox().getText();
		SoftAssert s=new SoftAssert();
		s.assertEquals(actualTextboxData, ORGNAME);
			UtilityClassObject.getTest().log(Status.INFO,ORGNAME+" is verified pass");

		s.assertAll();
		
		/*create Contact*/
		String LASTNAME = elib.getDataFromExcel("Contacts", 7, 2) + jlib.getRandomNumber();
		ContactPage c = new ContactPage(driver);
		CreateContactPage ccp = new CreateContactPage(driver);
		ContactInformationPage ci = new ContactInformationPage(driver);

		h.getContactsLink().click();
		c.getPlusSign().click();

		ccp.getLastNameTextBox().sendKeys(LASTNAME);

		ccp.getOrgPlusSign().click();

		/*Swithing to child Window*/
		wlib.switchToWindowOnUrl(driver, "Accounts&action");

		ccp.getOrgNameTextBox().sendKeys(ORGNAME);
		Thread.sleep(2000);
		ccp.getSearchBtn().click();
		Thread.sleep(2000);
		ccp.getOrgNameinlookUp().click();

		/*Switching to parent Window*/
		wlib.switchToWindowOnUrl(driver, "Contacts&action");

		ccp.getSaveBtn().click();

		String actualLastName = ci.getActuallastName().getText();
		
			UtilityClassObject.getTest().log(Status.INFO,actualLastName);
		/* verifying Lastname*/
		
		s.assertEquals(actualLastName, LASTNAME);
			UtilityClassObject.getTest().log(Status.INFO,LASTNAME+" is verified pass");

		s.assertAll();

		/*verify org name in contact module integration ListenersPractice.ing*/
		String orgNameInContact = ci.getActualOrgName().getText().trim();

			UtilityClassObject.getTest().log(Status.INFO,orgNameInContact);
		Assert.assertEquals(orgNameInContact, ORGNAME);
			UtilityClassObject.getTest().log(Status.INFO,ORGNAME+" is verified pass");


		

			UtilityClassObject.getTest().log(Status.INFO,"======Done=======");

	}

}
