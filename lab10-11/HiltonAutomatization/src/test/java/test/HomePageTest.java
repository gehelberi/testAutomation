package test;

import model.Event;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HiltonHomePage;
import service.EventCreator;

public class HomePageTest extends CommonConditions{

    private static final int BOOK_HOTEL_PRESS_AMOUNT = 9;
    private static final String EXPECTED_LINK_REDIRECT = "https://www.hilton.com/en/events/";
    private static final String ERROR_MESSAGE_EXPECTED = "Please enter a Location.";

    //№2
    @Test
    public void bookRomeForLotsOfPeopleTest() {

        String actualLink = new HiltonHomePage(driver)
                .openPage()
                .pressBookButton()
                .pressAddRoomButton(BOOK_HOTEL_PRESS_AMOUNT)
                .openHelpLink()
                .getCurrentPageUrl();

        Assert.assertNotEquals(EXPECTED_LINK_REDIRECT,actualLink);
    }

    //№3
    @Test
    public void findElementsInAgeListTest(){
        boolean isAscending = new HiltonHomePage(driver)
                .openPage()
                .pressBookButton()
                .pressAddKidButton()
                .isAscendingAgesInList();
        Assert.assertTrue(isAscending);
    }

    //№5
    @Test
    public void findPlaceWithIncorrectKeyboardLayoutTest(){
        Event event = EventCreator.createEventIncorrectWithoutRooms();
        String actualErrorMessage = new HiltonHomePage(driver)
                .openPage()
                .fillSearchForm(event)
                .pressFindHotelButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_MESSAGE_EXPECTED, actualErrorMessage);
    }

    //№6
    @Test
    public void findPlaceWithTooShortNameTest(){
        Event event = EventCreator.createTooShortEvent();
        String actualErrorMessage = new HiltonHomePage(driver)
                .openPage()
                .fillSearchForm(event)
                .pressFindHotelButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_MESSAGE_EXPECTED, actualErrorMessage);
    }

    //№8
    @Test
    public void findPlaceWithoutData(){
        Event event = EventCreator.createEventWithoutData();
        String actualErrorMessage = new HiltonHomePage(driver)
                .openPage()
                .fillSearchForm(event)
                .pressFindHotelButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_MESSAGE_EXPECTED, actualErrorMessage);
    }

}
