package com.crm.orgTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
//import com.comCast.crm.generic.ObjectUtility.UtilityClassObject;
import com.comCast.crm.generic.baseClassUtility.BaseClass;
import com.comCast.crm.generic.listenersUtility.ListenersPractice;
import com.comCast.crm.objectrepositoryutility.CreateOrganizationPage;
import com.comCast.crm.objectrepositoryutility.HomePage;
import com.comCast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comCast.crm.objectrepositoryutility.OrganizationPage;


import junit.framework.Assert;
/**
 * @author Pratyusha
 * test class for Organization module
 */
//@Listeners(com.comCast.crm.generic.listenersUtility.ListenersPractice.class)

public class CreateOrganizationTest extends BaseClass {
/**
 * this method is to test create organization
 * @throws IOException
 * @throws InterruptedException
 */
	@Test(groups = "smoke")
	public void craeteOrgTest() throws IOException, InterruptedException {
/*Reading data from excel*/
		String ORGNAME = elib.getDataFromExcel("Organization", 1, 2) + jlib.getRandomNumber();

		ListenersPractice.test.log(Status.INFO,ORGNAME);

		HomePage hp = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);

		/*navigate to org module*/
		hp.getOrganizationsLink().click();

		op.getPlusSign().click();

		/*create org business action*/
		cp.createOrg(ORGNAME);

		Thread.sleep(3000);

		boolean actualData = oi.getActualOrgNameHeader().getText().contains(ORGNAME);
		Assert.assertEquals(actualData, true);
		ListenersPractice.test.log(Status.INFO,ORGNAME + " is verified in header info Pass");

		String actualTextboxData = oi.getActualOrgNameBox().getText();
		Assert.assertEquals(actualTextboxData, ORGNAME);
		ListenersPractice.test.log(Status.INFO,ORGNAME + " is verified  Pass");
		ListenersPractice.test.log(Status.INFO,"Done");
	}
	/**
	 * this method is to test create Org with industry and type
	 * @throws InterruptedException
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	@Test(groups = "regression")
	public void createOrgWithIndustry() throws InterruptedException, EncryptedDocumentException, IOException {

		String ORGNAME = elib.getDataFromExcel("Organization", 4, 2) + jlib.getRandomNumber();
		String INDUSTRY = elib.getDataFromExcel("Organization", 4, 3);
		String TYPE = elib.getDataFromExcel("Organization", 4, 4);

		ListenersPractice.test.log(Status.INFO,ORGNAME);

		HomePage h = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);

		h.getOrganizationsLink().click();
		op.getPlusSign().click();

		// calling business action from POM Class
		cp.createOrg(ORGNAME, INDUSTRY, TYPE);

		Thread.sleep(3000);

		boolean actualDataIndustry = oi.getActualindustry().getText().contains(INDUSTRY);
		boolean actualDataType = oi.getActualtypeCheck().getText().contains(TYPE);

		ListenersPractice.test.log(Status.INFO,oi.getActualindustry().getText());

		ListenersPractice.test.log(Status.INFO,oi.getActualtypeCheck().getText());
		// verifying Industry and type
		SoftAssert as = new SoftAssert();
		as.assertEquals(actualDataIndustry, true);
		ListenersPractice.test.log(Status.INFO,oi.getActualindustry().getText() + " is verified pass");

		as.assertEquals(actualDataType, true);
		ListenersPractice.test.log(Status.INFO,oi.getActualtypeCheck().getText() + " is verified pass");

		ListenersPractice.test.log(Status.INFO,"Done");

	}
/**
 * this test method is to test create org with phone number
 * @throws InterruptedException
 * @throws IOException
 */
	@Test(groups = "regression")
	public void createOrgWithTest() throws InterruptedException, IOException {

		String ORGNAME = elib.getDataFromExcel("Organization", 7, 2) + jlib.getRandomNumber();

		String PHONENUMBER = elib.getDataFromExcel("Organization", 7, 3);

		ListenersPractice.test.log(Status.INFO,ORGNAME);
		HomePage h = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);

		h.getOrganizationsLink().click();
		op.getPlusSign().click();
		cp.getOrgNameTextBox().sendKeys(ORGNAME);

		cp.getPhoneTextBox().sendKeys(PHONENUMBER);

		cp.getSaveBtn().click();

		String actualPhoneNumber = oi.getActualphoneNumber().getText();

		// verifying PhoneNumber and type
		SoftAssert as = new SoftAssert();
		as.assertEquals(actualPhoneNumber, PHONENUMBER);
		ListenersPractice.test.log(Status.INFO,PHONENUMBER + " is verified pass");
		ListenersPractice.test.log(Status.INFO,"Done");

	}

}
