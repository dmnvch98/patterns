package org.example.adapter;

public class Main {
    public static void main(String[] args) {
        USB usb = new CardReader(new MicroUsb());
        usb.connectWithUSBCable();
    }
}
