package org.example.hometask;

public interface RequestHandler {
    boolean canHandleRequest(Request req);

    Request handle(Request req);
}