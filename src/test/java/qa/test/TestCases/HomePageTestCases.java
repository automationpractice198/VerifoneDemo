package qa.test.TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import qa.java.pages.ContactUSPage;
import qa.java.pages.SuppportPage;
import qa.java.pages.VerifoneHomePage;
import qa.java.testbase.TestBase;

public class HomePageTestCases extends TestBase {
	VerifoneHomePage HomePage;
	ContactUSPage ContactUS;
	SuppportPage SupportPage;
	HomePageTestCases(){
		super.setupBrowser();
		HomePage= new VerifoneHomePage(Browser);
	}
	
	@Test (priority=1, groups= {"Regression","Sanity"})
	public void TestPresenceOfLeftHeader() {
		Boolean Insight=HomePage.VerifyPresenceOfHeader(HomePage.Insights);
		Boolean solution=HomePage.VerifyPresenceOfHeader(HomePage.Solutions);
		Boolean Devices = HomePage.VerifyPresenceOfHeader(HomePage.Devices);
		Boolean verifyConnect = HomePage.VerifyPresenceOfHeader(HomePage.VerifoneConnect);
		if (Insight==true&&solution==true&&Devices==true&&verifyConnect==true) 
			Assert.assertEquals("Available header links are Insight,solution,Devices, verifyConnect","Available header links are Insight,solution,Devices, verifyConnect");
		else 
			Assert.assertEquals("Some of the headerLinks are missing","Available header links are Insight,solution,Devices, verifyConnect");
	}
	
	@Test (priority=2 , groups= {"Regression","Sanity"})
	public void TestPresenceOfLogo() {
		Assert.assertTrue(HomePage.VerifyPresenceOfHeader(HomePage.verifoneLogo));
	}
	
	@Test (priority=3, groups= {"Regression","Sanity"})
	public void TestPresenceOfRightHeader() {
		Boolean Support = HomePage.VerifyPresenceOfHeader(HomePage.Support);
		Boolean ContactUs = HomePage.VerifyPresenceOfHeader(HomePage.ContactUs);
		Boolean Search = HomePage.VerifyPresenceOfHeader(HomePage.Search);
		if (Support==true&&ContactUs==true&&Search==true)
			Assert.assertEquals("Available header links are Support, ContactUs, Search" , "Available header links are Support, ContactUs, Search");
		else 
			Assert.assertEquals("Some header names are not matching", "Available header links are Support, ContactUs, Search");
	}
	
	@Test (priority=4, groups= {"Regression"})
	public void TesttheAvailableArticleOnHomePage() {
		HomePage.ListTheArticlePresentinHomePage();
	}
	
	@Test (priority=5, groups= {"Sanity"})
	public void CheckTheValuesAvailableForHeader() {
		HomePage.VerifyTheHeadeOptions(HomePage.Insights);
	}
	
	@Test (priority=6, groups= {"Regression","Sanity"})
	public void NavigationToContactUS() {
		ContactUS = HomePage.NavigateToContactUS();
		if (Browser.getCurrentUrl().equals("https://www.verifone.com/en/us/contact-us")) Assert.assertEquals("User is on Contact us page", "User is on Contact us page");
		else Assert.assertEquals("User is on Contact us page", "User is not on Contact us page");
	}
	
	
}
