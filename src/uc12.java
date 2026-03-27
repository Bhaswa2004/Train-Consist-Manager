import java.util.ArrayList;
import java.util.List;

// GoodsBogie class with type and cargo
class GoodsBogie {
    String type;   // e.g., Cylindrical, Box
    String cargo;  // e.g., Petroleum, Coal

    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return type + " -> " + cargo;
    }
}

public class UC12 {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Create list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));

        // Validate using stream + allMatch
        boolean safe = goodsBogies.stream()
                .allMatch(b -> {
                    // Cylindrical bogie can carry only Petroleum
                    if (b.type.equals("Cylindrical")) {
                        return b.cargo.equals("Petroleum");
                    }
                    // Other bogies can carry anything
                    return true;
                });

        // Display result
        if (safe) {
            System.out.println("Train formation is safety compliant.");
        } else {
            System.out.println("Train formation is NOT safety compliant!");
        }

        // Program continues...
    }
}
