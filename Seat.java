// Seat is the main class for seats in the cinema
// RegularSeat, PremiumSeat and VIPSeat all extend this class
// each seat has a different price

public abstract class Seat implements Bookable {

    private int seatNumber;
    private boolean isBooked;
    private String bookedByName;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.isBooked = false;
        this.bookedByName = null;
    }

    // child classes will give the price and type
    public abstract double getPrice();
    public abstract String getSeatType();

    // book the seat
    @Override
    public void book(String customerName) throws Exception {
        if (isBooked == true) {
            throw new Exception("seat " + seatNumber + " is already booked");
        }
        isBooked = true;
        bookedByName = customerName;
    }

    // cancel the booking
    @Override
    public void cancel() throws Exception {
        if (isBooked == false) {
            throw new Exception("seat " + seatNumber + " is not booked so cant cancel");
        }
        isBooked = false;
        bookedByName = null;
    }

    @Override
    public boolean isAvailable() {
        return !isBooked;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getBookedByName() {
        return bookedByName;
    }

    @Override
    public String toString() {
        String status = "Available";
        if (isBooked == true) {
            status = "Booked";
        }
        return "Seat " + seatNumber + " | " + getSeatType() + " | Rs." + getPrice() + " | " + status;
    }


    // regular seat costs least
    static class RegularSeat extends Seat {

        public RegularSeat(int seatNumber) {
            super(seatNumber);
        }

        @Override
        public double getPrice() {
            return 150;
        }

        @Override
        public String getSeatType() {
            return "Regular";
        }
    }


    // premium seat is middle range
    static class PremiumSeat extends Seat {

        public PremiumSeat(int seatNumber) {
            super(seatNumber);
        }

        @Override
        public double getPrice() {
            return 300;
        }

        @Override
        public String getSeatType() {
            return "Premium";
        }
    }


    // vip seat is the most expensive
    static class VIPSeat extends Seat {

        public VIPSeat(int seatNumber) {
            super(seatNumber);
        }

        @Override
        public double getPrice() {
            return 500;
        }

        @Override
        public String getSeatType() {
            return "VIP";
        }
    }
}
