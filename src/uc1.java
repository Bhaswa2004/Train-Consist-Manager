import java.util.ArrayList;
import java.util.List;

public class uc1 {

    public static void main(String[] args) {

        // Step 1: Print welcome message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("UC1: Initialize Train and Display Consist Summary");
        System.out.println();

        // Step 2: Initialize empty train consist using ArrayList
        List<String> trainConsist = new ArrayList<>();

        // Step 3: Display initial bogie count
        System.out.println("Train consist initialized.");
        System.out.println("Initial number of bogies: " + trainConsist.size());

        // Step 4: Program continues
        System.out.println("Program ready for further operations...");
    }
}