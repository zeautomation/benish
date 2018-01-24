package outomation.outomationBeni;



import org.junit.Test;
import org.openqa.selenium.remote.RemoteWebDriver;

import outomation.outomationBeni.VroomsPageObjects.vroomHomePage;

public class SerchVrooms extends BasicTest  {

	@Test
	public void serch() {
		vroomHomePage.openUrl();
		//vroomHomePage.driverwrapper.maxPage();
		vroomHomePage.serch("BMW");
		vroomHomePage.serchButton();
		vroomHomePage.sortlistDropDown();
		vroomHomePage.sortLowestPrice();
		vroomHomePage.getNumberOfCarsFromSearch();
		driverwrapper.printScreen();
		
		
		
	}
	
}
