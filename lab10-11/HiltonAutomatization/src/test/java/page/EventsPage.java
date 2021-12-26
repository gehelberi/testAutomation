package page;

import model.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.EventsPageTest;

public class EventsPage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.hilton.com/en/events/";
    private static final String WHERE_TO_INPUT_XPATH = "//*[@id=\"search-form-query\"]";
    private static final String ROOMS_NUMBER_INPUT_XPATH = "//*[@id=\"__next\"]//input[@name=\"numRooms\"]";
    private static final String FIND_BUTTON_XPATH = "//*[@id=\"__next\"]//button[@data-testid=\"search-cta-btn\"]";
    private static final String ERROR_XPATH = "//*[@id=\"search-form-query-error\"]";



    @FindBy(xpath = WHERE_TO_INPUT_XPATH)
    WebElement whereToInput;

    @FindBy(xpath = ROOMS_NUMBER_INPUT_XPATH)
    WebElement roomsNumberInput;

    @FindBy(xpath = FIND_BUTTON_XPATH)
    WebElement findButton;

    public EventsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public EventsPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Page events opened");
        return this;
    }

    public EventsPage fillEventsForm(Event event){
        whereToInput.sendKeys(event.getPlace());
        roomsNumberInput.sendKeys(String.valueOf(event.getRoomsNumber()));
        return this;
    }

    public EventsPage pressFindButton(){
        findButton.click();
        logger.info("Find Event button clicked");
        return this;
    }

    public boolean isPageContainsFindError(){
        return driver.findElements(By.xpath(ERROR_XPATH)).size() > 0;
    }

}
