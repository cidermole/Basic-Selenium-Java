package localbrowsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by andrew on 12/3/16.
 */
@Test(groups = {"mac", "windows", "linux"})
public class Chrome {
    private WebDriver driver;

    @BeforeTest
    public void chromeSetup(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        final String[] args = { "--no-sandbox", "--disable-gpu" };
        options.addArguments(args);
	options.setHeadless(true);
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
    }
    @Test
    public void test(){
        driver.get("http://example.com");
        Assert.assertEquals(driver.getTitle(), "Example Domain");
    }

    @AfterTest
    public void testTeardown(){
        driver.quit();
    }
}
