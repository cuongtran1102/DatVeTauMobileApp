package Object;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ticket {
    private int trainID, seatNumber;
    private String userUID;
    private float price;
    private LocalDate departureDay;
    private LocalTime departureTime;

    public Ticket() {
    }

    public Ticket(int trainID, int seatNumber, String userUID, float price, LocalDate departureDay, LocalTime departureTime) {
        this.trainID = trainID;
        this.seatNumber = seatNumber;
        this.userUID = userUID;
        this.price = price;
        this.departureDay = departureDay;
        this.departureTime = departureTime;
    }

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getUserUID() {
        return userUID;
    }

    public void setUserUID(String userUID) {
        this.userUID = userUID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(LocalDate departureDay) {
        this.departureDay = departureDay;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }
}
