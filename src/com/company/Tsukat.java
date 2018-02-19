package com.company;

public class Tsukat {
    private String name;
    private int weight;
    private int price;
    private int quantity;

    Tsukat(String name, int weight, int price, int quantity){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
