package org.example.patternshometask.managers;

import lombok.Builder;
import lombok.Getter;
import org.example.patternshometask.executors.Executor;
import org.example.patternshometask.requests.Request;

import java.util.List;

@Builder
public class Administrator extends Manager {
    @Getter
    private List<Executor> executors;
    private final String name;
    private Executor canHandleRequestExecutor;

    @Override
    public boolean canHandleRequest(Request req) {
        canHandleRequestExecutor = executors.stream()
            .filter(executor -> executor.canHandleRequest(req))
            .findFirst().orElse(null);
        if (canHandleRequestExecutor != null) {
            System.out.println("Admin " + name + " found executor who can execute the task :)");
            return true;
        }
        System.out.println("Admin " + name + " didn't find executor who can execute the task :(");
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
