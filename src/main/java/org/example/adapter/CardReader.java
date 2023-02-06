package org.example.adapter;

public class CardReader implements USB {
    private final MicroUsb microUsb;

    public CardReader(MicroUsb microUsb) {
        this.microUsb = microUsb;
    }
    @Override
    public void connectWithUSBCable() {
        microUsb.connectToComputer();
        microUsb.sendData("Photo 1", "Photo 2");
    }
}
