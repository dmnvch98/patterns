package org.example.hometask;

public interface RequestHandler {
    boolean canHandleRequest(Request req);

    void handle(Request req);
}