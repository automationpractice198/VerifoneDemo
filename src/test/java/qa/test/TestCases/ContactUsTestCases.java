package qa.test.TestCases;

import org.testng.annotations.Test;
import org.testng.Assert;
import qa.java.pages.ContactUSPage;
import qa.java.pages.SuppportPage;
import qa.java.testbase.TestBase;

public class ContactUsTestCases extends TestBase{
	ContactUSPage ContactUS;
	SuppportPage SupportPage;
	public ContactUsTestCases() {
		ContactUS = new ContactUSPage(Browser);
	}
	
	@Test (priority=7, groups= {"Regression","Sanity"})
	public void VerifyFormFillup() {
		if (Browser.getCurrentUrl().equalsIgnoreCase("https://www.verifone.com/en/us/contact-us")) {
			System.out.println("Entered inside if");
		ContactUS.FillValue(ContactUS.FirstName, "Mahesh");
		ContactUS.FillValue(ContactUS.eMail, "AutomationTesting@Test.com");
		ContactUS.FillValue(ContactUS.PhoneNumber, "1231231234");
		ContactUS.valueSelection(ContactUS.MBusinessType,ContactUS.BusinessType,"Support");
		ContactUS.valueSelection(ContactUS.MState,ContactUS.State, "KS");
		ContactUS.valueSelection(ContactUS.MCountry,ContactUS.Country, "United States");
		ContactUS.FillValue(ContactUS.Company, "Verifone");
		ContactUS.valueSelection(ContactUS.MNumberOfDevices,ContactUS.NumberOfDevice, "< 10");
		ContactUS.FillValue(ContactUS.message,"*****Testing the automation script on contact us page******");
		ContactUS.click(ContactUS.CheckBox);
		ContactUS.click(ContactUS.TermsAndCondition);
		}
		else System.out.println("Didn't get inside");
	}
	
	@Test (priority=8, groups= {"Sanity"})
	public void VerifyTheTermsAndConditionContent() {
		String content = "By checking one of the boxes above, you consent to, and authorize Verifone to, share with the applicable third party provider of payment processing services the contact information you provided to Verifone. Verifone is making this referral at your request and for your convenience, and you acknowledge that you desire to be contacted by the applicable third party regarding its service offerings. Verifone makes no representations or warranties concerning any services offer by any such third party, including with respect to prices, terms of delivery of any services, performance, and terms of payment.";
		if (ContactUS.GetContentText(ContactUS.TermsAndConditionContent).equalsIgnoreCase(content)) {
			Assert.assertEquals("Terms and condition content are matching", "Terms and condition content are matching");
			System.out.println(ContactUS.GetContentText(ContactUS.TermsAndConditionContent));
		}
		else Assert.assertEquals("Terms and condition content are matching", "Terms and condition content are not matching");
	}
	@Test(priority=9, groups= {"Regression","Sanity"})
	public void NavigationToSupportPage() {
		SupportPage = ContactUS.NavigateToSupportPage();
	}
}
