package qa.java.pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.java.testbase.TestBase;

public class VerifoneHomePage extends TestBase {
	public WebDriver Browser;
	@FindBy(className="header-menu__logo")
	public WebElement verifoneLogo;
	@FindBy(className="hero__category")
	public  WebElement DateOnHomePage;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@title='Insights']")
	public  WebElement Insights;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@title='Solutions']")
	public WebElement Solutions;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@title='Devices']")
	public WebElement Devices;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@title='Verifone Connect']")
	public  WebElement VerifoneConnect;
	@FindBy(xpath="//li[@class='header-menu__item']//a[@target='_blank']")
	public  WebElement Support;
	@FindBy(xpath="//li[@class='header-menu__item header-menu__item--last-child']//a[@class='header-menu__link']")
	public  WebElement ContactUs;
	@FindBy(xpath="//li[@class='header-menu__item header-menu__search']")
	public  WebElement Search;
	@FindBy(xpath="//section[@class='article-intro__items']//div[@class='article-intro__item-wrapper']")
	public  List<WebElement> Articles;
	
	
	public VerifoneHomePage(WebDriver Driver){
		this.Browser=Driver;
		 PageFactory.initElements(Browser, this);
	}
	
	public  Boolean VerifyPresenceOfHeader(WebElement element) {
		return TestBase.waitForElement(element).isDisplayed();
	}
	public void ListTheArticlePresentinHomePage() {
		Iterator<WebElement> iterator = Articles.iterator();
		int counter=0;
		while (iterator.hasNext()) {
			counter++;
			System.out.println("#"+counter+"->"+iterator.next().getText());
		}
	}
	public void VerifyTheHeadeOptions(WebElement Header) {
		String[] e = Header.toString().split("xpath: ");
		List<WebElement> HeaderContent = Browser.findElements(By.xpath(e[1].substring(0, e[1].length()-1)+"//following-sibling::div[@class='header-submenu']//ul[@class='header-submenu__group']//li[@class='header-submenu__item']"));
		Iterator<WebElement> iterator = HeaderContent.iterator();
		int counter=0;
		while (iterator.hasNext()){
			counter++;
			System.out.println("Value# "+counter+"->"+iterator.next().getText());
		}
	}
	
	public ContactUSPage NavigateToContactUS() {
		ContactUs.click();
		return new ContactUSPage(Browser);
	}
	
	public SuppportPage NavigateToSupportPage() {
		Support.click();	
		return new SuppportPage(Browser);
	}
	
}
