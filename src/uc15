// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// GoodsBogie class
class GoodsBogie {
    private String shape;   // Rectangular or Cylindrical
    private String cargo;   // Assigned cargo

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            // Validation: Petroleum cannot go in Rectangular bogie
            if (shape.equalsIgnoreCase("Rectangular") &&
                cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                    "Unsafe Assignment: Petroleum cannot be loaded into a Rectangular bogie!"
                );
            }

            // If safe
            this.cargo = cargoType;
            System.out.println("Cargo '" + cargoType + "' assigned successfully to " + shape + " bogie.");

        } catch (CargoSafetyException e) {
            // Handle exception
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Cargo assignment attempt completed.\n");
        }
    }

    public void display() {
        System.out.println("Bogie Shape: " + shape);
        System.out.println("Cargo: " + (cargo == null ? "None" : cargo));
        System.out.println("---------------------------");
    }
}

// Main Application
public class TrainConsistApp {
    public static void main(String[] args) {

        // Safe case
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");  // ✅ Allowed
        bogie1.display();

        // Unsafe case
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");  // ❌ Exception handled
        bogie2.display();

        // Another safe case
        GoodsBogie bogie3 = new GoodsBogie("Rectangular");
        bogie3.assignCargo("Coal");       // ✅ Allowed
        bogie3.display();

        System.out.println("Program continues after handling exceptions.");
    }
}
