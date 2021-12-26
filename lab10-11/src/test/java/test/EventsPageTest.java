package test;

import model.Event;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.EventsPage;
import service.EventCreator;

public class EventsPageTest extends CommonConditions{

//№4
    @Test
    public void findEventWithLotsOfRooms() {
        Event event = EventCreator.creteEvent();

        EventsPage eventsPage = new EventsPage(driver);
        boolean isContainsError = eventsPage
                .openPage()
                .fillEventsForm(event)
                .pressFindButton()
                .isPageContainsFindError();

        Assert.assertFalse(isContainsError);
    }


}
