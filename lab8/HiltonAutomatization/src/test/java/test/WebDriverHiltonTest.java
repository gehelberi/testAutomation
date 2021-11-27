package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
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
    }
}
