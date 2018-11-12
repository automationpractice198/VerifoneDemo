package qa.java.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.java.testbase.TestBase;

public class SuppportPage extends TestBase{
	public WebDriver Browser;
	@FindBy(className="content")
	public WebElement WelComeSupportPage;
	@FindBy(xpath="//div[@class='alert-block open-alert']")
	public WebElement CurrentAlerts;
	@FindBy(xpath="//div[@class='list-block']//div[@class='row-block row0']//div[@class='item item0']")
	public WebElement PetroAndConvience;
	@FindBy(xpath="//div[@class='list-block']//div[@class='row-block row0']//div[@class='item item1']")
	public WebElement CountertopSolution;
	@FindBy(xpath="//div[@class='list-block']//div[@class='row-block row0']//div[@class='item item2']")
	public WebElement MobileAndWireless;
	@FindBy(xpath="//div[@class='list-block']//div[@class='row-block row1']//div[@class='item item0']")
	public WebElement PCSoftware;
	@FindBy(xpath="//div[@class='list-block']//div[@class='row-block row1']//div[@class='item item1']")
	public WebElement GateWays;
	public SuppportPage(WebDriver driver) {
		this.Browser=driver;
		PageFactory.initElements(Browser, this);
	}
	
	public Boolean verifyPresenseOfElement(WebElement element) {
		List<String> BrowserSelection = new ArrayList<String>(Browser.getWindowHandles());
		Boolean present = false;
		Browser.switchTo().window(BrowserSelection.get(1));
		present= waitForElement(element).isDisplayed();
		return present;
	}
	public String getPageTitle() {
		List<String> BrowserSelection = new ArrayList<String>(Browser.getWindowHandles());
		Browser.switchTo().window(BrowserSelection.get(1));
		return Browser.getTitle();
	}

}
