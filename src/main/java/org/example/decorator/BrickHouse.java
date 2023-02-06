package org.example.decorator;

public class BrickHouse extends House{
    public BrickHouse() {
        info = "Brick house";
    }
    @Override
    public int getPrice() {
        return 20000;
    }

}
