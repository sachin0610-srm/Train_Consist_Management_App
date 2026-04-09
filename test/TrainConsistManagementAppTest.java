import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Mock Bogie class for testing purposes
class Bogie {
    int capacity;
    String type;

    Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

class TrainConsistManagementAppTest {

    /**
     * testReduce_TotalSeatCalculation()
     * Verifies that the reduce operation correctly calculates the total seating capacity
     * of all bogies.
     */
    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 50),
                new Bogie("First Class", 24)
        );

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(146, totalSeats, "The total seating capacity should be the sum of all bogies.");
    }

    /**
     * testReduce_EmptyBogieList()
     * Verifies that aggregation on an empty bogie list returns the default identity value.
     */
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(0, totalSeats, "The resulting total seating capacity for an empty list should be 0[cite: 1].");
    }

    /**
     * testReduce_SingleBogieCapacity()
     * Verifies behavior when only one bogie exists in the list[cite: 1].
     */
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72));

        int totalSeats = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(72, totalSeats, "Total capacity should match the single bogie's capacity[cite: 1].");
    }

    /**
     * testReduce_OriginalListUnchanged()
     * Verifies that the original bogie list remains unchanged after performing the aggregation[cite: 1].
     */
    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = Arrays.asList(new Bogie("Sleeper", 72), new Bogie("AC Chair", 50));
        int originalSize = bogies.size();

        bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        assertEquals(originalSize, bogies.size(), "The original list size should remain unchanged[cite: 1].");
    }
}