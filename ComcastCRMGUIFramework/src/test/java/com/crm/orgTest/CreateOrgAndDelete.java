package com.crm.orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comCast.crm.generic.baseClassUtility.BaseClass;
import com.comCast.crm.objectrepositoryutility.CreateOrganizationPage;
import com.comCast.crm.objectrepositoryutility.HomePage;
import com.comCast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comCast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgAndDelete extends BaseClass {

	
	@Test
	public void createOrgAndDelete() throws InterruptedException, IOException {

		String ORGNAME = elib.getDataFromExcel("Organization", 10, 2) + jlib.getRandomNumber();
		String ORGSelectBy = elib.getDataFromExcel("Organization", 10, 3);

		System.out.println(ORGNAME);

		HomePage h = new HomePage(driver);
		OrganizationPage op = new OrganizationPage(driver);
		CreateOrganizationPage cp = new CreateOrganizationPage(driver);
		OrganizationInformationPage oi = new OrganizationInformationPage(driver);

		h.getOrganizationsLink().click();

		op.getPlusSign().click();

		// create org business action
		cp.createOrg(ORGNAME);

		Thread.sleep(3000);

		String actualData = oi.getActualOrgNameHeader().getText();

		if (actualData.contains(ORGNAME)) {
			System.out.println(ORGNAME + "   is avaiable PASS in header message");
		} else {
			System.out.println(ORGNAME + " is not avaiable FAIL");
		}

		String actualTextboxData = oi.getActualOrgNameBox().getText();
		if (actualTextboxData.equals(ORGNAME)) {
			System.out.println(ORGNAME + "   is avaiable PASS");
		} else {
			System.out.println(ORGNAME + " Is not avaiable FAIL");
		}

		h.getOrganizationsLink().click();
		op.getSearchBox().sendKeys(ORGNAME);
		op.getIndropdown().click();

		wlib.select(op.getIndropdown(), ORGSelectBy);
		op.getSearch().click();
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//a[text()='"+ORGNAME+"']/ancestor::tr[@class='lvtColData']/descendant::a[text()='del']")).click();
		
		wlib.switchToAlertAndAccept(driver);

		Thread.sleep(2000);
		System.out.println(ORGNAME + "  is deleted sucessfully!");

		System.out.println("Done");
	}

}
