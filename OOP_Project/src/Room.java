import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
public class Room {
    // Attributes
    private String roomId;
    private String roomType;
    private double price;
    private boolean isAvailable;
    private int capacity;
    private ArrayList<String> amenities;
    private Accommodation accommodation;
    private static final String fileName  = "Rooms.txt";

    // Parametrized Constructor
    public Room(String roomId, String roomType, double price, boolean isAvailable, int capacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = isAvailable;
        this.capacity = capacity;
        this.amenities = new ArrayList<>();
    }

    // Getters
    public String getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<String> getAmenities() {
        return amenities;
    }

    // Setters
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    // Methods to modify amenities
    public void addAmenity(String amenity) {
        if (!amenities.contains(amenity)) {
            amenities.add(amenity);
        }
    }
    public void removeAmenity(String amenity) {
        amenities.remove(amenity);
    }
    public static ArrayList<Room> initializeRoomsFromFile(String filePath) {
        ArrayList<Room> rooms = new ArrayList<>();
        try  {
            FileInputStream fis = new FileInputStream(filePath);
            Scanner reader = new Scanner(fis);
            String line;
            while (reader.hasNextLine()){
                line = reader.nextLine();
                String[] roomData = line.split(",");
                String roomId = roomData[0].trim();
                String roomType = roomData[1].trim();
                double price = Double.parseDouble(roomData[2].trim());
                boolean isAvailable = Boolean.parseBoolean(roomData[3].trim());
                int capacity = Integer.parseInt(roomData[4].trim());
                Room room = new Room(roomId, roomType, price, isAvailable, capacity);
                rooms.add(room);
            }
        } catch (IOException e) {
            System.out.println("Error reading room data from file: " + e.getMessage());
        }
        return rooms;
    }

    // Display room details
    public void displayRoomDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
        System.out.println("Capacity: " + capacity);
        System.out.println("Amenities: " + String.join(", ", amenities));
    }
}



