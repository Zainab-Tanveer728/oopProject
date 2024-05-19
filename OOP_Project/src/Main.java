import java.util.ArrayList;
import java.util.Date;
public class Main {
    public static void main(String[] args) {
        // Initialize rooms from file
        //ArrayList<Room> rooms = Room.initializeRoomsFromFile("Rooms.txt");
        Room room = new Room("208", "Hsotel", 120.00, false, 4);

        // Create a sample user
        User user = new User("John Doe", "john@example.com", "password123", "1234567890");

        // Create a sample accommodation
        Accommodation accommodation = new Accommodation("123", "Sample Accommodation", true, 100.00, 0.0);
        accommodation.setLocation("City Center");
        accommodation.setRoomType("Double");
        ArrayList<String> amenities = new ArrayList<>();
        amenities.add("Wi-Fi");
        amenities.add("TV");
        accommodation.setAmenities(amenities);

        // Create a sample booking
        Date checkInDate = new Date(); // Current date
        Date checkOutDate = new Date(checkInDate.getTime() + (3 * 24 * 60 * 60 * 1000)); // Check out after 3 days
        double totalPrice = 100.00 * 3; // Price per night multiplied by number of nights
        boolean confirmed = true;
        Booking booking = new Booking();
        booking.addBooking(accommodation, room, user, checkInDate, checkOutDate, totalPrice, confirmed);

        // Display booking details
        System.out.println("Booking details:");
        booking.displayBookingDetails();

        // Display inventory details
        System.out.println("\nInventory details:");
        Inventory inventory = new Inventory("456", "Sample Inventory", 10);
        inventory.addAccommodation(accommodation);
        inventory.displayInventoryDetails();

    }
    }
