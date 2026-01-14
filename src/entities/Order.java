package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
    private long id;
    private Status status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order(Status status, LocalDate orderDate, List<Product> products, Customer customer){
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 100000000);
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = orderDate.plusDays(5);
        this.products = products;
        this.customer = customer;
    }

    public long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status=" + status +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
