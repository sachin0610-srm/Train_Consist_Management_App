import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Bogie {
    private String id;
    private int capacity;

    public Bogie(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

public class PerformanceComparisonApp {
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("B" + i, (int) (Math.random() * 100)));
        }

        long startTimeLoop = System.nanoTime();
        List<Bogie> filteredWithLoop = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                filteredWithLoop.add(b);
            }
        }
        long durationLoop = System.nanoTime() - startTimeLoop;

        long startTimeStream = System.nanoTime();
        List<Bogie> filteredWithStream = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
        long durationStream = System.nanoTime() - startTimeStream;

        System.out.println("=======================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("=======================================");
        System.out.println();
        System.out.println("Loop Execution Time (ns): " + durationLoop);
        System.out.println("Stream Execution Time (ns): " + durationStream);
        System.out.println();
        System.out.println("UC13 performance benchmarking completed...");
    }
}