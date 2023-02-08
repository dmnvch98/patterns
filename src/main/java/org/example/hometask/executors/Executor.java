package org.example.hometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.hometask.Request;
import org.example.hometask.RequestHandler;

@SuperBuilder
public abstract class Executor implements RequestHandler {
    @Override
    public abstract boolean canHandleRequest(Request req);

    @Override
    public abstract Request handle(Request req);
}
