package com.example.thinkinginjava.generic;

import com.example.thinkinginjava.util.Generator;

import java.util.ArrayList;
import java.util.Random;

class Product {
    private final int id;
    private String description;
    private double price;
    public Product(int id, String desc, double pri) {
        this.id = id;
        description = desc;
        price = pri;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);
        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    public Aisle(int nShelves, int nProducts) {
        for(int i = 0; i < nShelves; i ++) {
            add(new Shelf(nProducts));
        }
    }
}

public class Store extends ArrayList<Aisle> {
    public Store(int nAisles, int nShelves, int nProducts) {
        for(int i = 0; i < nAisles; i ++) {
            add(new Aisle(nShelves, nProducts));
        }
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        for(Aisle a : this) {
            for(Shelf s : a) {
                for (Product p: s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();
    }
}