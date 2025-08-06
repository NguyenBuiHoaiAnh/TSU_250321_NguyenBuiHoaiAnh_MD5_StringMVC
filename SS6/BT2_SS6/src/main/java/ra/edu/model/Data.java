package ra.edu.model;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Product> productsList = new ArrayList<>();

    static {
        productsList.add(new Product(1, "Laptop", 1500.0, "Powerful laptop", "images/laptop.png"));
        productsList.add(new Product(2, "Smartphone", 700.0, "Latest smartphone", "images/phone.png"));
        productsList.add(new Product(3, "Tablet", 500.0, "High-res tablet", "images/tablet.png"));
        productsList.add(new Product(4, "Monitor", 300.0, "HD monitor", "images/monitor.png"));
        productsList.add(new Product(5, "Keyboard", 50.0, "Mechanical keyboard", "images/keyboard.png"));
        productsList.add(new Product(6, "Mouse", 30.0, "Wireless mouse", "images/mouse.png"));
        productsList.add(new Product(7, "Printer", 200.0, "Laser printer", "images/printer.png"));
        productsList.add(new Product(8, "Camera", 900.0, "Digital camera", "images/camera.png"));
        productsList.add(new Product(9, "Speaker", 100.0, "Bluetooth speaker", "images/speaker.png"));
        productsList.add(new Product(10, "Router", 120.0, "WiFi router", "images/router.png"));
    }

}
