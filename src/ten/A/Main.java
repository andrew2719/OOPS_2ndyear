import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final List<Customer> customers = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            addCustomer();
            printMemoryUsage();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void addCustomer() {
        customers.add(new Customer(generateLargeData()));
    }

    private static byte[] generateLargeData() {
        byte[] data = new byte[1024 * 1024]; // 1MB of data
        random.nextBytes(data);
        return data;
    }

    private static void printMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used Memory: " + usedMemory / (1024 * 1024) + " MB");
    }
}

class Customer {
    private byte[] data;

    public Customer(byte[] data) {
        this.data = data;
    }
}