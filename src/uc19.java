import java.util.Arrays;
import java.util.Scanner;

public class BogieBinarySearch {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Compare using compareTo()
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true; // Found
            } 
            else if (result < 0) {
                low = mid + 1; // Search right half
            } 
            else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Unsorted input (will be sorted first)
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // Sort before binary search
        Arrays.sort(bogieIds);

        System.out.println("Sorted Bogie IDs:");
        System.out.println(Arrays.toString(bogieIds));

        // User input
        System.out.print("Enter Bogie ID to search: ");
        String key = sc.nextLine();

        // Perform search
        boolean found = binarySearch(bogieIds, key);

        // Output result
        if (found) {
            System.out.println("Bogie ID " + key + " FOUND.");
        } else {
            System.out.println("Bogie ID " + key + " NOT FOUND.");
        }

        sc.close();
    }
}
