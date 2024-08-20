import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the combined string: ");
        String combinedString = scanner.nextLine().toLowerCase();

        System.out.print("Enter the name: ");
        String name = scanner.nextLine().toLowerCase();

        String surname = extractSurname(combinedString, name);

        System.out.println("Name: " + capitalizeFirstLetter(name));
        System.out.println("Surname: " + capitalizeFirstLetter(surname));

        scanner.close();
    }

    public static String extractSurname(String combinedString, String name) {
        int nameIndex = combinedString.indexOf(name);
        String prefix = combinedString.substring(0, nameIndex);
        String suffix = combinedString.substring(nameIndex + name.length());
        
        return prefix + suffix;
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}