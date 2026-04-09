import java.util.ArrayList;
import java.util.List;

class Bogie {
    String type;
    String cargo;

    Bogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
}

public class SafetyCheckApp {
    public static void main(String[] args) {

        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Cylindrical", "Petroleum"));
        train.add(new Bogie("Open", "Coal"));
        train.add(new Bogie("Box", "Grain"));
        train.add(new Bogie("Cylindrical", "Coal")); // This triggers the safety violation

        System.out.println("==========================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("==========================================\n");

        System.out.println("Goods Bogies in Train:");
        train.forEach(b -> System.out.println(b.type + " -> " + b.cargo));

        boolean isSafe = train.stream().allMatch(b ->
                !b.type.equalsIgnoreCase("Cylindrical") || b.cargo.equalsIgnoreCase("Petroleum")
        );

        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (!isSafe) {
            System.out.println("Train formation is NOT SAFE.");
        } else {
            System.out.println("Train formation is SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}