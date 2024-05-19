import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
public class User implements Serializable {

    // Attributes
    // Protected attributes because there will be child classes of this class
    protected String name;
    protected String email;
    protected String password;
    String CNIC;
    protected int otp;
    protected boolean verified;
    private static final String fileName  = "users.txt"; // File to store user data

      // parametrized Constructor
    public User(String name, String email, String password, String CNIC){
        this.name = name;
        this.email = email;
        this.password = password;
        this.CNIC = CNIC;
        this.otp = 0; // Initialize otp to avoid potential null pointer exceptions
        this.verified = false;

    }
    Scanner input = new Scanner(System.in);
    // Methods for a user
    public void Register() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            PrintStream ps = new PrintStream(fos);


            System.out.println("Enter your name:");
            name = input.nextLine();

            System.out.println("Enter your email:");
            email = input.nextLine();

            System.out.println("Enter your password:");
            password = input.nextLine();

            System.out.println("Enter your CNIC ");
            CNIC = input.next();

            // Write user data to the file
            ps.println(name + "," + email + "," + password + "," + CNIC);
            System.out.println("User registered successfully!");
            ps.close(); // Close the print stream otherwise data is not getting saved in the file
            fos.close();

        } catch (IOException e) {
            System.out.println("An error has occurred while registering the user ");
        }
    }
    public boolean login() {
        try {
            System.out.println("Enter your email");
            String inputEmail = input.next(); // Read user input for email
            input.nextLine();
            System.out.println("Enter your password");
            String inputPassword = input.next(); // Read user input for password

            FileInputStream fis = new FileInputStream(fileName);
            Scanner reader = new Scanner(fis);

            boolean userFound = false; // Flag to track if user is found
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] userData = line.split(",");
                if (userData.length == 4 && userData[1].trim().equals(inputEmail) && userData[2].trim().equals(inputPassword)) {
                    System.out.println("Login successful!");
                    userFound = true; // Set flag to true as user is found
                    break; // Exit loop as user is found
                }
            }
            reader.close(); // Close resources
            fis.close();

            if (!userFound) { // If user not found
                System.out.println("Invalid email or password! Please register.");
                return false;
            }

            return true; // Return true if user is found
        } catch (IOException e) {
            System.out.println("Error occurred while logging in: " + e.getMessage());
            return false;
        }
    }

    public void sendOTP(String userEmail) {
        try {
            Random random = new Random();
            otp = 1000 + random.nextInt(9000); // Generate a random 4-digit OTP
            System.out.println("OTP sent to " + userEmail + ": " + otp);

        } catch (Exception e) {
            System.out.println("Error occurred while sending OTP: " + e.getMessage());
        }
    }
    public boolean verifyOTP() {
        try {
            System.out.println("Enter your OTP");
            int inputOTP = input.nextInt();
            if (inputOTP == this.otp) {
                this.verified = true;
                System.out.println("User " + email + " has been verified successfully!");
                return true;
            } else {
                System.out.println("Invalid OTP!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error occurred while verifying OTP: " + e.getMessage());
            return false;
        }
    }
    }
class Student extends User{
    // Attributes
    private String studentID;
    private String testDate;
    // parametrized Constructor
    public Student(String name, String email, String password, String CNIC,String studentID, String testDate) {
        super(name, email, password, CNIC);
        this.studentID = studentID;
        this.testDate = testDate;
    }
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    // Getters
    public String getStudentID() {
        return studentID;
    }

    public String getTestDate() {
        return testDate;
    }

    // Methods
    public ArrayList<Accommodation> searchAccommodation(ArrayList<Room> allRooms, String location, String roomType, ArrayList<String> amenities) {
        ArrayList<Accommodation> matchedAccommodations = new ArrayList<>();
        // Iterate over all rooms in the system
        for (Room room : allRooms) {
            Accommodation accommodation = room.getAccommodation(); // Assuming each room has a reference to its accommodation
            // Check if the accommodation matches the search criteria
            if ((location == null || accommodation.getLocation().equalsIgnoreCase(location))
                    && (roomType == null || room.getRoomType().equalsIgnoreCase(roomType))
                    && (amenities == null || room.getAmenities().containsAll(amenities))) {
                matchedAccommodations.add(accommodation);
            }
        }
        return matchedAccommodations;
    }

    // Method to book accommodation
    public void bookAccommodation(Accommodation accommodation, String bookingDate, int duration) {
        // Implementation of book accommodation logic

        Booking booking = new Booking();
        booking.addBooking(booking);
        System.out.println("Accommodation booked successfully!");
    }

    public void viewBookings() {
        Booking bookings = new Booking();
        bookings.displayBookingDetails();
    }

    // Method to submit feedback for a booking
}
class Administrator extends User{
    // Attributes
    private String administratorId;

    // parametrized Constructor
    public Administrator(String name, String email, String password, String CNIC, String administratorId){
        super(name, email, password, CNIC);
        this.administratorId = administratorId;
    }
    // Methods
    public void managePartnership(Partnership partnership, ArrayList<Room> rooms) {
        // Assuming the partnership is established
        // Add rooms provided by partners to the inventory
        for (Room room : rooms) {
            Inventory.addRoom(room);
        }
        System.out.println("Rooms provided by the partner have been added to the inventory.");
    }

    public void manageInventory(String action, Room room) {
        switch (action.toLowerCase()) {
            case "add":
                Inventory.addRoom(room);
                System.out.println("Room added to inventory: " + room.getRoomId());
                break;
            case "remove":
                Inventory.removeRoom(room);
                System.out.println("Room removed from inventory: " + room.getRoomId());
                break;
            case "update":
                // Assuming the room already exists in the inventory
                Inventory.updateRoom(room);
                System.out.println("Room updated in inventory: " + room.getRoomId());
                break;
            default:
                System.out.println("Invalid action. Please specify 'add', 'remove', or 'update'.");
        }
    }
}


