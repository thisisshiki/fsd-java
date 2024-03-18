package lecture6;

import utils.In;

public class Product {
    private String type;
    private double price;
    private int quantity;

    public Product(String type, double price, int quantity) {
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }

    public Product() {
        this.type = readType();
        this.price = readPrice();
        this.quantity = readQuantity();
    }

    private String readType() {
        System.out.print("Type: ");
        return In.nextLine();
    }

    private double readPrice() {
        System.out.print("Price: ");
        return In.nextDouble();
    }

    private int readQuantity() {
        System.out.print("Quantity: ");
        return In.nextInt();
    }

    public boolean isEmpty() {
        return this.quantity == 0;
    }

    public double stocked(int quantity) {
        this.quantity += quantity;
        return this.price * quantity;
    }

    public double sold(int quantity) {
        this.quantity -= quantity;
        return this.price * quantity;
    }

    public boolean has(int quantity) {
        return this.quantity >= quantity;
    }

    public double cash(int quantity) {
        return this.price * quantity;
    }

    @Override
    public String toString() {
        String formatted = String.format("%.2f", this.price);
        String output = this.type;
        output += (this.quantity > 0) ? " level: " + this.quantity + " at price $" + formatted
                : " stock level: " + this.quantity;
        return output;
    }   
   
}
