package concreteObjects;


/*Flight: This class maintains information about flights.  A flight can be associated with 0 or more flight sections.  There can only be one flight section of a particular seat class in a flight, e.g., only one business class and only one first class.  The seat classes are defined by the enumerator type SeatClass which defines the values, first, business, and economy.  The major operations of Flight are summarized below.

FlightSection: This class maintains information about flight sections.  A flight section has a seat class (first, business, or economy) and must have at least 1 seat.

hasAvailableSeats(): returns true iff the section has some seats that are not booked

bookSeat(): books an available seat.

A flight section can contain at most 100 rows of seats and at most 10 columns of seats.

Seat: This class maintains information about seats.  Specifically, a seat has an identifier (a seat is identified by a row number and a column character, where the character is a letter from A to J), and a status which indicates whether the seat is booked. */

public class Flight {
    String name, orig, dest;
    Date date; 
    String id;
}
