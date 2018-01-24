package outomation.outomationBeni;

import org.junit.After;
import org.junit.Before;

public class BasicTest {

	public WebDriverwrapper driverwrapper;

	@Before
	public void Befor() throws Exception {
		driverwrapper = new WebDriverwrapper();
		driverwrapper.init();
		driverwrapper.maxPage();
		
		
		genericPageObject.setDriver(driverwrapper);
	}
	@After
	public void after() {
		//driverwrapper.printConsoleLogs();
		driverwrapper.quit();
	}
	
}
