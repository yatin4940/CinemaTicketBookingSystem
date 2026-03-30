#  Cinema Booking System

A complete, interactive, console-based Java application that simulates a movie theater booking system. Built using core Object-Oriented Programming (OOP) principles.

##  Features

* **Interactive Menu:** Navigate the system using a simple Command Line Interface (CLI).
* **View Movies:** Check currently showing movies, genres, ratings, and showtimes.
* **Dynamic Seat Layout:** View available and booked seats in real-time. Seats are categorized into Regular, Premium, and VIP tiers.
* **Book Tickets:** Reserve a specific seat for a movie and generate a detailed booking receipt.
* **Cancel Bookings:** Free up a previously booked seat by seat number.
* **View All Bookings:** See a list of all currently active tickets in the system.

##  Project Structure

* `Main.java` - The entry point containing the interactive user menu and scanner logic.
* `CinemaHall.java` - Manages the movies, seats, and the core booking/cancellation logic.
* `Movie.java` - Stores movie details and available showtimes.
* `Seat.java` - An abstract class defining seat properties. Extended by `RegularSeat`, `PremiumSeat`, and `VIPSeat`.
* `Ticket.java` - Generates a receipt upon successful booking.
* `Bookable.java` - An interface defining the standard booking actions (`book`, `cancel`, `isAvailable`).

##  OOP Concepts Demonstrated

This project showcases several fundamental Object-Oriented principles:
* **Encapsulation:** Data fields in classes (like `Movie` and `Ticket`) are kept private and accessed via public getter methods to protect the integrity of the data.
* **Abstraction:** The `Bookable` interface hides the complex implementation details of booking and cancelling, exposing only the necessary methods.
* **Inheritance:** `RegularSeat`, `PremiumSeat`, and `VIPSeat` inherit core properties and methods from the abstract `Seat` class, promoting code reuse.
* **Polymorphism:** The `CinemaHall` manages a single list of `Seat` objects, but thanks to polymorphism, calling `getPrice()` or `getSeatType()` on a seat dynamically executes the correct method for whether it is a Regular, Premium, or VIP seat.

##  Prerequisites

To run this project, you will need:
* **Java Development Kit (JDK)** 8 or higher installed on your machine.

##  How to Run

1. **Clone the repository:**
   ```bash
   git clone (https://github.com/yatin4940/CinemaTicketBookingSystem)
   
2. **Compile the Java files:**
```bash
   javac *.java
```

3. **Run the application:**
```bash
   java Main
