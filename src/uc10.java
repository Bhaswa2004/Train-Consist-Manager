import java.util.*;
import java.util.stream.*;

// Bogie class
class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
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

        // Step 1: Create list (reuse previous UC data)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Step 2: Calculate total seats using map + reduce
        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)     // extract capacity
                .reduce(0, Integer::sum);   // aggregate sum

        // Step 3: Display result
        System.out.println("Total Seating Capacity of Train: " + totalSeats);

        // Step 4: Original list unchanged
        System.out.println("\nBogies List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}}
