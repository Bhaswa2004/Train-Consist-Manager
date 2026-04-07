import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App - UC20
 * Exception Handling During Search Operations
 * 
 * This class demonstrates defensive programming by validating the state
 * before performing search operations and throwing IllegalStateException
 * when the bogie collection is empty.
 */
public class TrainConsistManagement {
    
    private List<String> bogies;
    private String trainName;
    
    /**
     * Constructor to initialize an empty train consist
     * @param trainName The name/identifier of the train
     */
    public TrainConsistManagement(String trainName) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>();
    }
    
    /**
     * Constructor to initialize train consist with existing bogies
     * @param trainName The name/identifier of the train
     * @param bogies List of bogie IDs to initialize
     */
    public TrainConsistManagement(String trainName, List<String> bogies) {
        this.trainName = trainName;
        this.bogies = new ArrayList<>(bogies);
    }
    
    /**
     * Adds a bogie to the train consist
     * @param bogieId The unique identifier of the bogie
     */
    public void addBogie(String bogieId) {
        if (bogieId == null || bogieId.trim().isEmpty()) {
            throw new IllegalArgumentException("Bogie ID cannot be null or empty");
        }
        bogies.add(bogieId);
        System.out.println("Added bogie: " + bogieId);
    }
    
    /**
     * Removes a bogie from the train consist
     * @param bogieId The unique identifier of the bogie to remove
     * @return true if bogie was found and removed, false otherwise
     */
    public boolean removeBogie(String bogieId) {
        return bogies.remove(bogieId);
    }
    
    /**
     * Searches for a bogie in the train consist with defensive validation
     * 
     * @param bogieId The bogie ID to search for
     * @return true if the bogie exists, false otherwise
     * @throws IllegalStateException if the bogie collection is empty
     * @throws IllegalArgumentException if the bogieId is null or empty
     */
    public boolean searchBogie(String bogieId) {
        // Validate input parameter
        if (bogieId == null || bogieId.trim().isEmpty()) {
            throw new IllegalArgumentException("Search bogie ID cannot be null or empty");
        }
        
        // STATE VALIDATION - Check if bogie collection is empty
        // This implements the fail-fast principle
        if (bogies.isEmpty()) {
            throw new IllegalStateException(
                "Cannot perform search operation. No bogies exist in train '" + 
                trainName + "'. Please add bogies before searching."
            );
        }
        
        // Search logic - only executes if validation passes
        boolean found = bogies.contains(bogieId);
        
        if (found) {
            System.out.println("Bogie " + bogieId + " found in train '" + trainName + "'");
        } else {
            System.out.println("Bogie " + bogieId + " not found in train '" + trainName + "'");
        }
        
        return found;
    }
    
    /**
     * Gets the current number of bogies in the train
     * @return number of bogies
     */
    public int getBogieCount() {
        return bogies.size();
    }
    
    /**
     * Checks if the train has any bogies
     * @return true if no bogies exist, false otherwise
     */
    public boolean isEmpty() {
        return bogies.isEmpty();
    }
    
    /**
     * Displays all bogies in the train
     */
    public void displayAllBogies() {
        if (bogies.isEmpty()) {
            System.out.println("Train '" + trainName + "' has no bogies.");
        } else {
            System.out.println("Train '" + trainName + "' bogies: " + bogies);
        }
    }
    
    /**
     * Main method to demonstrate the functionality
     */
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App - UC20 ===\n");
        
        // Test Case 1: Exception when searching empty train
        System.out.println("--- Test Case 1: Exception When Empty Data ---");
        TrainConsistManagement emptyTrain = new TrainConsistManagement("Express-101");
        emptyTrain.displayAllBogies();
        
        try {
            System.out.println("\nAttempting to search for 'BG101' in empty train...");
            emptyTrain.searchBogie("BG101");
        } catch (IllegalStateException e) {
            System.out.println("✓ Exception caught as expected: " + e.getMessage());
        }
        
        // Test Case 2: Search allowed when data exists
        System.out.println("\n--- Test Case 2: Search Allowed When Data Exists ---");
        TrainConsistManagement trainWithData = new TrainConsistManagement("Rajdhani-202");
        trainWithData.addBogie("BG101");
        trainWithData.addBogie("BG205");
        trainWithData.addBogie("BG309");
        trainWithData.displayAllBogies();
        
        try {
            System.out.println("\nSearching for 'BG101'...");
            boolean found = trainWithData.searchBogie("BG101");
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        // Test Case 3: Search match found after validation
        System.out.println("\n--- Test Case 3: Search Match Found After Validation ---");
        try {
            System.out.println("Searching for 'BG205'...");
            boolean found = trainWithData.searchBogie("BG205");
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        // Test Case 4: Search match not found after validation
        System.out.println("\n--- Test Case 4: Search Match Not Found After Validation ---");
        try {
            System.out.println("Searching for 'BG999'...");
            boolean found = trainWithData.searchBogie("BG999");
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        // Test Case 5: Single element valid case
        System.out.println("\n--- Test Case 5: Single Element Valid Case ---");
        TrainConsistManagement singleBogieTrain = new TrainConsistManagement("Local-303");
        singleBogieTrain.addBogie("BG101");
        singleBogieTrain.displayAllBogies();
        
        try {
            System.out.println("\nSearching for 'BG101' in single bogie train...");
            boolean found = singleBogieTrain.searchBogie("BG101");
            System.out.println("Result: " + found);
            
            System.out.println("\nSearching for 'BG999' in single bogie train...");
            found = singleBogieTrain.searchBogie("BG999");
            System.out.println("Result: " + found);
        } catch (IllegalStateException e) {
            System.out.println("Unexpected exception: " + e.getMessage());
        }
        
        // Additional demonstration: Parameter validation
        System.out.println("\n--- Additional: Parameter Validation ---");
        try {
            System.out.println("Attempting to search with null ID...");
            trainWithData.searchBogie(null);
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Exception caught as expected: " + e.getMessage());
        }
        
        System.out.println("\n=== Program Execution Complete ===");
    }
}

/**
 * JUnit-style test class for validating the implementation
 * (For manual testing or to be used with JUnit framework)
 */
class TrainConsistManagementTests {
    
    private TrainConsistManagement train;
    
    void setUp() {
        train = new TrainConsistManagement("TestTrain");
    }
    
    void testSearch_ThrowsExceptionWhenEmpty() {
        System.out.println("\n[Test] testSearch_ThrowsExceptionWhenEmpty");
        setUp();
        try {
            train.searchBogie("BG101");
            System.out.println("FAILED: Expected IllegalStateException was not thrown");
        } catch (IllegalStateException e) {
            System.out.println("PASSED: IllegalStateException thrown as expected");
            System.out.println("  Message: " + e.getMessage());
        }
    }
    
    void testSearch_AllowsSearchWhenDataExists() {
        System.out.println("\n[Test] testSearch_AllowsSearchWhenDataExists");
        setUp();
        train.addBogie("BG101");
        train.addBogie("BG205");
        
        try {
            boolean result = train.searchBogie("BG101");
            System.out.println("PASSED: Search executed without exception, result: " + result);
        } catch (IllegalStateException e) {
            System.out.println("FAILED: Unexpected exception: " + e.getMessage());
        }
    }
    
    void testSearch_BogieFoundAfterValidation() {
        System.out.println("\n[Test] testSearch_BogieFoundAfterValidation");
        setUp();
        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");
        
        boolean result = train.searchBogie("BG205");
        if (result) {
            System.out.println("PASSED: Bogie found as expected, result: " + result);
        } else {
            System.out.println("FAILED: Bogie not found when it should exist");
        }
    }
    
    void testSearch_BogieNotFoundAfterValidation() {
        System.out.println("\n[Test] testSearch_BogieNotFoundAfterValidation");
        setUp();
        train.addBogie("BG101");
        train.addBogie("BG205");
        train.addBogie("BG309");
        
        boolean result = train.searchBogie("BG999");
        if (!result) {
            System.out.println("PASSED: Bogie correctly not found, result: " + result);
        } else {
            System.out.println("FAILED: Bogie found when it shouldn't exist");
        }
    }
    
    void testSearch_SingleElementValidCase() {
        System.out.println("\n[Test] testSearch_SingleElementValidCase");
        setUp();
        train.addBogie("BG101");
        
        boolean result = train.searchBogie("BG101");
        if (result) {
            System.out.println("PASSED: Bogie found in single-element train, result: " + result);
        } else {
            System.out.println("FAILED: Bogie not found in single-element train");
        }
    }
    
    void runAllTests() {
        System.out.println("\n=== Running All Tests ===");
        testSearch_ThrowsExceptionWhenEmpty();
        testSearch_AllowsSearchWhenDataExists();
        testSearch_BogieFoundAfterValidation();
        testSearch_BogieNotFoundAfterValidation();
        testSearch_SingleElementValidCase();
        System.out.println("\n=== All Tests Completed ===");
    }
    
    public static void main(String[] args) {
        TrainConsistManagementTests tests = new TrainConsistManagementTests();
        tests.runAllTests();
    }
}
