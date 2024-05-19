import java.util.Date;
import java.util.ArrayList;
import java.util.Random;

public class Booking {
    private String bookingId;
    private ArrayList<Booking> bookings; // List of bookings
    private Accommodation accommodation;
    private Room room;
    private User user;
    private Date checkInDate;
    private Date checkOutDate;
    private double totalPrice;
    private boolean confirmed;

    public Booking(){

    }
    // Constructor
    public Booking(String bookingId, Accommodation accommodation, Room room, User user, Date checkInDate, Date checkOutDate, double totalPrice, boolean confirmed) {
        this.bookingId = bookingId;
        this.accommodation = accommodation;
        this.room = room;
        this.user = user;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.confirmed = confirmed;
        this.bookings = new ArrayList<>();
    }

    // Setters and Getters
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    // Display booking details
    public void displayBookingDetails() {
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Accommodation ID: " + accommodation.getAccommodationId());
        System.out.println("Room ID: " + room.getRoomId());
        //System.out.println("User ID: " + user.getName());
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Confirmed: " + (confirmed ? "Yes" : "No"));
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }
    // Method to iterate over bookings
    public void iterateBookings() {
        for (Booking booking : bookings) {
            System.out.println("Booking ID: " + booking.getBookingId());
            System.out.println("Accommodation ID: " + accommodation.getAccommodationId());
            System.out.println("Room ID: " + room.getRoomId());
            System.out.println("User ID: " + user.getClass());
        }
    }
    private static String generateBookingId() {
        ArrayList<String> usedBookingIds = new ArrayList<>();


        String bookingId;
        do {
            // Generate a random 5-digit number
            Random random = new Random();
            int randomId = random.nextInt(90000) + 10000;
            bookingId = String.valueOf(randomId);
        } while (usedBookingIds.contains(bookingId)); // Check if the generated ID is already used

        // Add the generated ID to the list of used IDs
        usedBookingIds.add(bookingId);

        return bookingId;
    }

    // Method to create and add a new booking
    public void addBooking(Accommodation accommodation, Room room, User user, Date checkInDate, Date checkOutDate, double totalPrice, boolean confirmed) {
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, accommodation, room, user, checkInDate, checkOutDate, totalPrice, confirmed);
        bookings.add(booking);
    }
}
