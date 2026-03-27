import java.util.*;
import java.util.stream.Collectors;

// Bogie class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

// Main class
public class TrainConsistApp {
    public static void main(String[] args) {

        // Step 1: Create list (can reuse from UC7/UC8)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70)); // duplicate type for grouping
        bogies.add(new Bogie("AC Chair", 60));

        // Step 2: Group bogies by type (name)
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Step 3: Display grouped result
        System.out.println("Grouped Bogies by Type:\n");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
            System.out.println();
        }

        // Step 4: Original list remains unchanged
        System.out.println("Original Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}
