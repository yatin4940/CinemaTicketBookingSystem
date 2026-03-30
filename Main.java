// this is the main file where everything runs
// we create a cinema hall add movies and then book some seats

public class Main {

    public static void main(String[] args) {

        // create cinema hall
        CinemaHall hall = new CinemaHall("StarPlex Cinema Hall 1");

        // create movies and add show times
        Movie m1 = new Movie("M01", "Interstellar", "Sci-Fi", 8.6, 169);
        m1.addShowTime("10:00 AM");
        m1.addShowTime("2:00 PM");
        m1.addShowTime("7:30 PM");

        Movie m2 = new Movie("M02", "The Dark Knight", "Action", 9.0, 152);
        m2.addShowTime("11:00 AM");
        m2.addShowTime("3:30 PM");
        m2.addShowTime("8:00 PM");

        Movie m3 = new Movie("M03", "Inception", "Thriller", 8.8, 148);
        m3.addShowTime("12:00 PM");
        m3.addShowTime("4:00 PM");
        m3.addShowTime("9:00 PM");

        // add movies to hall
        hall.addMovie(m1);
        hall.addMovie(m2);
        hall.addMovie(m3);

        // show movies list
        hall.showAllMovies();

        // show seat layout
        hall.showAllSeats();

        // book some seats
        System.out.println("--- Making Bookings ---");
        System.out.println();

        Ticket t1 = hall.bookSeat("Ravi Sharma", "M01", "7:30 PM", 3);
        if (t1 != null) {
            t1.printTicket();
        }

        Ticket t2 = hall.bookSeat("Priya Mehta", "M02", "8:00 PM", 14);
        if (t2 != null) {
            t2.printTicket();
        }

        Ticket t3 = hall.bookSeat("Arjun Das", "M03", "9:00 PM", 7);
        if (t3 != null) {
            t3.printTicket();
        }

        // try to book same seat again - this should give error
        System.out.println("--- Testing Error: booking same seat again ---");
        hall.bookSeat("Sneha Rao", "M01", "7:30 PM", 3);
        System.out.println();

        // try wrong show time - this should also give error
        System.out.println("--- Testing Error: wrong show time ---");
        hall.bookSeat("Kiran Patel", "M02", "5:00 PM", 8);
        System.out.println();

        // cancel a booking
        System.out.println("--- Cancelling Seat 7 ---");
        hall.cancelBooking(7);
        System.out.println();

        // try to cancel a seat that was never booked
        System.out.println("--- Testing Error: cancel seat that is not booked ---");
        hall.cancelBooking(2);
        System.out.println();

        // show updated seats after bookings and cancellation
        hall.showAllSeats();

        // show all tickets
        hall.showAllTickets();
    }
}
