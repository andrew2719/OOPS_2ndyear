import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get customer details
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        System.out.println("Enter customer email:");
        String email = scanner.nextLine();
        System.out.println("Enter customer address:");
        String address = scanner.nextLine();

        Customer customer = new Customer(name, email, address);

        // Get number of products
        System.out.println("Enter the number of products:");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order order = new Order(customer);

        // Get product details and add to order
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter product details (ID, name, price, quantity):");
            String[] productDetails = scanner.nextLine().split(" ");
            int id = Integer.parseInt(productDetails[0]);
            String productName = productDetails[1];
            double price = Double.parseDouble(productDetails[2]);
            int quantity = Integer.parseInt(productDetails[3]);

            Product product = new Product(id, productName, price, quantity);
            order.addProduct(product);
        }

        // Display order summary
        System.out.println("\nOrder Summary:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Total Price: $" + order.getTotalPrice());

        scanner.close();
    }
}

class Customer {
    private String name;
    private String email;
    private String address;

    public Customer(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}

class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Order {
    private static int nextOrderId = 1;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.orderId = nextOrderId++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        return products.stream()
                .mapToDouble(p -> p.getPrice() * p.getQuantity())
                .sum();
    }

    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}