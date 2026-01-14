package entities;

import java.util.Random;

public class Product {
    private long id;
    private String name;
    private Category category;
    private double price;

    public Product(String name, Category category, double price){
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 100000000);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPrice10(double price) {
        this.price = price / 100 * 90;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                '}';
    }
}
