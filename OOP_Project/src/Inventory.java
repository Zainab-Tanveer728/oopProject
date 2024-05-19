import java.util.ArrayList;

public class Inventory {
    private String inventoryId;
    private String inventoryName;
    private int maxSize;
    private ArrayList<Accommodation> accommodations;
    private int currentSize;
    private static ArrayList<Room> availableRooms = new ArrayList<>();

    // Constructor
    public Inventory(String inventoryId, String inventoryName, int maxSize) {
        this.inventoryId = inventoryId;
        this.inventoryName = inventoryName;
        this.maxSize = maxSize;
        this.accommodations = new ArrayList<>();
        this.currentSize = 0;
    }

    // Setters and Getters
    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getInventoryName() {
        return inventoryName;
    }

    public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public ArrayList<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(ArrayList<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    // Methods to manage accommodations
    public void addAccommodation(Accommodation accommodation) {
        if (currentSize < maxSize) {
            accommodations.add(accommodation);
            currentSize++;
        } else {
            System.out.println("Inventory is full. Cannot add more accommodations.");
        }
    }

    public void removeAccommodation(Accommodation accommodation) {
        if (accommodations.remove(accommodation)) {
            currentSize--;
        }
    }

    public Accommodation findAccommodationById(String accommodationId) {
        for (Accommodation accommodation : accommodations) {
            if (accommodation.getAccommodationId().equals(accommodationId)) {
                return accommodation;
            }
        }
        return null;
    }

    // Method to update availability
    public void updateAvailability(String accommodationId, boolean available) {
        Accommodation accommodation = findAccommodationById(accommodationId);
        if (accommodation != null) {
            accommodation.setAvailable(available);
        } else {
            System.out.println("Accommodation not found.");
        }
    }

    // Method to check availability of accommodations
    public void checkAvailability() {
        for (Accommodation accommodation : accommodations) {
            System.out.println("Accommodation ID: " + accommodation.getAccommodationId() + " is " +
                    (accommodation.isAvailable() ? "available" : "not available"));
        }
    }

    // Display inventory details
    public void displayInventoryDetails() {
        System.out.println("Inventory ID: " + inventoryId);
        System.out.println("Inventory Name: " + inventoryName);
        System.out.println("Max Size: " + maxSize);
        System.out.println("Current Size: " + currentSize);
        for (Accommodation accommodation : accommodations) {
            accommodation.displayAccommodationDetails();
        }
    }

    public static void addRoom(Room room) {
        availableRooms.add(room);
    }

    public static ArrayList<Room> getAvailableRooms() {
        return availableRooms;
    }

    public static void removeRoom(Room room) {
        availableRooms.remove(room);
    }

    public static void updateRoom(Room updatedRoom) {
        for (int i = 0; i < availableRooms.size(); i++) {
            if (availableRooms.get(i).getRoomId().equals(updatedRoom.getRoomId())) {
                availableRooms.set(i, updatedRoom);
                break;
            }
        }
    }
}
