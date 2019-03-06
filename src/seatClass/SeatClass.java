package seatClass;

public class SeatClass{
    public class business extends FlightSection{
        @Override
        boolean hasAvailableSeats() {
            return false;
        }
    
        @Override
        void bookSeat() {
    
        }
    }
    public class economy extends FlightSection{
        @Override
        boolean hasAvailableSeats() {
            return false;
        }
    
        @Override
        void bookSeat() {
    
        }
    }
    public class first extends FlightSection{
        @Override
        boolean hasAvailableSeats() {
            return false;
        }
    
        @Override
        void bookSeat() {
    
        }
    }
	public static SeatClass economy;
	public static SeatClass first;
	public static SeatClass business;
}