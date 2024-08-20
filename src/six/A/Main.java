import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input student information
        String name = scanner.nextLine();
        String id = scanner.nextLine();
        double initialGpa = scanner.nextDouble();

        Student student = new Student(name, id, initialGpa);
        student.displayInfo();

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            double newGpa = scanner.nextDouble();
            if (student.updateGPA(newGpa)) {
                System.out.println("GPA updated successfully.");
            } else {
                System.out.println("Invalid GPA. Please provide a value between 0 and 4.0.");
            }
            student.displayInfo();
        }

        scanner.close();
    }
}

class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = (gpa >= 0 && gpa <= 4.0) ? gpa : 0;
    }

    public boolean updateGPA(double newGpa) {
        if (newGpa >= 0 && newGpa <= 4.0) {
            this.gpa = newGpa;
            return true;
        }
        return false;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}