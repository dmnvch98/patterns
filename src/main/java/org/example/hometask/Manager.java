package org.example.hometask;


public abstract class Manager {
    abstract void makeRequest(Request command);

    public void receiveRequest(Request command) {}
}
