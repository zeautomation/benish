package outomation.outomationBeni;



import org.junit.Test;
import org.openqa.selenium.WebElement;

public  class  loginTest extends BasicTest {

	private static final String SUT_URL = "http://autocourse.tmtjk6qchm.us-east-1.elasticbeanstalk.com/loginPage.jsp";

	@Test
	public void login() throws Exception {

		
		driverwrapper.openUrl(SUT_URL);
		
		System.out.println("fianding faild");
		
		WebElement element = driverwrapper.getElementByType("username", "id");
		element.sendKeys("user1");
		
		WebElement password = driverwrapper.getElementByType("password", "id");
		password.sendKeys("pass1");
		
		WebElement submit = driverwrapper.getElementByType("//button[text()='submit']", "xpath");
		submit.click();
	}
}
