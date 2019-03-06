package seatClass;

public class Business extends FlightSection{
    @Override
    boolean hasAvailableSeats() {
        return false;
    }

    @Override
    void bookSeat() {

    }
}
