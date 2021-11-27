package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HiltonHomePage;

public class WebDriverHiltonTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--user-agent='Mozilla/5.0 (Windows Phone 10.0; Android 4.2.1; Microsoft; Lumia 640 XL LTE) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Mobile Safari/537.36 Edge/12.10166'");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void bookRomeForLotsOfPeopleTest() throws InterruptedException {
        String expectedLink = "https://www.hilton.com/en/events/";

        HiltonHomePage homePage = new HiltonHomePage(driver)
                .openPage()
                .pressBookButton()
                .pressAddRoomButtonLotsTimes()
                .openHelpLink();
        String actualLink = homePage.getCurrentPageUrl();

        Assert.assertEquals(expectedLink,actualLink);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
