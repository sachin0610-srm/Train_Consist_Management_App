import java.util.Arrays;
import java.util.List;

class Bogie {
    String type;
    int capacity;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }
}

public class TrainAggregation {
    public static void main(String[] args) {
        // Data input matching the document screenshot
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        System.out.println("=======================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("=======================================");
        System.out.println("\nBogies in Train:");

        // Printing each bogie details
        bogies.forEach(b -> System.out.println(b.getType() + " -> " + b.getCapacity()));

        // Stream API: map() to get capacities and reduce() to sum them
        int totalSeatingCapacity = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        System.out.println("\nTotal Seating Capacity of Train: " + totalSeatingCapacity);
        System.out.println("\nUC10 aggregation completed...");
    }
}