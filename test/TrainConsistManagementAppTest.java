import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementAppTest {

    class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() { return type; }
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(groupedBogies.containsKey("Sleeper"));
        assertTrue(groupedBogies.containsKey("AC Chair"));
        assertEquals(2, groupedBogies.get("Sleeper").size());
    }

    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(2, groupedBogies.get("Sleeper").size());
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = Collections.emptyList();

        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));

        assertTrue(groupedBogies.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>(Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("First Class", 24)
        ));
        int originalSize = bogies.size();

        bogies.stream().collect(Collectors.groupingBy(Bogie::getType));

        assertEquals(originalSize, bogies.size());
    }
}