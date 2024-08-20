import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.print("Enter the Dividend Number: ");
        double dividend = scanner.nextDouble();

        System.out.print("Enter the Divisor Number: ");
        double divisor = scanner.nextDouble();

        try {
            double result = calculator.divide(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}

class Calculator {
    public double divide(double dividend, double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return dividend / divisor;
    }
}