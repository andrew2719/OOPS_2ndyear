import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        this.name = name;
        this.id = id;
        setGPA(gpa);
    }

    public void setGPA(double gpa) {
        if (gpa >= 0 && gpa <= 4.0) {
            this.gpa = gpa;
            System.out.println("GPA updated successfully.");
        } else {
            System.out.println("Invalid GPA. Please provide a value between 0 and 4.0.");
        }
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}

class MemoryLeakSimulator {
    private List<Object> memoryLeakList = new ArrayList<>();

    public void simulateMemoryLeak() {
        System.out.println("Simulating memory leak...");
        for (int i = 0; i < 100000; i++) {
            memoryLeakList.add(new Object());
        }
        System.out.println("Memory leak simulation completed.");
        System.out.println("Number of objects remaining in memoryLeakList: " + memoryLeakList.size());
    }

    public void fixMemoryLeak() {
        memoryLeakList.clear();
        System.out.println("Memory leak fixed. Objects cleared from memoryLeakList.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Student Database
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        String id = scanner.next();
        double initialGPA = scanner.nextDouble();
        
        Student student = new Student(name, id, initialGPA);
        student.displayInfo();

        int numTestCases = scanner.nextInt();
        for (int i = 0; i < numTestCases; i++) {
            double newGPA = scanner.nextDouble();
            student.setGPA(newGPA);
            student.displayInfo();
        }

        // Memory Leak Detection
        MemoryLeakSimulator simulator = new MemoryLeakSimulator();
        simulator.simulateMemoryLeak();
        
        // Uncomment the following line to fix the memory leak
        // simulator.fixMemoryLeak();

        scanner.close();
    }
}