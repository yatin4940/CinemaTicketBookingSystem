// ticket is created when a seat is booked successfully
// it stores all booking info and prints a simple receipt

public class Ticket {

    private static int lastTicketNumber = 100;

    private String ticketId;
    private String customerName;
    private String movieTitle;
    private String showTime;
    private String seatType;
    private int seatNumber;
    private double amountPaid;

    public Ticket(String customerName, String movieTitle, String showTime, String seatType, int seatNumber, double amountPaid) {
        lastTicketNumber++;
        this.ticketId = "TKT" + lastTicketNumber;
        this.customerName = customerName;
        this.movieTitle = movieTitle;
        this.showTime = showTime;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.amountPaid = amountPaid;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getCustomerName() {
        return customerName;
    }

    // print the ticket like a receipt
    public void printTicket() {
        System.out.println("----------------------------------");
        System.out.println("         BOOKING TICKET           ");
        System.out.println("----------------------------------");
        System.out.println("Ticket ID    : " + ticketId);
        System.out.println("Name         : " + customerName);
        System.out.println("Movie        : " + movieTitle);
        System.out.println("Show Time    : " + showTime);
        System.out.println("Seat Number  : " + seatNumber);
        System.out.println("Seat Type    : " + seatType);
        System.out.println("Amount Paid  : Rs." + amountPaid);
        System.out.println("----------------------------------");
        System.out.println("Enjoy the movie!");
        System.out.println("----------------------------------");
        System.out.println();
    }
}
