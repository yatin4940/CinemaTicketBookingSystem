// CinemaHall manages all the movies seats and bookings
// you can book a seat cancel it and see all the tickets here

import java.util.ArrayList;

public class CinemaHall {

    private String hallName;
    private ArrayList<Movie> movieList;
    private ArrayList<Seat> seatList;
    private ArrayList<Ticket> ticketList;

    public CinemaHall(String hallName) {
        this.hallName = hallName;
        this.movieList = new ArrayList<Movie>();
        this.seatList = new ArrayList<Seat>();
        this.ticketList = new ArrayList<Ticket>();

        // add seats when hall is created
        addSeats();
    }

    // seats 1 to 5 are regular, 6 to 10 are premium, 11 to 15 are vip
    private void addSeats() {
        for (int i = 1; i <= 5; i++) {
            seatList.add(new Seat.RegularSeat(i));
        }
        for (int i = 6; i <= 10; i++) {
            seatList.add(new Seat.PremiumSeat(i));
        }
        for (int i = 11; i <= 15; i++) {
            seatList.add(new Seat.VIPSeat(i));
        }
    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    // search movie by id
    public Movie findMovie(String movieId) {
        for (int i = 0; i < movieList.size(); i++) {
            Movie m = movieList.get(i);
            if (m.getMovieId().equals(movieId)) {
                return m;
            }
        }
        return null;
    }

    // search seat by number
    public Seat findSeat(int seatNumber) {
        for (int i = 0; i < seatList.size(); i++) {
            Seat s = seatList.get(i);
            if (s.getSeatNumber() == seatNumber) {
                return s;
            }
        }
        return null;
    }

    // main booking method
    public Ticket bookSeat(String customerName, String movieId, String showTime, int seatNumber) {

        // check if movie exists
        Movie movie = findMovie(movieId);
        if (movie == null) {
            System.out.println("Error: movie not found with id " + movieId);
            return null;
        }

        // check if show time is valid
        if (movie.hasShowTime(showTime) == false) {
            System.out.println("Error: show time " + showTime + " is not available for this movie");
            System.out.println("Available times are: " + movie.getShowTimes());
            return null;
        }

        // check if seat exists
        Seat seat = findSeat(seatNumber);
        if (seat == null) {
            System.out.println("Error: seat number " + seatNumber + " does not exist");
            return null;
        }

        // try to book the seat
        try {
            seat.book(customerName);

            Ticket ticket = new Ticket(customerName, movie.getTitle(), showTime, seat.getSeatType(), seat.getSeatNumber(), seat.getPrice());
            ticketList.add(ticket);

            System.out.println("Booking successful for " + customerName);
            return ticket;

        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
            return null;
        }
    }

    // cancel booking by seat number
    public void cancelBooking(int seatNumber) {
        Seat seat = findSeat(seatNumber);

        if (seat == null) {
            System.out.println("Error: seat " + seatNumber + " not found");
            return;
        }

        try {
            String name = seat.getBookedByName();
            seat.cancel();
            System.out.println("Booking cancelled for seat " + seatNumber + " which was booked by " + name);
        } catch (Exception e) {
            System.out.println("Cancel failed: " + e.getMessage());
        }
    }

    // show all movies
    public void showAllMovies() {
        System.out.println("==================================");
        System.out.println("Movies showing at " + hallName);
        System.out.println("==================================");
        for (int i = 0; i < movieList.size(); i++) {
            movieList.get(i).showMovieInfo();
        }
    }

    // show all seats and their status
    public void showAllSeats() {
        System.out.println("==================================");
        System.out.println("Seat Layout for " + hallName);
        System.out.println("==================================");
        for (int i = 0; i < seatList.size(); i++) {
            System.out.println(seatList.get(i));
        }
        System.out.println();
    }

    // show all tickets that were booked
    public void showAllTickets() {
        System.out.println("==================================");
        System.out.println("All Bookings at " + hallName);
        System.out.println("==================================");
        if (ticketList.size() == 0) {
            System.out.println("No bookings yet");
            return;
        }
        for (int i = 0; i < ticketList.size(); i++) {
            ticketList.get(i).printTicket();
        }
    }
}
