package qa.java.testbase;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	public static WebDriver Browser;
	public static void setupBrowser() {
		Browser = new ChromeDriver();
		Browser.navigate().to("https://www.verifone.com/en/us");
		Browser.manage().window().fullscreen();
	}
	
	public static WebElement waitForElement (WebElement element) {
		WebElement present = (new WebDriverWait(Browser,10)).until(ExpectedConditions.visibilityOf(element));
		if(present !=null) return element;
		else throw new IllegalArgumentException();
	}
	
	public static String valueOfKey(String Key) throws Exception{
		FileInputStream file = new FileInputStream("/Users/arunaarali/eclipse-workspace/Verifone/src/main/java/qa/java/config/Config.properties");
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(Key);
	}
	
	public static void ScrollForElement(WebElement Element, String value) {
		JavascriptExecutor js = (JavascriptExecutor)Browser;
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.sendKeys(value);
	}
	/*public static void main(String[] args) throws Exception {
		setupBrowser();
		System.out.println(valueOfKey("Driver"));
		VerifoneHomePage.LeftHeaderValue();
	}*/

}
