package org.example.patternshometask.requests;

public interface RequestHandler {
    boolean canHandleRequest(Request req);

    Request handle(Request req);
}