import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Setup Phase: Create cinema hall and add movies
        CinemaHall hall = new CinemaHall("StarPlex Cinema Hall 1");

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

        hall.addMovie(m1);
        hall.addMovie(m2);
        hall.addMovie(m3);

        // 2. Interactive Phase: Setup Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("==========================================");
        System.out.println("  Welcome to StarPlex Booking System!     ");
        System.out.println("==========================================");

        // 3. The Menu Loop
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. View all movies");
            System.out.println("2. View seat layout");
            System.out.println("3. Book a ticket");
            System.out.println("4. Cancel a booking");
            System.out.println("5. View all current bookings");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = 0;
            try {
                // Read as string and parse to avoid scanner line break issues
                choice = Integer.parseInt(scanner.nextLine()); 
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            // 4. Handle user choices
            switch (choice) {
                case 1:
                    hall.showAllMovies();
                    break;

                case 2:
                    hall.showAllSeats();
                    break;

                case 3:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Movie ID (e.g., M01): ");
                    String movieId = scanner.nextLine();
                    
                    System.out.print("Enter Show Time (e.g., 7:30 PM): ");
                    String time = scanner.nextLine();
                    
                    System.out.print("Enter Seat Number (1-15): ");
                    int seatNum = 0;
                    try {
                        seatNum = Integer.parseInt(scanner.nextLine());
                        Ticket ticket = hall.bookSeat(name, movieId, time, seatNum);
                        
                        if (ticket != null) {
                            System.out.println("\n*** Ticket Successfully Generated ***");
                            ticket.printTicket();
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid number for the seat.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the Seat Number to Cancel: ");
                    try {
                        int cancelSeat = Integer.parseInt(scanner.nextLine());
                        hall.cancelBooking(cancelSeat);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter a valid number for the seat.");
                    }
                    break;

                case 5:
                    hall.showAllTickets();
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for using the StarPlex System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 6.");
            }
        }
        
        // Close the scanner when exiting the program
        scanner.close(); 
    }
}