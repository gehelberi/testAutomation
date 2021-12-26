package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HiltonHomePage extends AbstractPage{

    private static final String PAGE_URL = "http://hilton.com/en/";
    private static final String BOOK_BUTTON_PATH = "//*[@id=\"__next\"]/div/div/div[2]/main/div[1]/div/form/div[1]/div/div[3]/div/button[1]";
    private static final String ADD_ROOM_BUTTON_PATH = "//*[@id=\"searchFormRoomInfo\"]/div[3]/button";
    private static final String HELP_LINK = "//*[@id=\"searchFormRoomInfo\"]/div[4]/a";

    @FindBy(xpath = BOOK_BUTTON_PATH)
    private WebElement bookButton;

    @FindBy(xpath = ADD_ROOM_BUTTON_PATH)
    private WebElement addRoomButton;

    @FindBy(xpath = HELP_LINK)
    private WebElement helpLink;


    public HiltonHomePage(WebDriver driver) {
        super(driver);
    }

    public HiltonHomePage openPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(BOOK_BUTTON_PATH)));
        return this;
    }

    public HiltonHomePage pressBookButton(){
        bookButton.click();
        return this;
    }

    public HiltonHomePage pressAddRoomButtonLotsTimes(){
        while (addRoomButton.isEnabled()){
            addRoomButton.click();
        }
        return this;
    }

    public HiltonHomePage openHelpLink(){
        helpLink.click();
        return this;
    }

    public String getCurrentPageUrl(){

        return driver.getCurrentUrl();
    }



}
