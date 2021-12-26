package page;

import model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

public class LocationsPage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.hilton.com/en/locations/";
    private static final String WHERE_TO_INPUT_XPATH = "//*[@id=\"search-form-query\"]";
    private static final String FIND_HOTEL_BUTTON_XPATH = "//*[@id=\"searchFormContent\"]//button[contains(@class,\"btn btn-primary btn-lg\")]";
    private static final String RESULT_HOTEL_NAME_XPATH = "//*[@id=\"hotel-LUZBBHX\"]";
    private static final String HINT_TEXT_XPATH = "//*[@id=\"790444311\"]//span[@class=\"text-base\"]";

    @FindBy(xpath = WHERE_TO_INPUT_XPATH)
    WebElement whereToInput;

    @FindBy(xpath = FIND_HOTEL_BUTTON_XPATH)
    private WebElement findHotelButton;


    public LocationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public LocationsPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Locations Page opened");
        return this;
    }

    public LocationsPage fillSearchForm(Event event){
        whereToInput.sendKeys(event.getPlace());
        return this;
    }

    public LocationsPage pressFindButton(){
        findHotelButton.click();
        logger.info("Find button on page Locations pressed");
        return this;
    }

    public String getResultHotelName(){
        return Waits.getWebElementUntilWait(driver, RESULT_HOTEL_NAME_XPATH)
                .getText();
    }

    public String getHintMessageText(){
        return Waits.getWebElementUntilWait(driver, HINT_TEXT_XPATH)
                .getText();
    }

}
