package qa.java.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.java.testbase.TestBase;

public class ContactUSPage extends TestBase {
	public WebDriver Browser;
	@FindBy(className = "hero__content")
	public WebElement HeroContent;
	@FindBy(id = "edit-first-name")
	public WebElement FirstName;
	@FindBy(id = "edit-email")
	public WebElement eMail;
	@FindBy(id = "edit-phone-number")
	public WebElement PhoneNumber;
	@FindBy(xpath="//select[@id='edit-business-type']//following-sibling::ul[@class='select-options']//li")
	public List<WebElement> BusinessType;
	@FindBy(xpath="//select[@id='edit-state-province']//following-sibling::ul[@class='select-options']//li")
	public List<WebElement> State;
	@FindBy(xpath="//select[@id='edit-country']//following-sibling::ul[@class='select-options']//li")
	public List<WebElement> Country;
	@FindBy(id="edit-company-name")
	public WebElement Company;
	@FindBy(xpath="//select[@id='edit-number-of-devices']//following-sibling::ul[@class='select-options']//li")
	public List<WebElement> NumberOfDevice;
	@FindBy(id="edit-message")
	public WebElement message;
	@FindBy(xpath="//div[@class='js-form-type-select']//select[@id='edit-business-type']//following-sibling::div[@class='js-form-type-select-styled']")
	public WebElement MBusinessType;
	@FindBy(xpath="//div[@class='js-form-type-select']//select[@id='edit-state-province']//following-sibling::div[@class='js-form-type-select-styled']")
	public WebElement MState;
	@FindBy(xpath="//div[@class='js-form-type-select']//select[@id='edit-country']//following-sibling::div[@class='js-form-type-select-styled']")
	public WebElement MCountry;
	@FindBy(xpath="//div[@class='js-form-type-select']//select[@id='edit-number-of-devices']//following-sibling::div[@class='js-form-type-select-styled']")
	public WebElement MNumberOfDevices;
	@FindBy(xpath="//label[@for='edit-terms-of-service']")
	public WebElement CheckBox;
	@FindBy(xpath="//label[@for='edit-terms-of-service']//a")
	public WebElement TermsAndCondition;
	@FindBy(xpath="//div[@class='webform-terms-of-service-details--content']")
	public WebElement TermsAndConditionContent;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@target='_blank']")
	public  WebElement Support;
	

	public ContactUSPage(WebDriver driver) {
		this.Browser = driver;
		PageFactory.initElements(Browser, this);
	}

	public void valueSelection(WebElement MainElement, List<WebElement> elements, String value) {
		MainElement.click();
		for (WebElement element:elements) {
			if (element.getAttribute("innerHTML").equalsIgnoreCase(value)) {
				element.click();
				break;
			}
		}
	}
	
	public void FillValue(WebElement element , String value) {
		//List<String> BrowserSelection = new ArrayList<String>(Browser.getWindowHandles());
		//Browser.switchTo().window(BrowserSelection.get(0));
		ScrollForElement(element, value);
	}
	
	public void click(WebElement element) {
		//List<String> BrowserSelection = new ArrayList<String>(Browser.getWindowHandles());
		//Browser.switchTo().window(BrowserSelection.get(0));
		element.click();
	}
	
	public String GetContentText(WebElement element) {
		return element.getText();
	}

	public SuppportPage NavigateToSupportPage() {
		Support.click();	
		return new SuppportPage(Browser);
	}

}
