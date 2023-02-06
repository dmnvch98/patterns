package org.example.adapter;

import java.util.Arrays;

public class MicroUsb {
    public void connectToComputer() {
        System.out.println("Connected to computer");
    }
    public void sendData(String... data) {
        System.out.println("Data sent: " + Arrays.toString(data));
    }
}
