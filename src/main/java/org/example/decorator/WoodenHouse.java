package org.example.decorator;

public class WoodenHouse extends House {
    public WoodenHouse() {
        info = "Wooden house";
    }

    @Override
    public int getPrice() {
        return 15000;
    }
}
