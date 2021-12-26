package model;

public class Event {
    private String place;
    private int roomsNumber;

    public Event(String place, int roomsNumber) {
        this.place = place;
        this.roomsNumber = roomsNumber;
    }

    public Event(String place){
        this.place = place;
    }

    public String getPlace() {
        return place;
    }

    public int getRoomsNumber() {
        return roomsNumber;
    }
}
