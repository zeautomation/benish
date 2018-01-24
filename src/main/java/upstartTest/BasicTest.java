package upstartTest;

import org.junit.After;
import org.junit.Before;

public class BasicTest {

	public WebDriverwrapper driverwrapper;

	@Before
	public void Befor() throws Exception {
		driverwrapper = new WebDriverwrapper();
		driverwrapper.init();
		
		
		genericPageObject.setDriver(driverwrapper);
	}
	@After
	public void after() {
		//driverwrapper.printConsoleLogs();
		driverwrapper.quit();
	}
	
}
