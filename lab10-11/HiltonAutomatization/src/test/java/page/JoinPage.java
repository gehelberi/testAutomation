package page;

import model.Participant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class JoinPage extends AbstractPage{

    private static final Logger logger = LogManager.getRootLogger();
    private static final String PAGE_URL = "https://www.hilton.com/en/hilton-honors/join/";
    private static final String FIRST_NAME_INPUT_XPATH = "//*[@id=\"firstNameTextInput\"]";
    private static final String LAST_NAME_INPUT_XPATH = "//*[@id=\"lastNameTextInput\"]";
    private static final String PHONE_INPUT_XPATH = "//*[@id=\"phoneTextInput\"]";
    private static final String MAIL_INPUT_XPATH = "//*[@id=\"emailTextInput\"]";
    private static final String COUNTRY_SELECT_XPATH = "//*[@id=\"countryCountryDropDown\"]";
    private static final String ADDRESS_INPUT_XPATH = "//*[@id=\"addressLine1TextInput\"]";
    private static final String CITY_INPUT_XPATH = "//*[@id=\"cityTextInput\"]";
    private static final String PASSWORD_INPUT_XPATH = "//*[@id=\"passwordTextInput\"]";
    private static final String PASSWORD_CONFIRM_INPUT_XPATH = "//*[@id=\"confirmPasswordTextInput\"]";
    private static final String FIND_BUTTON_XPATH = "//*[@id=\"main\"]//button[contains(@class,\"primary\")]";
    private static final String ERROR_MESSAGE_XPATH = "//*[@id=\"main\"]//p[@data-e2e=\"joinFlashMessageText\"]";


    @FindBy(xpath = FIRST_NAME_INPUT_XPATH)
    private WebElement firstNameInput;

    @FindBy(xpath = LAST_NAME_INPUT_XPATH)
    private WebElement lastNameInput;

    @FindBy(xpath = PHONE_INPUT_XPATH)
    private WebElement phoneInput;

    @FindBy(xpath = MAIL_INPUT_XPATH)
    private WebElement mailInput;

    @FindBy(xpath = COUNTRY_SELECT_XPATH)
    private WebElement countrySelect;

    @FindBy(xpath = CITY_INPUT_XPATH)
    private WebElement cityInput;

    @FindBy(xpath = PASSWORD_INPUT_XPATH)
    private WebElement passwordInput;

    @FindBy(xpath = PASSWORD_CONFIRM_INPUT_XPATH)
    private WebElement passwordConfirmInput;

    @FindBy(xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;

    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public JoinPage openPage() {
        driver.get(PAGE_URL);
        logger.info("Join page opened");
        return this;
    }

    public JoinPage fillParticipantForm(Participant participant) {
        firstNameInput.sendKeys(participant.getFirstName());
        lastNameInput.sendKeys(participant.getLastName());
        phoneInput.sendKeys(String.valueOf(participant.getPhone()));
        mailInput.sendKeys(participant.getMail());
        new Select(countrySelect).selectByVisibleText(participant.getCountry());
        Waits.getWebElementUntilWait(driver, ADDRESS_INPUT_XPATH).sendKeys(participant.getAddress());
        cityInput.sendKeys(participant.getCity());
        passwordInput.sendKeys(participant.getPassword());
        passwordConfirmInput.sendKeys(participant.getConfirmPassword());
        return this;
    }

    public JoinPage pressFindButton(){
        findButton.click();
        logger.info("Find button pressed on Join page");
        return this;
    }

    public String getErrorMessage(){
        return Waits.getWebElementUntilWait(driver,ERROR_MESSAGE_XPATH)
                .getText();
    }


}
