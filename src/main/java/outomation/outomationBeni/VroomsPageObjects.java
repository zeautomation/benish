package outomation.outomationBeni;

import java.sql.Driver;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VroomsPageObjects {

	private static final String serch_btn = "//*[@class='search-btn-text']";

	public static class vroomHomePage extends genericPageObject  implements ILoadable {

		public static void openUrl() {
			driverwrapper.openUrl("https://www.vroom.com/");
		}

		public static void serch(String text) {
			WebElement serch = driverwrapper.getElementByType("hero-search-input", "id");
			if (serch != null) {
				serch.sendKeys(text);
			} else {
				System.out.println("element dont find");
			}
		}
		public static void serchButton() {
			WebElement serchButton = driverwrapper.getElementByType(serch_btn, "xpath");
			serchButton.click();
		}
		public  void isPageLoadeb() {
			driverwrapper.getElementByType("//img[contains(@srcset,'value2')]", "xpath");
		}
		
		//whait for  resoult of all cars
		public static void getNumberOfCarsFromSearch() {
			driverwrapper.getElementByType("//div[@class='car-image-container']","xpath");
			
		}
		
		//copy fromomer
	
		public static void sortlistDropDown() {
			WebElement listDopDown = driverwrapper.getElementByType("//*[@id=\"cars-section\"]/div/div[3]/div/div/span", "xpath");
			listDopDown.click();
		}
		public static void sortLowestPrice() {
			WebElement lowersort = driverwrapper.getElementByType("//*[@id=\"cars-section\"]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]", "xpath");
			lowersort.click();
		}
		
//		public static void aboveList() {
//			WebElement above40K = driverwrapper.getElementByType("//div[contains(text(),'Above $40K')]", "xpath");
//			above40K.click();
//		}
		
		
	}
}
