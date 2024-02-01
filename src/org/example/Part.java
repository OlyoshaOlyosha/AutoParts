package org.example;

public class Part {
    public String id;
    public String name;
    public int quantity;
    public int price;
    public int weight;

    public Part(String id, String name, int quantity, int price, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.weight = weight;
    }
}