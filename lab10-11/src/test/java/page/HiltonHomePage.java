package page;

import com.google.common.collect.Ordering;
import model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class HiltonHomePage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "http://hilton.com/en/";
    private static final String BOOK_BUTTON_PATH = "//button[contains(@class,\"btn btn-text-outline btn-lg\")]";
    private static final String ADD_ROOM_BUTTON_PATH = "//button[contains(@class,\"appearance-none font-bold flex items-center stroke-primary\")]";
    private static final String HELP_LINK = "//span[text()=\"Book 10 or more rooms with group booking\"]";
    private static final String ADD_KID_BUTTON = "//*[@id=\"searchFormRoomInfo\"]//button[@aria-label=\"Add kid to room 1\"]";
    private static final String KIDS_AGE_ELEMENT_LIST = "//*[@id=\"search-form-room-1-child-0-age\"]//option";
    private static final String WHERE_TO_INPUT_XPATH = "//*[@id=\"search-form-query\"]";
    private static final String FIND_HOTEL_BUTTON_XPATH = "//button[contains(@class,\"btn btn-primary w-full\")]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"search-form-query-error\"]/span";

    @FindBy(xpath = BOOK_BUTTON_PATH)
    private WebElement bookButton;

    @FindBy(xpath = ADD_ROOM_BUTTON_PATH)
    private WebElement addRoomButton;

    @FindBy(xpath = HELP_LINK)
    private WebElement helpLink;

    @FindBy(xpath = ADD_KID_BUTTON)
    private WebElement addKid;

    @FindBy(xpath = WHERE_TO_INPUT_XPATH)
    private WebElement searchForm;

    @FindBy(xpath = FIND_HOTEL_BUTTON_XPATH)
    private WebElement findHotelButton;


    public HiltonHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public HiltonHomePage openPage(){
        driver.get(PAGE_URL);
        logger.info("Home page opened");
        return this;
    }

    public HiltonHomePage pressBookButton(){
        bookButton.click();
        return this;
    }


    public HiltonHomePage pressAddRoomButton(int pressAmount){
        for (int i = 0; i < pressAmount; i++){
            addRoomButton.click();
        }
        return this;
    }

    public HiltonHomePage pressAddKidButton(){
        addKid.click();
        return this;
    }

    public HiltonHomePage openHelpLink(){
        helpLink.click();
        return this;
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isAscendingAgesInList(){

        List<WebElement> listOfWebElements = driver.findElements(By.xpath(KIDS_AGE_ELEMENT_LIST));
        List<Integer> listOfAges = new ArrayList<>();

        for(int i = 2;i < listOfWebElements.size();i++){
            listOfAges.add(Integer.parseInt(listOfWebElements.get(i).getText()));
        }

        return Ordering.natural().isOrdered(listOfAges);
    }

    public HiltonHomePage fillSearchForm(Event event){
        searchForm.sendKeys(new String(event.getPlace().getBytes(StandardCharsets.UTF_8)));
        return this;
    }

    public HiltonHomePage pressFindHotelButton(){
        findHotelButton.click();
        return this;
    }

    public String getErrorMessage(){
        return Waits.getWebElementUntilWait(driver,ERROR_MESSAGE_XPATH).getText();
    }

}
