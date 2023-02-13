package org.example.patternshometask.executors;

import lombok.experimental.SuperBuilder;
import org.example.patternshometask.executors.states.State;
import org.example.patternshometask.executors.states.WorkState;
import org.example.patternshometask.requests.Request;
import org.example.patternshometask.requests.RequestType;

@SuperBuilder
public class Supplier {
    private final String name;
    private State state;

    public boolean canExecuteTask(Request request) {
        if (request.getRequestType().equals(RequestType.SUPPLIER_REQUEST)) {
            if (state.getClass().equals(WorkState.class)) {
                return true;
            }
            System.out.println("Supplier " + name + " cannot make this task. Their status is "
                + state.observe());
        }
        return false;
    }

    public Request execute(Request req) {
        System.out.println("Supplier " + name + " executed task: ");
        req.getCommand().run();
        req.setCompleted(true);
        return req;
    }
}
