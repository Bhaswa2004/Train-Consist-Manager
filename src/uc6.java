import java.util.HashMap;
import java.util.Map;

public class uc6 {
    public static void main(String[] args) {
        // Create a HashMap to store bogie-capacity mapping
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert capacity values for bogies using put() method
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 78);
        bogieCapacityMap.put("First Class", 48);
        bogieCapacityMap.put("Rectangular Goods", 2500);
        bogieCapacityMap.put("Cylindrical Goods", 1800);

        // Iterate over the map using entrySet() and display each bogie with its capacity
        System.out.println("=== Train Consist - Bogie Capacity Details ===\n");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieName = entry.getKey();
            Integer capacity = entry.getValue();

            // Determine the capacity type based on bogie name
            if (bogieName.contains("Sleeper") || bogieName.contains("AC") || bogieName.contains("First")) {
                System.out.println("Bogie: " + bogieName + " | Seating Capacity: " + capacity + " passengers");
            } else {
                System.out.println("Bogie: " + bogieName + " | Load Capacity: " + capacity + " tons");
            }
        }

        // Demonstrate fast lookup using HashMap
        System.out.println("\n=== Fast Lookup Example ===");
        String searchBogie = "Sleeper";
        Integer capacity = bogieCapacityMap.get(searchBogie);
        if (capacity != null) {
            System.out.println("Capacity of " + searchBogie + " bogie: " + capacity + " passengers");
        } else {
            System.out.println("Bogie not found: " + searchBogie);
        }

        // Show total number of bogies in the consist
        System.out.println("\n=== Summary ===");
        System.out.println("Total number of bogies in consist: " + bogieCapacityMap.size());
    }
}
