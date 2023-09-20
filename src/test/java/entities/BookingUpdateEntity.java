package entities;


public class BookingUpdateEntity {

    public String firstname;
    public String lastname;
    public int totalprice;
    public boolean depositpaid;
    public DatesBooking bookingdates;
    public String additionalneeds;

    public static class DatesBooking {

        public String checkin;
        public String checkout;
    }
}