package org.example.decorator;

public class Main {
    public static void main(String[] args) {
        House house = new BrickHouse();
        house = new SecondFloor(house);
        System.out.println(house.getInfo());
        System.out.println(house.getPrice());
        house = new Garage(house);
        System.out.println(house.getInfo());
        System.out.println(house.getPrice());
    }
}
