package qa.java.utility;

import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import qa.java.testbase.TestBase;

public class Utility extends TestBase {
	public void GetScreenShot(String testCaseName) throws Exception {
		File file = ((TakesScreenshot)Browser).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("Desktop/mahesh/ScreenShots/"+testCaseName+".jpg"));
	}
}
