package entities;

import java.util.Random;

public class Customer {
    private long id;
    private String name;
    private int tier;

    public Customer(String name, int tier){
        Random rndm = new Random();
        this.id = rndm.nextInt(1, 100000000);
        this.name = name;
        if(tier < 0) {
            this.tier = 0;
        } else if(tier > 5) {
            this.tier = 5;
        } else {
            this.tier = tier;
        }
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

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
