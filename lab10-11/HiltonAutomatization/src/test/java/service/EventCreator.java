package service;

import model.Event;

import java.nio.charset.StandardCharsets;

public class EventCreator {
    private static final String TEST_DATA_PLACE = "testdata.event.place";
    private static final String TEST_DATA_ROOMS = "testdata.event.roomsNumber";
    private static final String TEST_DATA_PLACE_INCORRECT = "testdata.event.placeIncorrect";
    private static final String TEST_DATA_SHORT_PLACE = "testdata.event.placeTooShort";
    private static final String TEST_DATA_UPPER_CASE = "testdata.event.placeUpperCase";

    public static Event creteEvent(){
        return new Event(TestDataReader.getTestData(TEST_DATA_PLACE), Integer.parseInt(TestDataReader.getTestData(TEST_DATA_ROOMS)));
    }

    public static Event createEventIncorrectWithoutRooms(){
        return new Event(new String(TestDataReader.getTestData(TEST_DATA_PLACE_INCORRECT).getBytes(StandardCharsets.UTF_8)));
    }

    public static Event createTooShortEvent(){
        return new Event(TestDataReader.getTestData(TEST_DATA_SHORT_PLACE));
    }   
    
    public static Event createEventWithoutData(){
        return new Event("");
    }

    public static Event createEventUpperCase(){
        return new Event(TestDataReader.getTestData(TEST_DATA_UPPER_CASE));
    }

}
