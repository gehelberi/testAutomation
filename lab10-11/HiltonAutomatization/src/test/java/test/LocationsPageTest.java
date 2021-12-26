package test;

import model.Event;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.LocationsPage;
import service.EventCreator;

import java.util.Locale;

public class LocationsPageTest extends CommonConditions{

    //№7
    @Test
    public void findHotelWithCorrectDataTest(){
        Event event = EventCreator.creteEvent();
        String hotelResult = new LocationsPage(driver)
                .openPage()
                .fillSearchForm(event)
                .pressFindButton()
                .getResultHotelName();
        Assert.assertTrue(hotelResult.indexOf(event.getPlace()) != 1);
    }

    //№9
    @Test
    public void checkCaseDependenceTest(){
        Event event = EventCreator.createEventUpperCase();
        String actualHint = new LocationsPage(driver)
                .openPage()
                .fillSearchForm(event)
                .getHintMessageText();
        Assert.assertEquals(actualHint.toLowerCase(Locale.ROOT)
                ,event.getPlace().toLowerCase(Locale.ROOT));
    }

}
