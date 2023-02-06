package org.example.decorator;

public class SecondFloor extends HouseDecorator {
    House house;

    public SecondFloor(House house) {
        this.house = house;
    }

    @Override
    public int getPrice() {
        return house.getPrice() + 20_000;
    }

    @Override
    public String getInfo() {
       return house.getInfo() + " + второй этаж";
    }
}
