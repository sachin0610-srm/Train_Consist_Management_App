import java.util.Scanner;
import java.util.regex.Pattern;

public class TrainValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");
        System.out.println();

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        boolean isTrainIdValid = Pattern.matches("TRN-\\d{4}", trainId);
        boolean isCargoCodeValid = Pattern.matches("PET-[A-Z]{2}", cargoCode);

        System.out.println();
        System.out.println("Validation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);
        System.out.println();
        System.out.println("UC11 validation completed...");

        scanner.close();
    }
}