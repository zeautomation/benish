package upstartTest;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.sql.Driver;
import java.util.List;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverwrapper {

	RemoteWebDriver remoteWebDriver;

	public void quit() {
		remoteWebDriver.quit();
	}
	
	//add cookie 
	public void addCookies (String cookieName, String value) {
		Cookie cookie = new Cookie(cookieName, value);
		remoteWebDriver.manage().addCookie(cookie);		
	}
	//maxpage
	public void maxPage() {
		remoteWebDriver.manage().window().maximize();
	}
	
	public void init() throws Exception {
		DesiredCapabilities capabiltirs = DesiredCapabilities.chrome();

		// configuration to log
		LoggingPreferences loggingPreferences = new LoggingPreferences();
		loggingPreferences.enable(LogType.BROWSER, Level.ALL);
		capabiltirs.setCapability(CapabilityType.LOGGING_PREFS, loggingPreferences);

		remoteWebDriver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabiltirs);
	}
	
	public void openUrl(String url) {
		remoteWebDriver.get(url);
	}

	public WebElement getElementByType(String value, String type) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(remoteWebDriver, 10, 1000);
		try {
			if (type.equals("xpath")) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			} else if (type.equals("id")) {
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return element;
	}
	
	// return all list web element by specific expath
	public List<WebElement> finOfElemnt(String Xpath) {
		// web driver wait by time
		WebDriverWait driverwait = new WebDriverWait(remoteWebDriver, 20, 1000);

		// Variable Initialization
		List<WebElement> elementList = null;

		try {
			elementList = driverwait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(Xpath)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementList;
	}

	// this methods is a screen shots
	public void printScreen() {

		WebDriver augmentedDriver = new Augmenter().augment(remoteWebDriver);
		File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);

		copyFile(screenshot, System.getProperty("user.dir") + "\\files\\scr\\" + screenshot.getName());
	}

	// copy file
	public static void copyFile(File source, String destinationPath) {
		try {
			InputStream in = new FileInputStream(source);
			try {
				OutputStream out = new FileOutputStream(new File(destinationPath));
				try {
					// Transfer bytes from in to out
					byte[] buf = new byte[1024];
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
				} finally {
					out.close();
				}
			} finally {
				in.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//print to log
	public LogEntries getConsleLog() {
		return remoteWebDriver.manage().logs().get(LogType.BROWSER);
	}
	public void printConsoleLogs() {
		List<LogEntry> consoleLogEntries = getConsleLog().getAll();
		//Placement the logentry into  the console
		for (int i = 0; i < consoleLogEntries.size(); i++) {
			LogEntry entry = consoleLogEntries.get(i);
			System.out.println(entry.getMessage()+ " : " + entry.getTimestamp());
		}
	}
}
