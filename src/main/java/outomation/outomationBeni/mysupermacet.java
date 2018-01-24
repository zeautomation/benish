package outomation.outomationBeni;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class mysupermacet extends BasicTest{
	
	private static final String SUT_URL = "http://server42:5001/";

	@Test
	public void mysupermarket() throws Exception {

		
		driverwrapper.openUrl(SUT_URL);
		System.out.println("test if it work");
	
		WebElement stertSaveMany = driverwrapper.getElementByType("//div[@class='StartButton']/a[@href='http://www.mysupermarket.co.il/עכשיו_בזול/מדף']", "xpath");
		stertSaveMany.click();

		WebElement theXbutton = driverwrapper.getElementByType("//div[@class='ui-dialog-titlebar-close ui-corner-all']//a['ui-dialog-titlebar-close ui-corner-all']", "xpath");
		theXbutton.click();
		
		//*[@id="MasterBody"]/div[6]/div[1]/a
		
		System.out.println("bla");
	}
}
