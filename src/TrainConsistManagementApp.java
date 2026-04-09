public class TrainConsistApp {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("==========================================\n");

        try {
            // Valid Case
            String type1 = "Sleeper";
            int capacity1 = 72;
            if (capacity1 <= 0) throw new InvalidCapacityException("Capacity must be greater than zero");
            System.out.println("Created Bogie: " + type1 + " -> " + capacity1);

            // Invalid Case
            int capacity2 = -10; // Or 0
            if (capacity2 <= 0) throw new InvalidCapacityException("Capacity must be greater than zero");

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}