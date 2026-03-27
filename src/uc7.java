import java.util.*;

// Bogie class
class Bogie {
    String name;
    int capacity;

    // Constructor
    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    // Display method
    @Override
    public String toString() {
        return name + " - Capacity: " + capacity;
    }
}

// Main class
public class uc7 {
    public static void main(String[] args) {

        // Step 1: Create List
        List<Bogie> bogies = new ArrayList<>();

        // Step 2: Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Step 3: Sort using Comparator (ascending order)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // If you want descending order, use this instead:
        // bogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());

        // Step 4: Display sorted bogies
        System.out.println("Bogies sorted by capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}
