import java.util.ArrayList;
import java.util.List;

public class uc2 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC2: Add Passenger Bogies to Train");
        System.out.println();

        // Step 1: Create ArrayList for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // Step 2: Add bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Step 3: Display bogies
        System.out.println("Passenger bogies after addition:");
        System.out.println(passengerBogies);

        // Step 4: Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Step 5: Check existence of "Sleeper"
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nDoes Sleeper exist? " + exists);

        // Step 6: Display final list
        System.out.println("\nPassenger bogies after removal:");
        System.out.println(passengerBogies);

        System.out.println("\nProgram continues...");
    }
}
