import java.util.LinkedList;

public class uc4 {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC4: Maintain Ordered Bogie IDs (LinkedList)");
        System.out.println();

        // Step 1: Create LinkedList for train consist
        LinkedList<String> trainConsist = new LinkedList<>();

        // Step 2: Add bogies
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Step 3: Insert Pantry Car at position 2 (index 1)
        trainConsist.add(1, "Pantry Car");

        // Step 4: Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        // Step 5: Display final ordered consist
        System.out.println("Final Train Consist:");
        System.out.println(trainConsist);

        System.out.println("\nOrder is maintained using LinkedList!");
    }
}
