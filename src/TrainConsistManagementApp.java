import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();

        System.out.println("Initializing Train...");
        System.out.println("Current Bogie Count: " + trainConsist.size());

        if (trainConsist.isEmpty()) {
            System.out.println("Status: The train is currently empty (Engine only).");
        } else {
            System.out.println("Current Consist: " + trainConsist);
        }

        System.out.println("\nProgram ready for further operations.");
    }
}