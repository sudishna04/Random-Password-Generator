import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+[]{}|;:,.<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        System.out.print("Include lowercase characters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase characters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include numeric characters? (yes/no): ");
        boolean includeNumeric = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        if (!includeLowercase && !includeUppercase && !includeNumeric && !includeSpecial) {
            System.out.println("At least one character type should be included.");
            return;
        }

        String availableCharacters = "";
        if (includeLowercase) {
            availableCharacters += LOWERCASE_CHARACTERS;
        }
        if (includeUppercase) {
            availableCharacters += UPPERCASE_CHARACTERS;
        }
        if (includeNumeric) {
            availableCharacters += NUMERIC_CHARACTERS;
        }
        if (includeSpecial) {
            availableCharacters += SPECIAL_CHARACTERS;
        }

        String password = generateRandomPassword(length, availableCharacters);
        System.out.println("Generated Password: " + password);
    }

    private static String generateRandomPassword(int length, String availableCharacters) {
        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(availableCharacters.length());
            char randomChar = availableCharacters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
