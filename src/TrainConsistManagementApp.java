import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " -> " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("================================\n");

        // Step 1: User creates a list of bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // Steps 2, 3, 4: Convert to stream, apply groupingBy(), and store in Map
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Step 5: Display grouped result
        System.out.println("\nGrouped Bogies:\n");
        groupedBogies.forEach((type, list) -> {
            System.out.println("Bogie Type: " + type);
            list.forEach(b -> System.out.println("  Capacity -> " + b.getCapacity()));
            System.out.println();
        });

        System.out.println("UC9 grouping completed...");
    }
}