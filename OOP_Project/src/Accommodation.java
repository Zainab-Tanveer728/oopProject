import java.util.ArrayList;
public class Accommodation {
    private String accommodationId;
    private String accommodationName;
    private boolean available;
    private double price;
    private double discount;
    private ArrayList<Room> rooms; // List of rooms in the accommodation
    private String location;
    private String roomType;
    private ArrayList<String> amenities;

    // Constructor
    public Accommodation(String accommodationId, String accommodationName, boolean available, double price, double discount) {
        this.accommodationId = accommodationId;
        this.accommodationName = accommodationName;
        this.available = available;
        this.price = price;
        this.discount = discount;
        this.rooms = new ArrayList<>();
    }

    // Setters and Getters
    public String getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(String accommodationId) {
        this.accommodationId = accommodationId;
    }

    public String getAccommodationName() {
        return accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName = accommodationName;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public ArrayList<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    // Methods to manage rooms
    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }
   // Method to find Room by Id
    public Room findRoomById(String roomId) {
        for (Room room : rooms) {
            if (room.getRoomId().equals(roomId)) {
                return room;
            }
        }
        return null;
    }

    // Method to negotiate discount
    public void negotiateDiscount() {
        System.out.println("Negotiating discount for accommodation ID: " + accommodationId);
        if (discount > 0) {
            price -= price * (discount / 100);
            System.out.println("New price after discount: " + price);
        } else {
            System.out.println("No discount available.");
        }
    }

    // Method to assign room
    public void assignRoom(String roomId) {
        System.out.println("Assigning room for accommodation ID: " + accommodationId);
        Room room = findRoomById(roomId);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            System.out.println("Room " + roomId + " assigned.");
        } else {
            System.out.println("Room " + roomId + " is not available.");
        }
    }

    // Method to check available rooms
    public void checkAvailableRooms() {
        System.out.println("Checking available rooms for accommodation ID: " + accommodationId);
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println("Room " + room.getRoomId() + " is available.");
            }
        }
    }

    public boolean isAvailable() {
        return available;
    }

    // Display accommodation details
    public void displayAccommodationDetails() {
        System.out.println("Accommodation ID: " + accommodationId);
        System.out.println("Accommodation Name: " + accommodationName);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (available ? "Yes" : "No"));
        System.out.println("Rooms: ");
        for (Room room : rooms) {
            room.displayRoomDetails();
        }
    }
}
