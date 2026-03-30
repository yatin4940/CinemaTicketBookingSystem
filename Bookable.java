// this is the interface for booking
// any class that wants to be booked must implement these methods

public interface Bookable {

    void book(String customerName) throws Exception;

    void cancel() throws Exception;

    boolean isAvailable();
}
