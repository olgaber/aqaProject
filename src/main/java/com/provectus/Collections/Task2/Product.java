package com.provectus.Collections.Task2;

import java.util.Collections;
import java.util.Comparator;

public class Product{
    private String name;
    private int qty;

    private double price;

    public Product(String name, int qty, double price){
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name = " + name +", Quantity = " + qty + ", Price = " + price + "\n";
    }

}

class ComparatorByName implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ComparatorByPrice implements Comparator<Product>{
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()){
            return 1;
        }
        else if (o1.getPrice() < o2.getPrice()){
            return -1;
        }
        else return 0;
    }
}
