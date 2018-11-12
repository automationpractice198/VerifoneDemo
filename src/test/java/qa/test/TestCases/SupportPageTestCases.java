package qa.test.TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import qa.java.pages.SuppportPage;
import qa.java.testbase.TestBase;

public class SupportPageTestCases extends TestBase {
	SuppportPage SupportPage;
	public SupportPageTestCases() {
		SupportPage=new SuppportPage(Browser);
	}
	@Test(priority=10,groups= {"Regression","Sanity"})
	public void TestUserOnSuppportPage() {
		if (SupportPage.getPageTitle().equalsIgnoreCase("Verifone Support Portal"))
			Assert.assertEquals("User is on support page", "User is on support page");
		else {
			System.out.println("Failed");
			Assert.assertEquals("User is on support page", "User is not on support page");
		}
	}
	
	@Test (priority=11, groups= {"Regression","Sanity"})
	public void verifySupportPageElements() {
		Boolean WelCome= SupportPage.verifyPresenseOfElement(SupportPage.WelComeSupportPage);
		Boolean Alerts = SupportPage.verifyPresenseOfElement(SupportPage.CurrentAlerts);
		Boolean PetroAndConv = SupportPage.verifyPresenseOfElement(SupportPage.PetroAndConvience);
		Boolean CounterTopSol = SupportPage.verifyPresenseOfElement(SupportPage.CountertopSolution);
		Boolean MobileWireless=SupportPage.verifyPresenseOfElement(SupportPage.MobileAndWireless);
		Boolean PCSoft = SupportPage.verifyPresenseOfElement(SupportPage.PCSoftware);
		Boolean GateWay = SupportPage.verifyPresenseOfElement(SupportPage.GateWays);
		if (WelCome==true&&Alerts==true&&PetroAndConv==true&&CounterTopSol==true&&MobileWireless==true&&PCSoft==true&&GateWay==true) {
			Assert.assertEquals("Support page has all the content in the page", "Support page has all the content in the page");
		}
		else Assert.assertEquals("Support page has all the content in the page", "Support page does not has all the content");
	}
}
