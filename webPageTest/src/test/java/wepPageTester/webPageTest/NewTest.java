package wepPageTester.webPageTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
 
public class NewTest {
 
 public WebDriver driver; 
 
  
public class TestChromeBrowser {
	
	static final String driverPath = "D:\\SeleniumDrivers\\";
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.out.println("*******************");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void testGooglePageTitleInIEBrowser() {
		driver.navigate().to("http://www.google.com");
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
		Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");
	}

	@AfterClass
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing chrome browser");
			driver.quit();
			///15 mayıs
		}
	}
	
}
}
