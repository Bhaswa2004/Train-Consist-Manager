import java.util.LinkedHashSet;
import java.util.Set;

public class uc5 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC5: Preserve Insertion Order of Bogies (LinkedHashSet)");
        System.out.println();

        // Step 1: Create LinkedHashSet for train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Step 2: Add bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Step 3: Attempt to add duplicate
        trainFormation.add("Sleeper"); // duplicate

        // Step 4: Display final formation
        System.out.println("Final Train Formation:");
        System.out.println(trainFormation);

        System.out.println("\nDuplicates are not allowed, and order is preserved!");
    }
}
