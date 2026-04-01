import java.util.LinkedList;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        // Initializing the LinkedList to maintain the physical order of the train
        LinkedList<String> bogieList = new LinkedList<>();

        System.out.println("======================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("======================================");

        // 1. Initial Train Consist
        bogieList.add("Engine");
        bogieList.add("Sleeper");
        bogieList.add("AC");
        bogieList.add("Cargo");
        bogieList.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(bogieList);

        // 2. Inserting 'Pantry Car' at position 2
        // In Java LinkedList, index 2 is the 3rd position
        bogieList.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(bogieList);

        // 3. Removing First and Last Bogie
        bogieList.removeFirst(); // Removes 'Engine'
        bogieList.removeLast();  // Removes 'Guard'

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(bogieList);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}