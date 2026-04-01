import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        Set<String> bogieIds = new HashSet<>();

        System.out.println("===============================");
        System.out.println("UC3 - Track Unique Bogie IDs");
        System.out.println("===============================");
        System.out.println();

        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG104");
        bogieIds.add("BG101");

        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);
        System.out.println();

        System.out.println("Note:");
        System.out.println("Duplicates are automatically ignored by HashSet.");
        System.out.println();
        System.out.println("UC3 uniqueness validation completed...");
    }
}