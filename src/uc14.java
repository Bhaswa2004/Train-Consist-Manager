import java.util.ArrayList;
import java.util.List;

// Custom Exception for Invalid Capacity
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    String name;
    int capacity;

    // Constructor validates capacity
    PassengerBogie(String name, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero. Provided: " + capacity);
        }
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class uc14 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            // Valid bogie
            PassengerBogie sleeper = new PassengerBogie("Sleeper", 72);
            bogies.add(sleeper);

            // Invalid bogie (should throw exception)
            PassengerBogie faulty = new PassengerBogie("First Class", 0);
            bogies.add(faulty);

        } catch (InvalidCapacityException e) {
            System.out.println("Error creating bogie: " + e.getMessage());
        }

        // Display valid bogies
        System.out.println("Current Train Consist:");
        for (PassengerBogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("Program continues safely...");
    }
}
