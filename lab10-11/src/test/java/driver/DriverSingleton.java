package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static WebDriver driver;

    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if(null == driver){
            switch (System.getProperty("browser")){
                case "firefox":{
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
                    driver = new FirefoxDriver(firefoxOptions);
                }
                default: {
                    WebDriverManager.chromedriver().version("96.0.4664.45").setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless","--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                            "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                            "--disable-gpu", "--ignore-certificate-errors");
                    driver = new ChromeDriver(chromeOptions);
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
