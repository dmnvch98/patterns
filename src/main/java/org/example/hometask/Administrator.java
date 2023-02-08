package org.example.hometask;

import lombok.Builder;
import org.example.hometask.executors.Executor;

import java.util.List;

public class Administrator implements RequestHandler {
    private final List<Executor> executors;
    private final String name;
    private Executor canHandleRequestExecutor;

    @Builder
    public Administrator(List<Executor> executors, String name) {
        this.executors = executors;
        this.name = name;
    }

    @Override
    public boolean canHandleRequest(Request req) {
        canHandleRequestExecutor = executors.stream()
            .filter(executor -> executor.canHandleRequest(req))
            .findFirst().orElse(null);
        if (canHandleRequestExecutor != null) {
            System.out.println("Admin " + name + " found executor who can execute task :)");
            return true;
        }
        System.out.println("Admin " + name + " didn't find executor who can execute task :(");
        return false;
    }

    @Override
    public Request handle(Request req) {
        if (canHandleRequestExecutor != null) {
            return canHandleRequestExecutor.handle(req);
        }
        return req;
    }
}
