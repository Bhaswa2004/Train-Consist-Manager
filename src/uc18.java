import java.util.Scanner;

public class BogieSearch {

    // Linear Search Method
    public static boolean linearSearch(String[] bogieIds, String key) {

        for (int i = 0; i < bogieIds.length; i++) {

            // Compare using equals()
            if (bogieIds[i].equals(key)) {
                return true; // Found → stop early
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Array of Bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Display available IDs
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println();

        // User input
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        // Perform search
        boolean found = linearSearch(bogieIds, searchKey);

        // Output result
        if (found) {
            System.out.println("Bogie ID " + searchKey + " FOUND.");
        } else {
            System.out.println("Bogie ID " + searchKey + " NOT FOUND.");
        }

        sc.close();
    }
}
